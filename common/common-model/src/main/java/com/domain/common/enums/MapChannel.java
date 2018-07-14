package com.domain.common.enums;

/**
 * 地图渠道
 */
public enum MapChannel {

    baidu(1, "百度地图"),
    tencent(2, "腾讯地图"),
    amap(3, "高德地图"),
    apple(4, "苹果地图"),
    google(5, "谷歌地图"),
    here(6, "HERE地图");

    private Integer code;
    private String name;

    MapChannel(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getCode() {

        return code;
    }
}
