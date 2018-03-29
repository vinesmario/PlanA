package com.netty.client;

import com.domain.common.model.protobuf.Message;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class NettyClient {

    private ClientHandler handler;

    public ClientHandler getHandler() {
        return handler;
    }

    public Boolean connect(String host, int port) {
        Bootstrap bootstrap = new Bootstrap();
        EventLoopGroup group = new NioEventLoopGroup();
        ChannelFuture future = bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline p = ch.pipeline();
                        p.addLast(new ProtobufVarint32FrameDecoder());
                        p.addLast(new ProtobufDecoder(Message.Head.getDefaultInstance()));
                        p.addLast(new ProtobufVarint32LengthFieldPrepender());
                        p.addLast(new ProtobufEncoder());
                        p.addLast(new ClientHandler());
                    }
                })
                .connect(host, port)
                .addListener(new ChannelFutureListener() {
                    public void operationComplete(final ChannelFuture channelFuture) throws Exception {
                        if (channelFuture.isSuccess()) {
                            handler = channelFuture.channel().pipeline().get(ClientHandler.class);
                            log.info("Connect to server successfully!");
                        } else {
                            log.warn("Failed to connect to server, try connect after 10s");
                            channelFuture.channel().eventLoop().schedule(() -> connect(host, port), 10, TimeUnit.SECONDS);
                        }
                    }
                });
        future.awaitUninterruptibly();

        return Boolean.TRUE;
    }

}
