package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizarPessoa {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o código da pessoa:");
        int codigo = sc.nextInt();

        String select = "SELECT codigo, nome FROM pessoas WHERE codigo = ?";
        String update = "UPDATE pessoas SET nome = ? WHERE codigo = ?";

        Connection conexao = FabricadeConexao.getConexao();
        PreparedStatement stmt = conexao.prepareStatement(select);
        stmt.setInt(1, codigo);
        ResultSet resultado = stmt.executeQuery();

        if(resultado.next()){
            Pessoas p = new Pessoas(resultado.getInt(1), resultado.getString(2));
            System.out.println("O nome atual é: " + p.getNome());
            sc.nextLine();

            System.out.println("Informe o novo nome: ");
            String Novonome = sc.nextLine();

            stmt.close();

            stmt = conexao.prepareStatement(update);
            stmt.setString(1, Novonome);
            stmt.setInt(2,codigo);
            stmt.execute();
            System.out.println("Pessoa encontrada com sucesso! ");
        } else {
            System.out.println("Pessoa não encontrada! ");
        }
        conexao.close();
        sc.close();
    }
}
