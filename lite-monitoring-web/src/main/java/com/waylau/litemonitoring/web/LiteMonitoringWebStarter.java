package com.waylau.litemonitoring.web;

import com.waylau.lite.jetty.LiteJettyServer;

/**
 * Lite Monitoring Web Main Application.
 * 
 * @since 1.0.0 2020年1月5日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class LiteMonitoringWebStarter {
	public static void main(String[] args) {
		new LiteJettyServer().run(args);
	}
}
