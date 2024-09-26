package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection conexao = FabricadeConexao.getConexao();

        Statement stmt = conexao.createStatement();
        stmt.execute("CREATE DATABASE IF NOT EXISTS Javacursos");

        System.out.println(" Banco criado com sucesso!");
        conexao.close();

    }
}