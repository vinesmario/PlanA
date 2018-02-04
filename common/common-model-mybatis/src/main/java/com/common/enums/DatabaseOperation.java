package com.common.enums;

public enum DatabaseOperation {
    create("C", "创建"),
    retrieve("R", "读取"),
    update("U", "更新"),
    delete("D", "删除");

    private String shortName;
    private String description;

    DatabaseOperation(String shortName, String description) {
        this.shortName = shortName;
        this.description = description;
    }

    public String getShortName() {
        return shortName;
    }

    public String getDescription() {
        return description;
    }
}
