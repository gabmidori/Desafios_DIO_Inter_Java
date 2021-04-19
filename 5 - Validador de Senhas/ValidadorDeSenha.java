import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ValidadorDeSenha {

    public static void main(String[] args) throws IOException {
        InputStream is = System.in;
        System.out.print("Digite uma senha: ");

        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String senha="";
        String patern = "^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$";

        //insira sua resolução aqui
        while (!(senha = br.readLine()).equals("sair")) {
            boolean quantidadeDeCaracter = senha.length() >= 6 && senha.length() <= 32;
            boolean contemLetraMaiuscula = false;
            boolean contemLetraMinuscula = false;
            boolean contemNumero = false;

            for(int indiceCaracter=0; indiceCaracter < senha.length(); indiceCaracter++){
                if(Character.isDigit(senha.charAt(indiceCaracter))){
                    contemNumero = true;
                }
                else if(Character.isLetter(senha.charAt(indiceCaracter))&& Character.isUpperCase(senha.charAt(indiceCaracter))){
                    contemLetraMaiuscula = true;
                }
                else if(Character.isLetter(senha.charAt(indiceCaracter)) && Character.isLowerCase(senha.charAt(indiceCaracter))){
                    contemLetraMinuscula =true;
                }
            }


            if ( quantidadeDeCaracter && contemLetraMaiuscula && contemLetraMinuscula && contemNumero) {
                if (!senha.matches(patern)){
                    System.out.println("Senha invalida.\n");
                }else{
                    System.out.println("Senha valida.\n");
                }
            } else {
                System.out.println("Senha invalida.\n");
            }
            System.out.print("Digite uma senha ou sair: ");
        }
    }

}
