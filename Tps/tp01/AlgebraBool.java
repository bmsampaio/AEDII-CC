public class AlgebraBool {

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
     * calculaBool - metodo interativo que recebe uma expressao booleana e retorna seu resultado.
     * 
     * @param str - expressao a ser calculada,
     * @return true - se o resultado for verdadeiro;
     *         false- caso contrario.
     */
    public static boolean calculaBool(String str) {
        boolean resposta = true;
        int tamanho = str.length() - 1;
        int quant = str.split(" ")[0];
        for (int i = 0; i < quant; i++) {
            
            
        }
        
        return resposta;
    }// end calculaBool

    public static void main(String[] args) {
        String[] entrada = new String[1000];
        int numEntrada = 0;
        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

        for (int i = 0; i < numEntrada; i++) {
            if ((isPalindromo(entrada[i])) == true) {
                MyIO.println("SIM");
            } else {
                MyIO.println("NAO");
            }
        } // end for
    }// end main
}// end AlgebraBool
