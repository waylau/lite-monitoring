/**
 * Welcome to https://waylau.com
 */
package com.waylau.litemonitoring.client.oshi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;

/**
 * 
 * @since 1.0.0 2020年1月5日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public class GlobalMemoryTest {
    private static final Logger logger = LoggerFactory.getLogger(SystemInfoTest.class);

    public static void main(String[] args) {
        logger.info("Initializing System...");
        SystemInfo si = new SystemInfo();

        HardwareAbstractionLayer hal = si.getHardware();
        
        GlobalMemory memory = hal.getMemory();
        logger.info(memory.getAvailable() + "");
        logger.info(memory.getTotal() + "");
        logger.info(memory.toString() + "");
    }
    
}
