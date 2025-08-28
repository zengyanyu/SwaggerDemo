package com.example.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.example.util.DateUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

@Component
public class MPMetaObjectHandle implements MetaObjectHandler {
    /**
     * 这个类配合这两个注解使用
     *
     * @TableField(fill = FieldFill.INSERT)
     * private LocalDateTime createTime;
     * @TableField(fill = FieldFill.UPDATE)
     * private LocalDateTime updateTime;
     */

    // 保存填充
    @Override
    public void insertFill(MetaObject metaObject) {
        metaObject.setValue("createTime", DateUtils.getCurrentTime());
    }

    // 修改填充
    @Override
    public void updateFill(MetaObject metaObject) {
        metaObject.setValue("updateTime", DateUtils.getCurrentTime());
    }
}
