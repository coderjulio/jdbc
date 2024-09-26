package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {
    public static void main(String[] args) throws SQLException {
//        try (Scanner scanner = new Scanner(System.in);
//             Connection conexao = FabricadeConexao.getConexao()) {
//
//            System.out.println("Informe o nome: ");
//            String nome = scanner.nextLine();
//
//            String sql = "INSERT INTO pessoas (nome) VALUES (?)";
//            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
//                stmt.setString(1, nome);
//                int inserted = stmt.executeUpdate();
//
//                if (inserted > 0) {
//                    System.out.println("Inserção bem sucedida");
//                }
//            }
//        } catch (SQLException e) {
//            System.err.println("Erro ao inserir no banco: " + e.getMessage());
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o nome: ");
        String nome = sc.nextLine();

        String sql = "INSERT INTO pessoas (nome) VALUES (?)";
        Connection conexao = FabricadeConexao.getConexao();
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.execute();
        System.out.println("Pessoa incluída com sucesso!");
        sc.close();
    }
}
