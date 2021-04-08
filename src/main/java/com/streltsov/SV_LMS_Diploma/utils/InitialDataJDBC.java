package com.streltsov.SV_LMS_Diploma.utils;

import com.streltsov.SV_LMS_Diploma.dao.jdbcImpl.ConnectionSingle;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class InitialDataJDBC {

    Connection connect = ConnectionSingle.getConnectionToAll();

    public void createInitialData() throws SQLException {
        Statement statementTables = null;
        Statement statementData = null;
        String queryTables = readQueryFile("src/main/resources/tablesScript.sql");
        String queryData = readQueryFile("src/main/resources/initialDataSQL.sql");
        try {
            statementTables = connect.createStatement();
            statementTables.executeUpdate(queryTables);
            statementData = connect.createStatement();
            statementData.executeUpdate(queryData);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            assert statementTables != null;
            statementTables.close();
        }
    }

    static String readQueryFile(String path) {
        String query = null;
        try {
            query = String.join("", Files.readAllLines(Paths.get(path)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return query;
    }
}
