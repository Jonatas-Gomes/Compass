import dao.ProdutoDAO;
import factory.ConnectionFactory;
import modelo.Produto;

import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ProdutoMain {
    public static void main(String[] args){
        Connection connection = new ConnectionFactory().recuperaConexao();
        ProdutoDAO produtoDAO = new ProdutoDAO(connection);
        Scanner scan = new Scanner(System.in);
        int opcao = 0;
        Produto cadeira = new Produto("Cadeira", "Cadeira MX5", 5, 750.00);
        Produto mesa = new Produto("Mesa", "Mesa Gamer PKMN", 3, 700.00);
        Produto abajur = new Produto("Abajur", "Abajur Gamer PKMN", 7, 150);
        loopinfinito: while(true) {
           System.out.println("DIGITE UMA OPÇÃO:\n 1- CADASTRAR 3 PRODUTOS\n 2- ALTERE O PRIMEIRO PRODUTO INSERIDO\n 3- EXCLUA O SEGUNDO PRODUTO INSERIDO\n " +
                   "0- PARA SAIR");
           for (int i = 0; i < 1; i++) {
               try {
                   opcao = scan.nextInt();
                   while (opcao < 0 || opcao > 3) {
                       System.out.println("Opção incorreta! digite um número inteiro entre 0 e 3");
                       opcao = scan.nextInt();
                   }
               } catch (InputMismatchException e) {
                   System.out.println("Digite apenas números: ");
                   i--;
                   scan.nextLine();
               }
           }
           switch (opcao) {
               case 1:
                   produtoDAO.salvaTresProdutos(cadeira, mesa, abajur);
                   break;
               case 2:
                       produtoDAO.altera("Cadeira Gamer God of War", 1200.00);
                   break;
               case 3:
                   produtoDAO.deleta(mesa);
                   break;
               case 0:
                   produtoDAO.deletaTodosCampos(); // deletar todos os campos ao final da execução do programa para facilitar testagens.
                   System.out.println("Fim da execução do programa!");
                   break loopinfinito;
           }
       }
    }
}