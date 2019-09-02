package com.ctbt.ctbtweb.jdbcCoding;

import java.sql.*;

public class JdbcOracle {
    private static Connection connection = null;
    private static String driver = "oracle.jdbc.driver.OracleDriver";
    private static String url = "jdbc:oracle:thin:@192.168.1.16:1521:orcl";
    private static String username = "NewCTBT";
    private static String password = "newctbt";

    private static synchronized Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, username, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void query(String sql, boolean isSelect) throws SQLException {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println(name);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void query(String sql) throws SQLException {
        PreparedStatement preparedStatement;
        preparedStatement = getConnection().prepareStatement(sql);
        ResultSet result = preparedStatement.executeQuery();
        int i = 1;
        int ID = 3014588;
        while (result.next()) {
//            System.out.println(i + " " + "SHIPID: " + result.getInt("ID"));
            System.out.println(result.getInt("ID"));
            i++;
            ID++;
        }
        preparedStatement.execute();
        preparedStatement.close();
    }


    public void close() {
        try {
            getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
