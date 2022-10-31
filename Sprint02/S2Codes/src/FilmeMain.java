import dao.FilmeDAO;
import factory.ConnectionFactory;

import java.sql.Connection;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FilmeMain {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int pagina;
        Connection connection = new ConnectionFactory().recuperaConexao();
        FilmeDAO filmeDAO = new FilmeDAO(connection);
       for (int i = 0; i < 1; i++) {
           try {
               System.out.println("Quantos filmes você deseja ver?");
               int numerosDefilmes = scan.nextInt();
               do {
                   System.out.println("Qual pagina você quer consulta? Escolha uma das opções abaixo: \n1- Pagina 1\n2- Pagina 2");
                   pagina = scan.nextInt();
               } while (pagina < 1 || pagina > 2);
               filmeDAO.listaPaginada(pagina, numerosDefilmes);
           } catch (InputMismatchException e) {
               System.out.println("Digite apenas números: ");
               scan.nextLine();
               i--;
           }
       }

    }
}
