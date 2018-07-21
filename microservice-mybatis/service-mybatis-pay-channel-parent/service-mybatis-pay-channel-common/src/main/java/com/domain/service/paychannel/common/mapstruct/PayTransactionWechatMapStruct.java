package com.domain.service.paychannel.common.mapstruct;

import com.cwgj.common.model.mapstruct.CrudEntityMapStruct;
import com.cwgj.service.pay.common.dto.PayTransactionWechatDto;
import com.cwgj.service.pay.common.entity.PayTransactionWechat;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author maodipu
 * @date 2018-01-18
 */

@Mapper(componentModel = "spring")
public interface PayTransactionWechatMapStruct extends CrudEntityMapStruct<PayTransactionWechat, PayTransactionWechatDto> {

}
