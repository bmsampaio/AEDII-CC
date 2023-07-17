import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

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

class Celula {
    public Personagens elemento; // Elemento inserido na celula.
    public Celula prox; // Aponta a celula prox.
    private static Personagens x;

    /**
     * Construtor da classe.
     */
    public Celula() {
        this(x);
    }

    /**
     * Construtor da classe.
     * 
     * @param elemento int inserido na celula.
     */
    public Celula(Personagens elemento) {
        this.elemento = elemento;
        this.prox = null;
    }
}

/**
 * Pilha dinamica
 */
class Pilha {
    private Celula topo;
    int tamanho = 0;

    /**
     * Construtor da classe que cria uma fila sem elementos.
     */
    public Pilha() {
        topo = null;
    }

    /**
     * Insere elemento na pilha (politica FILO).
     * 
     * @param x int elemento a inserir.
     */
    public void empilhar(Personagens x) {
        Celula tmp = new Celula(x);
        tmp.prox = topo;
        topo = tmp;
        tmp = null;
        tamanho++;
    }

    /**
     * Remove elemento da pilha (politica FILO).
     * 
     * @return Elemento removido.
     * @trhows Exception Se a sequencia nao contiver elementos.
     */
    public Personagens desempilhar() throws Exception {
        if (topo == null) {
            throw new Exception("Erro ao remover!");
        }
        Personagens resp = topo.elemento;
        Celula tmp = topo;
        topo = topo.prox;
        tmp.prox = null;
        tmp = null;
        tamanho--;
        return resp;
    }

    /**
     * Mostra os elementos separados por espacos, comecando do topo.
     */
    public void mostrar() {
        // int y = 0;
        for (Celula i = topo; i != null; i = i.prox) {
            System.out.print(i.elemento.imprimir() + "\n");
        }
    }

    public void mostraPilha() {

        mostraPilha(topo, tamanho);
    }

    private void mostraPilha(Celula i, int count) {

        if (i != null) {

            mostraPilha(i.prox, --count);
            System.out.print("[" + count + "] " + i.elemento.imprimir() + "\n");

        }
    }

}



public class pilhaFlexivel {

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
        MyIO.setCharset("UTF-8");
        Personagens personagens = new Personagens();
        Pilha p1 = new Pilha();
        String[] entrada = new String[1000];
        String[] entrada2 = new String[1000];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numEntrada = 0, aux = 0, pos = 0;
        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = br.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

        for (int i = 0; i < numEntrada; i++) {
            personagens = new Personagens();
            personagens.ler(entrada[i]);
            p1.empilhar(personagens);

        } // end for
        numEntrada = 0;
        aux = Integer.parseInt(br.readLine());

        while (numEntrada < aux) {
            entrada2[numEntrada] = br.readLine();
            numEntrada++;
        }

        for (int i = 0; i < numEntrada; i++) {
            // System.out.println(entrada2[i]);
            if (entrada2[i].contains("I") == true) {
                personagens = new Personagens();
                personagens.ler(entrada2[i].split(" ")[1]);
                p1.empilhar(personagens);
            } else if (entrada2[i].contains("R") == true) {
                personagens = new Personagens();
                System.out.println("(R) " + p1.desempilhar().getNome());
            }
        } // end for
        p1.mostraPilha();
        br.close();
    }// end main

}
