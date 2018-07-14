package com.domain.common.enums;

public enum TradeType {

	CASH(1, "现金", PayChannel.CASH),
	WECHAT_NATIVE(11, "微信扫码支付", PayChannel.WECHAT),
	WECHAT_JSAPI(12, "微信公众号支付", PayChannel.WECHAT),
	WECHAT_APP(13, "微信APP支付", PayChannel.WECHAT),
	WECHAT_H5(14, "微信H5网页支付", PayChannel.WECHAT),
	WECHAT_MINI_APP(15, "微信小程序支付", PayChannel.WECHAT),
	WECHAT_CARD(16, "微信刷卡支付", PayChannel.WECHAT),
	ALIPAY_NATIVE(21, "支付宝扫码支付", PayChannel.ALIPAY),
	ALIPAY_JSAPI(22, "支付宝生活号支付", PayChannel.ALIPAY),
	ALIPAY_APP(23, "支付宝APP支付", PayChannel.ALIPAY),
	ALIPAY_H5(24, "支付宝H5网页支付", PayChannel.ALIPAY);

	private Integer code;
	private String name;
	private PayChannel payChannel;

	TradeType(Integer code, String name, PayChannel payChannel) {
		this.code = code;
		this.payChannel = payChannel;
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public PayChannel getPayChannel() {
		return payChannel;
	}

}
