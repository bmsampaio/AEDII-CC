public class Espelho {

    /**
     * isPalindromo - metodo interativo que recebe uma string e a
     * classifica como palindromo, ou nao.
     * 
     * @param str - string a ser classificada,
     * @return true - se a string for um palindromo;
     *         false- caso contrario.
     */
    public static boolean isPalindromo(String str) {
        boolean resposta = true;
        int tamanho = str.length() - 1;
        String inversa = "";
        for (int i = tamanho; i >= 0; i--) {
            inversa += str.charAt(i);

        } // end for
        for (int i = 0; i < tamanho; i++) {
            // Caso um caracter seja diferente do outro, resposta sera false
            if (inversa.charAt(i) != str.charAt(i)) {
                resposta = false;
            } // end if
        } // end for
        return resposta;
    }// end isPalindromo
    public static void main(String[] args) {
        String[] entrada = new String[1000];
        int numEntrada = 0;
        // Leitura da entrada padrao
        while (hasNext()) {
            entrada[numEntrada] = MyIO.readLine();
        } 
        for (int i = 0; i < numEntrada; i++) {
            System.out.println(entrada[i]);
            // if ((isPalindromo(entrada[i])) == true) {
            //     MyIO.println("SIM");
            // } else {
            //     MyIO.println("NAO");
            // }
        } // end for
    }//end main
    }// end Espelho