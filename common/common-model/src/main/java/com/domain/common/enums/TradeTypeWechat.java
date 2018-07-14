package com.domain.common.enums;

public enum TradeTypeWechat {

	NATIVE("NATIVE", "原生扫码支付"),
	JSAPI("JSAPI", "公众号支付"),
	APP("APP", "app支付"),
	H5("MWEB", "H5支付"),
	MINI_APP("JSAPI", "小程序支付");

	private String code;
	private String name;

	TradeTypeWechat(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
}
