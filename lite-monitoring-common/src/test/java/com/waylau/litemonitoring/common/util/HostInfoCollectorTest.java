/**
 * Welcome to https://waylau.com
 */
package com.waylau.litemonitoring.common.util;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.waylau.litemonitoring.common.api.HostInfo;

/**
 * HostInfoCollector Test.
 * 
 * @since 1.0.0 2020年1月11日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public class HostInfoCollectorTest {

	static final Logger logger = 
		    LoggerFactory.getLogger(HostInfoCollectorTest.class);
	
	@Test
	void testGetHostInfo() throws InterruptedException {
		HostInfo info = HostInfoCollector.getHostInfo();
		logger.info("采集信息：{}", info);
	}
}
