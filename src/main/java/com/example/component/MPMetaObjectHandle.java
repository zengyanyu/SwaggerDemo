package com.example.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.example.config.UserContextHolder;
import com.example.entity.UserInfo;
import com.example.util.DateUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/*
 * 元数据对象组件（字段内容自动填充）
 * 结合注解：@TableField(fill = FieldFill.INSERT)
 *         @TableField(fill = FieldFill.UPDATE) 使用
 */
@Component
public class MPMetaObjectHandle implements MetaObjectHandler {

    // 保存填充
    @Override
    public void insertFill(MetaObject metaObject) {
        metaObject.setValue("createTime", DateUtils.getCurrentTime());
        UserInfo userContext = UserContextHolder.getUserContext();
        if (null != userContext) {
            metaObject.setValue("createBy", userContext.getUsername());
        }
    }

    // 修改填充
    @Override
    public void updateFill(MetaObject metaObject) {
        metaObject.setValue("updateTime", DateUtils.getCurrentTime());
        UserInfo userContext = UserContextHolder.getUserContext();
        if (null != userContext) {
            metaObject.setValue("updateBy", userContext.getUsername());
        }
    }

}
