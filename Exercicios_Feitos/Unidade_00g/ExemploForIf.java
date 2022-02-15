import java.util.Scanner;

/**
 * Faça um programa que leia a nota de 5 alunos e mostre na tela a média
 * das notas cujo valor é maior ou igual a oitenta
 */
public class ExemploForIf {
    public static void main(String[] args) {

        float nota = 0;
        float soma = 0;
        int quantidade = 0;
        float media = 0;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Insira a nota do aluno:");
            nota = sc.nextFloat();
            if (nota >= 80) {
                soma = soma + nota;
                quantidade++;
            }
        }
        sc.close();
        media = soma / quantidade;
        System.out.println("A media das notas maiores que 80 e " + media);

    }
}
