package com.example.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@TableName("log_record_entity")
@ApiModel(value = "日志记录实体", description = "日志记录实体")
public class LogRecordEntity implements Serializable {

    @ExcelIgnore
    @Id
    @ApiModelProperty("日志唯一标识")
    private String id;

    @ExcelProperty("操作名称")
    @Comment("操作名称")
    @ApiModelProperty("操作名称")
    private String operateName;

    @ExcelProperty("操作账号")
    @Comment("操作账号")
    @ApiModelProperty("操作账号")
    private String operateUsername;

    @ExcelProperty("请求路径")
    @Comment("请求路径")
    @ApiModelProperty("请求路径")
    private String path;

    @ExcelProperty("请求方式")
    @Comment("请求方式")
    @ApiModelProperty("请求方式")
    private String method;

    @ExcelProperty("请求IP地址")
    @Comment("请求IP地址")
    @ApiModelProperty("请求IP地址")
    private String requestIp;

    @ExcelProperty("全限定类名称")
    @Comment("全限定类名称")
    @ApiModelProperty("全限定类名称")
    private String qualifiedName;

    @ExcelProperty("请求入参")
    @Comment("请求入参")
    @Type(type = "text")
    @Column(columnDefinition = "TEXT")
    @ApiModelProperty("请求入参")
    private String inputParam;

    @ExcelProperty("请求出参")
    @Comment("请求出参")
    @ApiModelProperty("请求出参")
    private String outputParam;

    @ExcelProperty("异常信息")
    @Comment("异常信息")
    @Type(type = "text")
    @Column(columnDefinition = "TEXT")
    @ApiModelProperty("异常信息")
    private String errorMsg;

    @ExcelProperty("请求时间")
    @Comment("请求时间")
    @ApiModelProperty("请求时间")
    private LocalDateTime requestTime;

    @ExcelProperty("响应时间")
    @Comment("响应时间")
    @ApiModelProperty("响应时间")
    private LocalDateTime responseTime;

    @ExcelProperty("请求是否成功")
    @Comment("请求是否成功")
    @ApiModelProperty("请求是否成功")
    private String status;

}
