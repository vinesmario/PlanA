package com.domain.common.enums;

public enum TradeTypeAlipay {

	;

	private String val;

	private String desc;

	TradeTypeAlipay(String val, String desc) {
		this.val = val;
	}

	public String getVal() {
		return val;
	}
}
