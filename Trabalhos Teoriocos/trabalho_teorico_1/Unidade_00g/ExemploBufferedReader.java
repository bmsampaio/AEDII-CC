import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Faça um programa que leia uma String, caractere, inteiro e real. Em seguida,
 * seu
 * programa deve imprimir na tela os valores lidos do teclado
 */
public class ExemploBufferedReader {
    public static void main(String[] args) {
        String str = "";
        char c = 'c';
        int x = 0;
        float y = 0;
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        System.out.printf("Digite um frase:\n");
        str = br.readLine();
        System.out.printf("Digite uma letra:\n");
        c = br.readLine().charAt(0);
        System.out.printf("Digite um numero inteiro:\n");
        x = br.read();
        System.out.printf("Digite um numero real:\n");
        y = br.read();
        System.out.print(str);
        System.out.print(c);
        System.out.print(x);
        System.out.print(y);

        br.close(); 
        r.close();
    }

}
