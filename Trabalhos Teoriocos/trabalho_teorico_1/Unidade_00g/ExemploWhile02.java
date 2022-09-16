/**
 * Faça um programa que mostre na tela o logaritmo na base 10 dos
números 1 à 10
 */
public class ExemploWhile02 {
    public static void main(String[] args) {
        int contador = 1;
        while (contador<11) {
        System.out.println("log de " + contador + " = " + Math.log10(contador));
        contador++;
        }
    }
    
}
