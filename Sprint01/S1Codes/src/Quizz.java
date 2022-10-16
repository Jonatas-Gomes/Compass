import java.util.InputMismatchException;
import java.util.Scanner;
public class Quizz {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nomeDoUsuario;
        String[] perguntas = new String[6]; // Guarda as perguntas
        String[] opcoes = new String[6]; // guarda as opções de respostas.
        int resposta;   // guardará a resposta do usuário em cada laço, em cada pergunta.
        int[] opcoesCorretas = new int[6];// guarda as respostas corretas
        int acertos = 0, erros = 0;
        //Abaixo, populando arrays.
        perguntas[0] = "Qual a capital do Canadá?: ";
        opcoes[0] = ("1- Toronto\n2- Ottawa\n3- Amsterdã\n4- Brasília");
        opcoesCorretas[0] = 2;

        perguntas[1] = "Em que ano aconteceu a queda do Muro de Berlim?: ";
        opcoes[1] = ("1- 1942\n2- 1979\n3- 1989\n4- 1985");
        opcoesCorretas[1] = 3;

        perguntas[2] = "Qual destes abaixo é considerado o pai do Java? ";
        opcoes[2] = ("1- Ryan Gosling \n2- Mark Hamill\n3- James Webb\n4- James Gosling");
        opcoesCorretas[2] = 4;

        perguntas[3] = "Qual o ano de criação do GITHUB? ";
        opcoes[3] = "1- 2005\n2- 2003\n2- 2009\n3- 2008\n4- 2010";
        opcoesCorretas[3] = 3;

        perguntas[4] = "Em que ano faleceu o pianista e cantor Ray Charles?";
        opcoes[4] = "1- 1995\n2- 2000\n3- 2004\n4-2008";
        opcoesCorretas[4] = 3;

        perguntas[5] = "Por quem e quando foi criado a ferramenta GIT";
        opcoes[5] = "1- Gabe Newell - 2005\n2- Gordon Freeman - 1999\n3- Larry Tesler - 2004\n4- Linus Torvald - 2005";
        opcoesCorretas[5] = 4;

        System.out.println("Digite seu nome: ");
        nomeDoUsuario = scan.nextLine();

        for (int i = 0; i < perguntas.length; i++) {
            try {
                System.out.println("Q" + (i + 1) + ")- " + perguntas[i]);
                System.out.println(opcoes[i]);
                System.out.println("Digite um número inteiro de 1 a 4 que corresponda a opção correta: ");
                resposta = scan.nextInt();
                while (resposta < 1 || resposta > 4) {
                    System.out.println("Opção invalida! digite um número entre 1 e 4.");
                    resposta = scan.nextInt();
                }

                if (resposta == opcoesCorretas[i]) {
                    System.out.println("Muito bem! você acertou!");
                    acertos++;

                } else {
                    System.out.println(("Que pena! Você errou! a resposta certa é a opção: ") + opcoesCorretas[i]);
                    erros++;

                }
            }catch(InputMismatchException e){
                System.out.println("Entrada invalida, digite apenas números!");
                scan.nextLine(); // limpar buffer
                i--; // para retornar um loop, retorna ao loop da entrada inválida.
            }
        }
        System.out.println("Usuário: " + nomeDoUsuario);
        System.out.println("Acertos: "+acertos+"\nErros: "+ erros);



    }
}