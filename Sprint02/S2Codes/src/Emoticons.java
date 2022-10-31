import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Emoticons {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);
        String smileyRegex = "\\:-\\)";
        String sadFaceRegex = "\\:-\\(";
        int contadorSmiley = 0;
        int contadorSadFace = 0;

        System.out.println("Digite uma frase: ");
        String frase = scan.nextLine();
        contadorSmiley = buscaRegex(frase, smileyRegex);
        contadorSadFace = buscaRegex(frase,sadFaceRegex);
        if(contadorSmiley > contadorSadFace){
            System.out.println("divertido");
        }else if(contadorSmiley == contadorSadFace || (contadorSmiley == 0 && contadorSadFace == 0) ){
            System.out.println("neutro");
        }else{
            System.out.println("chateado");
        }
    }

    public static int buscaRegex(String frase, String regex){
        int contador = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(frase);
        while(matcher.find()){
            //System.out.println(matcher.start());
            contador++;
        }
        return contador;
    }
}
