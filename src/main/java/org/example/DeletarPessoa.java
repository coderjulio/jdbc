package org.example;//package org.example;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//public class DeletarPessoa {
//    public static void main(String[] args) throws SQLException {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Informe o código da pessoa a ser deletada:");
//        int codigo = sc.nextInt();
//
//        String select = "SELECT codigo, nome FROM pessoas WHERE codigo = ?";
//        String delete = "DELETE FROM pessoas WHERE codigo = ?";
//        String update = "UPDATE pessoas SET codigo = codigo - 1 WHERE codigo > ?";
//
//        Connection conexao = FabricadeConexao.getConexao();
//        PreparedStatement stmt = conexao.prepareStatement(select);
//        stmt.setInt(1, codigo);
//        ResultSet resultado = stmt.executeQuery();
//
//        if (resultado.next()) {
//            String nome = resultado.getString(2);
//            System.out.println("Pessoa encontrada: " + nome);
//            System.out.println("Tem certeza que deseja deletar esta pessoa? (s/n)");
//            sc.nextLine(); // Limpar o buffer do scanner
//            String resposta = sc.nextLine();
//
//            if (resposta.equalsIgnoreCase("s")) {
//                // Atualizar códigos das pessoas que têm código maior
//                stmt.close();
//                stmt = conexao.prepareStatement(update);
//                stmt.setInt(1, codigo);
//                stmt.execute();
//
//                // Deletar a pessoa
//                stmt.close();
//                stmt = conexao.prepareStatement(delete);
//                stmt.setInt(1, codigo);
//                stmt.execute();
//
//                System.out.println("Pessoa deletada com sucesso!");
//            } else {
//                System.out.println("Operação cancelada.");
//            }
//        } else {
//            System.out.println("Pessoa não encontrada!");
//        }
//
//        conexao.close();
//        sc.close();
//    }
//}
//
import org.example.FabricadeConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletarPessoa {
//    public static void main(String[] args) throws SQLException {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Informe o código da pessoa a ser deletada:");
//        int codigo = sc.nextInt();
//
//        String select = "SELECT codigo, nome FROM pessoas WHERE codigo = ?";
//        String delete = "DELETE FROM pessoas WHERE codigo = ?";
//
//        Connection conexao = FabricadeConexao.getConexao();
//        PreparedStatement stmt = conexao.prepareStatement(select);
//        stmt.setInt(1, codigo);
//        ResultSet resultado = stmt.executeQuery();
//
//        if (resultado.next()) {
//            String nome = resultado.getString(2);
//            System.out.println("Pessoa encontrada: " + nome);
//            System.out.println("Tem certeza que deseja deletar esta pessoa? (s/n)");
//            sc.nextLine(); // Limpar o buffer do scanner
//            String resposta = sc.nextLine();
//
//            if (resposta.equalsIgnoreCase("s")) {
//                stmt.close();
//
//                stmt = conexao.prepareStatement(delete);
//                stmt.setInt(1, codigo);
//                stmt.execute();
//                System.out.println("Pessoa deletada com sucesso!");
//            } else {
//                System.out.println("Operação cancelada.");
//            }
//        } else {
//            System.out.println("Pessoa não encontrada!");
//        }
//
//        conexao.close();
//        sc.close();


        public static void main(String[] args) throws SQLException{
            Scanner sc1 = new Scanner(System.in);
            System.out.println("Informe o codigo da pessoa: ");
            int codigo = sc1.nextInt();

            String select = "DELETE FROM pessoas WHERE codigo = ?";

            Connection conexao = FabricadeConexao.getConexao();
            PreparedStatement stmt = conexao.prepareStatement(select);
            stmt.setInt(1, codigo);

            int contador = stmt.executeUpdate();

            if(contador > 0) {
                System.out.println("Pessoa excluida com sucesso!");
            } else {
                System.out.println("Nada feito!!");
            }

            System.out.println("Linhas afetadas" + contador);

            conexao.close();
            sc1.close();

        }
}