import java.io.BufferedReader;
import java.io.InputStreamReader;

public class primeiroDicionario {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] entrada = new String[1000];
        String[] palavras = new String[1000];
        String texto = "";
        String linha = "";
        int numEntrada = 0, aux = 0;
        linha = br.readLine();
        while (linha != null) {
            entrada[numEntrada] = linha.toLowerCase();
            linha = br.readLine();
            numEntrada++;
        }
        for (int i = 0; i < numEntrada; i++) {
            texto = texto + entrada[i] + " ";
        }
        texto = texto.replace("(*$", " ").replace("#.", " ").replace(".", " ").replace("\"", "").replace(":", " ")
                .replace("  ", " ");
        texto = texto.replace("  ", " ");
        palavras = texto.split(" ");
        /**
         * Algoritmo de ordenacao por selecao.
         */

        for (int i = 0; i < (palavras.length - 1); i++) {
            int menor = i;
            for (int j = (i + 1); j < palavras.length; j++) {
                if ((palavras[menor].compareTo(palavras[j])) > 0) {
                    menor = j;
                }
            }
            String temp = palavras[menor];
            palavras[menor] = palavras[i];
            palavras[i] = temp;
        }

        for (int i = 0; i < palavras.length; i++) {
            System.out.println(palavras[i]);
        }

        br.close();

    }
}
