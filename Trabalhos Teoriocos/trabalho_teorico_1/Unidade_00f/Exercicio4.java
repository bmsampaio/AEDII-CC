//Leia o nome de dois arquivos e copie o conteúdo do primeiro para o último
public class Exercicio4 {
    public static void main(String[] args) {
        Arq.openRead("exercicio1.txt");
        String frase = Arq.readAll();
        Arq.close();
        Arq.openWrite("exercicio4.txt");
        Arq.println(frase);
        Arq.close();

    }
}
