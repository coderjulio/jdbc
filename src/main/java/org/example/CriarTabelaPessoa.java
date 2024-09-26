package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaPessoa {
    public static void main(String[] args) throws SQLException {

        Connection conexao = FabricadeConexao.getConexao();

        String sql = "CREATE TABLE pessoas (" +
                "codigo INT AUTO_iNCREMENT PRIMARY KEY," +
                "nome VARCHAR(80) NOT NULL" +
                ")";

        Statement stmt = conexao.createStatement();

        stmt.execute(sql);

        System.out.println("Tabela criada com sucesso!!");
        conexao.close();
    }
}
