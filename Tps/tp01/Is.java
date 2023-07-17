public class Is {
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
     * isVogal - metodo para dizer se a string recebida
     * e composta toda de vogais.
     * 
     * @param str - string a ser analizada.
     * @return true - se a string for composta somente por vogais;
     *         false- caso contrario.
     */
    public static boolean isVogal(String str) {
        boolean resposta = true;
        int tamanho = str.length();
        int i = 0;
        do {
            if ((str.charAt(i) == 'a' ||
                    str.charAt(i) == 'e' ||
                    str.charAt(i) == 'i' ||
                    str.charAt(i) == 'o' ||
                    str.charAt(i) == 'u') ||
                    (str.charAt(i) == 'A' ||
                            str.charAt(i) == 'E' ||
                            str.charAt(i) == 'I' ||
                            str.charAt(i) == 'O' ||
                            str.charAt(i) == 'U')) {
                // se for uma vogal continuar o teste
                i++;
            } // end if
            else {
                // se nao for uma vogal parar contador e retornar falso
                i = tamanho;
                resposta = false;
            } // end else
        } while (i < tamanho);
        return resposta;

    }// end isVogal

    /**
     * isConsoante - metodo para dizer se a string recebida
     * e composta toda de consoantes.
     * 
     * @param str - string a ser analizada.
     * @return true - se a string for composta somente por consoantes;
     *         false- caso contrario.
     */
    public static boolean isConsoante(String str) {
        boolean resposta = true;
        int tamanho = str.length();
        int i = 0;
        do {
            // testar se e uma letra
            if ((str.charAt(i) > 65 && str.charAt(i) <= 90) || (str.charAt(i) > 97 && str.charAt(i) <= 122)) {
                // testar se nao e vogal
                if (!(str.charAt(i) == 'a' ||
                        str.charAt(i) == 'e' ||
                        str.charAt(i) == 'i' ||
                        str.charAt(i) == 'o' ||
                        str.charAt(i) == 'u') ||
                        !(str.charAt(i) == 'A' ||
                                str.charAt(i) == 'E' ||
                                str.charAt(i) == 'I' ||
                                str.charAt(i) == 'O' ||
                                str.charAt(i) == 'U')) {
                    // se for uma letra e nao for uma vogal -> continuar o teste
                    i++;
                } // end if
                else {
                    // se for uma vogal parar contador e retornar falso
                    i = tamanho;
                    resposta = false;
                } // end else
            } // end if
            else {
                // se nao for uma letra parar contador e retornar falso
                i = tamanho;
                resposta = false;
            } // end else
        } while (i < tamanho);
        return resposta;
    }// end isConsoante

    /**
     * isInteiro - metodo para dizer se a string recebida
     * e composta por um numero inteiro.
     * 
     * @param str - string a ser analizada.
     * @return true - se a string e um numero inteiro;
     *         false- caso contrario.
     */
    public static boolean isInteiro(String str) {
        boolean resposta = true;
        int tamanho = str.length();
        int i = 0;
        do {
            if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                // se for um algarismo continuar o teste
                i++;
            } else {
                // se nao for um algarismo parar contador e retornar falso
                i = tamanho;
                resposta = false;
            } // end else
        } while (i < tamanho);
        return resposta;
    }// end isInteiro

    /**
     * isReal - metodo para dizer se a string recebida
     * e composta por um numero real.
     * 
     * @param str - string a ser analizada.
     * @return true - se a string e um numero real;
     *         false- caso contrario.
     */
    public static boolean isReal(String str) {
        boolean resposta = false;
        int tamanho = str.length();
        int i = 0;
        do {

            // testar se e uma letra
            if ((str.charAt(i) > 65 && str.charAt(i) <= 90) || (str.charAt(i) > 97 && str.charAt(i) <= 122)) {
                // se for uma letra parar contador e retornar falso
                i = tamanho;
                resposta = false;
            } else if (str.charAt(i) == 44) {
                // se nao for uma letra mas for virgula retornar verdadeiro
                resposta = true;
            }
            i++;

        } while (i < tamanho);
        return resposta;
    }// end isReal

    public static void main(String[] args) {
        String[] entrada = new String[1000];
        int numEntrada = 0;
        String vogal = "";
        String consoante = "";
        String inteiro = "";
        String real = "";
        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

        for (int i = 0; i < numEntrada; i++) {
            if (isVogal(entrada[i]) == true) {
                vogal = "SIM";
            } // end if
            else {
                vogal = "NAO";
            }
            if (isConsoante(entrada[i]) == true) {
                consoante = "SIM";
            } // end if
            else {
                consoante = "NAO";
            }
            if (isInteiro(entrada[i]) == true) {
                inteiro = "SIM";
            } // end if
            else {
                inteiro = "NAO";
            }
            if (isReal(entrada[i]) == true) {
                real = "SIM";
            } // end if
            else {
                real = "NAO";
            }

            MyIO.println(vogal + " " + consoante + " " + inteiro + " " + real);

        } // end for

    }// end main
}// end is
