/**
 * Faça um programa que mostre na tela os 10 primeiros números pares
 */
public class ExemploWhile01 {
    public static void main(String[] args) {
        int contador = 0;
        int par = 0;
        while (contador < 10) {
            par = par + 2;
            System.out.println(par);
            contador++;
        };
    }
}
