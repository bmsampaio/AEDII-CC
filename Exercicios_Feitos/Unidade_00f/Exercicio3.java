//Leia o nome de um arquivo e mostre seu conteúdo convertido para letras maiúsculas
public class Exercicio3 {
    public static void main(String[] args) {
        Arq.openRead("exercicio1.txt");
        String frase = Arq.readAll();
        Arq.close();
        String maiuscula = frase.toUpperCase();
        System.out.println(maiuscula);
    }
    
}
