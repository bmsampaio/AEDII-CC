import java.util.Random;

public class AlteracaoAleatoria {
    /**
     * isFim - metodo para dizer se a string recebida
     * e a palavra FIM.
     * 
     * @param str - string a ser analizada.
     * @return true - se a string for a palavra FIM;
     *         false- caso contrario.
     */
    public static boolean isFim(String str) {
        boolean resposta = false;
        int tamanho = str.length();
        if (tamanho == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M') {
            resposta = true;
        } // end if
        return resposta;
    }// end isFim

    /**
     * alteracao - metodo para trocar uma letra recebida como parametro por outra
     * tambem recebida.
     * 
     * @param str     - string a ser tratada.
     * @param letraI  - letra para ser retirada da string.
     * @param letraII - letra para substituicao.
     * @return string depois do tratamento.
     */
    public static String alteracao(String str, char letraI, char letraII) {
        String resposta = "";
        int tamanho = str.length();
        char[] converter = new char[tamanho];
        for (int i = 0; i < tamanho; i++) {
            if (str.charAt(i) == letraI) {
                converter[i] = letraII;
            }//end if
            else
            {
                converter[i] = str.charAt(i);
            }
        }//end for
        resposta = new String(converter);
        return resposta;
    }//end alteracao
    public static void main(String[] args) {
        String[] entrada = new String[1000];
        int numEntrada = 0;
        char letraI = 'a';
        char letraII = 'a';
        Random gerador = new Random();
        gerador.setSeed(4);
        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

        for (int i = 0; i < numEntrada; i++) {
            letraI = ((char) ('a' + (Math.abs(gerador.nextInt()) % 26)));
            letraII = ((char) ('a' + (Math.abs(gerador.nextInt()) % 26)));
            MyIO.println(alteracao(entrada[i], letraI, letraII));
        } // end for
    }//end main
}//end AlteracaoAleatoria
