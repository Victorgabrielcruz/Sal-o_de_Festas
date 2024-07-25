/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salao_de_festas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Víctor
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/SalaoFestas"; // URL corrigida
    private static final String USER = "postgres";
    private static final String PASSWORD = "cruzpereira10";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
