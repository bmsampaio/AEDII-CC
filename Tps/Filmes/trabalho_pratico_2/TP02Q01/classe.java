import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * classe
 */

class Filme {
    public static SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
    // atributos
    private String nome;
    private String tituloOriginal;
    private Date dataDeLancamento;
    private int duracao;
    private String genero;
    private String idiomaOriginal;
    private String situacao;
    private float orcamento;
    private String[] palavrasChave;

    public Filme() {
        nome = "";
        tituloOriginal = "";
        dataDeLancamento = new Date(0);
        duracao = 0;
        genero = "";
        idiomaOriginal = "";
        situacao = "";
        orcamento = 0;
    }// end construtor

    // Gets & Sets
    public void setNome(String nome) {
        this.nome = nome;
    }// end setNome

    public String getNome() {
        return nome;
    }// end getNome

    public void setTituloOriginal(String tituloOriginal) {
        this.tituloOriginal = tituloOriginal;
    }// end setTituloOriginal

    public String getTituloOriginal() {
        return tituloOriginal;
    }// end getTituloOriginal

    public void setDataDeLancamento(Date dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }// end setDataDeLancamento

    public Date getDataDeLancamento() {
        return dataDeLancamento;
    }// end getDataDeLancamento

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }// end setDataDeLancamento

    public int getDuracao() {
        return duracao;
    }// end getDataDeLancamento

    public void setGenero(String genero) {
        this.genero = genero;
    }// end setGenero

    public String getGenero() {
        return genero;
    }// end getGenero

    public void setIdiomaOriginal(String idiomaOriginal) {
        this.idiomaOriginal = idiomaOriginal;
    }// end setidiomaOriginal

    public String getIdiomaOriginal() {
        return idiomaOriginal;
    }// end getidiomaOriginal

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }// end setSituacao

    public String getSituacao() {
        return situacao;
    }// end getSituacao

    public void setOrcamento(float orcamento) {
        this.orcamento = orcamento;
    }// end setOrcamento

    public float getOrcamento() {
        return orcamento;
    }// end getOrcamento

    public void setPalavrasChave(String[] palavrasChave) {
        this.palavrasChave = palavrasChave;

    }// end setPalavrasChave
    public String getPalavrasChave() {
        int i = 0;
        String aux = "";
        while(palavrasChave[i]!=null){
            aux = aux + palavrasChave[i];
            i++;
            if(palavrasChave[i]!=null){
            aux = aux + ',' + ' ';}
        }
        return aux;
    }// end getPalavrasChave

}// end Filme

public class classe {

    public static SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
    public static Filme filmes = new Filme();

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

    public static String removeTags(String entrada) {
        String saida = "";
        int i = 0;

        do {

            if (entrada.charAt(i) == '>') {
                i++;
                while (entrada.charAt(i) != '<') {

                    saida = saida + entrada.charAt(i);
                    i++;
                }
            } else {
                i++;
            }
        } while (i < (entrada.length() - 1));
        return saida;
    }

    public static int tratarDuracao(String entrada) {
        int resultado = 0;
        int hora = 0;
        int min = 0;
        entrada = entrada.replace("h", "");
        entrada = entrada.replace("m", "");
        hora = Integer.parseInt(entrada.split(" ")[0]);
        if (hora >= 4) {
            min = hora;
            resultado = min;
        } else {
            min = Integer.parseInt(entrada.split(" ")[1]);
            hora = hora * 60;
            resultado = hora + min;
        }
        return resultado;
    }

    public static float tratarOrcamento(String entrada) {
        float resultado = 0;
        if (entrada.contains("-")) {
            resultado = 0;
        } else {
            entrada = entrada.replace("$", "");
            entrada = entrada.replace(",", "");
            resultado = Float.parseFloat(entrada);
        }

        return resultado;
    }

    public static Date tratarData(String entrada) throws ParseException {
        Date saida = new Date(0);
        saida = form.parse(entrada);
        return saida;
    }

    public static void ler(String nomeArquivo) throws Exception {
        // leitura do arquivo
        String caminho = "/tmp/filmes/";
        FileReader arq = new FileReader(caminho + nomeArquivo);
        BufferedReader br = new BufferedReader(arq);
        // receber os atributos
        String linha = br.readLine();
        // atributo nome
        while (!linha.contains("h2 class")) {
            linha = br.readLine();
        }
        linha = br.readLine().trim();

        filmes.setNome(removeTags(linha));

        // atributo data lancamento
        linha = br.readLine();
        while (!linha.contains("class=\"release\"")) {
            linha = br.readLine();
        }
        linha = br.readLine().trim().split(" ")[0];
        filmes.setDataDeLancamento(tratarData(linha));

        // atributo genero
        linha = br.readLine();
        while (!(linha.contains("class=\"genres\""))) {
            linha = br.readLine();
        }
        linha = br.readLine();
        linha = br.readLine().trim();
        filmes.setGenero(removeTags(linha).replace("&nbsp;", ""));

        // atributo duracao
        while (!linha.contains("span class=\"runtime\"")) {
            linha = br.readLine();
        }
        linha = br.readLine();
        linha = br.readLine().trim();
        filmes.setDuracao(tratarDuracao(linha));

        // atributo titulo original

        while (!linha.contains("class=\"social_links\"")) {
            linha = br.readLine();
        }
        while (!linha.contains("strong")) {
            linha = br.readLine();
        }

        if (linha.contains("Título original")) {
            filmes.setTituloOriginal(removeTags(linha).replace("Título original", "").trim());
        } else {
            filmes.setTituloOriginal(filmes.getNome());
        }

        // atributo situacao
        while (!linha.contains("bdi>Situação")) {
            linha = br.readLine();
        }
        filmes.setSituacao(linha.replace("<strong><bdi>Situação</bdi></strong>", "").trim());

        // atributo idioma original
        while (!linha.contains("Idioma original")) {
            linha = br.readLine();
        }
        filmes.setIdiomaOriginal(removeTags(linha).replace("Idioma original", "").trim());

        // atributo Orçamento
        while (!linha.contains("Orçamento")) {
            linha = br.readLine();
        }
        filmes.setOrcamento(tratarOrcamento(removeTags(linha).replace("Orçamento", "").trim()));

        String palavrasTemp[] = new String[30];
        int contador = 0;
        // atributo palavras-chave
        while (!linha.contains("Palavras-chave")) {
            linha = br.readLine();
        } // end while
        linha = br.readLine();
        linha = br.readLine();
        if (linha.contains("Nenhuma palavra-chave foi adicionada.")) {
            palavrasTemp[0] = new String("");
        } else {
            linha = br.readLine();
            while (!linha.contains("</ul>")) {
                linha = br.readLine();
                if (linha.contains("li")) {
                    palavrasTemp[contador] = removeTags(linha.trim());
                    contador++;
                } // end if
            } // end while
        } // end else
        filmes.setPalavrasChave(palavrasTemp);
        br.close();
    }

    public static String imprimir() {
        return filmes.getNome() + " " + filmes.getTituloOriginal() + " " + form.format(filmes.getDataDeLancamento())
                + " " + filmes.getDuracao() + " " + filmes.getGenero() + " " + filmes.getIdiomaOriginal() + " "
                + filmes.getSituacao() + " " + filmes.getOrcamento() + " " + "[" + filmes.getPalavrasChave() + "]";
    }

    public static void main(String[] args) throws Exception {
       // MyIO.setCharset("UTF-8");
        String[] entrada = new String[1000];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numEntrada = 0;
        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = br.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM
        for (int i = 0; i < numEntrada; i++) {
            ler(entrada[i]);
            System.out.println(imprimir());
        } // end for
        br.close();
    }// end main
}// end classe principal