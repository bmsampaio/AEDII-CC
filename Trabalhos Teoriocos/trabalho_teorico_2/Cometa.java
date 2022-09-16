
public class Cometa {

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
     * anoCometa - metodo para dizer qual o proximo ano da passagem do cometa
     * Halley.
     * 
     * @param ano - ano atual.
     * @return proximo ano de passagem do cometa.
     */
    public static int anoCometa(int ano) {

        int resposta = 0;
        int ultimaPassagem = 1986;
        int auxilio = 0;
        int[] passagens = new int[14];
        // Preencher um vetor com as proximas 14 passagens do cometa
        for (int i = 0; i < 14; i++) {
            passagens[i] = ultimaPassagem + 76;
            ultimaPassagem = passagens[i];
        } // end for
        for (int i = 0; i < 14; i++) {
            // Se -> ano de passagem da posicao i - ano atual >= 76
            // -> o proximo ano de passagem do cometa e o proprio ano de passagem da posicao i
            auxilio = passagens[i] - ano;
            if (auxilio <= 76) {
                resposta = passagens[i];
            } // end if
        } // end for
        return resposta;
    }// end anoCometa

    public static void main(String[] args) {
        String[] entrada = new String[1000];
        int numEntrada = 0;
        int i = 0;
        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();

        } while (isZero(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo o 0

        do {
            MyIO.println(anoCometa(Integer.parseInt(entrada[i])));
            i++;
        } while (i < numEntrada);

    }// end main
}// end Cometa
