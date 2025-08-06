package com.example.service;

import com.example.commons.ResponseData;
import com.example.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 菜单 服务类
 *
 * @author zengyanyu
 * @since 2025-07-30
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 保存或更新菜单
     *
     * @param menu 菜单
     * @return
     */
    ResponseData saveOrUpdateMenu(Menu menu);

}
