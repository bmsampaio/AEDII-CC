public class isRecursivo {
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
        return isVogal(str, 0);
    }

    public static boolean isVogal(String str, int index) {
        int tamanho = str.length();
        if (index == tamanho) {
            return true;
        }
        char atual = str.charAt(index);

        if ((atual == 'a' ||
                atual == 'e' ||
                atual == 'i' ||
                atual == 'o' ||
                atual == 'u') ||
                (atual == 'A' ||
                        atual == 'E' ||
                        atual == 'I' ||
                        atual == 'O' ||
                        atual == 'U')) {
            return isVogal(str, index + 1);
        } // end if
        else {
            // se nao for uma vogal parar contador e retornar falso
            return false;
        } // end else

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
        return isConsoante(str, 0);
    }

    public static boolean isConsoante(String str, int index) {
        int tamanho = str.length();
        if (index == tamanho) {
            return true;
        }
        char atual = str.charAt(index);
        // testar se e uma letra
        if ((atual > 65 && atual <= 90) || (atual > 97 && atual <= 122)) {
            // testar se nao e vogal
            if (!(atual == 'a' ||
                    atual == 'e' ||
                    atual == 'i' ||
                    atual == 'o' ||
                    atual == 'u') ||
                    !(atual == 'A' ||
                            atual == 'E' ||
                            atual == 'I' ||
                            atual == 'O' ||
                            atual == 'U')) {
                // se for uma letra e nao for uma vogal -> continuar o teste
                return isConsoante(str, index + 1);
            } // end if
            else {
                // se for uma vogal parar contador e retornar falso
                return false;
            } // end else
        } // end if
        else {
            // se nao for uma letra parar contador e retornar falso
            return false;
        } // end else
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
        return isInteiro(str, 0);
    }

    public static boolean isInteiro(String str, int index) {
        int tamanho = str.length();
        if (index == tamanho) {
            return true;
        }
        char atual = str.charAt(index);
        if (atual >= 48 && atual <= 57) {
            // se for um algarismo continuar o teste
            return isInteiro(str, index + 1);
        } else {
            // se nao for um algarismo parar contador e retornar falso
            return false;
        } // end else
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
        return isReal(str, 0);
    }

    public static boolean isReal(String str, int index) {
        int tamanho = str.length();
        if (index == tamanho) {
            return true;
        }
        char atual = str.charAt(index);
        // testar se e uma letra
        if ((atual > 65 && atual <= 90) || (atual > 97 && atual <= 122)) {
            // se for uma letra parar contador e retornar falso
            return false;
        } else if (atual == 44) {
            // se nao for uma letra mas for virgula retornar verdadeiro
            return true;
        }
        return isReal(str, index + 1);
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