package com.ctbt.ctbtweb.jdbcCoding;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class ReadTxt {
    public static void main(String[] args) throws IOException, SQLException {
        JdbcOracle jdbcOracle = new JdbcOracle();
        String fileName = "E:\\JavaProjects\\JavaWork\\ctbt-web\\ships.txt";
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        int i = 1;
        int ID = 3014588;
        while (line != null) {
            System.out.println(i + " " + line);
            line = bufferedReader.readLine();
            String sql = "insert into SHIPSTOUSERS_TABLE (ID,SHIPID,USERID) values (" + ID + "," + line + "," + 122 + ")";
            jdbcOracle.query(sql);
            i++;
            ID++;
        }
        bufferedReader.close();
        fileReader.close();
    }
}
