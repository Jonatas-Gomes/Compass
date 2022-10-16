import java.text.ParseException;
import java.time.LocalTime;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) throws ParseException {
        Scanner scan = new Scanner (System.in);
        String[] usuarios = new String[4]; //Armazena os usuarios
        String[] senhas = new String[4];   // Armazena as senhas dos usuarios;

        String login;
        String senha;

        System.out.println("Digite seu Login: ");
        login = scan.nextLine();
        login = login.replace(" ", ""); // retira espaços em branco
        while(login.isEmpty()){                    // loop que verifica entrada vazias, ou seja, entradas somente com espaços em branco.
            System.out.println("Entrada vazia! digite o login corretamente: ");
            login = scan.nextLine();
            login = login.replace(" ", "");

        }

        System.out.println("Digite sua senha: ");
        senha = scan.nextLine();
        senha = senha.replace(" ", ""); // retira espaços em branco
        while(senha.isEmpty()){
            System.out.println("Entrada vazia! digite a senha corretamente: ");
            senha = scan.nextLine();
            senha = senha.replace(" ", "");
        }

        //Abaixo, populando arrays de usuarios e senhas;
        usuarios[0] = "Black";
        senhas[0] = "Charizard123";

        usuarios[1] = "Napoleon";
        senhas[1] = "Myhorseisblack";

        usuarios[2] = "Nefesus";
        senhas[2] = "codelove";

        usuarios[3] = "Ash";
        senhas[3] ="pikachu123";


        LocalTime horarioAtual = LocalTime.now(); // Captura o horario atual do pc;
        LocalTime [] faixasDeHorario = new LocalTime[7];// Guarda as faixas de horario
        faixasDeHorario[0] = LocalTime.of(11,59); // Populando os arrays com as faixas horário
        faixasDeHorario[1] = LocalTime.of(12,0);
        faixasDeHorario[3] = LocalTime.of(18,0);
        faixasDeHorario[4] = LocalTime.of(17,59);
        faixasDeHorario[5] = LocalTime.of(23,59);
        faixasDeHorario[6] = LocalTime.of(05,59);

        for (int i = 0; i < usuarios.length; i++) {
            if (login.equals(usuarios[i]) && senha.equals(senhas[i])) {
                if(horarioAtual.isBefore(faixasDeHorario[1]) && horarioAtual.isAfter(faixasDeHorario[6]) ) { // Antes das 12:00 e após 05:59
                    System.out.println("Bom dia, você se logou ao nosso sistema.");
                }else if(horarioAtual.isBefore(faixasDeHorario[3]) && horarioAtual.isAfter(faixasDeHorario[0])){ // Antes das 18h e após as 11:59
                    System.out.println("Boa tarde, você se logou ao nosso sistema.");
                }else if(horarioAtual.isBefore(faixasDeHorario[5]) && horarioAtual.isAfter(faixasDeHorario[4]) || horarioAtual.equals(faixasDeHorario[5])){
                    System.out.println("Boa noite, você se logou ao nosso sistema."); // Antes das 23h59 e após 17:59
                }else{
                    System.out.println("Boa madrugada, você se logou ao nosso sistema"); // após as 23h59 e antes das 05:59.
                }
                break;
            }
            if(i == usuarios.length -1){
                System.out.println("Nome de usuario e/ou senha incorretos!");
            }

        }

    }
}
