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
    public int elemento; // Conteudo do No
    public No esq, dir; // Filhos da esq e dir.
    public No2 outro;

    /**
     * Construtor da classe.
     * 
     * @param elemento Conteudo do No
     */
    public No(int elemento) {
        this(elemento, null, null);
        this.outro = null;
    }

    /**
     * Construtor da classe.
     * 
     * @param elemento Conteudo do No
     * @param esq      No da esquerda.
     * @param dir      No da direita.
     */
    public No(int elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
        this.outro = null;
    }
}

class No2 {
    public String nomePersonagem; // Nome do personagem.
    public No2 esq; // No da esquerda.
    public No2 dir; // No da direita.

    /**
     * Construtor da classe.
     * 
     * @param nomePersonagem Nome do personagem.
     */
    No2(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
        this.esq = this.dir = null;
    }

    /**
     * Construtor da classe.
     * 
     * @param nomePersonagem Nome do personagem.
     * @param esq            No2 da esquerda.
     * @param dir            No2 da direita.
     */
    No2(String nomePersonagem, No2 esq, No2 dir) {
        this.nomePersonagem = nomePersonagem;
        this.esq = esq;
        this.dir = dir;
    }
}

class ArvoreDeArvore {
    private No raiz; // Raiz da arvore.
    String caminho;

    /**
     * Construtor da classe.
     */
    public ArvoreDeArvore() {
        raiz = null;
        caminho = " raiz ";
    }

    // inserir na arvore 1
    public void inserir(int x) throws Exception {
        raiz = inserir(x, raiz);
    }

    /**
     * Metodo privado recursivo para inserir elemento.
     * 
     * @param x Elemento a ser inserido.
     * @param i No em analise.
     * @return No em analise, alterado ou nao.
     * @throws Exception Se o elemento existir.
     */
    private No inserir(int x, No i) throws Exception {
        if (i == null) {
            i = new No(x);

        } else if (x < i.elemento) {
            i.esq = inserir(x, i.esq);

        } else if (x > i.elemento) {
            i.dir = inserir(x, i.dir);

        } else {
            throw new Exception("Erro ao inserir!");
        }

        return i;
    }

    // inserir na arvore 2
    public void inserir2(String s, int y) throws Exception {
        inserir2(s, y, raiz);
    }

    public void inserir2(String s, int y, No i) throws Exception {
        if (i.elemento == y) {
            i.outro = inserir3(s, i.outro);

        } else if (y < i.elemento) {
            inserir2(s, y, i.esq);

        } else if (y > i.elemento) {
            inserir2(s, y, i.dir);

        } else {
            throw new Exception("Erro ao inserir: caractere invalido!");
        }
    }

    private No2 inserir3(String s, No2 i) throws Exception {
        if (i == null) {
            i = new No2(s);

        } else if (s.compareTo(i.nomePersonagem) < 0) {
            i.esq = inserir3(s, i.esq);

        } else if (s.compareTo(i.nomePersonagem) > 0) {
            i.dir = inserir3(s, i.dir);

        } else {
            throw new Exception("Erro ao inserir: elemento existente!");
        }

        return i;
    }

    public void mostrar() {
        mostrar(raiz);
    }

    public void mostrar(No i) {
        if (i != null) {
            mostrar(i.esq);
            // System.out.println("Letra: " + i.elemento);
            mostrar(i.outro);
            mostrar(i.dir);
        }
    }

    public void mostrar(No2 i) {
        if (i != null) {
            mostrar(i.esq);
            System.out.println(i.nomePersonagem);
            mostrar(i.dir);
        }
    }

    /**
     * Metodo publico iterativo para pesquisar elemento.
     * 
     * @param elemento Elemento que sera procurado.
     * @return <code>true</code> se o elemento existir,
     *         <code>false</code> em caso contrario.
     */
    public boolean pesquisar(String elemento) {
        return pesquisar(raiz, elemento);
    }

    private boolean pesquisar(No no, String x) {
        boolean resp = false;
        if (no != null) {

            resp = pesquisar2(no.outro, x);

            if (resp == false) {
                caminho = caminho + "esq ";
                resp = pesquisar(no.esq, x);
            }
            if (resp == false) {
                caminho = caminho + "dir ";
                resp = pesquisar(no.dir, x);
            }
           
        }
         return resp;
    }

    private boolean pesquisar2(No2 no, String x) {
        boolean resp= false;
        if(no != null){
           
           if (x.compareTo(no.nomePersonagem)==0) {
              resp = true;
         
           } 
           else{
           
            caminho = caminho + "ESQ ";
              resp = pesquisar2(no.esq,x);
           
              if(resp == false){
                caminho = caminho + "DIR ";
                 resp = pesquisar2(no.dir,x);
              }
           }
        }
        return resp;
    }

    public void zerarCaminho() {
        caminho = " raiz ";
    }

}

// end ArvoredeArvore
public class arvoreArvore {
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
        ArvoreDeArvore arvore = new ArvoreDeArvore();
        String[] entrada = new String[1000];
        String[] entrada2 = new String[1000];
        int[] altura = new int[100];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numEntrada = 0, numEntrada2 = 0, h = 0;
        arvore.inserir(7);
        arvore.inserir(3);
        arvore.inserir(11);
        arvore.inserir(1);
        arvore.inserir(5);
        arvore.inserir(9);
        arvore.inserir(12);
        arvore.inserir(0);
        arvore.inserir(2);
        arvore.inserir(4);
        arvore.inserir(6);
        arvore.inserir(8);
        arvore.inserir(10);
        arvore.inserir(13);
        arvore.inserir(14);

        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = br.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM
        for (int i = 0; i < numEntrada; i++) {
            personagens = new Personagens();
            personagens.ler(entrada[i]);
            altura[i] = personagens.getAltura() % 15;
            arvore.inserir2(personagens.getNome(), h);
        }
        do {
            entrada2[numEntrada2] = br.readLine();
        } while (isFim(entrada2[numEntrada2++]) == false);
        numEntrada2--; // Desconsiderar ultima linha contendo a palavra FIM
        for (int i = 0; i < numEntrada2; i++) {
            if (arvore.pesquisar(entrada2[i]) == true) {
                System.out.println(entrada2[i] + arvore.caminho + "SIM");
                arvore.zerarCaminho();
            } else {
                System.out.println(entrada2[i] + arvore.caminho + "NÃO");
                arvore.zerarCaminho();
            } 
        }
    br.close();
    }// end main
}
