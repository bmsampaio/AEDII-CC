public class CiframentoRecursivo {
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
     * ciframento - metodo para codificar uma string recebida utilizando o
     * ciframento de Cesar de forma recursiva
     * 
     * @param str - string a ser codificada.
     * @return string codificada.
     */
   
    public static String ciframento(String str) {
        return ciframento(str, 0);
    }
    public static String ciframento(String str, int i) {
        String resp = "";
        //condicao de parada
        if (i < str.length()) {
            
            resp += (char)(str.charAt(i) + 3);
            resp += ciframento(str, i + 1);
        }
        return resp;
        
    }// end ciframento

    public static void main(String[] args) {
        String[] entrada = new String[1000];
        int numEntrada = 0;
        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

        for (int i = 0; i < numEntrada; i++) {
            MyIO.println(ciframento(entrada[i]));
        } // end for
    }// end main
}// end CiframentoRecusivo
