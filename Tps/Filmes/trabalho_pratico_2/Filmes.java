import java.io.BufferedReader;
import java.io.FileReader;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Filmes {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private String nome;
    private String titulooriginal;
    private Date datalancamento;
    private int duracao;
    private String genero;
    private String idioma;
    private String situacao;
    private float orcamento;
    private String palavrachave[];
    
    //Construtores

   public Filmes(){
        nome = "";
        titulooriginal = "";
        duracao = 0;
        genero = "";
        idioma = "";
        situacao = "";
        orcamento = 0;
        palavrachave = new String[1000];
    }

    public Filmes(String nome,String titulooriginal , Date datalancamento,int duracao,String genero,String idioma,String situacao,float orcamento, String palavrachave[]){
        this.nome = nome;
        this.titulooriginal = titulooriginal;
        this.datalancamento = datalancamento;
        this.duracao = duracao;
        this.genero = genero;
        this.idioma = idioma;
        this.situacao = situacao;
        this.orcamento = orcamento;
        this.palavrachave = palavrachave;
    }

    //metodos de GET //

    public String getNome() {
        return nome;
    }
    public String getTitulooriginal() {
        return titulooriginal;
    }
    public Date getDatalancamento() {
        return datalancamento;
    }
    public int getDuracao() {
        return duracao;
    }
    public String getGenero() {
        return genero;
    }
    public String getIdioma() {
        return idioma;
    }
    public String getSituacao() {
        return situacao;
    }
    public float getOrcamento() {
        return orcamento;
    }
    public String[] getPalavrachave() {
        return palavrachave;
    }

    //Metodos de SET //

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTitulooriginal(String titulooriginal) {
        this.titulooriginal = titulooriginal;
    }
    public void setDatalancamento(Date datalancamento) {
        this.datalancamento = datalancamento;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    public void setOrcamento(float orcamento) {
        this.orcamento = orcamento;
    }
    public void setPalavrachave(String[] palavrachave) {
        this.palavrachave = palavrachave;
    }

    //Metodo de Remover Tags e remover () //

    public String RemoveTag(String Entrada){
        String resultado = "";
        int i = 0;

        while(i<Entrada.length()){
            if(Entrada.charAt(i) == '<'){
                i++;
                while(Entrada.charAt(i) == '>') i++;
            }else{
                resultado += Entrada.charAt(i);
            }
            i++;
        }

        resultado.replaceAll("&#160;", "").replaceAll("&nbsp;", "");

        return resultado;
    }

    public String BuscaParenteses(String original){
        String limpa = "";
        
        for(int i=0; original.charAt(i)!='('; i++){
            limpa += original.charAt(i);
        }

        return limpa;
    }

    //Metodo de leitura//

    public void ler(String nomeArq) throws Exception{
        
        FileReader leitura = new FileReader("/tmp/filmes/"+nomeArq);
        BufferedReader br = new BufferedReader(leitura);
        
        String linha = br.readLine();
        //pula as linhas até achar o titulo//
        while(!linha.contains("<title>")){
            linha = br.readLine();
        }
        //pegar o titulo que realmente interessa//
        setNome(BuscaParenteses(RemoveTag(linha).trim()));
        
        //Busca o titulo original do filme//
        while(!linha.contains("Título original")){
            linha = br.readLine();
        }
        setTitulooriginal(RemoveTag(linha).trim());

        //tempo de duração do filme//
        while(!linha.contains("runtime")){
            linha = br.readLine();
        }
        linha = br.readLine();
        setDuracao(Integer.parseInt(RemoveTag(linha).trim()));

        //busca o genero do filme//
        while(!linha.contains("genres")){
            linha = br.readLine();
        }
        linha = br.readLine();
        linha = br.readLine();
        setGenero(RemoveTag(genero).trim());

        //busca o idioma do filme//
        while(!linha.contains("Idioma original")){
            linha = br.readLine();
        }
        setIdioma(RemoveTag(linha).trim());

        //pegar o A data de lançamento//
        while(!linha.contains("span class =\"release\"")){
            linha = br.readLine();
        }
        linha = br.readLine();  
        setDatalancamento(sdf.parse(BuscaParenteses(linha).trim()));

        //Situaçao do filme//

        while(!linha.contains("Situação")){
            linha = br.readLine();
        }
        setSituacao(RemoveTag(linha).trim());

        //Pegar o orcamento do filme//

        while(!linha.contains("Orçamento")){
            linha = br.readLine();
        }
        setOrcamento(Float.parseFloat(RemoveTag(linha).trim()));

        //pegar palavra chave//
        while(!linha.contains("Palavras-chave")){
            linha=br.readLine();
        }
        String palavrasTemp[]= new String[30];
        int contador=0;
        while(!linha.contains("</url>")){
            linha=br.readLine();
            if(linha.contains("li")){
                //setar a palavra chave nesta linha em array temp
                palavrasTemp[contador++] = RemoveTag(linha).trim();
            }
        }
        contador=contador>0?contador-1:0;
        palavrachave = new String[contador];

        br.close();
    }

    //Metodo de Clone//

    public Filmes clone(){
        Filmes clone = new Filmes();
        clone.setNome(nome);
        clone.setTitulooriginal(titulooriginal);
        clone.setDatalancamento(datalancamento);
        clone.setDuracao(duracao);
        clone.setGenero(genero);
        clone.setIdioma(idioma);
        clone.setSituacao(situacao);
        clone.setOrcamento(orcamento);
        clone.setPalavrachave(palavrachave);
        return clone;
    }

    //Metodo de Impressao//

    public String imprimir(){
        return (getNome()+" "+getTitulooriginal()+" "+sdf.format(getDatalancamento())+" "+getDuracao()+" "+getGenero()+" "+getIdioma()+" "+getSituacao()+" "+getOrcamento()+" "+getPalavrachave());
    }

    public static boolean isFim(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    //Metodo do main//

    public static void main(String[] args) throws Exception {
        MyIO.setCharset("UTF-8");
        String[] entrada = new String[1000];
        int numEntrada = 0;
        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = MyIO.readLine();
            System.out.println(entrada[numEntrada]);
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM
        //nosso array , conforme a entrada
        Filmes filmes = new Filmes();

        for(int i=0; i<numEntrada; i++){
            filmes.ler(entrada[i]);
            System.out.println(filmes.imprimir());
            //System.out.println();
            // imprime nossos filmes
        }

        
    }

}