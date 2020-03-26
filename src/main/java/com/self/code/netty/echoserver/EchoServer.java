package com.self.code.netty.echoserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @program: self-code
 * @description: 服务端
 * @author: GaoBo
 * @create: 2020/2/20
 **/
public class EchoServer {

	private final int port = 8002;

	public static void main(String[] args) throws Exception {
		new EchoServer().start();
	}

	public void start() throws Exception{
		final EchoServerHandler serverHandler = new EchoServerHandler();
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(group).channel(NioServerSocketChannel.class)
					.localAddress(new InetSocketAddress(port))
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						public void initChannel(SocketChannel ch) throws Exception{
							ch.pipeline().addLast(serverHandler);
						}
					});
			ChannelFuture f = b.bind().sync();
			f.channel().closeFuture().sync();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			group.shutdownGracefully().sync();
		}
	}

}
