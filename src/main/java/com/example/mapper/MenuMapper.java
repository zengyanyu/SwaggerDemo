package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

/**
 * 菜单 Mapper 接口
 *
 * @author zengyanyu
 * @since 2025-07-30
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

}
