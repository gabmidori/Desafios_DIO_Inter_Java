import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class ConjuntosBonsOuRuins {
    public static void main(String[] args) throws IOException, IOException {
        InputStream is = System.in;
        System.out.print("Digite um texto: ");

        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        int N = Integer.valueOf(br.readLine());
        //insira sua solução aqui

        //A entrada termina quando N = 0
        while(N != 0){
            //Adiciona as palavras aos conjuntos
            List<String> conjuntos = new ArrayList<>();
            for(int i =0; i < N; i++){
                conjuntos.add(br.readLine());

                //ordenação dos conjuntos para facilitar a verificação de prefixo
                conjuntos = conjuntos.stream().sorted().collect(Collectors.toList());

            }
            System.out.println(conjuntos);

            //Verifica se o conjunto é Bom ou Ruim
            String resultadoConjunto = "";

            //percorrer cada conjunto
            for(int i =0; i < N -1 ; i++){
                if(conjuntos.get(i+1).startsWith(conjuntos.get(i))){
                    resultadoConjunto = "Conjunto Ruim";
                    break;
                }
                else resultadoConjunto = "Conjunto Bom";

            }

            //Imprime a saída
            System.out.println(resultadoConjunto);
            N = Integer.valueOf(br.readLine());
        }
    }
}
