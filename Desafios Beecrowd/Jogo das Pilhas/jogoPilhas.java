import java.io.BufferedReader;
import java.io.InputStreamReader;

public class jogoPilhas {

    public static int somarPilhas(int p[][], int linha, int coluna) {
        int result = 0;
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                result = result + p[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String linha = "";
        int p[][];
        int linhas = 0;
        linhas = Integer.parseInt(br.readLine());
        while (linhas != 0) {
            p = new int[linhas][3];
            for (int i = 0; i < linhas; i++) {
                linha = br.readLine();
                for (int j = 0; j < 3; j++) {
                    p[i][j] = Integer.parseInt(linha.split(" ")[j]);
                }
            }
            if (somarPilhas(p, linhas, 3) % 3 == 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            linhas = Integer.parseInt(br.readLine());
        }
        br.close();
    }
}