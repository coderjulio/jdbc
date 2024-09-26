package org.example;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultarDados {
    public static void main(String[] args) throws SQLException {
       Connection conexao = FabricadeConexao.getConexao();
       String sql = "SELECT * FROM pessoas";
        Statement stmt = conexao.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);

        List<Pessoas> pessoas = new ArrayList<>();

        while(resultado.next()){
            int codigo = resultado.getInt("codigo");
            String nome = resultado.getString("nome");
            pessoas.add(new Pessoas(codigo, nome));
        }

        for(Pessoas p: pessoas){
            System.out.println(p.getCodigo() + "-->" + p.getNome());
        }
        stmt.close();
        conexao.close();
    }
}
