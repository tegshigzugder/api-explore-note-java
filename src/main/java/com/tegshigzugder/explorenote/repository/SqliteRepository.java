package com.tegshigzugder.explorenote.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

@Service
public class SqliteRepository {
    public void createUser(String username, String email, String passwordhash) {
        // TODO replace sqlite with postgresql
        try ( // try-with-resources
                Connection connection = DriverManager.getConnection("jdbc:sqlite:explorenote.db");
                Statement statement = connection.createStatement();) {
            statement.setQueryTimeout(30);
            // statement.executeUpdate(
            // "CREATE TABLE users (id integer, username string, email string, passwordhash
            // string)");
            String sql = "INSERT INTO users (id, username, email, passwordhash) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, username);
                pstmt.setString(2, username);
                pstmt.setString(3, email);
                pstmt.setString(4, passwordhash);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace(System.err);
            }
            ResultSet rs = statement.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println("id = " + rs.getInt("id"));
                System.out.println("username = " + rs.getString("username"));
                System.out.println("email = " + rs.getString("email"));
                System.err.println("passwordhash = " + rs.getString("passwordhash"));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }
}
