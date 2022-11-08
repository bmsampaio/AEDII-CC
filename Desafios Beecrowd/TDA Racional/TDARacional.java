import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Enunciado:
 * A tarefa aqui neste problema é ler uma expressão matemática na forma de dois
 * números Racionais (numerador / denominador) e apresentar o resultado da
 * operação. Cada operando ou operador é separado por um espaço em branco. A
 * sequência de cada linha que contém a expressão a ser lida é: número,
 * caractere, número, caractere, número, caractere, número. A resposta deverá
 * ser apresentada e posteriormente simplificada. Deverá então ser apresentado o
 * sinal de igualdade e em seguida a resposta simplificada. No caso de não ser
 * possível uma simplificação, deve ser apresentada a mesma resposta após o
 * sinal de igualdade.
 * 
 * Considerando N1 e D1 como numerador e denominador da primeira fração, segue a
 * orientação de como deverá ser realizada cada uma das operações:
 * Soma: (N1*D2 + N2*D1) / (D1*D2)
 * Subtração: (N1*D2 - N2*D1) / (D1*D2)
 * Multiplicação: (N1*N2) / (D1*D2)
 * Divisão: (N1/D1) / (N2/D2), ou seja (N1*D2)/(N2*D1)
 */

public class Main {

    /**
     * operacao - funcao para realizar a operacao da entrada
     * 
     * @param entrada - string contendo a operacao a ser realizada
     * @return int - resultado da operacao
     */
    public static String operacao(String entrada) {
        String resultado = "";
        int N1 = 0, N2 = 0, D1 = 0, D2 = 0, Nresult = 0, Dresult = 0, Nsimp = 0, Dsimp = 0;
        char operador = 'a';
        N1 = Integer.parseInt(entrada.split(" ")[0]);
        D1 = Integer.parseInt(entrada.split(" ")[2]);
        operador = entrada.charAt(6);
        N2 = Integer.parseInt(entrada.split(" ")[4]);
        D2 = Integer.parseInt(entrada.split(" ")[6]);
        switch (operador) {
            case '+':
                Nresult = N1 * D2 + N2 * D1;
                Dresult = D1 * D2;
                if (Nresult % 2 == 0 && Dresult % 2 == 0) {
                    Nsimp = Nresult / 2;
                    Dsimp = Dresult / 2;
                    while (Nsimp % 2 == 0 && Dsimp % 2 == 0) {
                        Nsimp = Nsimp / 2;
                        Dsimp = Dsimp / 2;
                    }
                    while (Nsimp % 3 == 0 && Dsimp % 3 == 0) {
                        Nsimp = Nsimp / 3;
                        Dsimp = Dsimp / 3;
                    }
                    resultado = Nresult + "/" + Dresult + " = " + Nsimp + "/" + Dsimp;
                } else if (Nresult % 3 == 0 && Dresult % 3 == 0) {
                    Nsimp = Nresult / 3;
                    Dsimp = Dresult / 3;
                    while (Nsimp % 3 == 0 && Dsimp % 3 == 0) {
                        Nsimp = Nsimp / 3;
                        Dsimp = Dsimp / 3;
                    }
                    while (Nsimp % 2 == 0 && Dsimp % 2 == 0) {
                        Nsimp = Nsimp / 2;
                        Dsimp = Dsimp / 2;
                    }                    
                    resultado = Nresult + "/" + Dresult + " = " + Nsimp + "/" + Dsimp;
                } else {
                    resultado = Nresult + "/" + Dresult;
                }
                break;
            case '*':
                Nresult = (N1 * N2);
                Dresult = (D1 * D2);
                if (Nresult % 2 == 0 && Dresult % 2 == 0) {
                    Nsimp = Nresult / 2;
                    Dsimp = Dresult / 2;
                    while (Nsimp % 2 == 0 && Dsimp % 2 == 0) {
                        Nsimp = Nsimp / 2;
                        Dsimp = Dsimp / 2;
                    }
                    while (Nsimp % 3 == 0 && Dsimp % 3 == 0) {
                        Nsimp = Nsimp / 3;
                        Dsimp = Dsimp / 3;
                    }
                    resultado = Nresult + "/" + Dresult + " = " + Nsimp + "/" + Dsimp;
                } else if (Nresult % 3 == 0 && Dresult % 3 == 0) {
                    Nsimp = Nresult / 3;
                    Dsimp = Dresult / 3;
                    while (Nsimp % 3 == 0 && Dsimp % 3 == 0) {
                        Nsimp = Nsimp / 3;
                        Dsimp = Dsimp / 3;
                    }
                    while (Nsimp % 2 == 0 && Dsimp % 2 == 0) {
                        Nsimp = Nsimp / 2;
                        Dsimp = Dsimp / 2;
                    }                    
                    resultado = Nresult + "/" + Dresult + " = " + Nsimp + "/" + Dsimp;
                } else {
                    resultado = Nresult + "/" + Dresult;
                }
                break;
            case '-':
                Nresult = (N1 * D2 - N2 * D1);
                Dresult = (D1 * D2);
                if (Nresult % 2 == 0 && Dresult % 2 == 0) {
                    Nsimp = Nresult / 2;
                    Dsimp = Dresult / 2;
                    while (Nsimp % 2 == 0 && Dsimp % 2 == 0) {
                        Nsimp = Nsimp / 2;
                        Dsimp = Dsimp / 2;
                    }
                    while (Nsimp % 3 == 0 && Dsimp % 3 == 0) {
                        Nsimp = Nsimp / 3;
                        Dsimp = Dsimp / 3;
                    }
                    resultado = Nresult + "/" + Dresult + " = " + Nsimp + "/" + Dsimp;
                } else if (Nresult % 3 == 0 && Dresult % 3 == 0) {
                    Nsimp = Nresult / 3;
                    Dsimp = Dresult / 3;
                    while (Nsimp % 3 == 0 && Dsimp % 3 == 0) {
                        Nsimp = Nsimp / 3;
                        Dsimp = Dsimp / 3;
                    }
                    while (Nsimp % 2 == 0 && Dsimp % 2 == 0) {
                        Nsimp = Nsimp / 2;
                        Dsimp = Dsimp / 2;
                    }                    
                    resultado = Nresult + "/" + Dresult + " = " + Nsimp + "/" + Dsimp;
                } else {
                    resultado = Nresult + "/" + Dresult;
                }
                break;
            case '/':
                Nresult = (N1 * D2);
                Dresult = (N2 * D1);
                if (Nresult % 2 == 0 && Dresult % 2 == 0) {
                    Nsimp = Nresult / 2;
                    Dsimp = Dresult / 2;
                    while (Nsimp % 2 == 0 && Dsimp % 2 == 0) {
                        Nsimp = Nsimp / 2;
                        Dsimp = Dsimp / 2;
                    }
                    while (Nsimp % 3 == 0 && Dsimp % 3 == 0) {
                        Nsimp = Nsimp / 3;
                        Dsimp = Dsimp / 3;
                    }
                    resultado = Nresult + "/" + Dresult + " = " + Nsimp + "/" + Dsimp;
                } else if (Nresult % 3 == 0 && Dresult % 3 == 0) {
                    Nsimp = Nresult / 3;
                    Dsimp = Dresult / 3;
                    while (Nsimp % 3 == 0 && Dsimp % 3 == 0) {
                        Nsimp = Nsimp / 3;
                        Dsimp = Dsimp / 3;
                    }
                    while (Nsimp % 2 == 0 && Dsimp % 2 == 0) {
                        Nsimp = Nsimp / 2;
                        Dsimp = Dsimp / 2;
                    }                    
                    resultado = Nresult + "/" + Dresult + " = " + Nsimp + "/" + Dsimp;
                } else {
                    resultado = Nresult + "/" + Dresult;
                }
                break;
            default:
                break;
        }// end switch
        return resultado;
    }// end operacao

    public static void main(String[] args) throws IOException {
        String[] entrada = new String[5000];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numEntrada = 0;
        // Leitura de dados padrao
        numEntrada = Integer.parseInt(br.readLine());
        // System.out.println(numEntrada);
        for (int i = 0; i < numEntrada; i++) {
            entrada[i] = br.readLine();
        } // end for
        br.close();
        for (int i = 0; i < numEntrada; i++) {
            System.out.println(operacao(entrada[i]));
        } // end for
    }// end main

}// end TDARacional