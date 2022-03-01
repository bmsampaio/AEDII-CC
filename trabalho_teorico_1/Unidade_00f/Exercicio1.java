import java.util.Scanner;

/**
 * Leia o nome de um arquivo e uma frase e
 * salve essa frase nesse arquivo
 **/
public class Exercicio1 {
    public static void main(String[] args) {

        String frase = "";
        Scanner sc = new Scanner(System.in);
        System.out.printf("Digite um frase:\n");
        frase = sc.nextLine();
        sc.close(); //Encerra o programa
        Arq.openWrite("exercicio1.txt");
        Arq.println(frase);
        Arq.close();
    }
}
