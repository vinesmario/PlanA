package com.model.po.pay;

import com.common.model.po.CrudEntity;
import com.model.po.CrudEntity;
import lombok.Data;

/**
 * 支付订单-支付宝支付
 */
@Data
public class PayOrderAlipay extends CrudEntity {

    //    @Column(name = "app_id")
    private String appId;

    //    @Column(name = "device_info")
    private String deviceInfo;

    //    @Column(name = "sign")
    private String sign;

    //    @Column(name = "sign_type")
    private String signType;

    //    @Column(name = "body")
    private String body;

    //    @Column(name = "subject")
    private String subject;

    //    @Column(name = "seller_id")
    private String sellerId;

    //    @Column(name = "product_code")
    private String productCode;

    //    @Column(name = "goods_type")
    private String goodsType;

    //    @Column(name = "method_name")
    private String methodName;

    //    @Column(name = "out_trade_no")
    private String outTradeNo;

    //    @Column(name = "total_amount")
    private String totalAmount;

    //    @Column(name = "timeout_express")
    private String timeoutExpress;

    //    @Column(name = "notify_url")
    private String notifyUrl;

    //    @Column(name = "passback_params")
    private String passbackParams;

    //    @Column(name = "promo_params")
    private String promoParams;

    //    @Column(name = "enable_pay_channels")
    private String enablePayChannels;

    //    @Column(name = "disable_pay_channels")
    private String disablePayChannels;

    //    @Column(name = "store_id")
    private String storeId;

    //    @Column(name = "extend_params")
    private String extendParams;

    //    @Column(name = "spbill_create_ip")
    private String spbillCreateIp;
    /**
     * 支付状态：0-支付中；1-支付成功；2-支付失败
     */
//    @Column(name = "status")
    private Integer status;
    /**
     * 销售订单ID，可能为空，视具体业务
     */
    private Integer salesOrderId;
    /**
     * 充值订单ID，可能为空，视具体业务
     */
    private Integer chargeOrderId;
}
