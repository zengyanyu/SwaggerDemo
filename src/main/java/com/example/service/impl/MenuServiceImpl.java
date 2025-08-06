package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.commons.ResponseData;
import com.example.entity.Menu;
import com.example.mapper.MenuMapper;
import com.example.service.IMenuService;
import org.springframework.stereotype.Service;

/**
 * 菜单 服务实现类
 *
 * @author zengyanyu
 * @since 2025-07-30
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    /**
     * 保存或更新菜单
     *
     * @param menu 菜单
     * @return
     */
    @Override
    public ResponseData saveOrUpdateMenu(Menu menu) {
        this.saveOrUpdate(menu);
        return new ResponseData("保存或更新成功");
    }

}
