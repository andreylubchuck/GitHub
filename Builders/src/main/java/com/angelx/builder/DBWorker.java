package com.angelx.builder;

import java.sql.*;

public class DBWorker {
    protected static final String URL = "jdbc:mysql://localhost:3307/coctails";
    protected static final String USERNAME = "andreylubchuck";
    protected static final String PASSWORD = "27091975qwe";

    private Connection connection;

    public DBWorker() {

    }
}