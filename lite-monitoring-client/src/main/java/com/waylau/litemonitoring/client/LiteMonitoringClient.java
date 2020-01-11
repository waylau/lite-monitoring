package com.waylau.litemonitoring.client;

import com.waylau.litemonitoring.common.util.CommandLineArgs;
import com.waylau.litemonitoring.common.util.CommandLineArgsParser;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;


/**
 * Lite Monitoring Client.
 * 
 * @since 1.0.0 2020年1月5日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class LiteMonitoringClient {

	private static final String CMD_PORT = "port";
	private static final String CMD_SERVER = "server";
	private static final int DEFUALT_PORT = 8082;
	private static final String DEFUALT_SERVER = "localhost";
	
	public static void main(String[] args) throws Exception {
		CommandLineArgs commandLineArgs = CommandLineArgsParser.parse(args);
		Integer port = commandLineArgs.getIntArg(CMD_PORT);
		String server = commandLineArgs.getArg(CMD_SERVER);

		if (port == null) {
			port = DEFUALT_PORT;
		}

		if (server == null) {
			server = DEFUALT_SERVER;
		}

		new LiteMonitoringClient(server, port).run();
	}

    private final String host;
    private final int port;

    public LiteMonitoringClient(String host, int port){
        this.host = host;
        this.port = port;
    }

    public void run() throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap  = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
		            .handler(new LiteMonitoringClientInitializer());
            
            Channel channel = bootstrap.connect(host, port).sync().channel();
			
			// 等待连接关闭
			channel.closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }

    }

}
