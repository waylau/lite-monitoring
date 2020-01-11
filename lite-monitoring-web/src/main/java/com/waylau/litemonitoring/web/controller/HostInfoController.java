/**
 * Welcome to https://waylau.com
 */
package com.waylau.litemonitoring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waylau.litemonitoring.common.api.HostInfo;
import com.waylau.litemonitoring.web.service.HostInfoService;

/**
 * HostInfo Controller.
 * 
 * @since 1.0.0 2020年1月11日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@RestController
@RequestMapping("/hosts")
public class HostInfoController {

	@Autowired
	private HostInfoService hostInfoService;

	/**
	 * 根据host查询主机信息
	 * 
	 * @param host 主机唯一标识
	 * @return 主机信息
	 */
	@GetMapping("/{host:.*}")
	public List<HostInfo> findHostInfo(@PathVariable String host) {
		return hostInfoService.findHostInfo(host);
	}

	/**
	 * 查询主机唯一标识列表
	 * 
	 * @return 主机唯一标识列表
	 */
	@GetMapping
	public List<String> findHostInfoList() {
		return hostInfoService.findHostInfoList();
	}
}
