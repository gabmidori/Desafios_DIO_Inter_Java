import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class EntrevistaEmbaracosa {
    public static void main(String[] args) throws IOException, IOException {
        InputStream is = System.in;
        System.out.print("Digite um texto: ");

        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());

        //insira sua solução aqui
        String stringEntrada, stringSaida;
        boolean temSubstring;
        while((stringEntrada = br.readLine()) != ""){
            for(int i =0 ; i <= stringEntrada.length() - 1; i++){
                if(stringEntrada.substring(0,i).endsWith(stringEntrada.substring(i))){
                    stringSaida = stringEntrada.substring(0,i);
                    System.out.println(stringSaida);
                    temSubstring = true;
                }
            }
            if (temSubstring = false){
                System.out.println(stringEntrada);
            }
        }
    }
}
