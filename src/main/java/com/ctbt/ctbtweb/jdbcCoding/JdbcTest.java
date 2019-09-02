package com.ctbt.ctbtweb.jdbcCoding;

import java.sql.SQLException;

public class JdbcTest {
    public static void main(String[] args) throws SQLException {
        JdbcOracle jdbcOracle = new JdbcOracle();
        String sql = "select * from SHIPS_TABLE s where s.ID not in (select r.SHIPID from SHIPSTOUSERS_TABLE r where USERID=1486) and\n" +
                "                                         s.NAME like '%浙三渔%'";
        String sql2 = "select * from SHIPS_TABLE s where s.ID not in (select r.SHIPID from SHIPSTOUSERS_TABLE r where USERID=1486) and\n" +
                "                                         s.ID in (select r.SHIPID from SHIPSTOUSERS_TABLE r where r.USERID=122) and\n" +
                "                                         s.NAME like '%浙三渔%'";
        String sql3 = "insert into SHIPSTOUSERS_TABLE (ID,SHIPID,USERID) values (" + 3014606 + "," + 1753043 + "," + 122 + ")";
//        jdbcOracle.query("select * from SHIPSTOUSERS_TABLE");
        jdbcOracle.query(sql3);
//        String sql2="insert into "
//        jdbcOracle.query(sql2);
//        System.out.println(sql2);
    }
}
