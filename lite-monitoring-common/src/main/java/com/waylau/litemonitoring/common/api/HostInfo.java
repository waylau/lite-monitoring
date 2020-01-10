/**
 * Welcome to https://waylau.com
 */
package com.waylau.litemonitoring.common.api;

import java.io.Serializable;

/**
 * Host Info.
 * 
 * @since 1.0.0 2020年1月5日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class HostInfo implements Serializable {

	private static final Long serialVersionUID = 1L;
	
	/**
	 * 主机位置（IP+端口），也是主机的唯一表示
	 */
	private String host;

	/**
	 * 创建时间
	 */
	private Long createTime;

	/**
	 * 已用内存（单位：byte）
	 */
	private Long usedMemory;

	/**
	 * 总内存（单位：byte）
	 */
	private Long totalMemory;

	/**
	 * CPU使用率
	 */
	private Double usedCpu;

	public Long getUsedMemory() {
		return usedMemory;
	}

	public void setUsedMemory(Long usedMemory) {
		this.usedMemory = usedMemory;
	}

	public Long getTotalMemory() {
		return totalMemory;
	}

	public void setTotalMemory(Long totalMemory) {
		this.totalMemory = totalMemory;
	}

	public Double getUsedCpu() {
		return usedCpu;
	}

	public void setUsedCpu(Double usedCpu) {
		this.usedCpu = usedCpu;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public String toString() {
		return "HostInfo [host=" + host + ", createTime=" + createTime 
				+ ", usedMemory=" + usedMemory + ", totalMemory="
				+ totalMemory + ", usedCpu=" + usedCpu + "]";
	}

}
