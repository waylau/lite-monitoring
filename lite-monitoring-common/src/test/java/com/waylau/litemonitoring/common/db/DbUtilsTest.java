/**
 * Welcome to https://waylau.com
 */
package com.waylau.litemonitoring.common.db;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.waylau.litemonitoring.common.api.HostInfo;

/**
 * DbUtils Test.
 * 
 * @since 1.0.0 2020年1月11日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@TestMethodOrder(OrderAnnotation.class)
public class DbUtilsTest {
	static final Logger logger = 
		    LoggerFactory.getLogger(DbUtilsTest.class);
	
	private static final String SQL_QUERY =
			"SELECT host, create_time AS createTime, used_memory AS usedMemory, "
					+ "total_memory AS totalMemory, used_cpu AS usedCpu "
					+ "FROM t_host_info ORDER BY create_time desc LIMIT 10";

	private static final String SQL_INSERT =
			"INSERT INTO t_host_info (host, create_time, used_memory, "
			+ "total_memory, used_cpu) VALUES (?, ?, ?, ?, ?)";

	private static final String SQL_UPDATE =
			"UPDATE t_host_info SET create_time=?, used_memory=?, "
			+ "total_memory=?, used_cpu=? WHERE host=?";

	private static final String SQL_DELETE =
			"DELETE FROM t_host_info WHERE host=?";

	@Test
	@Order(3)
	void testQueryRunnerBeanHandler() throws IOException, SQLException {
		QueryRunner run = new QueryRunner(DbUtil.getDataSource());
	
		// BeanHandler用于将ResultSet中的第一条记录转为JavaBean
		ResultSetHandler<HostInfo> h = new BeanHandler<HostInfo>(HostInfo.class);
		HostInfo p = run.query(SQL_QUERY, h);

		logger.info(p.toString());
	}

	@Test
	@Order(4)
	void testQueryRunnerBeanListHandler() throws IOException, SQLException {
		QueryRunner run = new QueryRunner(DbUtil.getDataSource());

		// BeanListHandler用于将ResultSet中的所有记录转为JavaBean List
		ResultSetHandler<List<HostInfo>> h = new BeanListHandler<HostInfo>(HostInfo.class);
		List<HostInfo> hostInfoList = run.query(SQL_QUERY, h);
		
		logger.info(hostInfoList.toString());
	}

	@Test
	@Order(1)
	void testQueryRunnerInsert() throws IOException, SQLException {
		QueryRunner run = new QueryRunner(DbUtil.getDataSource());

		// 创建
		int inserts = run.update(SQL_INSERT, "i@waylau.com", 54321, 123, 345, 0.24);
		logger.info("Insert Results：{}" ,inserts);
	}

	@Test
	@Order(2)
	void testQueryRunnerUpdate() throws IOException, SQLException {
		QueryRunner run = new QueryRunner(DbUtil.getDataSource());

		// 更新
		int inserts = run.update(SQL_UPDATE, 4444, 1213, 3451, 0.54, "i@waylau.com");
		logger.info("Update Results：{}" ,inserts);

	}

	@Test
	@Order(5)
	void testQueryRunnerDelete() throws IOException, SQLException {

		QueryRunner run = new QueryRunner(DbUtil.getDataSource());
		// 删除
		int inserts = run.update(SQL_DELETE, "i@waylau.com");
		logger.info("Deleted Results：{}" ,inserts);
	}
}
