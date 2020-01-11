package com.waylau.litemonitoring.server;

import org.apache.commons.dbutils.QueryRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.waylau.litemonitoring.common.api.HostInfo;
import com.waylau.litemonitoring.common.db.DbUtil;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * LiteMonitoringServer Handler.
 * 
 * @since 1.0.0 2020年1月2日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class LiteMonitoringServerHandler extends SimpleChannelInboundHandler<Object> {
    private static final Logger logger = 
    		LoggerFactory.getLogger(LiteMonitoringServerHandler.class);
    
    private static final String SQL_INSERT =
			"INSERT INTO t_host_info (host, create_time, used_memory, "
			+ "total_memory, used_cpu) VALUES (?, ?, ?, ?, ?)";
    
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object obj) throws Exception {
		
		if (obj instanceof HostInfo) {
			HostInfo hostInfo = (HostInfo) obj;
			String host = ctx.channel().remoteAddress().toString().replace("/","");
			hostInfo.setHost(host);
			
			logger.info("{} -> Server: {}" , hostInfo.getHost(), hostInfo);
			
			QueryRunner run = new QueryRunner(DbUtil.getDataSource());

			// 创建
			int inserts = run.update(SQL_INSERT, hostInfo.getHost(), 
					hostInfo.getCreateTime(), hostInfo.getUsedMemory(), 
					hostInfo.getTotalMemory(), hostInfo.getUsedCpu());
			logger.info("Insert Results：{}" ,inserts);
		}
	}

}
