package com.waylau.litemonitoring.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.waylau.litemonitoring.common.api.HostInfo;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Server Handler.
 * 
 * @since 1.0.0 2020年1月2日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class LiteMonitoringServerHandler extends SimpleChannelInboundHandler<Object> {
    private static final Logger logger = LoggerFactory.getLogger(LiteMonitoringServerHandler.class);
    
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object obj) throws Exception {
		
		if (obj instanceof HostInfo) {
			HostInfo hostInfo = (HostInfo) obj;
			logger.info("{} -> Server: {}" , ctx.channel().remoteAddress(), hostInfo);
		}
	}

}
