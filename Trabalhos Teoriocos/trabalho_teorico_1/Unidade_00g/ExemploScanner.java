import java.util.Scanner;

/**
 * Faça um programa que leia uma String, caractere, inteiro e real. Em seguida,
 * seu
 * programa deve imprimir na tela os valores lidos do teclado
 */
public class ExemploScanner {
    public static void main(String[] args) {
        String str = "";
        char c = 'c';
        int x = 0;
        float y = 0;
        Scanner sc = new Scanner(System.in);
        System.out.printf("Digite um frase:\n");
        str = sc.nextLine();
        System.out.printf("Digite uma letra:\n");
        c = sc.next().charAt(0);
        System.out.printf("Digite um numero inteiro:\n");
        x = sc.nextInt();
        System.out.printf("Digite um numero real:\n");
        y = sc.nextFloat();
        System.out.print(str);
        System.out.print(c);
        System.out.print(x);
        System.out.print(y);
        sc.close(); // Encerra o programa
    }

}
