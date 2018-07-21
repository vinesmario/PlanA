package com.domain.service.paychannel.common.entity;

import com.cwgj.common.model.entity.CrudEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author maodipu
 * @date 2018-01-18
 */

@Data
public class PayTransactionWechat extends CrudEntity {

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")

    /**
     * 租户ID
     */
    private Integer tenantId;
    /**
     * 车场ID
     */
    private Integer parkId;
    /**
     * 订单编号
     */
    private String orderNo;
    /**
     * 交易编号  商户系统内部交易订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一。
     */
    private String outTradeNo;
    /**
     * 公众账号ID 微信支付分配的公众账号ID（企业号corpid即为此appId）
     */
    private String appid;
    /**
     * 商户号 微信支付分配的商户号
     */
    private String mchId;
    /**
     * 子商户公众账号ID 微信分配的子商户公众账号ID，如需在支付完成后获取sub_openid则此参数必传。
     */
    private String subAppid;
    /**
     * 子商户号 微信支付分配的子商户号
     */
    private String subMchId;
    /**
     * 用户标识 trade_type=JSAPI，此参数必传，用户在主商户appid下的唯一标识。openid和sub_openid可以选传其中之一，如果选择传sub_openid,则必须传sub_appid。
     */
    private String openid;
    /**
     * 用户子标识 trade_type=JSAPI，此参数必传，用户在子商户appid下的唯一标识。openid和sub_openid可以选传其中之一，如果选择传sub_openid,则必须传sub_appid。
     */
    private String subOpenid;
    /**
     * 微信支付订单号
     */
    private String transactionId;
    /**
     * 总金额 订单总金额，只能为整数，详见支付金额
     */
    private Integer totalFee;
    /**
     * 货币类型 符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    private String feeType;
    /**
     * 付款银行
     */
    private String bankType;
    /**
     * 现金支付金额  现金支付金额订单现金支付金额，详见支付金额
     */
    private Integer cashFee;
    /**
     * 现金支付货币类型 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    private String cashFeeType;
    /**
     * 应结订单金额  应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额。
     */
    private Integer settlementTotalFee;
    /**
     * 交易类型 JSAPI 公众号支付 NATIVE 扫码支付 APP APP支付 说明详见参数规定
     */
    private String tradeType;
    /**
     * 指定支付方式 no_credit--指定不能使用信用卡支付
     */
    private String limitPay;
    /**
     * 商品ID trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。
     */
    private String productId;
    /**
     * 设备号 终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB"
     */
    private String deviceInfo;
    /**
     * 终端IP APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
     */
    private String spbillCreateIp;
    /**
     * 商品描述 商品描述交易字段格式根据不同的应用场景按照以下格式：PC网站——网站主页title名-实际商品名称，例如：腾讯充值中心-QQ会员充值；公众号——传入公众号名称-实际商品名称，例如：腾讯形象店- image-QQ公仔； H5——移动网页的主页title名-实际商品名称，例如：腾讯充值中心-QQ会员充值；线下门店——门店品牌名-城市分店名-实际商品名称，例如： image形象店-深圳腾大- QQ公仔）； APP——应用市场上的APP名字-实际商品名称，天天爱消除-游戏充值。
     */
    private String body;
    /**
     * 商品详情 商品详细描述，对于使用单品优惠的商户，改字段必须按照规范上传，详见“单品优惠参数说明”
     */
    private String detail;
    /**
     * 附加数据 在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
     */
    private String attach;
    /**
     * 场景信息  该字段为JSON对象数据，对象格式为{"store_info":{"id": "门店ID","name": "名称","area_code": "编码","address": "地址" }}  。门店唯一标识、门店名称、门店所在地行政区划码(详见最新县及县以上行政区划代码) 、门店详细地址
     */
    private String sceneInfo;
    /**
     * 订单优惠标记
     */
    private String goodsTag;
    /**
     * 预支付交易会话标识 微信生成的预支付回话标识，用于后续接口调用中使用，该值有效期为2小时
     */
    private String prepayId;
    /**
     * 二维码链接 trade_type为NATIVE是有返回，可将该参数值生成二维码展示出来进行扫码支付
     */
    private String codeUrl;
    /**
     * 交易状态  1：创建；2：成功；3：取消；4：超时；5：失败
     */
    private Integer status;
    /**
     * 交易起始时间  订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
     */
    private String timeStart;
    /**
     * 交易结束时间 交易失效时间，格式为yyyyMMddHHmmss，交易失效时间是针对交易编号而言的
     */
    private String timeExpire;
    /**
     * 支付完成时间 格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
     */
    private String timeEnd;
    /**
     * 通知地址 接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。
     */
    private String notifyUrl;
    /**
     * 返回状态码 SUCCESS/FAIL 此字段是通信标识，非交易标识，交易是否成功需要查看result_code来判断
     */
    private String returnCode;
    /**
     * 返回信息 返回信息，如非空，为错误原因：签名失败;参数格式校验错误
     */
    private String returnMsg;
    /**
     * 业务结果 SUCCESS/FAIL
     */
    private String resultCode;
    /**
     * 错误代码
     */
    private String errCode;
    /**
     * 错误代码描述
     */
    private String errCodeDes;
    /**
     * 回调订单支付记录状态，0-否，1，是
     */
    private Integer notifyStatus;


}