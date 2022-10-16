import java.util.InputMismatchException;
import java.util.Scanner;

public class MainFuncionario {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        int quantidadeFuncionarios = 0;
        for (int i =0; i < 1; i++){
            try{  // trycatch para pegar exceptions de entrada invalidas
                System.out.print("Digite a quantidade funcionários que serão cadastrados: ");
                quantidadeFuncionarios = scan.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Entrada invalida! Digite apenas números. ");
                i--; // volta ao loop anterior
                scan.nextLine(); // limpabuffer
            }
        }
        Funcionario[] listaDeFuncionarios = new Funcionario[quantidadeFuncionarios];
        String nome;
        double salario = 0;

        for (int i = 0; i < listaDeFuncionarios.length;i++){
            try {
                scan.nextLine(); // limpar buffer do teclado;
                System.out.println("Digite o nome do " + (i + 1) + "º funcionario");
                nome = scan.nextLine();
                nome = nome.trim(); // remove espaços em branco do inicio e fim da string.
                while (nome.isEmpty()) { // verifica entrada strings em branco.
                    System.out.println("Entrada inválida! Digite corretamente o nome do funcionário: ");
                    nome = scan.nextLine();
                    nome = nome.trim();
                }

                System.out.println("Digite o salario de " + nome);
                salario = scan.nextDouble();
                while (salario <= 0) {
                    System.out.println("Não é permitido salário negativo! digite o salário corretamente: ");
                    salario = scan.nextDouble();
                }
                listaDeFuncionarios[i] = new Funcionario(nome, salario); // cria objeto funcionario e armazena no vetor
                listaDeFuncionarios[i].calculaNovoSalario(salario); // chama função para calcular salarioLiquido, bonificação ou desconto.
            }catch(InputMismatchException exception){
                System.out.println("Entrada invalida, digite apenas números na entrada salário. ");
                i--;
            }

        }

        for (int i = 0; i < listaDeFuncionarios.length;i++){ // imprime os funcionarios, utilizando os benefícios da reescrita do metodo toString.
            System.out.println(listaDeFuncionarios[i]);
        }

    }
}
