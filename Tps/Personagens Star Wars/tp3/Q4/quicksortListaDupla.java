import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

class Personagens {
    static DecimalFormat formatter = new DecimalFormat("#");
    // Atributos
    private String nome;
    private int altura;
    private double peso;
    private String corDoCabelo;
    private String corDaPele;
    private String corDosOlhos;
    private String anoNascimento;
    private String genero;
    private String homeworld;

    public Personagens() {
        nome = "";
        altura = 0;
        peso = 0.00;
        corDoCabelo = "";
        corDaPele = "";
        corDosOlhos = "";
        anoNascimento = "";
        genero = "";
        homeworld = "";
    }// end construtor

    // Setters & getters
    public void setNome(String nome) {
        this.nome = nome;
    }// end setNome

    public String getNome() {
        return nome;
    }// end getNome

    public void setAltura(int altura) {
        this.altura = altura;
    }// end setAltura

    public int getAltura() {
        return altura;
    }// end getAltura

    public void setPeso(double peso) {
        this.peso = peso;
    }// end setPeso

    public double getPeso() {
        return peso;
    }// end getPeso

    public void setCorDoCabelo(String corDoCabelo) {
        this.corDoCabelo = corDoCabelo;
    }// end setCorDoCabelo

    public String getCorDoCabelo() {
        return corDoCabelo;
    }// end getCorDoCabelo

    public void setCorDaPele(String corDaPele) {
        this.corDaPele = corDaPele;
    }// end setCorDaPele

    public String getCorDaPele() {
        return corDaPele;
    }// end getCorDaPele

    public void setCorDosOlhos(String corDosOlhos) {
        this.corDosOlhos = corDosOlhos;
    }// end setCorDosOlhos

    public String getCorDosOlhos() {
        return corDosOlhos;
    }// end getCorDosOlhos

    public void setAnoNascimento(String anoNascimento) {
        this.anoNascimento = anoNascimento;
    }// end setAnoNascimento

    public String getAnoNascimento() {
        return anoNascimento;
    }// end getAnoNascimento

    public void setGenero(String genero) {
        this.genero = genero;
    }// end setGenero

    public String getGenero() {
        return genero;
    }// end getGenero

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }// end setHomeworld

    public String getHomeworld() {
        return homeworld;
    }// end getHomeworld

    // metodo que mostra na tela todos os atributos de um personagem
    public String imprimir() {
        return (" ## " + getNome() + " ## " + getAltura() + " ## " + tratarPeso() + " ## " +
                getCorDoCabelo() + " ## " + getCorDaPele() + " ## " + getCorDosOlhos() + " ## " + getAnoNascimento()
                + " ## "
                + getGenero() + " ## " + getHomeworld() + " ## ");
    }// end imprimir

    // Funcao para tratar a forma como o atributo peso sera mostrado
    // Se o numero for zero depois do -> mostrara sem ponto
    // Se o numero depois do ponto for diferente de zero -> mostrara com ponto
    public String tratarPeso() {
        if (getPeso() == ((int) getPeso())) {
            return formatter.format(getPeso());
        } else {
            return String.valueOf(getPeso());
        }
    }// end tratarPeso

    // metodo para ler e setar os atributos de um personagem
    public void ler(String caminho) throws Exception {
        FileReader arq = new FileReader(caminho);
        BufferedReader br = new BufferedReader(arq);
        // receber os atributos
        String linha = br.readLine();
        setNome((linha.split("',")[0]).replace("{'name': '", "").replace("'", ""));
        try {
            setAltura(Integer.parseInt((linha.split("',")[1]).replace(" 'height': '", "").replace("'", "")));
        } catch (NumberFormatException e) {
            setAltura(0);
        }
        try {
            setPeso(Double.parseDouble((linha.split("',")[2]).replace(" 'mass': '", "").replace("'", "")));
        } catch (NumberFormatException e) {
            try {
                setPeso(Double.parseDouble(
                        (linha.split("',")[2]).replace(" 'mass': '", "").replace("'", "").replace(",", "")));
            } catch (NumberFormatException f) {
                setPeso(0);
            }
        }
        setCorDoCabelo((linha.split("',")[3]).replace(" 'hair_color': '", "").replace("'", ""));
        setCorDaPele((linha.split("',")[4]).replace(" 'skin_color': '", "").replace("'", ""));
        setCorDosOlhos((linha.split("',")[5]).replace(" 'eye_color': '", "").replace("'", ""));
        setAnoNascimento((linha.split("',")[6]).replace(" 'birth_year': '", "").replace("'", ""));
        setGenero((linha.split("',")[7]).replace(" 'gender': '", "").replace("'", ""));
        setHomeworld((linha.split("',")[8]).replace(" 'homeworld': '", "").replace("'", ""));
        br.close();
    }// end ler
}// end Personagens

class CelulaDupla {
    public Personagens elemento;
    public int posicao;
    public CelulaDupla ant;
    public CelulaDupla prox;
    private static Personagens x;

    /**
     * Construtor da classe.
     */
    public CelulaDupla() {
        this(x);
    }

    /**
     * Construtor da classe.
     * 
     * @param elemento Personagem inserido na celula.
     */
    public CelulaDupla(Personagens elemento) {
        this.elemento = elemento;
        this.posicao = 0;
        this.ant = this.prox = null;
    }
}

class ListaDupla {
    private CelulaDupla primeiro;
    private CelulaDupla ultimo;

    /**
     * Construtor da classe que cria uma lista dupla sem elementos (somente no
     * cabeca).
     */
    public ListaDupla() {
        primeiro = new CelulaDupla();
        ultimo = primeiro;
    }

    /**
     * Insere um elemento na primeira posicao da lista.
     * 
     * @param x int elemento a ser inserido.
     */
    public void inserirInicio(Personagens x, int posicao) {
        CelulaDupla tmp = new CelulaDupla(x);

        tmp.ant = primeiro;
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        primeiro.posicao = posicao;
        if (primeiro == ultimo) {
            ultimo = tmp;
        } else {
            tmp.prox.ant = tmp;
        }
        tmp = null;
    }

    /**
     * Insere um elemento na ultima posicao da lista.
     * 
     * @param x int elemento a ser inserido.
     */
    public void inserirFim(Personagens x, int posicao) {
        ultimo.prox = new CelulaDupla(x);
        ultimo.prox.ant = ultimo;
        ultimo.posicao = posicao;
        ultimo = ultimo.prox;
    }

    /**
     * Remove um elemento da primeira posicao da lista.
     * 
     * @return resp elemento a ser removido.
     * @throws Exception Se a lista nao contiver elementos.
     */
    public Personagens removerInicio() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover (vazia)!");
        }

        CelulaDupla tmp = primeiro;
        primeiro = primeiro.prox;
        Personagens resp = primeiro.elemento;
        tmp.prox = primeiro.ant = null;
        tmp = null;
        return resp;
    }

    /**
     * Remove um elemento da ultima posicao da lista.
     * 
     * @return resp elemento a ser removido.
     * @throws Exception Se a lista nao contiver elementos.
     */
    public Personagens removerFim() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover (vazia)!");
        }
        Personagens resp = ultimo.elemento;
        ultimo = ultimo.ant;
        ultimo.prox.ant = null;
        ultimo.prox = null;
        return resp;
    }

    /**
     * Insere um elemento em uma posicao especifica considerando que o
     * primeiro elemento valido esta na posicao 0.
     * 
     * @param x   int elemento a ser inserido.
     * @param pos int posicao da insercao.
     * @throws Exception Se <code>posicao</code> invalida.
     */
    public void inserir(Personagens x, int pos) throws Exception {

        int tamanho = tamanho();

        if (pos < 0 || pos > tamanho) {
            throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
        } else if (pos == 0) {
            inserirInicio(x, pos);
        } else if (pos == tamanho) {
            inserirFim(x, pos);
        } else {
            // Caminhar ate a posicao anterior a insercao
            CelulaDupla i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;

            CelulaDupla tmp = new CelulaDupla(x);
            tmp.ant = i;
            tmp.prox = i.prox;
            tmp.ant.prox = tmp.prox.ant = tmp;
            tmp = i = null;
        }
    }

    /**
     * Remove um elemento de uma posicao especifica da lista
     * considerando que o primeiro elemento valido esta na posicao 0.
     * 
     * @param posicao Meio da remocao.
     * @return resp int elemento a ser removido.
     * @throws Exception Se <code>posicao</code> invalida.
     */
    public Personagens remover(int pos) throws Exception {
        Personagens resp;
        int tamanho = tamanho();

        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover (vazia)!");

        } else if (pos < 0 || pos >= tamanho) {
            throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
        } else if (pos == 0) {
            resp = removerInicio();
        } else if (pos == tamanho - 1) {
            resp = removerFim();
        } else {
            // Caminhar ate a posicao anterior a insercao
            CelulaDupla i = primeiro.prox;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;

            i.ant.prox = i.prox;
            i.prox.ant = i.ant;
            resp = i.elemento;
            i.prox = i.ant = null;
            i = null;
        }

        return resp;
    }

    /**
     * Mostra os elementos da lista separados por espacos.
     */
    public void mostrar() {
        for (CelulaDupla i = primeiro.prox; i != null; i = i.prox) {
            System.out.print(i.elemento.imprimir() + "\n");
        }
    }

    /**
     * Calcula e retorna o tamanho, em numero de elementos, da lista.
     * 
     * @return resp int tamanho
     */
    public int tamanho() {
        int tamanho = 0;
        for (CelulaDupla i = primeiro; i != ultimo; i = i.prox, tamanho++)
            ;
        return tamanho;
    }

    void swap(CelulaDupla i, CelulaDupla j) {
        Personagens temp = i.elemento;
        i.elemento = j.elemento;
        j.elemento = temp;
    }

    public void quicksortRec(CelulaDupla esq, CelulaDupla dir) {
        CelulaDupla i = esq, j = dir, l;
        int c = 0;
        CelulaDupla pivoCelulaDupla = new CelulaDupla();
        l = i.prox;
        while (c < tamanho() / 2) {
            pivoCelulaDupla = l;
            l = l.prox;
            c++;
        }
        Personagens pivo = pivoCelulaDupla.elemento;
        Personagens temp;
        
        while (primeiro.posicao < j.posicao) {
            while (primeiro != null &&
            (primeiro.elemento.getCorDoCabelo().compareTo(pivo.getCorDoCabelo())) < 0
                    || (primeiro.elemento.getCorDoCabelo().compareTo(pivo.getCorDoCabelo())) == 0
                            && (primeiro.elemento.getNome().compareTo(pivo.getNome())) < 0) {

                primeiro = primeiro.prox;
            }

            while (ultimo != null && (ultimo.elemento.getCorDoCabelo().compareTo(pivo.getCorDoCabelo())) > 0
                    || (ultimo.elemento.getCorDoCabelo().compareTo(pivo.getCorDoCabelo())) == 0
                            && (ultimo.elemento.getNome().compareTo(pivo.getNome())) > 0) {

                ultimo = ultimo.ant;
            }

            if (primeiro.posicao < ultimo.posicao) {
                temp = primeiro.elemento;
                primeiro.elemento = ultimo.elemento;
                ultimo.elemento = temp;
                primeiro = primeiro.prox;
                ultimo = ultimo.ant;
            }
        }
        if (esq.posicao < ultimo.posicao)
            quicksortRec(esq, ultimo);
        if (primeiro.posicao < dir.posicao)
            quicksortRec(primeiro, dir);
    }// end quicksorRec

    void sort() {
        quicksortRec(primeiro, ultimo);
    }

}

public class quicksortListaDupla {

    /**
     * isFim - metodo para dizer se a string recebida
     * e a palavra FIM.
     * 
     * @param str - string a ser analizada.
     * @return true - se a string for a palavra FIM;
     *         false- caso contrario.
     */
    public static boolean isFim(String str) {
        boolean resposta = false;
        int tamanho = str.length();
        if (tamanho == 3 && str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M') {
            resposta = true;
        } // end if
        return resposta;
    }// end isFim

    public static void main(String[] args) throws Exception {
        // MyIO.setCharset("UTF-8");
        Personagens personagens = new Personagens();
        ListaDupla lista = new ListaDupla();
        String[] entrada = new String[1000];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numEntrada = 0;
        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = br.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

        for (int i = 0; i < numEntrada; i++) {
            personagens = new Personagens();
            personagens.ler(entrada[i]);
            lista.inserirFim(personagens, i);

        } // end for
        lista.sort();
        lista.mostrar();
        br.close();
    }// end main

}
