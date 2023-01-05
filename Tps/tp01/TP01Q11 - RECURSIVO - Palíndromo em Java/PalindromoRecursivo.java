public class PalindromoRecursivo {
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
     * isPalindromo - metodo recursivo que recebe uma string e a
     * classifica como palindromo, ou nao.
     * 
     * @param str - string a ser classificada,
     * @return true - se a string for um palindromo;
     *         false- caso contrario.
     * 
     */
    public static boolean isPalindromo(String str) {
        return isPalindromo(str, 0);
    }// end isPalindromo

    public static boolean isPalindromo(String str, int i) {
        boolean resposta = true;
        int tamanho = str.length() - 1;
        //condicao de parada
        if (i < str.length()) {
            /**se o caracter na posicao i for diferente do caracter na posicao (tamanho-i), 
            entao a string nao e um palindromo -> retornar falso.
            */
            if (str.charAt(i) != str.charAt(tamanho - i)) {
                resposta = false;
            }//end i
        } else {
            //motor da recursividade.
            resposta = isPalindromo(str, (i + 1));
        }//end else
        return resposta;
    }// end isPalindromo

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
}// end PalindromoRecursivo
