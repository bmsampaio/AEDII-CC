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

class No {
    public char elemento; // Conteudo do no.
    public final int tamanho = 255;
    public No[] prox;
    public boolean folha;

    public No() {
        this(' ');
    }

    public No(char elemento) {
        this.elemento = elemento;
        prox = new No[tamanho];
        for (int i = 0; i < tamanho; i++)
            prox[i] = null;
        folha = false;
    }

    public static int hash(char x) {
        return (int) x;
    }
}

class ArvoreTrie {
     No raiz;

    public ArvoreTrie() {
        raiz = new No();
    }

    public boolean pesquisar(String s) throws Exception {
        return pesquisar(s, raiz, 0);
    }

    public boolean pesquisar(String s, No no, int i) throws Exception {
        boolean resp;
        if (no.prox[s.charAt(i)] == null) {
            resp = false;
        } else if (i == s.length() - 1) {
            resp = (no.prox[s.charAt(i)].folha == true);
        } else if (i < s.length() - 1) {
            resp = pesquisar(s, no.prox[s.charAt(i)], i + 1);
        } else {
            throw new Exception("Erro ao pesquisar!");
        }
        return resp;
    }

    public void inserir(String s) throws Exception {
        inserir(s, raiz, 0);
    }

    private void inserir(String s, No no, int i) throws Exception {
        if (no.prox[s.charAt(i)] == null) {
            no.prox[s.charAt(i)] = new No(s.charAt(i));
            if (i == s.length() - 1) {
                no.prox[s.charAt(i)].folha = true;
            } else {
                inserir(s, no.prox[s.charAt(i)], i + 1);
            }
        } else if (no.prox[s.charAt(i)].folha == false && i < s.length() - 1) {
            inserir(s, no.prox[s.charAt(i)], i + 1);
        } else {
            throw new Exception("Erro ao inserir!");
        }
    }

}

public class trieTree {
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
        ArvoreTrie arvore1 = new ArvoreTrie();
        ArvoreTrie arvore2 = new ArvoreTrie();
        ArvoreTrie arvore3 = new ArvoreTrie();
        String[] entrada = new String[1000];
        String[] entrada2 = new String[1000];
        String[] entrada3 = new String[1000];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numEntrada = 0, numEntrada2 = 0, numEntrada3 = 0;
        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = br.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM
        for (int i = 0; i < numEntrada; i++) {
            personagens = new Personagens();
            personagens.ler(entrada[i]);
            arvore1.inserir(personagens.getNome());
        }
        do {
            entrada2[numEntrada2] = br.readLine();
        } while (isFim(entrada2[numEntrada2++]) == false);
        numEntrada2--; // Desconsiderar ultima linha contendo a palavra
        for (int i = 0; i < numEntrada2; i++) {
            personagens = new Personagens();
            personagens.ler(entrada2[i]);
            arvore2.inserir(personagens.getNome());
        }
        arvore3 = arvore1;
        for (int i = 0; i < numEntrada; i++) {
            personagens = new Personagens();
            personagens.ler(entrada2[i]);
            arvore3.inserir(personagens.getNome());
        }

        do {
            entrada3[numEntrada3] = br.readLine();
        } while (isFim(entrada3[numEntrada3++]) == false);
        numEntrada3--; // Desconsiderar ultima linha contendo a palavra

        for (int i = 0; i < numEntrada3; i++) {
            if (arvore3.pesquisar(entrada3[i]) == true) {
                System.out.print(entrada3[i] + " SIM\n");
            } else {
                System.out.print(entrada3[i] + " NÃO\n");
            }
        }
        br.close();
    }// end main
}
