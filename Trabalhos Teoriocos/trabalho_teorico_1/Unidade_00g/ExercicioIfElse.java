import java.util.Scanner;

/**
 * Faça um programa que leia três números reais representando os lados
 * de um triângulo e informe se seu triângulo é Equilátero, Isósceles ou
 * Escaleno
 */
public class ExercicioIfElse {
    public static void main(String[] args) {
        float a = 0;
        float b = 0;
        float c = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira um numero real:");
        a = sc.nextFloat();
        System.out.println("Insira um numero real:");
        b = sc.nextFloat();
        System.out.println("Insira um numero real:");
        c = sc.nextFloat();
        sc.close();
        // se todos os lados forem diferente o triangulo e escaleno
        if (a != b && a != c && b != c) {
            System.out.println("Triangulo Escaleno");
        } // end if
          // se todos os lados forem iguais o triangulo e equilatero
        else if (a == b && a == c && b == c) {
            System.out.println("Triangulo Equilatero");

        } // end else if
          // se dois lados forem iguais o triangulo e isosceles
        else {
            System.out.println("Triangulo Isosceles");
        } // end else
    }

}
