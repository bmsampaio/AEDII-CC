import java.util.Scanner;

/**
 * Faça um programa que leia a nota de um aluno e escreva na tela:
 * “Parabéns, muito bom” (se a nota >= 80); “Parabéns, aprovado” (se a
 * nota >= 70 && nota < 80); e, caso contrário, “Infelizmente, reprovado”
 */
public class ExemploIf {
    public static void main(String[] args) {
        float nota = 0;
        System.out.println("Insira a nota do aluno:");
        Scanner sc = new Scanner(System.in);
        nota = sc.nextFloat();
        sc.close();
        if (nota >= 80) {
            System.out.println("Parabens, muito bom");
        } else if (nota >= 70 && nota < 80) {
            System.out.println("Parabens, aprovado");
        } else {
            System.out.println("Infelizmente, reprovado");
        }

    }

}
