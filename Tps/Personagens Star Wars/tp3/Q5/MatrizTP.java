class Celula {
    int elemento;
    Celula prox, ant, inf, sup;

    // contrutor
    public Celula() {
        this(0);
    }

    public Celula(int elemento) {
        this.elemento = elemento;
        prox = ant = inf = sup = null;
    }
}// end Celula

class Matriz {
    Celula inicio;
    int linha, coluna;

    // contrutor
    public Matriz(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
        int x = 0;

        Celula i, j;
        int lin, col;

        // Criar a primeira celula
        inicio = new Celula(x++);

        // Criar as demais (coluna-1) celulas da 1a linha
        for (j = inicio, col = 1; col < coluna; j = j.prox, col++) {
            j.prox = new Celula(0);
            j.prox.ant = j;
        }

        // Criar as demais (linha-1) linhas
        for (i = inicio, lin = 1; lin < linha; i = i.inf, lin++) {
            i.inf = new Celula(0);
            i.inf.sup = i;

            for (j = i.inf, col = 1; col < coluna; j = j.prox, col++) {
                j.prox = new Celula(0);
                j.prox.ant = j;
                j.prox.sup = j.sup.prox;
                j.sup.prox.inf = j.prox;
            }
        }
    }

    public void inserir() {
        for (Celula i = inicio; i != null; i = i.inf) {
            for (Celula j = i; j != null; j = j.prox) {
                j.elemento = MyIO.readInt();
            }
        }
    }// end inserir

    public void mostrar() {
        for (Celula i = inicio; i != null; i = i.inf) {
            for (Celula j = i; j != null; j = j.prox) {
                System.out.print(j.elemento + " ");
            }
            MyIO.println("");
        }
    }// end mostrar

    public void DiagonalPrincipal() {
        if (this.linha == this.coluna && linha > 0) {
            Celula i = inicio;
            do {
                System.out.print(i.elemento + " ");
                i = i.prox;
                if (i != null) {
                    i = i.inf;
                }
            } while (i != null);
        }
    }

    public void DiagonalSecundaria() {
        if (this.linha == this.coluna && linha > 0) {
            Celula i;
            Celula temp = null;
            for (i = inicio; i != null; i = i.prox) {
                temp = i;
            }
            do {
                MyIO.print(temp.elemento + " ");
                temp = temp.inf;

                if (temp != null) {
                    temp = temp.ant;
                }
            } while (temp != null);
        }
    }// end diagonalSecundaria

    public Matriz soma(Matriz a) {
        return soma(this, a);
    }

    public Matriz soma(Matriz a, Matriz b) {
        Matriz resp = null;
        if (a.linha == b.linha && a.coluna == b.coluna) {
            resp = new Matriz(a.linha, a.coluna);
            Celula iResp = resp.inicio;
            Celula iA = a.inicio;
            Celula iB = b.inicio;
            for (int i = 0; i < linha; i++) {
                Celula jResp = iResp;
                Celula jA = iA;
                Celula jB = iB;
                for (int j = 0; j < coluna; j++) {
                    jResp.elemento = jA.elemento + jB.elemento;
                    jResp = jResp.prox;
                    jA = jA.prox;
                    jB = jB.prox;
                }
                iResp = iResp.inf;
                iA = iA.inf;
                iB = iB.inf;
            }
        }
        return resp;
    }

    public Matriz multiplicacao(Matriz a, Matriz b) {
        Matriz resp = null;
        if (a.linha == b.coluna) {
            resp = new Matriz(a.linha, b.coluna);

            Celula iResp = resp.inicio;
            Celula iA = a.inicio;
            Celula iB = b.inicio;

            for (int i = 0; i < linha; i++) {
                Celula jResp = iResp;
                Celula jA = iA;
                Celula jB = iB;

                for (int k = 0; k < b.coluna; k++) {
                    Celula tempA = jA;
                    Celula tempB = jB;

                    for (int j = 0; j < b.coluna; j++) {
                        jResp.elemento = jResp.elemento + (jA.elemento * jB.elemento);
                        jA = jA.prox;
                        jB = jB.inf;
                    }
                    jResp = jResp.prox;
                    jA = tempA;
                    jB = tempB.prox;
                }
                iResp = iResp.inf;
                iA = iA.inf;
            }
        }
        return resp;
    }
}

public class MatrizTP {
    public static void main(String[] args) throws Exception {

        int n = MyIO.readInt();
        for (int i = 0; i < n; i++) {

            int x = MyIO.readInt();
            int y = MyIO.readInt();
            Matriz matriz1 = new Matriz(x, y);
            matriz1.inserir();
            matriz1.DiagonalPrincipal();
            MyIO.println("");
            matriz1.DiagonalSecundaria();
            MyIO.println("");

            int x1 = MyIO.readInt();
            int y2 = MyIO.readInt();
            Matriz matriz2 = new Matriz(x, y);
            matriz2.inserir();

            Matriz temp = new Matriz(x, y);
            temp = matriz1.soma(matriz1, matriz2);
            temp.mostrar();

            Matriz temp2 = new Matriz(x, y);
            temp2 = matriz1.multiplicacao(matriz1, matriz2);
            temp2.mostrar();

        } // end for
    }// end main
}// end class
