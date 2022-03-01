import java.util.Scanner;

/**
 * Faça um programa que leia a nota de 5 alunos e mostre na tela a média
 * das mesmas usando o comando for
 */
public class ExemploFor {
    public static void main(String[] args) {
        float nota = 0;
        float soma = 0;
        int quantidade = 0;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Insira a nota do aluno:");
            nota = sc.nextFloat();
            soma = soma + nota;
            quantidade++;
        }
        sc.close();
        System.out.println("A media das notas e " + soma / quantidade);
    }

}
