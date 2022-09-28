import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Arrays;

/**
 * classe
 */

class Games {
    public static SimpleDateFormat form = new SimpleDateFormat("MM/yyyy");

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

}// end Games

class Fila {

    private String[] array;
    private int primeiro; // Remove do indice "primeiro".
    private int ultimo; // Insere no indice "ultimo".
    private int tamanho;

    /**
     * Construtor da classe.
     */

    public Fila() {
        this(50);
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }// end setTamanho

    /**
     * Construtor da classe.
     * 
     * @param tamanho Tamanho da fila.
     */
    public Fila(int tamanho) {
        array = new String[tamanho + 1];
        primeiro = ultimo = 0;
    }

    /**
     * Insere um elemento na ultima posicao da fila.
     * 
     * @param x int elemento a ser inserido.
     * @throws Exception Se a fila estiver cheia.
     */
    public void inserir(String x) throws Exception {

        // validar insercao
        if (((ultimo + 1) % array.length) == primeiro) {
            throw new Exception("Erro ao inserir!");
        }

        array[ultimo] = x;
        ultimo = (ultimo + 1) % array.length;
    }

    public void mostrar() {
        System.out.print("[ ");

        for (int i = primeiro; i != ultimo; i = ((i + 1) % array.length)) {
            System.out.print(array[i] + " ");
        }

        System.out.println("]");
    }

    /**
     * Algoritmo de ordenacao por insercao.
     */
    public void ordenar() {

        for (int i = 1; i < tamanho; i++) {
            String tmp = array[i];
            int j = i - 1;
            while ((j >= 0) && (array[j].compareTo(tmp) > 0)) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = tmp;
        }

    }
    /**
	 * Funcao para fazer uma pesquisa binaria
     * Retorna true - se encontrou a string desejada
     *         false - se nao encontrou a string desejada.
	 */
    public boolean pesquisaBinaria(String str) throws ClassCastException {
        ordenar();
        for (int index = 0; index < (tamanho); index++) {
            // System.out.println(array[index]);
        }
        boolean resposta = false;

        int dir = (tamanho - 1), esq = 0, meio;

        while (esq <= dir) {
            meio = (esq + dir) / 2;

            if (str.compareTo(array[meio]) == 0) {
                esq = dir + 1;
                resposta = true;
            } else if (str.compareTo(array[meio]) > 0) {
                esq = meio + 1;
            } else {

                dir = meio - 1;
            }
        }
        return resposta;
    }// end PesquisaBinaria
}

public class PesquisaBin {

    public static SimpleDateFormat form = new SimpleDateFormat("MM/yyyy");
    public static DateFormat dateFormat = new SimpleDateFormat("MMM/yyyy", new Locale("en", "US"));
    static DecimalFormat formatter = new DecimalFormat("#");
    // formatter.setRoundingMode(RoundingMode.UP);
    public static Fila id = new Fila();
    public static Games games = new Games();

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

    public static String tratarDuracao(int entrada) {
        String resultado = "";
        int hora = 0;
        int min = 0;
        if (entrada == 0) {
            resultado = "null";
        } else {
            hora = ((entrada)) / 60;
            min = ((entrada)) % 60;
            resultado = hora + "h " + min + "m";
        }

        return resultado;
    }

    public static Date tratarData(String entrada) throws Exception {
        // System.out.println(entrada);
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
        String data = numMes + "/" + numAno;
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
        while (!linha.contains(id)) {
            linha = br.readLine();
        }

        // atributo app_id
        games.setApp_id(Integer.parseInt(linha.split(",")[0]));

        // atributo name
        games.setName(linha.split(",")[1]);

        // atributo release_date
        games.setRelease_date(tratarData(linha.split(",")[2] + " " + linha.split(",")[3]));

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
        up = Float.parseFloat((linha.split("\\]")[1]).split(",")[5]);
        down = Float.parseFloat((linha.split("\\]")[1]).split(",")[6]);
        upvotes = (up * 100) / (up + down);
        games.setUpvotes(Math.round(upvotes));

        // atributo avg_pt
        games.setAvg_pt(Integer.parseInt((linha.split("\\]")[1]).split(",")[7]));

        // atributo developers
        auxDev = linha.split("\\]")[1];
        // System.out.println(auxDev);

        if (auxDev.contains("\",\"")) {

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

    public static String imprimir() {
        // formatter.setRoundingMode(RoundingMode.UP);
        return games.getApp_id() + " " + games.getName() +
                " " + dateFormat.format(games.getRelease_date()) + " "
                + games.getOwners() + " "
                + games.getAge() + " " + games.getPrice() + " " + games.getDlcs() + " [" + games.getLanguages() + "] "
                + games.getWebsite() +
                " " + games.getWindows() + " " + games.getMac() + " " + games.getLinux() + " "
                + formatter.format(games.getUpvotes())
                + "% " + tratarDuracao(games.getAvg_pt()) + " " + games.getDevelopers() + " [" + games.getGenres()
                + "]";
    }

    public static void main(String[] args) throws Exception {
        // MyIO.setCharset("UTF-8");
        String[] entrada = new String[1000];
        String[] entrada2 = new String[1000];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numEntrada = 0;
        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = br.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM
        id.setTamanho(50);

        for (int i = 0; i < numEntrada; i++) {
            ler(entrada[i]);
            // System.out.println(games.getName());
            id.inserir(games.getName());
        } // end for
        numEntrada = 0;
        do {
            entrada2[numEntrada] = br.readLine();
        } while (isFim(entrada2[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

        for (int i = 0; i < numEntrada; i++) {
            // System.out.println(entrada[i]);
            if (id.pesquisaBinaria(entrada2[i]) == true) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
        } // end for
        br.close();
    }// end main

}
