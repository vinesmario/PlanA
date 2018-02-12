package com.pay.model.dto;

import com.common.model.dto.CrudDto;
import lombok.Data;

/**
 * 退款订单-微信支付
 */
//@Entity
//@Table(name = "pay_order_wechat")
@Data
public class RefundOrderWechatDto extends CrudDto {

    //    @Column(name = "appid")
    private String appid;

    //    @Column(name = "mch_id")
    private String mchId;

    //    @Column(name = "sub_appid")
    private String subAppid;

    //    @Column(name = "sub_mch_id")
    private String subMchId;

    //    @Column(name = "transaction_id")
    private String transactionId;

    //    @Column(name = "out_trade_no")
    private String outTradeNo;

    //    @Column(name = "out_refund_no")
    private String outRefundNo;

    //    @Column(name = "refund_fee_type")
    private String refundfeeType;

    //    @Column(name = "total_fee")
    private Integer totalFee;

    //    @Column(name = "refund_fee")
    private Integer refundFee;

    //    @Column(name = "refund_desc")
    private String refundDesc;

    //    @Column(name = "refund_id")
    private String refundId;
    /**
     * 订单状态，0：退款中；1：退款成功；2：退款失败
     */
//    @Column(name = "status")
    private Byte status;

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
    /**
     * 交易订单ID，可能为空，视具体业务
     */
    private Integer tradeOrderId;

}
