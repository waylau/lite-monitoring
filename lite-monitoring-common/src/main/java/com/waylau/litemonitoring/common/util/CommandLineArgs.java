/**
 * Welcome to https://waylau.com
 */
package com.waylau.litemonitoring.common.util;

import java.util.HashMap;
import java.util.Map;


/**
 * Command line arguments.
 * 
 * @since 1.0.0 2018年8月18日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public class CommandLineArgs {

	private final Map<String, String> args = new HashMap<>();

	public void addArg(String argName, String argValue) {
		this.args.put(argName, argValue);
	}

	public boolean contains(String argName) {
		return this.args.containsKey(argName);
	}

	public String getArg(String argName) {
		return this.args.get(argName);
	}
	
	public Integer getIntArg(String argName) {
		String argValue = this.getArg(argName);
		return argValue == null ? null : Integer.valueOf(argValue);
	}

}
