/**
 * Leia o nome de um arquivo e mostre na tela o conteúdo
 * desse arquivo criptografado usando o ciframento de César
 * (k = 3)
 */
public class Exercicio7 {
    public static void main(String[] args) {
        int k = 3;
        Arq.openRead("exercicio1.txt");
        String frase = Arq.readAll();
        Arq.close();
        StringBuilder cript = new StringBuilder();
        int tamanhoString = frase.length();

        for (int c = 0; c < tamanhoString; c++) {

            int letraCifradaASCII = ((int) frase.charAt(c)) + k;

            if (frase.charAt(c) > 97 && frase.charAt(c) < 122) {
                while (letraCifradaASCII > 122) {
                    letraCifradaASCII = 97;
                }
            }
            if (frase.charAt(c) > 65 && frase.charAt(c) < 60) {
                while (letraCifradaASCII > 90) {
                    letraCifradaASCII = 65;
                }
            }
            cript.append((char) letraCifradaASCII);
        }
        
        System.out.println(cript);

    }

}
