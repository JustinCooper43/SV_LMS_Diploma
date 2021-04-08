package com.streltsov.SV_LMS_Diploma.dao.jdbcImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingle {

    private static final String path = "jdbc:h2:file:/Users/macuser/IdeaProjects/SV_LMS_Diploma/src/main/java/com/streltsov/SV_LMS_Diploma/testDB";

    public static Connection getConnectionToAll() {
        Connection connect = null;
        try {
            Class.forName("org.h2.Driver");
            connect = DriverManager.getConnection(path);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return connect;
    }
}
