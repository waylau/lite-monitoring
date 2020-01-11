/**
 * 
 */
package com.waylau.litemonitoring.client;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.waylau.litemonitoring.common.api.HostInfo;
import com.waylau.litemonitoring.common.util.HostInfoCollector;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * LiteMonitoringClient Handler.
 * 
 * @since 1.0.0 2020年1月2日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class LiteMonitoringClientHandler extends
		SimpleChannelInboundHandler<Object> {
    private static final Logger logger = 
    		LoggerFactory.getLogger(LiteMonitoringClientHandler.class);
    
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object obj)
			throws Exception {
		// NOOP
	}
	
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    	Channel ch = ctx.channel();
    	ch.eventLoop().scheduleAtFixedRate(
    	        new Runnable() {
    	            @Override
    	            public void run() {
    	            	
    	            	// 获取主机性能信息
    	            	HostInfo hostInfo = null;
						try {
							hostInfo = HostInfoCollector.getHostInfo();
						} catch (InterruptedException e) {
							logger.error("error: {}", e);
						}
	    				ch.write(hostInfo);
	    				ch.flush();
	    				
	    				logger.info("调度一次任务，数据：{}", hostInfo); 
    	            }
    	        }, 5, 5, TimeUnit.SECONDS);
    }

}
