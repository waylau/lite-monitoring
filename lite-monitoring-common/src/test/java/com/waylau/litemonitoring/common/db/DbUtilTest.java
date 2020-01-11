/**
 * Welcome to https://waylau.com
 */
package com.waylau.litemonitoring.common.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DbUtil Test.
 * 
 * @since 1.0.0 2020年1月11日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public class DbUtilTest {
	
	static final Logger logger = 
		    LoggerFactory.getLogger(DbUtilTest.class);
	
	@Test
	void testGetConnection() throws IOException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		try {
			logger.info("Creating connection.");
			conn = DbUtil.getConnection();
			logger.info("Creating statement.");
			stmt = conn.createStatement();
			logger.info("Executing statement.");
			boolean insertResult = stmt.execute(
					"INSERT INTO t_host_info (host,create_time,used_memory,"
					+ "total_memory,used_cpu) VALUES "
					+ "('i@waylau.com',54321, 123, 345, 0.24);");

			logger.info("Insert Results:" + insertResult);
			rset = stmt.executeQuery("select host,create_time,used_memory,"
					+ "total_memory,used_cpu from t_host_info;");
			logger.info("Query Results:");
			int numcols = rset.getMetaData().getColumnCount();

			while (rset.next()) {
				for (int i = 1; i <= numcols; i++) {
					logger.info(rset.getString(i));
				}
				logger.info("");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtil.releaseResources(rset, stmt, conn);
		}
	}
}
