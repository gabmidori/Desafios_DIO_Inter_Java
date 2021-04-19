import java.io.*;

public class EncontreAMaiorString {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException, IOException {
        String string1, string2, max, min; //declare suas variaveis aqui
        while ((string1 = in.readLine()) != null) { // complete seu código
            string2 = in.readLine();
            if (string1.length() > string2.length()){
                max = string1;
                min = string2;
            } else {
                max = string2;
                min = string1;
            }
            int minLength = min.length();
            int maxS = minLength;
            boolean f = true;
            while (maxS > 0 && f) { //altere as variaveis, se achar necessario
                int diff = minLength - maxS;
                for (int i = 0; i <= diff; i++ ) { //complete o laco de repeticao
                    if (max.contains(min.substring(i, i + maxS))) {
                        f = false;
                        maxS++;
                        break;
                    }
                }
                maxS--;
            }
            System.out.println(maxS);
        }
        out.close();
    }
}
