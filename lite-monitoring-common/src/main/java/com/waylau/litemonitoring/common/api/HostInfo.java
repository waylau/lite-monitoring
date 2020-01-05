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

	private static final long serialVersionUID = 1L;

	/**
	 * 创建时间
	 */
	private long createTime;

	/**
	 * 已用内存（单位：byte）
	 */
	private long usedMemory;

	/**
	 * 总内存（单位：byte）
	 */
	private long totalMemory;

	/**
	 * CPU使用率
	 */
	private double usedCpu;

	public long getUsedMemory() {
		return usedMemory;
	}

	public void setUsedMemory(long usedMemory) {
		this.usedMemory = usedMemory;
	}

	public long getTotalMemory() {
		return totalMemory;
	}

	public void setTotalMemory(long totalMemory) {
		this.totalMemory = totalMemory;
	}

	public double getUsedCpu() {
		return usedCpu;
	}

	public void setUsedCpu(double usedCpu) {
		this.usedCpu = usedCpu;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "HostInfo [createTime=" + createTime + ", usedMemory=" + usedMemory + ", totalMemory=" + totalMemory
				+ ", usedCpu=" + usedCpu + "]";
	}

}
