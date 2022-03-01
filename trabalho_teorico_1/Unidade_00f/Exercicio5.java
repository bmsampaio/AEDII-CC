/**
 * Leia o nome de dois arquivos, abra o primeiro, converta seu
 * conteúdo para letra maiúscula e salve o no segundo
 **/
public class Exercicio5 {
    public static void main(String[] args) {

        Arq.openRead("exercicio1.txt");
        String frase = Arq.readAll();
        Arq.close();
        String minuscula = frase.toLowerCase();
        Arq.openWrite("exercicio5.txt");
        Arq.println(minuscula);
        Arq.close();

    }
}
