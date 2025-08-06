package com.example.controller;

import com.example.commons.ResponseData;
import com.example.config.LogRecord;
import com.example.dto.FileDto;
import com.example.util.FileUtils;
import com.example.util.IOUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.velocity.shaded.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Api(tags = "文件控制器")
@RestController
public class FileController extends BaseController {

    @Value("${file.uploadFolder}")
    private String uploadFolder;

    /**
     * 文件上传
     *
     * @param files 文件集合
     * @return 文件上传的响应信息
     */
    @LogRecord("文件上传")
    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public ResponseData<List<FileDto>> fileUpload(@RequestParam("file") List<MultipartFile> files) {
        // 创建对象，设置属性
        List<FileDto> fileDtoList = new ArrayList<>();
        for (MultipartFile file : files) {
            // 单文件上传
            ResponseData<FileDto> upload = FileUtils.upload(file, uploadFolder);
            FileDto fileDto = upload.getData();
            // 将数据添加到集合中
            fileDtoList.add(fileDto);
        }
        return new ResponseData("上传文件成功", fileDtoList);
    }

    /**
     * 文件下载
     *
     * @param fileName 文件名称
     * @return
     * @throws MalformedURLException
     */
    @LogRecord("文件下载")
    @ApiOperation("文件下载")
    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) throws MalformedURLException {
        Path filePath = Paths.get(uploadFolder).resolve(fileName).normalize();
        Resource resource = new UrlResource(filePath.toUri());
        if (!resource.exists()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + resource.getFilename())
                .body(resource);
    }

    /**
     * 文件预览
     *
     * @param fileName 文件名称
     * @return
     * @throws IOException
     */
    @ApiOperation("文件预览")
    @GetMapping("/preview/{fileName}")
    public ResponseEntity<ByteArrayResource> previewFile(@PathVariable String fileName) throws IOException {
        File file = new File(uploadFolder + fileName);

        String contentType = FilenameUtils.getExtension(fileName);
        // 预览
        HttpHeaders httpHeaders = new HttpHeaders();
        if ("pdf".equalsIgnoreCase(contentType)) {
            httpHeaders.add("Content-Type", MediaType.APPLICATION_PDF_VALUE);
        } else if ("jpg".equalsIgnoreCase(contentType) || "jpeg".equalsIgnoreCase(contentType)
                || "png".equalsIgnoreCase(contentType)) {
            httpHeaders.add("Content-Type", MediaType.IMAGE_JPEG_VALUE);
        }
        // 获取文件流
        InputStream inputStream = new FileInputStream(uploadFolder + fileName);
        return new ResponseEntity<>(IOUtils.inputStreamToByteArrayResource(inputStream), httpHeaders, HttpStatus.OK);
    }

}
