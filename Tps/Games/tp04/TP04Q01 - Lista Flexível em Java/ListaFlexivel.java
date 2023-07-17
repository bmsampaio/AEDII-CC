import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * classe
 */

class Games {
    public static DateFormat dateFormat = new SimpleDateFormat("MMM/yyyy", new Locale("en", "US"));
    static DecimalFormat formatter = new DecimalFormat("##");
    ListaFlexivel classe = new ListaFlexivel();

    // atributos
    private int app_id;
    private String name;
    private Date release_date;
    private String owners;
    private int age;
    private float price;
    private int dlcs;
    private String[] languages;
    private String website;
    private boolean windows;
    private boolean mac;
    private boolean linux;
    private float upvotes;
    private int avg_pt;
    private String developers;
    private String[] genres;

    public Games() {
        app_id = 0;
        name = "";
        release_date = new Date(0);
        owners = "";
        age = 0;
        price = 0;
        dlcs = 0;
        website = "";
        windows = false;
        mac = false;
        linux = false;
        upvotes = 0;
        avg_pt = 0;
        developers = "";
    }// end construtor

    // Gets & Sets
    public void setApp_id(int app_id) {
        this.app_id = app_id;
    }// end setApp_id

    public int getApp_id() {
        return app_id;
    }// end getApp_id

    public void setName(String name) {
        this.name = name;
    }// end setName

    public String getName() {
        return name;
    }// end getName

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }// end setRelease_date

    public Date getRelease_date() {
        return release_date;
    }// end getRelease_date

    public void setOwners(String owners) {
        this.owners = owners;
    }// end setOwners

    public String getOwners() {
        return owners;
    }// end getOwners

    public void setAge(int age) {
        this.age = age;
    }// end setAge

    public int getAge() {
        return age;
    }// end getAge

    public void setPrice(float price) {
        this.price = price;
    }// end setPrice

    public float getPrice() {
        return price;
    }// end getPrice

    public void setDlcs(int dlcs) {
        this.dlcs = dlcs;
    }// end setDlcs

    public int getDlcs() {
        return dlcs;
    }// end getDlcs

    public void setWebsite(String website) {
        this.website = website;
    }// end setWebsite

    public String getWebsite() {
        return website;
    }// end getWebsite

    public void setWindows(Boolean windows) {
        this.windows = windows;
    }// end setWindows

    public boolean getWindows() {
        return windows;
    }// end getWindows

    public void setMac(Boolean mac) {
        this.mac = mac;
    }// end setMac

    public boolean getMac() {
        return mac;
    }// end getMac

    public void setLinux(Boolean linux) {
        this.linux = linux;
    }// end setLinux

    public boolean getLinux() {
        return linux;
    }// end getLinux

    public void setUpvotes(float upvotes) {
        this.upvotes = upvotes;
    }// end setUpvotes

    public float getUpvotes() {
        return upvotes;
    }// end getUpvotes

    public void setAvg_pt(int avg_pt) {
        this.avg_pt = avg_pt;
    }// end setAvg_pt

    public int getAvg_pt() {
        return avg_pt;
    }// end getAvg_pt

    public void setDevelopers(String developers) {
        this.developers = developers;
    }// end setDevelopers

    public String getDevelopers() {
        return developers;
    }// end getDevelopers

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }// end setLanguages

    public String getLanguages() {
        String aux = "";
        if (languages.length > 1) {
            for (int i = 0; i < languages.length; i++) {
                aux = aux + languages[i];
                if (i != languages.length - 1) {
                    aux = aux + ',';
                }
            }
        } else {
            aux = languages[0];
        }
        return aux;
    }// end getLanguages

    public void setGenres(String[] genres) {
        this.genres = genres;
    }// end setGenres

    public String getGenres() {
        String aux = "";
        if (genres.length > 1) {
            for (int i = 0; i < genres.length; i++) {
                aux = aux + genres[i];
                if (i != genres.length - 1) {
                    aux = aux + ',' + ' ';
                }
            }
        } else {
            aux = genres[0];
        }
        return aux;
    }// end getGenres

    public String imprimir() {

        return getApp_id() + " " + getName() +
                " " + dateFormat.format(getRelease_date()) + " "
                + getOwners() + " "
                + getAge() + " " + String.format(Locale.ENGLISH, "%.2f", getPrice()) + " " + getDlcs() + " ["
                + getLanguages() + "] "
                + getWebsite() +
                " " + getWindows() + " " + getMac() + " " + getLinux() + " "
                + formatter.format(getUpvotes())
                + "% " + classe.tratarDuracao(getAvg_pt()) + " " + getDevelopers() + " [" + getGenres()
                + "]";
    }

}// end Games

class Celula {
    public Games elemento; // Elemento inserido na celula.
    public Celula prox; // Aponta a celula prox.
    private static Games x;

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
    public Celula(Games elemento) {
        this.elemento = elemento;
        this.prox = null;
    }
}

/**
 * Lista dinamica
 */
class Lista {

    public static SimpleDateFormat form = new SimpleDateFormat("MM/yyyy");
    public static DateFormat dateFormat = new SimpleDateFormat("MMM/yyyy", new Locale("en", "US"));
    static DecimalFormat formatter = new DecimalFormat("#");
    private Games[] array;
    private int n;

    private Celula primeiro;
    private Celula ultimo;

    /**
     * Construtor da classe que cria uma lista sem elementos (somente no cabeca).
     */
    public Lista() {
        primeiro = new Celula();
        ultimo = primeiro;
    }

    /**
     * Insere um elemento na primeira posicao da lista.
     * 
     * @param x int elemento a ser inserido.
     */
    public void inserirInicio(Games x) {
        Celula tmp = new Celula(x);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        }
        tmp = null;
    }

    /**
     * Insere um elemento na ultima posicao da lista.
     * 
     * @param x int elemento a ser inserido.
     */
    public void inserirFim(Games x) {
        ultimo.prox = new Celula(x);
        ultimo = ultimo.prox;
    }

    /**
     * Remove um elemento da primeira posicao da lista.
     * 
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista nao contiver elementos.
     */
    public Games removerInicio() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover (vazia)!");
        }

        Celula tmp = primeiro;
        primeiro = primeiro.prox;
        Games resp = primeiro.elemento;
        tmp.prox = null;
        tmp = null;
        return resp;
    }

    /**
     * Remove um elemento da ultima posicao da lista.
     * 
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista nao contiver elementos.
     */
    public Games removerFim() throws Exception {
        if (primeiro == ultimo) {
            throw new Exception("Erro ao remover (vazia)!");
        }

        // Caminhar ate a penultima celula:
        Celula i;
        for (i = primeiro; i.prox != ultimo; i = i.prox)
            ;

        Games resp = ultimo.elemento;
        ultimo = i;
        i = ultimo.prox = null;

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
    public void inserir(Games x, int pos) throws Exception {

        int tamanho = tamanho();

        if (pos < 0 || pos > tamanho) {
            throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
        } else if (pos == 0) {
            inserirInicio(x);
        } else if (pos == tamanho) {
            inserirFim(x);
        } else {
            // Caminhar ate a posicao anterior a insercao
            Celula i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;

            Celula tmp = new Celula(x);
            tmp.prox = i.prox;
            i.prox = tmp;
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
    public Games remover(int pos) throws Exception {
        Games resp;
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
            Celula i = primeiro;
            for (int j = 0; j < pos; j++, i = i.prox)
                ;

            Celula tmp = i.prox;
            resp = tmp.elemento;
            i.prox = tmp.prox;
            tmp.prox = null;
            i = tmp = null;
        }

        return resp;
    }

    /**
	 * Mostra os elementos da lista separados por espacos.
	 */
	public void mostrar() {
        for(int y = 0; y < tamanho() ; ){
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
			System.out.print("[" + y++ + "] " + i.elemento.imprimir() + "\n");
        }
		}
	}

    // /**
    // * Procura um elemento e retorna se ele existe.
    // * @param x Elemento a pesquisar.
    // * @return <code>true</code> se o elemento existir,
    // * <code>false</code> em caso contrario.
    // */
    // public boolean pesquisar(int x) {
    // boolean resp = false;
    // for (Celula i = primeiro.prox; i != null; i = i.prox) {
    // if(i.elemento == x){
    // resp = true;
    // i = ultimo;
    // }
    // }
    // return resp;
    // }

    /**
     * Calcula e retorna o tamanho, em numero de elementos, da lista.
     * 
     * @return resp int tamanho
     */
    public int tamanho() {
        int tamanho = 0;
        for (Celula i = primeiro; i != ultimo; i = i.prox, tamanho++)
            ;
        return tamanho;
    }

}

public class ListaFlexivel {

    public static SimpleDateFormat form = new SimpleDateFormat("MM/yyyy");
    public static DateFormat dateFormat = new SimpleDateFormat("MMM/yyyy", new Locale("en", "US"));
    static DecimalFormat formatter = new DecimalFormat("#");
    public static Games games = new Games();
    public static Lista lista = new Lista();

    public String tratarDuracao(int entrada) {
        String resultado = "";
        int hora = 0;
        int min = 0;
        if (entrada == 0) {
            resultado = "null";
        } else {
            hora = ((entrada)) / 60;
            min = ((entrada)) % 60;
            if (hora > 0) {
                resultado = hora + "h " + min + "m";
            } else {
                resultado = min + "m";
            }
        }

        return resultado;
    }

    public static Date tratarData(String entrada) throws Exception {
        // System.out.println(entrada);
        int dia = Integer.parseInt((entrada.split(" ")[1]).split(",")[0]);
        String mes = entrada.split(" ")[0];
        mes = mes.replace("\"", "");
        int numMes = 0;
        if (mes.compareTo("Jan") == 0) {
            numMes = 1;
        } else if (mes.compareTo("Feb") == 0) {
            numMes = 2;
        } else if (mes.compareTo("Mar") == 0) {
            numMes = 3;
        } else if (mes.compareTo("Apr") == 0) {
            numMes = 4;
        } else if (mes.compareTo("May") == 0) {
            numMes = 5;
        } else if (mes.compareTo("Jun") == 0) {
            numMes = 6;
        } else if (mes.compareTo("Jul") == 0) {
            numMes = 7;
        } else if (mes.compareTo("Aug") == 0) {
            numMes = 8;
        } else if (mes.compareTo("Sep") == 0) {
            numMes = 9;
        } else if (mes.compareTo("Oct") == 0) {
            numMes = 10;
        } else if (mes.compareTo("Nov") == 0) {
            numMes = 11;
        } else if (mes.compareTo("Dec") == 0) {
            numMes = 12;
        }
        String ano = "";
        if (entrada.contains("  ")) {
            ano = entrada.split(" ")[3];
        } else {
            ano = entrada.split(" ")[1];
        }
        // System.out.println(ano);
        ano = ano.replace(",", "");
        ano = ano.replace("\"", "");
        int numAno = Integer.parseInt(ano);
        String data = dia + "/" + numMes + "/" + numAno;
        // System.out.println(data);
        Date saida = new Date(0);
        saida = form.parse(data);
        return saida;
    }

    public static void ler(String id) throws Exception, NumberFormatException {
        String website = "", auxDev = "";
        boolean windows, mac, linux;
        // int up, down;
        float upvotes, up, down;
        // leitura do arquivo
        FileReader arq = new FileReader("/tmp/games.csv");
        BufferedReader br = new BufferedReader(arq);
        // receber os atributos
        String linha = br.readLine();
        while (!(linha.split(",")[0].equals(id))) {
            linha = br.readLine();
        }

        // atributo app_id
        games.setApp_id(Integer.parseInt(linha.split(",")[0]));

        // atributo name
        games.setName(linha.split(",")[1]);

        // atributo release_date
        try {
            games.setRelease_date(tratarData(linha.split(",")[2] + " " + linha.split(",")[3]));
        } catch (NumberFormatException e) {
            games.setRelease_date(tratarData(
                    (linha.split("\",\"")[1]).split(",")[0] + " " + (linha.split("\",\"")[1]).split(",")[1]));
        }

        // atributo owners
        games.setOwners(linha.split(",")[4]);

        // atributo age
        games.setAge(Integer.parseInt(((linha.split("0 - ")[1])).split(",")[1]));

        // atributo price
        games.setPrice(Float.parseFloat((linha.split("0 - ")[1]).split(",")[2]));

        // atributo dlcs
        games.setDlcs(Integer.parseInt((linha.split("0 - ")[1]).split(",")[3]));

        // atributo languages
        String auxLanguages = linha.split("\\[")[1];
        auxLanguages = auxLanguages.split("\\]")[0];
        auxLanguages = auxLanguages.replace("'", "");

        // System.out.println(auxLanguages);
        String[] languages = new String[30];
        String[] languages1 = new String[1];
        if (auxLanguages.contains(",")) {
            languages = auxLanguages.split(",");
            games.setLanguages(languages);
        } else {
            languages1[0] = auxLanguages;
            games.setLanguages(languages1);
        }

        // atributo website
        website = (linha.split("\\]")[1]).split(",")[1];
        if (website.compareTo("") == 0) {
            website = "null";
        }
        games.setWebsite(website);

        // atributo windows
        windows = Boolean.parseBoolean((linha.split("\\]")[1]).split(",")[2]);
        games.setWindows(windows);

        // atributo mac
        mac = Boolean.parseBoolean((linha.split("\\]")[1]).split(",")[3]);
        games.setMac(mac);

        // atributo linux
        linux = Boolean.parseBoolean((linha.split("\\]")[1]).split(",")[4]);
        games.setLinux(linux);

        // atributo upvotes
        try {
            up = Float.parseFloat((linha.split("\\]")[1]).split(",")[5]);
            down = Float.parseFloat((linha.split("\\]")[1]).split(",")[6]);
        } catch (NumberFormatException e) {
            up = Float.parseFloat((linha.split("\\]")[1]).split(",")[6]);
            down = Float.parseFloat((linha.split("\\]")[1]).split(",")[7]);
        }
        upvotes = (up * 100) / (up + down);
        games.setUpvotes(Math.round(upvotes));

        // atributo avg_pt
        games.setAvg_pt(Integer.parseInt((linha.split("'\\]")[1]).split(",")[7]));

        // atributo developers
        auxDev = linha.split("\\]")[1];
        // System.out.println(auxDev);

        if (auxDev.contains("\",\"h")) {
            games.setDevelopers((auxDev.split("\",\"")[1]).split("\"")[1]);
        } else if (auxDev.contains("\",\"")) {
            games.setDevelopers((auxDev.split("\",\"")[0]).split("\"")[1]);
        } else {
            games.setDevelopers((linha.split("\\]")[1]).split(",")[8]);
        }

        // atributo genres
        String auxGenres = linha.split("\\]")[1];
        if (auxGenres.contains(",\"")) {
            auxGenres = auxGenres.split(",\"")[1];
            auxGenres = auxGenres.replace("\"", "");
        } else {
            try {
                auxGenres = (linha.split("\\]")[1]).split(",")[9];
            } catch (ArrayIndexOutOfBoundsException e) {
                auxGenres = "null";
            }

        }
        String[] genres = new String[30];
        String[] genres1 = new String[1];
        if (auxGenres.contains(",")) {
            genres = auxGenres.split(",");
            games.setGenres(genres);
        } else {
            genres1[0] = auxGenres;
            games.setGenres(genres1);
        }

        br.close();
    }

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
            games = new Games();
            ler(entrada[i]);
            // System.out.println(games.imprimir());
            lista.inserirFim(games);

        } // end for
        numEntrada = 0;
        aux = Integer.parseInt(br.readLine());

        while (numEntrada < aux) {
            entrada2[numEntrada] = br.readLine();
            numEntrada++;
        }

        for (int i = 0; i < numEntrada; i++) {
            // System.out.println(entrada2[i]);
            if (entrada2[i].contains("II") == true) {
                games = new Games();
                ler(entrada2[i].split(" ")[1]);
                // System.out.println(entrada2[i].split(" ")[1]);
                lista.inserirInicio(games);
            } else if (entrada2[i].contains("IF") == true) {
                games = new Games();
                ler(entrada2[i].split(" ")[1]);
                lista.inserirFim(games);
            } else if (entrada2[i].contains("I*") == true) {
                games = new Games();
                ler(entrada2[i].split(" ")[2]);
                pos = Integer.parseInt(entrada2[i].split(" ")[1]);
                lista.inserir(games, pos);
            } else if (entrada2[i].contains("RI") == true) {
                games = new Games();
                System.out.println("(R) " + lista.removerInicio().getName());
            } else if (entrada2[i].contains("RF") == true) {
                games = new Games();
                System.out.println("(R) " + lista.removerFim().getName());
            } else if (entrada2[i].contains("R*") == true) {
                games = new Games();
                pos = Integer.parseInt(entrada2[i].split(" ")[1]);
                System.out.println("(R) " + lista.remover(pos).getName());
            }
        } // end for
        lista.mostrar();
        br.close();
    }// end main

}
