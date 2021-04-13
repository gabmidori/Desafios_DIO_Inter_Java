import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.StringTokenizer;
import java.util.*;
import java.util.stream.Collectors;


public class AbreviandoPostsDoBlog {

    public static void main(String[] args) throws IOException {
        //abc abc abacaxi baleia bala bala bala casa caixa casa
        InputStream is = System.in;
        System.out.print("Digite um texto: ");

        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String frase = "";
        String line= "";

        //insira sua solução aqui
        Map<String, String> dicionarioDeAbreviacao = new HashMap<String, String>();
        Map<String, Map<String, Integer>> ocorrenciaDePalavra = new HashMap<String, Map<String, Integer>>();
        Map<String, Integer> mapReducaoDeCaracter = new HashMap<>();
        String palavra = "";

        //criar alfabeto
        List<String> alfabeto = new ArrayList(Arrays.asList("abcdefghijklmnopqrstuvwxyz".split("")));

        //gerar a frase
        while (!".".equals((line = br.readLine()))) {
            //mapear palavras de acordo com a letra
            alfabeto.stream().forEach(letra -> {
                dicionarioDeAbreviacao.put(letra, "");
                ocorrenciaDePalavra.put(letra, new HashMap<String, Integer>());
            });
            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                palavra = st.nextToken().toLowerCase();
                frase = frase + palavra + " ";
                //contar o número de repeticao das palavras com mais de 2 caracteres
                if (palavra.length() > 2) {
                    if (ocorrenciaDePalavra.get(palavra.substring(0, 1)).containsKey(palavra)) {
                        ocorrenciaDePalavra.get(palavra.substring(0, 1)).put(palavra, ocorrenciaDePalavra.get(palavra.substring(0, 1)).get(palavra) + 1);
                    } else {
                        ocorrenciaDePalavra.get(palavra.substring(0, 1)).put(palavra, 1);
                    }
                }
            }

            //calcular a reducao de caracteres
            for (String letra : alfabeto) {

                int caracteresReduzidos = 0;
                String palavraAbreviadaAtual = "";

                if (!ocorrenciaDePalavra.get(letra).isEmpty()) {
                    for (String palavraAbreviadaNova : ocorrenciaDePalavra.get(letra).keySet()) {
                        caracteresReduzidos = (palavraAbreviadaNova.length() - 2) * ocorrenciaDePalavra.get(letra).get(palavraAbreviadaNova);
                        mapReducaoDeCaracter.put(palavraAbreviadaNova, caracteresReduzidos);

                        palavraAbreviadaAtual = dicionarioDeAbreviacao.get(letra);

                        if (dicionarioDeAbreviacao.get(letra).isEmpty()) {
                            dicionarioDeAbreviacao.put(letra, palavraAbreviadaNova);
                        } else if (caracteresReduzidos > mapReducaoDeCaracter.get(palavraAbreviadaAtual)) {
                            dicionarioDeAbreviacao.put(letra, palavraAbreviadaNova);
                        }
                    }
                    //System.out.println(mapReducaoDeCaracter);
                }
            }
            //Substituir as palavras abreviadas

            int quantidadeDePalavraAbreviada = 0;
            String[] palavras = frase.split("\\s+");
            frase = "";
            for (String letra : dicionarioDeAbreviacao.keySet()) {
                if (!dicionarioDeAbreviacao.get(letra).isEmpty()) {
                    //contar palavras abreviadas
                    quantidadeDePalavraAbreviada++;

                    //substitui palavras abreviadas na frase
                    //frase = frase.replaceAll(dicionarioDeAbreviacao.get(letra),letra+".");

                    for (int i = 0; i < palavras.length; i++) {
                        if (dicionarioDeAbreviacao.get(letra).equals(palavras[i])) {
                            palavras[i] = letra + ".";
                        }
                    }
                }
            }
            for (int i = 0; i < palavras.length; i++) {
                frase += palavras[i] + " ";
            }
            //fazer o print da saida

            System.out.println(frase);
            System.out.println(quantidadeDePalavraAbreviada);

            for (String letra : dicionarioDeAbreviacao.keySet()) {
                if (!dicionarioDeAbreviacao.get(letra).isEmpty()) {
                    System.out.println(letra + ". " + "= " + dicionarioDeAbreviacao.get(letra));
                }
            }
            mapReducaoDeCaracter.clear();
            dicionarioDeAbreviacao.clear();
            ocorrenciaDePalavra.clear();
            frase = "";
        }
    }
}