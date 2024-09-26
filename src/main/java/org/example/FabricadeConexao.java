package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricadeConexao {
    public static Connection getConexao(){
        try{
            String url = "jdbc:mysql://localhost:3306/Javacursos?useSSL=false";
            String user = "root";
            String password = "senaigama";

            return DriverManager.getConnection(url,user,password);
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
