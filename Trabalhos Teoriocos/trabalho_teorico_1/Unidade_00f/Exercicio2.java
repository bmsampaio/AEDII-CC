//Leia o nome de um arquivo e mostre seu conteúdo na tela
public class Exercicio2 {
    public static void main(String[] args) {
        Arq.openRead("exercicio1.txt");
        String frase = Arq.readAll();
        Arq.close();
        System.out.println(frase);
    }
    
}
