package com.ruoyi.project.tool.codegenerator.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class SqlTableAnalysis {

    private static Logger logger = Logger.getLogger("SqlTableAnalysis.class");

    private static final String SQL = "SELECT * FROM ";// 数据库操作


    /**
     * 获取数据库下的所有表名
     */
    public List<String> getTableNames() {
        List<String> tableNames = new ArrayList<>();
        Connection conn = ConnectionUtil.getConnection();
        ResultSet rs = null;
        try {
            //获取数据库的元数据
            DatabaseMetaData db = conn.getMetaData();
            //从元数据中获取到所有的表名
            rs = db.getTables(null, null, null, new String[]{"TABLE"});
            while (rs.next()) {
                tableNames.add(rs.getString(3));
            }
        } catch (SQLException e) {
            logger.info("getTableNames failure");
        } finally {
            try {
                rs.close();
                ConnectionUtil.release(conn, null);
            } catch (SQLException e) {
                logger.info("close ResultSet failure");
            }
        }
        return tableNames;
    }

    /**
     * 获取表中所有字段名称
     */
    public List<String> getColumnNames(String tableName) {
        List<String> columnNames = new ArrayList<>();
        //与数据库的连接
        Connection conn = ConnectionUtil.getConnection();
        PreparedStatement pStemt = null;
        String tableSql = SQL + tableName;
        try {
            pStemt = conn.prepareStatement(tableSql);
            //结果集元数据
            ResultSetMetaData rsmd = pStemt.getMetaData();
            //表列数
            int size = rsmd.getColumnCount();
            for (int i = 0; i < size; i++) {
                columnNames.add(rsmd.getColumnName(i + 1));
            }
        } catch (SQLException e) {
            logger.info("getColumnNames failure");
        } finally {
            if (pStemt != null) {
                try {
                    pStemt.close();
                    ConnectionUtil.release(conn, null);
                } catch (SQLException e) {
                    logger.info("getColumnNames close pstem and connection failure");
                }
            }
        }
        return columnNames;
    }

    /**
     * 获取表中所有字段类型
     *
     * @param tableName
     * @return
     */
    public  List<String> getColumnTypes(String tableName) {
        List<String> columnTypes = new ArrayList<>();
        //与数据库的连接
        Connection conn = ConnectionUtil.getConnection();
        PreparedStatement pStemt = null;
        String tableSql = SQL + tableName;
        try {
            pStemt = conn.prepareStatement(tableSql);
            //结果集元数据
            ResultSetMetaData rsmd = pStemt.getMetaData();
            //表列数
            int size = rsmd.getColumnCount();
            for (int i = 0; i < size; i++) {
                columnTypes.add(rsmd.getColumnTypeName(i + 1));
            }
        } catch (SQLException e) {
            System.out.println("getColumnTypes failure");
        } finally {
            if (pStemt != null) {
                try {
                    pStemt.close();
                    ConnectionUtil.release(conn, null);
                } catch (SQLException e) {
                    System.out.println("getColumnTypes close pstem and connection failure");
                }
            }
        }
        return columnTypes;
    }

}
