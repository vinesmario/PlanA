package com.domain.service.paychannel.common.dto;

import com.cwgj.common.model.dto.CrudDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author maodipu
 * @date 2018-01-18
 */
@ApiModel(value = "RefundTransactionWechat", description = "RefundTransactionWechat")
@Data
public class RefundTransactionWechatDto extends CrudDto {

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
     * 商户退款单号 商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
     */
    private String outRefundNo;
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
     * 微信支付订单号
     */
    private String transactionId;
    /**
     * 微信退款单号，返回结果提供
     */
    private String refundId;
    /**
     * 总金额 订单总金额，只能为整数，详见支付金额
     */
    private Integer totalFee;
    /**
     * 货币类型 符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    private String feeType;
    /**
     * 申请退款金额  退款总金额，单位为分，只能为整数，可部分退款。详见支付金额
     */
    private Integer refundFee;
    /**
     * 退款货币种类  退款货币类型，需与支付一致，或者不填。符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    private String refundFeeType;
    /**
     * 现金支付金额  现金支付金额订单现金支付金额，详见支付金额
     */
    private Integer cashFee;
    /**
     * 现金退款金额 现金退款金额，单位为分，只能为整数，详见支付金额
     */
    private Integer cashRefundFee;
    /**
     * 应结订单金额  应结订单金额=订单金额-免充值代金券金额，应结订单金额<=订单金额。
     */
    private Integer settlementTotalFee;
    /**
     * 退款金额 去掉非充值代金券退款金额后的退款金额，退款金额=申请退款金额-非充值代金券退款金额，退款金额<=申请退款金额
     */
    private Integer settlementRefundFee;
    /**
     * 退款原因  若商户传入，会在下发给用户的退款消息中体现退款原因
     */
    private String refundDesc;
    /**
     * 退款资金来源  仅针对老资金流商户使用 REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款（默认使用未结算资金退款） REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款
     */
    private String refundAccount;
    /**
     * 退款状态  交易状态  1：创建；2：成功；3：取消；4：超时；5：失败
     */
    private Integer status;
    /**
     * 退款结果通知url 异步接收微信支付退款结果通知的回调地址，通知URL必须为外网可访问的url，不允许带参数。如果参数中传了notify_url，则商户平台上配置的回调地址将不会生效。
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