#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <err.h>
//------------------------------------FUNCOES PERSONAGEM---------------------------------------------------
typedef struct
{
    char *nome;
    int altura;
    double peso;
    char *corDeCabelo;
    char *corDaPele;
    char *corDosOlhos;
    char *anoNascimento;
    char *genero;
    char *homeworld;

} Personagem; // end personagens

// variaveis globais
Personagem personagens[100];
int COUNT = 0;

/**
 * substring - funcao que recebe uma string e duas palavras
 * e retorna um pedaco da string delimitada pelas duas palavras.
 *
 * @param str - string a ser separada.
 * @param inicio - palavra de inicio .
 * @param fim - palavra de fim .
 * @return substring.
 */
char *substring(char *str, char *inicio, char *fim)
{
    // printf("-----%s----------%s--------%s-----\n\n\n", str, inicio, fim);
    // Posicao da palavra início e fim na string
    char *posInicio = strstr(str, inicio);
    char *posFim = strstr(str, fim);

    // Indice de inicio e fim da substring
    int indexInicio = posInicio - str;
    int indexFim = posFim - str;

    int tamanho = indexFim - indexInicio - strlen(inicio);
    char *respSubstring = malloc(sizeof(char) * (tamanho + 1));
    // free(respSubstring);

    for (int i = 0; i < tamanho; i++)
    {
        respSubstring[i] = str[indexInicio + strlen(inicio) + i];
    }

    respSubstring[tamanho] = '\0';
    return respSubstring;
}
/**
 * ler - metodo para ler e tratar o arquivo aberto pelo caminho
 * e retirar os espacos vazios.
 *
 * @param caminho - string contendo o caminho do arquivo.
 *
 */
void ler(char caminho[])
{
    // variaveis
    char *p, *aux;
    int k = 0;
    p = (char *)malloc(1000 * sizeof(char));
    aux = (char *)malloc(1000 * sizeof(char));
    // leitura do arquivo
    caminho[strcspn(caminho, "\n")] = 0;
    FILE *arq = fopen((caminho), "r");

    if (!arq)
        printf("Erro, nao foi possivel abrir o arquivo\n");
    else
    {
        fgets(p, 500, arq);
        for (int i = 0; i < 500; i++)
        {
            if (p[i] != '{' && p[i] != '}' && p[i] != 39 && p[i] != ':')
            {
                aux[k] = p[i];
                k++;
            }
        }
        // printf("%s\n",aux);
        personagens[COUNT].nome = substring(aux, "name ", ", height");
        personagens[COUNT].altura = atoi(substring(aux, "height", ", mass"));
        personagens[COUNT].peso = atof(substring(aux, "mass", ", hair_color"));
        personagens[COUNT].corDeCabelo = substring(aux, "hair_color ", ", skin_color");
        personagens[COUNT].corDaPele = substring(aux, "skin_color", ", eye_color");
        personagens[COUNT].corDosOlhos = substring(aux, "eye_color", ", birth_year");
        personagens[COUNT].anoNascimento = substring(aux, "birth_year", ", gender");
        personagens[COUNT].genero = substring(aux, "gender", ", homeworld");
        personagens[COUNT].homeworld = substring(aux, "homeworld", ", film");
        COUNT++;
    }
    free(p);
    free(aux);
    aux = NULL;
    p = NULL;
}

void imprimir()
{
    for (int i = 0; i < COUNT; i++)
    {
        if (personagens[i].peso == (int)personagens[i].peso)
        {
            printf(" ## %s ## %d ## %.f ## %s ##%s ##%s ##%s ##%s ##%s ## \n", personagens[i].nome, personagens[i].altura, personagens[i].peso, personagens[i].corDeCabelo, personagens[i].corDaPele, personagens[i].corDosOlhos, personagens[i].anoNascimento, personagens[i].genero, personagens[i].homeworld);
        }
        else
        {
            printf(" ## %s ## %d ## %.1f ## %s ##%s ##%s ##%s ##%s ##%s ## \n", personagens[i].nome, personagens[i].altura, personagens[i].peso, personagens[i].corDeCabelo, personagens[i].corDaPele, personagens[i].corDosOlhos, personagens[i].anoNascimento, personagens[i].genero, personagens[i].homeworld);
        }
    }
}
//------------------------------------FUNCOES LISTA DUPLA---------------------------------------------------
// TIPO CELULA ===================================================================
typedef struct CelulaDupla
{
    Personagem elemento;      // Elemento inserido na celula.
    struct CelulaDupla *prox; // Aponta a celula prox.
    struct CelulaDupla *ant;  // Aponta a celula anterior.
} CelulaDupla;

CelulaDupla *novaCelulaDupla(Personagem elemento)
{
    CelulaDupla *nova = (CelulaDupla *)malloc(sizeof(CelulaDupla));
    nova->elemento = elemento;
    nova->ant = nova->prox = NULL;
    return nova;
}

// LISTA PROPRIAMENTE DITA =======================================================

CelulaDupla *primeiro;
CelulaDupla *ultimo;

/**
 * Cria uma lista dupla sem elementos (somente no cabeca).
 */
void start()
{
    primeiro = novaCelulaDupla(personagens[0]);
    ultimo = primeiro;
}

/**
 * Insere um elemento na primeira posicao da lista.
 * @param x int elemento a ser inserido.
 */
void inserirInicio(Personagem x)
{
    CelulaDupla *tmp = novaCelulaDupla(x);

    tmp->ant = primeiro;
    tmp->prox = primeiro->prox;
    primeiro->prox = tmp;
    if (primeiro == ultimo)
    {
        ultimo = tmp;
    }
    else
    {
        tmp->prox->ant = tmp;
    }
    tmp = NULL;
}

/**
 * Insere um elemento na ultima posicao da lista.
 * @param x int elemento a ser inserido.
 */
void inserirFim(Personagem x)
{
    ultimo->prox = novaCelulaDupla(x);
    ultimo->prox->ant = ultimo;
    ultimo = ultimo->prox;
}

/**
 * Remove um elemento da primeira posicao da lista.
 * @return resp int elemento a ser removido.
 */
Personagem removerInicio()
{
    if (primeiro == ultimo)
    {
        errx(1, "Erro ao remover (vazia)!");
    }

    CelulaDupla *tmp = primeiro;
    primeiro = primeiro->prox;
    Personagem resp = primeiro->elemento;
    tmp->prox = primeiro->ant = NULL;
    free(tmp);
    tmp = NULL;
    return resp;
}

/**
 * Remove um elemento da ultima posicao da lista.
 * @return resp int elemento a ser removido.
 */
Personagem removerFim()
{
    if (primeiro == ultimo)
    {
        errx(1, "Erro ao remover (vazia)!");
    }
    Personagem resp = ultimo->elemento;
    ultimo = ultimo->ant;
    ultimo->prox->ant = NULL;
    free(ultimo->prox);
    ultimo->prox = NULL;
    return resp;
}

/**
 *  Calcula e retorna o tamanho, em numero de elementos, da lista.
 *  @return resp int tamanho
 */
int tamanho()
{
    int tamanho = 0;
    CelulaDupla *i;
    for (i = primeiro; i != ultimo; i = i->prox, tamanho++)
        ;
    return tamanho;
}

/**
 * Insere um elemento em uma posicao especifica considerando que o
 * primeiro elemento valido esta na posicao 0.
 * @param x int elemento a ser inserido.
 * @param pos int posicao da insercao.
 * @throws Exception Se <code>posicao</code> invalida.
 */
void inserir(Personagem x, int pos)
{

    int tam = tamanho();

    if (pos < 0 || pos > tam)
    {
        errx(1, "Erro ao remover (posicao %d/%d invalida!", pos, tam);
    }
    else if (pos == 0)
    {
        inserirInicio(x);
    }
    else if (pos == tam)
    {
        inserirFim(x);
    }
    else
    {
        // Caminhar ate a posicao anterior a insercao
        CelulaDupla *i = primeiro;
        int j;
        for (j = 0; j < pos; j++, i = i->prox)
            ;

        CelulaDupla *tmp = novaCelulaDupla(x);
        tmp->ant = i;
        tmp->prox = i->prox;
        tmp->ant->prox = tmp->prox->ant = tmp;
        tmp = i = NULL;
    }
}

/**
 * Remove um elemento de uma posicao especifica da lista
 * considerando que o primeiro elemento valido esta na posicao 0.
 * @param posicao Meio da remocao.
 * @return resp int elemento a ser removido.
 * @throws Exception Se <code>posicao</code> invalida.
 */
Personagem remover(int pos)
{
    Personagem resp;
    int tam = tamanho();

    if (primeiro == ultimo)
    {
        errx(1, "Erro ao remover (vazia)!");
    }
    else if (pos < 0 || pos >= tam)
    {
        errx(1, "Erro ao remover (posicao %d/%d invalida!", pos, tam);
    }
    else if (pos == 0)
    {
        resp = removerInicio();
    }
    else if (pos == tam - 1)
    {
        resp = removerFim();
    }
    else
    {
        // Caminhar ate a posicao anterior a insercao
        CelulaDupla *i = primeiro->prox;
        int j;
        for (j = 0; j < pos; j++, i = i->prox)
            ;

        i->ant->prox = i->prox;
        i->prox->ant = i->ant;
        resp = i->elemento;
        i->prox = i->ant = NULL;
        free(i);
        i = NULL;
    }

    return resp;
}

// -----------quick----------

void swap(int i, int j)
{
    Personagem temp = personagens[i];
    personagens[i] = personagens[j];
    personagens[j] = temp;
}

void quicksortRec(int esq, int dir)
{
    int i = esq, j = dir;
    Personagem pivo = personagens[(dir + esq) / 2];
    Personagem temp;
    while (i <= j)
    {
        while (strcmp(personagens[i].corDeCabelo, (pivo.corDeCabelo)) < 0 || strcmp(personagens[i].corDeCabelo, (pivo.corDeCabelo)) == 0 && strcmp(personagens[i].nome, (pivo.nome)) < 0)
            i++;
        while (strcmp(personagens[j].corDeCabelo, (pivo.corDeCabelo)) > 0 || strcmp(personagens[j].corDeCabelo, (pivo.corDeCabelo)) == 0 && strcmp(personagens[j].nome, (pivo.nome)) > 0)
            j--;
        if (i <= j)
        {
            temp = personagens[i];
            personagens[i] = personagens[j];
            personagens[j] = temp;
            i++;
            j--;
        }
    }
    if (esq < j)
        quicksortRec(esq, j);
    if (i < dir)
        quicksortRec(i, dir);
}

void sort()
{
    quicksortRec(0, COUNT - 1);
}

//------------------------------------FUNCOES MAIN---------------------------------------------------

/**
 * isFim - metodo para dizer se a string recebida
 * e a palavra FIM.
 *
 * @param str - string a ser analizada.
 * @return true - se a string for a palavra FIM;
 *         false- caso contrario.
 */
bool isFim(char *str)
{
    bool resposta = false;
    int tamanho = strlen(str);
    if (str[0] == 'F' && str[1] == 'I' && str[2] == 'M')
    {
        resposta = true;
    } // end if
    return resposta;
} // end isFim

int main(void)
{
    char entrada[1000];
    char *entrada2;
    int numEntrada = 0, countMain = 0;
    entrada2 = (char *)malloc(200 * sizeof(char));
    // Leitura da entrada padrao
    fgets(entrada, 200, stdin);
    ler(entrada);
    start();
    inserirFim(personagens[COUNT]);
    fgets(entrada, 200, stdin);
    while (isFim(entrada) == false)
    {
        ler(entrada);
        inserirFim(personagens[COUNT]);
        fgets(entrada, 200, stdin);
    }
    sort();
    imprimir();

    return 0;
}