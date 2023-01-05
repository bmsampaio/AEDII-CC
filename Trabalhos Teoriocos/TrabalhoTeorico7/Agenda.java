import java.sql.NClob;

/**
 * Você foi contratado para desenvolver uma agenda de contatos (atributos nome,
 * telefone, e-mail e CPF) para um escritório de advocacia. Um colega sugeriu
 * implementar uma árvore de binária de listas em que a pesquisa na árvore
 * acontece pela primeira letra do nome e, quando encontramos a letra, temos uma
 * pesquisa em uma lista de contatos. A figura abaixo ilustra sua estrutura de
 * dados.
 */

// 1) Crie uma classe Contato contendo os atributos String nome, telefone e
// email e int cpf;

class Contato {
    // atributos
    private String nome, telefone, email;
    private int cpf;

    public Contato() {
        nome = "";
        telefone = "";
        email = "";
        cpf = 0;
    }// end constructor

    // Gets & Sets
    public void setNome(String nome) {
        this.nome = nome;
    }// end setNome

    public String getNome() {
        return nome;
    }// end getNome

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }// end setTelefone

    public String getTelefone() {
        return telefone;
    }// end getTelefone

    public void setEmail(String email) {
        this.email = email;
    }// end setEmail

    public String getEmail() {
        return email;
    }// end getEmail

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }// end setCpf

    public int getCpf() {
        return cpf;
    }// end getCpf

}// end contado

// 2) Crie uma classe Celula contendo os atributos Contato contato e Celula
// prox;

class Celula {
    Contato contato;
    Celula prox;

    public Celula() {
        this(null, null);
    }

    public Celula(Contato contato) {
        this(contato, null);
    }

    public Celula(Contato contato, Celula prox) {
        this.contato = contato;
        this.prox = prox;
    }
}// end Celula

// 3) Crie uma classe No contendo os atributos char letra, No esq e dir; e
// Celula primeiro e ultimo;

class No {
    public char letra;
    public No esq, dir;
    public Celula primeiro, ultimo;

    public No(char letra) {
        this.letra = letra;
        this.esq = this.dir = null;
        primeiro = ultimo = new Celula();
    }
}// end No

/**
 * 4) Crie uma classe Agenda contendo:
 * 4.1) Atributo No raiz;
 * 4.2) Um método construtor que cria 26 nós na árvore de letras inserindo os
 * valores M, F, T, C, I, P, W, A, B, D, E, G, H, J, K, L, N, O, Q, R, S, U, V,
 * X, Y e Z, respectivamente. Nesse caso, é recomendado a existência de um
 * método inserirÁrvore(char letra) igual ao método inserir da árvore binária;
 * 4.3) Método boolean inserir(Contato contato);
 * 4.4) Método boolean remover(String nome);
 * 4.5) Método boolean pesquisar(String nome);
 * 4.6) Método boolean pesquisar(int cpf).
 */
public class Agenda {
    private No raiz;

    public Agenda() throws Exception {
        raiz = new No('M');
        inserir('F', raiz);
        inserir('T', raiz);
        inserir('C', raiz);
        inserir('I', raiz);
        inserir('P', raiz);
        inserir('W', raiz);
        inserir('A', raiz);
        inserir('B', raiz);
        inserir('D', raiz);
        inserir('E', raiz);
        inserir('G', raiz);
        inserir('H', raiz);
        inserir('J', raiz);
        inserir('K', raiz);
        inserir('L', raiz);
        inserir('N', raiz);
        inserir('O', raiz);
        inserir('Q', raiz);
        inserir('R', raiz);
        inserir('S', raiz);
        inserir('U', raiz);
        inserir('V', raiz);
        inserir('X', raiz);
        inserir('Y', raiz);
        inserir('Z', raiz);

    }// end insercao

    /**
     * Metodo privado recursivo para inserir letra.
     * 
     * @param x Elemento a ser inserido.
     * @param i No em analise.
     * @return No em analise, alterado ou nao.
     * @throws Exception Se o elemento existir.
     */

    private No inserir(char letra, No i) throws Exception {
        if (i == null) {
            i = new No(letra);

        } else if (letra < i.letra) {
            i.esq = inserir(letra, i.esq);

        } else if (letra > i.letra) {
            i.dir = inserir(letra, i.dir);

        } else {
            throw new Exception("Erro ao inserir!");
        }

        return i;
    }

    public boolean pesquisarNome(String nome) {
        return pesquisarNome(raiz, nome);
    }

    private boolean pesquisarNome(No no, String nome) {
        boolean resp;
        if (no == null) {
            resp = false;
        } else if (Char.toUpper(nome.charAt(0)) == no.letra) {
            resp = false;
            for (Celula i = no.primeiro.prox; (!resp && i != null); i = i.prox) {
                if (i.contato.nome.equals(nome) == true) {
                    resp = true;
                }
            }
        } else if (Char.toUpper(nome.charAt(0)) < no.letra) {
            resp = pesquisarNome(no.esq, nome);

        } else {
            resp = pesquisarNome(no.dir, nome);
        }
        return resp;
    }

    public void inserir(Contato contato) throws Exception {
        if (Character.isLetter(contato.nome.charAt(0))) {
            raiz = inserir(raiz, contato);
        } else {
            throw new Exception("Erro ao inserir!");
        }
    }

    private No inserir(No no, Contato contato) throws Exception {
        // insere o nó com a letra
        if (no == null) {
            no = new no(Character.toUpperCase(contato.nome.charAt(0)));
            no.ultimo.prox = new Celula(contato);
            no.ultimo = no.ultimo.prox;

            // insere o contatinho
        } else if (Character.toUpperCase(contato.nome.charAt(0)) == no.letra) {
            no.ultimo.prox = new Celula(contato);
            no.ultimo = no.ultimo.prox;

            // letra menor, caminha para a esquerda
        } else if (Character.toUpperCase(contato.nome.charAt(0)) < no.letra) {
            no.esq = inserir(no.esq, contato);

            // letra maior, caminha para a direita
        } else {
            no.dir = inserir(no.dir, contato);
        }
        return no;
    }

    public boolean pesquisar(int cpf) {
        return pesquisar(raiz, cpf);
    }

    private boolean pesquisar(No no, int cpf) {
        boolean resp = false;
        if (no != null) {
            resp = pesquisar(no.primeiro.prox, cpf);
            if (resp == false) {
                resp = pesquisar(no.esq, cpf);
                if (resp == false) {
                    resp = pesquisar(no.dir, cpf);
                }
            }
        }
        return resp;
    }

    private boolean pesquisar(Celula i, int cpf) {
        // efeuar a pesquisa na lista a partir do i
    }

}
