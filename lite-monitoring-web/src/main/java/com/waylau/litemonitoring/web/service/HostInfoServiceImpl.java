/**
 * Welcome to https://waylau.com
 */
package com.waylau.litemonitoring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waylau.litemonitoring.common.api.HostInfo;
import com.waylau.litemonitoring.web.mapper.HostInfoMapper;

/**
 * HostInfoService Implement.
 * 
 * @since 1.0.0 2020年1月11日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@Service
public class HostInfoServiceImpl implements HostInfoService {

	@Autowired
	private HostInfoMapper hostInfoMapper;
	
	@Override
	public List<String> findHostInfoList() {
		return hostInfoMapper.findHostInfoList();
	}

	@Override
	public List<HostInfo> findHostInfo(String host) {
		return hostInfoMapper.findHostInfo(host);
	}

}
