package com.pay.model.po;

import com.common.model.po.CrudEntity;
import lombok.Data;

/**
 * 支付交易流水-微信支付
 */
//@Entity
//@Table(name = "pay_trade_wechat")
@Data
public class PayTradeWechat extends CrudEntity {

    //    @Column(name = "appid")
    private String appid;

    //    @Column(name = "mch_id")
    private String mchId;

    //    @Column(name = "sub_appid")
    private String subAppid;

    //    @Column(name = "sub_mch_id")
    private String subMchId;

    //    @Column(name = "device_info")
    private String deviceInfo;

    //    @Column(name = "body")
    private String body;

    //    @Column(name = "detail")
    private String detail;

    //    @Column(name = "attach")
    private String attach;

    //    @Column(name = "out_trade_no")
    private String outTradeNo;

    //    @Column(name = "fee_type")
    private String feeType;

    //    @Column(name = "total_fee")
    private Integer totalFee;

    //    @Column(name = "spbill_create_ip")
    private String spbillCreateIp;

    //    @Column(name = "time_start")
    private String timeStart;

    //    @Column(name = "time_expire")
    private String timeExpire;

    //    @Column(name = "notify_url")
    private String notifyUrl;

    //    @Column(name = "trade_type")
    private String tradeType;

    //    @Column(name = "product_id")
    private String productId;

    //    @Column(name = "return_code")
    private String returnCode;

    //    @Column(name = "return_msg")
    private String returnMsg;

    //    @Column(name = "result_code")
    private String resultCode;

    //    @Column(name = "err_code")
    private String errCode;

    //    @Column(name = "err_code_des")
    private String errCodeDes;

    //    @Column(name = "prepay_id")
    private String prepayId;
    /**
     * 支付状态：0-支付中；1-支付成功；2-支付失败
     */
//    @Column(name = "status")
    private Byte status;
    /**
     * 关联类型
     */
//    @Column(name = "attach_type")
    private String attachType;

    //    @Column(name = "openid")
    private String openid;

    //    @Column(name = "transaction_id")
    private String transactionId;

    //    @Column(name = "time_end")
    private String timeEnd;
    /**
     * 销售订单ID，可能为空，视具体业务
     */
    private Integer salesOrderId;
    /**
     * 充值订单ID，可能为空，视具体业务
     */
    private Integer chargeOrderId;

}
