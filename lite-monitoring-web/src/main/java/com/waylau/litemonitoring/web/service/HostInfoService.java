/**
 * Welcome to https://waylau.com
 */
package com.waylau.litemonitoring.web.service;

import java.util.List;

import com.waylau.litemonitoring.common.api.HostInfo;

/**
 * HostInfo Service.
 * 
 * @since 1.0.0 2020年1月11日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface HostInfoService {

	/**
	 * 获取主机唯一标识列表
	 * @return 主机唯一标识列表
	 */
	List<String> findHostInfoList();
	
	/**
	 * 根据主机唯一标识查询主机状态信息
	 * @return 主机状态信息
	 */
	List<HostInfo> findHostInfo(String host);
	
}
