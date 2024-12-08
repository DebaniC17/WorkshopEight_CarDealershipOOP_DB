package com.ps;

import org.apache.commons.dbcp2.BasicDataSource;

public class Main {
    public static void main(String[] args) {
    BasicDataSource basicDataSource = new BasicDataSource();
    basicDataSource.setUrl("jdbc:mysql://localhost:3306/dealerships_db");
    basicDataSource.setUsername(args[0]);
    basicDataSource.setPassword(args[1]);


    }
}