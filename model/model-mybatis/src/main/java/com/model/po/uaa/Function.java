package com.model.po.uaa;

import com.model.po.TreeCrudEntity;
import lombok.Data;

/**
 * 功能
 */
@Data
public class Function extends TreeCrudEntity<Function> {

    private String href;    // 链接
    private String target;   // 目标
    private String icon;    // 图标
    private String permission; // 权限标识
}
