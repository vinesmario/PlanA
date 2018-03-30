package com.domain.netty.client;

import com.domain.biz.uaa.protobuf.Message;
import com.google.common.collect.Maps;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Map;

public class ClientHandler extends SimpleChannelInboundHandler<Message.Head> {

    private Map<Integer, MessageCallBack> mapCallBack = Maps.newConcurrentMap();
    private volatile Channel channel;

    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
        this.channel = ctx.channel();
    }

    /**
     * 接收消息
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message.Head msg) throws Exception {
        Message.Head response = msg;
        int msgId = response.getMsgId();
        MessageCallBack callBack = mapCallBack.get(msgId);
        if (callBack != null) {
            mapCallBack.remove(msgId);
            callBack.over(response);
        }
    }

    /**
     * 发送消息，并获取返回值
     *
     * @param request
     * @return
     */
    public Message.Head sendRequest(Message.Head request) {
        MessageCallBack callBack = new MessageCallBack(request);
        mapCallBack.put(request.getMsgId(), callBack);
        channel.writeAndFlush(request);
        return callBack.start();

    }

}
