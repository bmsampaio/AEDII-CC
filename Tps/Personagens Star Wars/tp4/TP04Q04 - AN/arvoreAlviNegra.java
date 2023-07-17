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
    public boolean cor;
    public Personagens elemento;
    public No esq, dir;

    public No(Personagens elemento) {
        this(elemento, false, null, null);
    }

    public No(Personagens elemento, boolean cor) {
        this(elemento, cor, null, null);
    }

    public No(Personagens elemento, boolean cor, No esq, No dir) {
        this.cor = cor;
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}

class ArvoreAN {
    private No raiz; // Raiz da arvore.
    public String caminho;

    /**
     * Construtor da classe.
     */
    public ArvoreAN() {
        raiz = null;
        caminho = " raiz ";
    }

    /**
     * Metodo publico iterativo para pesquisar elemento.
     * 
     * @param x Elemento que sera procurado.
     * @return <code>true</code> se o elemento existir,
     *         <code>false</code> em caso contrario.
     */
    public boolean pesquisar(String x) {
        return pesquisar(x, raiz);
    }

    /**
     * Metodo privado recursivo para pesquisar elemento.
     * 
     * @param x Elemento que sera procurado.
     * @param i No em analise.
     * @return <code>true</code> se o elemento existir,
     *         <code>false</code> em caso contrario.
     */
    private boolean pesquisar(String x, No i) {
        boolean resp;
        if (i == null) {
            resp = false;

        } else if (x.compareTo(i.elemento.getNome()) == 0) {
            resp = true;

        } else if (x.compareTo(i.elemento.getNome()) < 0) {
            caminho = caminho + "esq ";
            resp = pesquisar(x, i.esq);

        } else {
            caminho = caminho + "dir ";
            resp = pesquisar(x, i.dir);

        }

        return resp;
    }

    public void zerarCaminho() {
        caminho = " raiz ";
    }

    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void caminharCentral() {
        System.out.print("[ ");
        caminharCentral(raiz);
        System.out.println("]");
    }

    /**
     * Metodo privado recursivo para exibir elementos.
     * 
     * @param i No em analise.
     */
    private void caminharCentral(No i) {
        if (i != null) {
            caminharCentral(i.esq); // Elementos da esquerda.
            System.out.print(i.elemento + " "); // Conteudo do no.
            caminharCentral(i.dir); // Elementos da direita.
        }
    }

    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void caminharPre() {
        System.out.print("[ ");
        caminharPre(raiz);
        System.out.println("]");
    }

    /**
     * Metodo privado recursivo para exibir elementos.
     * 
     * @param i No em analise.
     */
    private void caminharPre(No i) {
        if (i != null) {
            System.out.print(i.elemento + " "); // Conteudo do no.
            caminharPre(i.esq); // Elementos da esquerda.
            caminharPre(i.dir); // Elementos da direita.
        }
    }

    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void caminharPos() {
        System.out.print("[ ");
        caminharPos(raiz);
        System.out.println("]");
    }

    /**
     * Metodo privado recursivo para exibir elementos.
     * 
     * @param i No em analise.
     */
    private void caminharPos(No i) {
        if (i != null) {
            caminharPos(i.esq); // Elementos da esquerda.
            caminharPos(i.dir); // Elementos da direita.
            System.out.print(i.elemento + " "); // Conteudo do no.
        }
    }

    public void inserir(Personagens elemento) throws Exception {
        // Se a arvore estiver vazia
        if (raiz == null) {
            raiz = new No(elemento);
            // Senao, se a arvore tiver um elemento
        } else if (raiz.esq == null && raiz.dir == null) {
            if (elemento.getNome().compareTo(raiz.elemento.getNome()) < 0) {
                raiz.esq = new No(elemento);
            } else {
                raiz.dir = new No(elemento);
            }

            // Senao, se a arvore tiver dois elementos (raiz e dir)
        } else if (raiz.esq == null) {
            if (elemento.getNome().compareTo(raiz.elemento.getNome()) < 0) {
                raiz.esq = new No(elemento);
            } else if (elemento.getNome().compareTo(raiz.dir.elemento.getNome()) < 0) {
                raiz.esq = new No(raiz.elemento);
                raiz.elemento = elemento;
            } else {
                raiz.esq = new No(raiz.elemento);
                raiz.elemento = raiz.dir.elemento;
                raiz.dir.elemento = elemento;
            }
            raiz.esq.cor = raiz.dir.cor = false;

            // Senao, se a arvore tiver dois elementos (raiz e esq)
        } else if (raiz.dir == null) {
            if (elemento.getNome().compareTo(raiz.elemento.getNome()) > 0) {
                raiz.dir = new No(elemento);

            } else if (elemento.getNome().compareTo(raiz.esq.elemento.getNome()) > 0) {
                raiz.dir = new No(raiz.elemento);
                raiz.elemento = elemento;
            } else {
                raiz.dir = new No(raiz.elemento);
                raiz.elemento = raiz.esq.elemento;
                raiz.esq.elemento = elemento;
            }
            raiz.esq.cor = raiz.dir.cor = false;

            // Senao, a arvore tem tres ou mais elementos
        } else {
            inserir(elemento, null, null, null, raiz);
        }
        raiz.cor = false;
    }

    private void balancear(No bisavo, No avo, No pai, No i) {
        // Se o pai tambem e preto, reequilibrar a arvore, rotacionando o avo
        if (pai.cor == true) {
            // 4 tipos de reequilibrios e acoplamento
            if (pai.elemento.getNome().compareTo(avo.elemento.getNome()) > 0) { // rotacao a esquerda ou
                                                                                // direita-esquerda
                if (i.elemento.getNome().compareTo(pai.elemento.getNome()) > 0) {
                    avo = rotacaoEsq(avo);
                } else {
                    avo = rotacaoDirEsq(avo);
                }
            } else { // rotacao a direita ou esquerda-direita
                if (i.elemento.getNome().compareTo(pai.elemento.getNome()) < 0) {
                    avo = rotacaoDir(avo);
                } else {
                    avo = rotacaoEsqDir(avo);
                }
            }
            if (bisavo == null) {
                raiz = avo;
            } else if (avo.elemento.getNome().compareTo(bisavo.elemento.getNome()) < 0) {
                bisavo.esq = avo;
            } else {
                bisavo.dir = avo;
            }
            // reestabelecer as cores apos a rotacao
            avo.cor = false;
            avo.esq.cor = avo.dir.cor = true;
        } // if(pai.cor == true)
    }

    /**
     * Metodo privado recursivo para inserir elemento.
     * 
     * @param elemento Elemento a ser inserido.
     * @param avo      No em analise.
     * @param pai      No em analise.
     * @param i        No em analise.
     * @throws Exception Se o elemento existir.
     */
    private void inserir(Personagens elemento, No bisavo, No avo, No pai, No i) throws Exception {
        if (i == null) {
            if (elemento.getNome().compareTo(pai.elemento.getNome()) < 0) {
                i = pai.esq = new No(elemento, true);
            } else {
                i = pai.dir = new No(elemento, true);
            }
            if (pai.cor == true) {
                balancear(bisavo, avo, pai, i);
            }
        } else {
            // Achou um 4-no: eh preciso fragmeta-lo e reequilibrar a arvore
            if (i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true) {
                i.cor = true;
                i.esq.cor = i.dir.cor = false;
                if (i == raiz) {
                    i.cor = false;
                } else if (pai.cor == true) {
                    balancear(bisavo, avo, pai, i);
                }
            }
            if (elemento.getNome().compareTo(i.elemento.getNome()) < 0) {
                inserir(elemento, avo, pai, i, i.esq);
            } else if (elemento.getNome().compareTo(i.elemento.getNome()) > 0) {
                inserir(elemento, avo, pai, i, i.dir);
            } else {
                throw new Exception("Erro inserir (elemento repetido)!");
            }
        }
    }

    private No rotacaoDir(No no) {
        No noEsq = no.esq;
        No noEsqDir = noEsq.dir;

        noEsq.dir = no;
        no.esq = noEsqDir;

        return noEsq;
    }

    private No rotacaoEsq(No no) {
        No noDir = no.dir;
        No noDirEsq = noDir.esq;

        noDir.esq = no;
        no.dir = noDirEsq;
        return noDir;
    }

    private No rotacaoDirEsq(No no) {
        no.dir = rotacaoDir(no.dir);
        return rotacaoEsq(no);
    }

    private No rotacaoEsqDir(No no) {
        no.esq = rotacaoEsq(no.esq);
        return rotacaoDir(no);
    }
}

public class arvoreAlviNegra {
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
        ArvoreAN arvore = new ArvoreAN();
        String[] entrada = new String[1000];
        String[] entrada2 = new String[1000];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numEntrada = 0, numEntrada2 = 0;
        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = br.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM
        for (int i = 0; i < numEntrada; i++) {
            personagens = new Personagens();
            personagens.ler(entrada[i]);
            arvore.inserir(personagens);
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
