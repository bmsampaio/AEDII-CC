/**
 * Leia o nome de dois arquivos e copie o conteúdo do primeiro
 * para o segundo invertendo a ordem dos caracteres. O último
 * caractere no arquivo de entrada será o primeiro do de saída,
 * o penúltimo caractere será o segundo, ...
 */
public class Exercicio6 {
    public static void main(String[] args) {

        Arq.openRead("exercicio1.txt");
        String frase = Arq.readAll();
        Arq.close();
        String invertido = new StringBuilder(frase).reverse().toString();
        Arq.openWrite("exercicio6.txt");
        Arq.println(invertido);
        Arq.close();

    }
}