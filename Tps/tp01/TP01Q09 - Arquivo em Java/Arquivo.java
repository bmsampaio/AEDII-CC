import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {
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

    public static void main(String[] args) throws IOException {
        FileWriter arq = new FileWriter("d:\\dados.txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        double entrada = 0.0;
        int numEntrada = 0, contador = 0;
        // Leitura da entrada padrao
        numEntrada = MyIO.readInt();
        do {
            entrada = MyIO.readDouble();
            //Salvando dados em um arquivo
            gravarArq.printf("%f",entrada);
            gravarArq.printf("%n");
            contador++;
        } while (contador < numEntrada);
        arq.close();

        // for (int i = 0; i < numEntrada; i++) {
        //     if ((isPalindromo(entrada[i])) == true) {
        //         MyIO.println("SIM");
        //     } else {
        //         MyIO.println("NAO");
        //     }
        // } // end for
    }// end main
}// end Palindromo