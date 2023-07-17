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

/*
public class buscaInternet {
    public static void main(String[] args) throws Exception {
        String[] entrada = new String[100];
        String linha = "";
        int numEntrada = 0, link1 = 0, link2 = 0, link3 = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        linha = br.readLine();
        while (linha != null) {
            entrada[numEntrada] = linha;
            numEntrada++;
            linha = br.readLine();
        }
        for (int i = 0; i < numEntrada; i++) {
            link3 = Integer.parseInt(entrada[i]);
            link2 = 2 * link3;
            link1 = 2 * link2;
            System.out.println(link1);

        }
    }

}
------------------------------------------------------------------------------------------------------------
class Aluno {
    private String nome;
    private String assinaturaOriginal;

    public Aluno() {
        nome = "";
        assinaturaOriginal = "";
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setAssinaturaOriginal(String assinaturaOriginal) {
        this.assinaturaOriginal = assinaturaOriginal;
    }

    public String getAssinaturaOriginal() {
        return assinaturaOriginal;
    }
}
public class Girafales {
    static boolean ehFalso(String assinatura1, String assinatura2) {
        boolean resp = true;
        int count = 0;
        for (int i = 0; i < assinatura1.length(); i++) {
            if (assinatura1.charAt(i) != assinatura2.charAt(i)) {
                count++;
            }
        }
        if (count > 1) {
            resp = false;
        }
        return resp;
    }

    public static void main(String[] args) throws Exception {
        Aluno[] alunos = new Aluno[50];
        int numEntrada = 0, aux = 0, aux1 = 0, count = 0, resp = 0;
        String[] entrada = new String[100];
        String linha = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        numEntrada = Integer.parseInt(br.readLine());
        do {

            linha = br.readLine();
            alunos[count] = new Aluno();
            alunos[count].setNome(linha.split(" ")[0]);
            alunos[count].setAssinaturaOriginal(linha.split(" ")[1]);
            count++;
            aux++;
        } while (aux < numEntrada);
        linha = br.readLine();
        numEntrada = Integer.parseInt(linha);
        do {
            linha = br.readLine();
            entrada[aux1] = linha;
            aux1++;
        } while (aux1 < numEntrada);

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < aux1; j++) {
                if (((entrada[j].split(" ")[0]).compareTo(alunos[i].getNome())) == 0) {
                    if (ehFalso((entrada[j].split(" ")[1]), (alunos[i].getAssinaturaOriginal())) == false) {
                        resp++;
                    }
                }
            }
        } 
        System.out.println(resp);
        linha = br.readLine();
        numEntrada = Integer.parseInt(linha);
        aux = 0;
        count = 0;
        aux1 = 0;
        do {
            linha = br.readLine();
            alunos[count] = new Aluno();
            alunos[count].setNome(linha.split(" ")[0]);
            alunos[count].setAssinaturaOriginal(linha.split(" ")[1]);
            count++;
            aux++;
        } while (aux < numEntrada);
        linha = br.readLine();
        numEntrada = Integer.parseInt(linha);
        aux = 0;
        do {
            linha = br.readLine();
            entrada[aux1] = linha;
            aux1++;
            aux++;
        } while (aux < numEntrada);
        resp = 0;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < aux1; j++) {
                if (((entrada[j].split(" ")[0]).compareTo(alunos[i].getNome())) == 0) {
                    if (ehFalso((entrada[j].split(" ")[1]), (alunos[i].getAssinaturaOriginal())) == false) {
                        resp++;
                    }
                }
            }
        }
        System.out.println(resp);
    }
}
----------------------------------------------------------------------------------------------------------
/* 
// class Lista {
//     private String[] array;
//     private int n;

//     /**
//      * Construtor da classe.
//      */
//     public Lista() {
//         this(20);
//     }

//     /**
//      * Construtor da classe.
//      * 
//      * @param tamanho Tamanho da lista.
//      */
//     public Lista(int tamanho) {
//         array = new String[tamanho];
//         n = 0;
//     }

//     /**
//      * Insere um elemento na primeira posicao da lista e move os demais
//      * elementos para o fim da lista.
//      * 
//      * @param x int elemento a ser inserido.
//      * @throws Exception Se a lista estiver cheia.
//      */
//     public void inserirInicio(String x) throws Exception {

//         // validar insercao
//         if (n >= array.length) {
//             throw new Exception("Erro ao inserir!");
//         }

//         // levar elementos para o fim do array
//         for (int i = n; i > 0; i--) {
//             array[i] = array[i - 1];
//         }

//         array[0] = x;
//         n++;
//     }

//     /**
//      * Insere um elemento na ultima posicao da lista.
//      * 
//      * @param x int elemento a ser inserido.
//      * @throws Exception Se a lista estiver cheia.
//      */
//     public void inserirFim(String x) throws Exception {

//         // validar insercao
//         if (n >= array.length) {
//             throw new Exception("Erro ao inserir!");
//         }

//         array[n] = x;
//         n++;
//     }

//     /**
//      * Insere um elemento em uma posicao especifica e move os demais
//      * elementos para o fim da lista.
//      * 
//      * @param x   int elemento a ser inserido.
//      * @param pos Posicao de insercao.
//      * @throws Exception Se a lista estiver cheia ou a posicao invalida.
//      */
//     public void inserir(String x, int pos) throws Exception {

//         // validar insercao
//         if (n >= array.length || pos < 0 || pos > n) {
//             throw new Exception("Erro ao inserir!");
//         }

//         // levar elementos para o fim do array
//         for (int i = n; i > pos; i--) {
//             array[i] = array[i - 1];
//         }

//         array[pos] = x;
//         n++;
//     }

//     /**
//      * Remove um elemento da primeira posicao da lista e movimenta
//      * os demais elementos para o inicio da mesma.
//      * 
//      * @return resp int elemento a ser removido.
//      * @throws Exception Se a lista estiver vazia.
//      */
//     public String removerInicio() throws Exception {

//         // validar remocao
//         if (n == 0) {
//             throw new Exception("Erro ao remover!");
//         }

//         String resp = array[0];
//         n--;

//         for (int i = 0; i < n; i++) {
//             array[i] = array[i + 1];
//         }

//         return resp;
//     }

//     /**
//      * Remove um elemento da ultima posicao da lista.
//      * 
//      * @return resp int elemento a ser removido.
//      * @throws Exception Se a lista estiver vazia.
//      */
//     public String removerFim() throws Exception {

//         // validar remocao
//         if (n == 0) {
//             throw new Exception("Erro ao remover!");
//         }

//         return array[--n];
//     }

//     /**
//      * Remove um elemento de uma posicao especifica da lista e
//      * movimenta os demais elementos para o inicio da mesma.
//      * 
//      * @param pos Posicao de remocao.
//      * @return resp int elemento a ser removido.
//      * @throws Exception Se a lista estiver vazia ou a posicao for invalida.
//      */
//     public String remover(int pos) throws Exception {

//         // validar remocao
//         if (n == 0 || pos < 0 || pos >= n) {
//             throw new Exception("Erro ao remover!");
//         }

//         String resp = array[pos];
//         n--;

//         for (int i = pos; i < n; i++) {
//             array[i] = array[i + 1];
//         }

//         return resp;
//     }

//     /**
//      * Mostra os elementos da lista separados por espacos.
//      */
//     public void mostrar() {
//         System.out.print("[ ");
//         for (int i = 0; i < n; i++) {
//             System.out.print(array[i] + " ");
//         }
//         System.out.println("]");
//     }

//     public void limpar() {
//         String[] array2 = new String[100];
//         int count = 0;
//         for (int i = 0; i < n-1; i++) {
//             for (int j = 1; j < n; j++) {
//                 if (array[i].compareTo(array[j]) != 0) {
//                     array2[count] = array[i];
//                     count++;
//                 }

//             }
//         }
//         for (int index = 0; index < count; index++) {
//             System.out.println(array2[index]);
//         }
//     }

//     /**
//      * Procura um elemento e retorna se ele existe.
//      * 
//      * @param x int elemento a ser pesquisado.
//      * @return <code>true</code> se o array existir,
//      *         <code>false</code> em caso contrario.
//      */
//     public boolean pesquisar(String x) {
//         boolean retorno = false;
//         for (int i = 0; i < n && retorno == false; i++) {
//             retorno = (array[i] == x);
//         }
//         return retorno;
//     }
// }

// public class listaCompras {

//     public static void main(String[] args) throws Exception {
//         Lista list1 = new Lista();
//         String[] entrada = new String[100];
//         String linha = "";
//         int numEntrada = 0, aux = 0;
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         linha = br.readLine();
//         numEntrada = Integer.parseInt(linha);
//         do {
//             linha = br.readLine();
//             for (int j = 0; j < 30; j++) {
//                 try {
//                     list1.inserirFim(linha.split(" ")[j]);
//                 } catch (Exception e) {
//                     j = 30;
//                 }
//             }
//             list1.mostrar();
//             list1.limpar();
//             aux++;
//         } while (aux < numEntrada);
        
        
        
//         //list1.mostrar();
//         br.close();
//     }

// }
/* -----------------------------------------------------------------------------------------------------------

public class Biblioteca {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[100];
        String[] array2 = new String[100];
        String linha = "";
        int numEntrada = 0, aux = 0;
        numEntrada = Integer.parseInt(br.readLine());
        do{
            linha = br.readLine();
            array[aux] = linha; 
            aux++;
            
        }while (numEntrada > aux);
        /**
        // Algoritmo de ordenacao por selecao.
         

         for (int i = 0; i < (aux - 1); i++) {
            int menor = i;
            for (int j = (i + 1); j < aux; j++) {
                if ((array[menor].compareTo(array[j])) > 0) {
                    menor = j;
                }
            }
            String temp = array[menor];
            array[menor] = array[i];
            array[i] = temp;
        }

        for (int i = 0; i < aux; i++) {
            System.out.println(array[i]);
        }

        aux = 0;
        numEntrada = Integer.parseInt(br.readLine());
        do{
            linha = br.readLine();
            array2[aux] = linha;
            aux++;
        }while(numEntrada > aux);
        /**
         //Algoritmo de ordenacao por selecao.
         

        for (int i = 0; i < (aux - 1); i++) {
            int menor = i;
            for (int j = (i + 1); j < aux; j++) {
                if ((array2[menor].compareTo(array2[j])) > 0) {
                    menor = j;
                }
            }
            String temp = array2[menor];
            array2[menor] = array2[i];
            array2[i] = temp;
        }

        for (int i = 0; i < aux; i++) {
            System.out.println(array2[i]);
        }

        br.close();

    }

}


----------------------------------------------------------------------------------------------------------

 */

class Fila {

    private Personagens[] array;
    private int primeiro; // Remove do indice "primeiro".
    private int ultimo; // Insere no indice "ultimo".

    /**
     * Construtor da classe.
     */

    public Fila() {
        this(30);
    }

    /**
     * Construtor da classe.
     * 
     * @param tamanho Tamanho da fila.
     */
    public Fila(int tamanho) {
        array = new Personagens[tamanho + 1];
        primeiro = ultimo = 0;
    }

    /**
     * Insere um elemento na ultima posicao da fila.
     * 
     * @param x int elemento a ser inserido.
     * @throws Exception Se a fila estiver cheia.
     */
    public void inserir(Personagens x) throws Exception {

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
            Personagens personagens = array[i];
            System.out.print(array[i].getNome() + " ");
        }
        System.out.println("]");
    }

    public boolean Find(String str) {
        boolean resposta = false;
        // System.out.println(array.length);
        for (int j = 0; j < (array.length - 1); j++) {
            if ((array[j].getNome()).equals(str) == true) {
                resposta = true;
            } // end if
        } // end for
        return resposta;
    }// end Find
}

public class pesquisaSequencial {

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
        String[] entrada = new String[1000];
        String[] entrada2 = new String[1000];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numEntrada = 0;
        // Leitura da entrada padrao
        do {
            entrada[numEntrada] = br.readLine();
        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM
        Fila fila = new Fila(numEntrada);
        for (int i = 0; i < numEntrada; i++) {
            personagens = new Personagens();
            personagens.ler(entrada[i]);
            fila.inserir(personagens);
        } // end for
        numEntrada = 0;
        do {
            entrada2[numEntrada] = br.readLine();
        } while (isFim(entrada2[numEntrada++]) == false);
        numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

        for (int i = 0; i < numEntrada; i++) {
            // System.out.println(entrada2[i]);
            if (fila.Find(entrada2[i]) == true) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
        } // end for

        br.close();
    }// end main

}
