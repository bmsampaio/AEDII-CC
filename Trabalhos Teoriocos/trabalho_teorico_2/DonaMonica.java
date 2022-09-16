public class DonaMonica {

    /**
     * isZero - metodo para dizer se a string recebida
     * e o 0.
     * 
     * @param str - string a ser analizada.
     * @return true - se a string for 0;
     *         false- caso contrario.
     */
    public static boolean isZero(String str) {
        boolean resposta = false;
        int tamanho = str.length();
        if (tamanho == 1 && str.charAt(0) == '0') {
            resposta = true;
        } // end if
        return resposta;
    }// end isZero

    /**
     * filhoMaisVelho - metodo para dizer a idade do filho maiis velho
     * 
     * @param filhoUm   - idade de um dos filho.
     * @param filhoDois - idade de outro filho.
     * @param mae       - idade da mae.
     * @return idade do filho mais velho.
     */
    public static int filhoMaisVelho(int filhoUm, int filhoDois, int mae) {
        int resultado = 0;
        int filhoTres = 0;
        filhoTres = mae - (filhoUm + filhoDois);
        if (filhoUm > filhoDois && filhoUm > filhoTres) {
            resultado = filhoUm;
        } else if (filhoDois > filhoUm && filhoDois > filhoTres) {
            resultado = filhoDois;
        } else if (filhoTres > filhoUm && filhoTres > filhoDois) {
            resultado = filhoTres;
        }
        return resultado;
    }// end filhoMaisVelho

    public static void main(String[] args) {
        String[] entrada = new String[1000];
        String[] separada = new String[1000];
        int numEntrada = 0;
        int filhoUm = 0;
        int filhoDois = 0;
        int mae = 0;
        int linha = 0;
        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isZero(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo o 0

        do {
            separada = entrada[linha].split(" ");
            mae = Integer.parseInt(separada[0]);
            filhoUm = Integer.parseInt(separada[1]);
            filhoDois = Integer.parseInt(separada[2]);
            MyIO.println(filhoMaisVelho(filhoUm, filhoDois, mae));
            linha++;
        } while (linha < numEntrada);
        

    }// end main
}// end DonaMonica