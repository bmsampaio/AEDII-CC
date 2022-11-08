import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Evergreen Bushy, um dos duendes ajudantes de Noel, responsável por inventar
 * muitos dos brinquedos distribuídos por Noel e também muito conhecido por
 * fazer pegadinhas com o bom velhinho, aprontou mais uma neste ano.
 * 
 * Como sempre faz todos os anos, Bushy separou os presentes para cada criança
 * colocando um bilhete com o nome dela. O problema que ele não se limitou a
 * simplesmente colocar o nome correto da criança no presente: ele zoou :) cada
 * um dos nomes misturando as letras segundo uma sequência: duas letras do nome,
 * seguidas por duas letras do sobrenome, seguidas por duas letras do nome e por
 * duas letras do sobrenome e assim por diante.
 * 
 * Bem, como Noel está bem cansado e sem tempo para brincadeiras, pediu a você
 * que é expert em programação para fazer um programa que converta o nome
 * misturado por Evergreen no nome correto de cada criança.
 * 
 * Apenas um fato curioso: a primeira linha do nome misturado sempre terá um
 * número par de caracteres e a segunda linha, sempre terá o mesmo número de
 * caracteres da primeira linha ou um caractere a menos do que a primeira linha.
 */
public class PegadinhaEvergreen {

    public static String desembaralha(String Nome1, String Nome2) {
        String resultado = "";
        System.out.println(Nome1 + " - " + Nome2);
        int i = 0;
        int j = 0;
        while (i < Nome1.length() - 2) {
            j = i + 1;
            resultado = resultado + Nome1.charAt(i) + Nome1.charAt(j) + Nome2.charAt(i) + Nome2.charAt(j);
            i = i + 2;
        }
        // for (int i = 0; i < Nome1.length() - 1; i = i + 2) {
        // for (int j = 1; j < Nome2.length() - 2; j = j + 2) {
        // resultado = resultado + Nome1.charAt(i) + Nome1.charAt(j) + Nome2.charAt(i) +
        // Nome2.charAt(j);
        // }
        // }
        return resultado;

    }

    public static void main(String[] args) throws IOException {
        String[] entrada = new String[2000];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numEntrada = 0, j = 0;
        // Leitura de dados padrao
        numEntrada = Integer.parseInt(br.readLine());
        // System.out.println(numEntrada);
        for (int i = 0; i < numEntrada * 2; i++) {
            entrada[i] = br.readLine();
        } // end for
        br.close();
        for (int i = 0; i < numEntrada * 2; i = i + 2) {
            j = i + 1;
            System.out.println(desembaralha(entrada[i], entrada[j]));
        } // end for

    }
}
