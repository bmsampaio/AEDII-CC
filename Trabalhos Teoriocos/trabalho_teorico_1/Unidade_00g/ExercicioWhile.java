import java.util.Scanner;

/**
 * Faça um programa que leia a nota de 5 alunos e mostre na tela a média
 * das mesmas
 */
public class ExercicioWhile {
    public static void main(String[] args) {
        int contador = 0;
        float nota = 0;
        float soma = 0;
        Scanner sc = new Scanner(System.in);
        while (contador < 5) {
            System.out.println("Insira a nota do aluno:");
            nota = sc.nextFloat();
            soma = soma + nota;
            contador++;
        }
        sc.close();
        System.out.println("A media das notas e " + soma/contador);
    }
}
