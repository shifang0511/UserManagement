package org.shifang.usermanage.log;
import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionFactory {
    private static final DataSource dataSource;
    private static final String DB_PROPERTIES_PATH = "/db.properties";

    static {
        Properties properties = new Properties();
        try (InputStream stream = ConnectionFactory.class.getResourceAsStream(DB_PROPERTIES_PATH)) {
            if (stream == null) {
                throw new ExceptionInInitializerError("Unable to find " + DB_PROPERTIES_PATH + " on classpath");
            }
            properties.load(stream);

            DruidDataSource druidDataSource = new DruidDataSource();
            druidDataSource.configFromPropety(properties);

            // 验证数据源配置是否正确，尝试获取连接
            try (Connection testConnection = druidDataSource.getConnection()) {
                if (testConnection != null) {
                    dataSource = druidDataSource;
                } else {
                    throw new ExceptionInInitializerError("DataSource configuration failed, cannot obtain a valid connection.");
                }
            }
        } catch (IOException | SQLException e) {
            throw new ExceptionInInitializerError("Failed to initialize DataSource: " + e.getMessage() + e);
        }
    }

    /**
     * 获取数据库连接。
     *
     * @return 数据库连接对象
     * @throws SQLException 连接数据库失败时抛出
     */
    public static Connection getDatabaseConnection() throws SQLException {
        return dataSource.getConnection();
    }
}

