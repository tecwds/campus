package com.project.C3P0utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Utils {
    private static ComboPooledDataSource ds;

    static {
        ds = new ComboPooledDataSource();
    }

    public static DataSource getDataSource() {
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    // 关闭连接池方法，确保在应用关闭时调用
    public static void closeDataSource() {
        if (ds != null) {
            ds.close();
        }
    }
}
