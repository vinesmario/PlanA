package com.domain.netty.server;

import com.domain.biz.uaa.protobuf.Message;
import com.domain.common.util.MacUtils;
import com.domain.common.util.RC4EncryptUtil;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class ServerHandler extends SimpleChannelInboundHandler<Message.Head> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message.Head head) throws Exception {
        //对业务数据校验MAC、解密并进行反序列化
        byte[] bytes = head.getData().toByteArray();
        String mac = MacUtils.MACString(bytes);
        log.debug("Before RC4 Decode:{}", Arrays.toString(bytes));
        if (!mac.equals(head.getMac())) {
            log.info(mac);
            log.info(head.getMac());
            log.error("MAC校验失败");
            sendErrMsg(ctx, head, 0xF3);//失败，数据校验失败！
            return;
        }

        bytes = RC4EncryptUtil.rc4(encryptionKey, bytes);
        log.debug("After  RC4 Decode:{}", Arrays.toString(bytes));

        /*for(byte item:bytes){
            int result = item&0xff;
            System.out.print(result+",");
        }
        System.out.println();*/

        Message.Base base;
        try {
            base = Message.Base.parseFrom(ByteString.copyFrom(bytes));
        } catch (InvalidProtocolBufferException e) {
            log.error("使用key[{}]解密后反序列化异常", encryptionKey);
            sendErrMsg(ctx, message, 0xF2);//失败，数据解析出错。
            ctx.close();
            return;
        }
        log.info("BizServerHandler opcode==" + Integer.toHexString(base.getOpCode()).toUpperCase());
    }


}
