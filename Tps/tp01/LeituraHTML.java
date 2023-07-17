import java.io.*;
import java.net.*;

public class LeituraHTML {
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

    public static String getHtml(String endereco) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;

        try {
            url = new URL(endereco);
            is = url.openStream(); // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                resp += line + "\n";
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            is.close();
        } catch (IOException ioe) {
            // nothing to see here

        }

        return resp;
    }

    /**
     * contandoLetras - metodo para contar o numero de vogais, vogais com acentos, consoantes e tags.
     * 
     * 
     * @param str - string a ser analizada.
     * @return resposta - string juntando todas os contadores.
     */
    public static String contandoLetras(String str) {
        String resposta = "", nome = "";
        int tamanho = str.length();
        int contadorA = 0, contadorE = 0, contadorI = 0, contadorO = 0, contadorU = 0, contadorAA = 0,
                contadorEE = 0, contadorII = 0, contadorOO = 0, contadorUU = 0, contadorAAA = 0,
                contadorEEE = 0, contadorIII = 0, contadorOOO = 0, contadorUUU = 0, contadorAAAA = 0,
                contadorEEEE = 0, contadorIIII = 0, contadorOOOO = 0, contadorUUUU = 0, contadorAAAAA = 0,
                contadorOOOOO = 0, contadorV = 0, contadorBR = 0, contadorTABLE = 0;
        char AA = 225,EE = 233, II = 237, OO = 243, UU = 250, AAA = 224,EEE = 232, III = 236, OOO = 242, UUU = 249, AAAA = 226,
        EEEE = 234, IIII = 238, OOOO = 244, UUUU = 251, AAAAA = 227, OOOOO = 245;
        for (int i = 0; i < tamanho; i++) {
            // testar se e uma letra
            if ((str.charAt(i) >= 97 && str.charAt(i) <= 122)) {
                // testar se e vogal
                if ((str.charAt(i) == 'a' ||
                        str.charAt(i) == 'e' ||
                        str.charAt(i) == 'i' ||
                        str.charAt(i) == 'o' ||
                        str.charAt(i) == 'u')) {
                    if (str.charAt(i) == 'a') {
                        contadorA++;
                    } // end if
                    else if (str.charAt(i) == 'e') {
                        contadorE++;
                    } // end else if
                    else if (str.charAt(i) == 'i') {
                        contadorI++;
                    } // end else if
                    else if (str.charAt(i) == 'o') {
                        contadorO++;
                    } // end else if
                    else if (str.charAt(i) == 'u') {
                        contadorU++;
                    } // end else if
                } // end if
                  // se for uma nao for uma vogal -> e uma consoante
                else {
                    contadorV++;
                } // end else
            } // end if
            else if (str.charAt(i) == 225) {
                contadorAA++;
            } // end else if
            else if (str.charAt(i) == 233) {
                contadorEE++;
            } // end else if
            else if (str.charAt(i) == 237) {
                contadorII++;
            } // end else if
            else if (str.charAt(i) == 243) {
                contadorOO++;
            } // end else if
            else if (str.charAt(i) == 250) {
                contadorUU++;
            } // end else if
            else if (str.charAt(i) == 224) {
                contadorAAA++;
            } // end else if
            else if (str.charAt(i) == 232) {
                contadorEEE++;
            } // end else if
            else if (str.charAt(i) == 236) {
                contadorIII++;
            } // end else if
            else if (str.charAt(i) == 242) {
                contadorOOO++;
            } // end else if
            else if (str.charAt(i) == 249) {
                contadorUUU++;
            } // end else if
            else if (str.charAt(i) == 226) {
                contadorAAAA++;
            } // end else if
            else if (str.charAt(i) == 234) {
                contadorEEEE++;
            } // end else if
            else if (str.charAt(i) == 238) {
                contadorIIII++;
            } // end else if
            else if (str.charAt(i) == 244) {
                contadorOOOO++;
            } // end else if
            else if (str.charAt(i) == 251) {
                contadorUUUU++;
            } // end else if
            else if (str.charAt(i) == 227) {
                contadorAAAAA++;
            } // end else if
            else if (str.charAt(i) == 245) {
                contadorOOOOO++;
            } // end else if
            else if (str.charAt(i) == '<' && str.charAt(i + 1) == 'b' && str.charAt(i + 2) == 'r'
                    && str.charAt(i + 3) == '>') {
                contadorBR++;
            } else if (str.charAt(i) == '<' && str.charAt(i + 1) == 't' && str.charAt(i + 2) == 'a'
                    && str.charAt(i + 3) == 'b' && str.charAt(i + 4) == 'l' && str.charAt(i + 5) == 'e'
                    && str.charAt(i + 6) == '>') {
                contadorTABLE++;
            }
            // else if (str.charAt(i) == '<' && str.charAt(i + 1) == 't' && str.charAt(i + 2) == 'i'
            //         && str.charAt(i + 3) == 't' && str.charAt(i + 4) == 'l' && str.charAt(i + 5) == 'e' && str.charAt(i + 6) == '>' ) {
                
            // }
            
        } // end for
        resposta = "a(" + contadorA + ") e(" + contadorE + ") i(" + contadorI + ") o(" + contadorO + ") u(" + contadorU
                + ") " + AA +"(" + contadorAA + ") "+ EE + "(" + contadorEE + ") " + II + "(" + contadorII + ") " + OO +"(" + contadorOO + ") " + UU + "("
                + contadorUU + ") " + AAA +"(" + contadorAAA + ") " + EEE + "(" + contadorEEE + ") "+ III + "(" + contadorIII + ") " + OOO +"(" + contadorOOO
                + ") " + UUU + "("
                + contadorUUU + ") " + AAAAA + "(" + contadorAAAAA + ") " + OOOOO + "(" + contadorOOOOO + ") " + AAAA +"(" + contadorAAAA + ") " + EEEE + "("
                + contadorEEEE + ") " + IIII + "(" + contadorIIII + ") " + OOOO + "(" + contadorOOOO + ") " + UUUU + "("
                + contadorUUUU + ") consoante(" + contadorV + ") <br>(" + contadorBR + ") <table>(" + contadorTABLE
                + ") " + nome;
        return resposta;

    }// end isVogal

    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");
        String[] entrada = new String[1000];
        int numEntrada = 0;
        String nome, endereco, html;
        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

        for (int i = 1; i < numEntrada; i += 2) {

            endereco = entrada[i];
            //System.out.println("endereco = " + endereco);
            html = getHtml(endereco);
            System.out.println(contandoLetras(html));
            // System.out.println(html);

        } // end for

    }// end main
}// end LeituraHTML
