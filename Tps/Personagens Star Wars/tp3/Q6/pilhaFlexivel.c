#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
#include <math.h>
#include <err.h>
#define MAXTAM 5
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

        personagens[COUNT].nome = substring(aux, "name", ", height");
        personagens[COUNT].altura = atoi(substring(aux, "height", ", mass"));
        personagens[COUNT].peso = atof(substring(aux, "mass", ", hair_color"));
        personagens[COUNT].corDeCabelo = substring(aux, "hair_color", ", skin_color");
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
            printf("##%s ## %d ## %.f ##%s ##%s ##%s ##%s ##%s ##%s ##\n", personagens[i].nome, personagens[i].altura, personagens[i].peso, personagens[i].corDeCabelo, personagens[i].corDaPele, personagens[i].corDosOlhos, personagens[i].anoNascimento, personagens[i].genero, personagens[i].homeworld);
        }
        else
        {
            printf("##%s ## %d ## %.1f ##%s ##%s ##%s ##%s ##%s ##%s ##\n", personagens[i].nome, personagens[i].altura, personagens[i].peso, personagens[i].corDeCabelo, personagens[i].corDaPele, personagens[i].corDosOlhos, personagens[i].anoNascimento, personagens[i].genero, personagens[i].homeworld);
        }
    }
}
//------------------------------------FUNCOES PILHA FLEX---------------------------------------------------

// TIPO CELULA ===================================================================
typedef struct Celula
{
    Personagem elemento; // Elemento inserido na celula.
    struct Celula *prox; // Aponta a celula prox.
} Celula;

Celula *novaCelula(Personagem elemento)
{
    Celula *nova = (Celula *)malloc(sizeof(Celula));
    nova->elemento = elemento;
    nova->prox = NULL;
    return nova;
}

// FILA PROPRIAMENTE DITA ========================================================
Celula *topo;
int tamanho = 0;

/**
 * Cria uma fila sem elementos.
 */
void start()
{
    topo = NULL;
}

/**
 * Insere elemento na pilha (politica FILO).
 * @param x elemento a inserir.
 */
void inserir(Personagem x)
{
    Celula *tmp = novaCelula(x);
    tmp->prox = topo;
    topo = tmp;
    tmp = NULL;
    tamanho++;
}

/**
 * Remove elemento da pilha (politica FILO).
 * @return Elemento removido.
 */
Personagem remover()
{
    if (topo == NULL)
    {
        errx(1, "Erro ao remover!");
    }

    Personagem resp = topo->elemento;
    Celula *tmp = topo;
    topo = topo->prox;
    tmp->prox = NULL;
    free(tmp);
    tmp = NULL;
    tamanho--;
    return resp;
}

/**
 * Mostra os elementos separados por espacos, comecando do topo.
 */
void mostrar()
{
    Celula *i;
    int c = 0;
    for (i = topo; i != NULL; i = i->prox)
    {
        if (i->elemento.peso == (int)(i->elemento.peso))
        {
            printf("[%d] ##%s ## %d ## %.f ##%s ##%s ##%s ##%s ##%s ##%s ##\n", c, i->elemento.nome, i->elemento.altura, i->elemento.peso, i->elemento.corDeCabelo, i->elemento.corDaPele, i->elemento.corDosOlhos, i->elemento.anoNascimento, i->elemento.genero, i->elemento.homeworld);
        }
        else
        {
            printf("[%d] ##%s ## %d ## %.1f ##%s ##%s ##%s ##%s ##%s ##%s ##\n", c, i->elemento.nome, i->elemento.altura, i->elemento.peso, i->elemento.corDeCabelo, i->elemento.corDaPele, i->elemento.corDosOlhos, i->elemento.anoNascimento, i->elemento.genero, i->elemento.homeworld);
        }
        c++;
    }
}
void mostraPilha(Celula *i, int count)
{
    if (i != NULL)
    {
        mostraPilha(i->prox, --count);
        if (i->elemento.peso == (int)(i->elemento.peso))
        {
            printf("[%d]  ##%s ## %d ## %.f ##%s ##%s ##%s ##%s ##%s ##%s ## \n", count, i->elemento.nome, i->elemento.altura, i->elemento.peso, i->elemento.corDeCabelo, i->elemento.corDaPele, i->elemento.corDosOlhos, i->elemento.anoNascimento, i->elemento.genero, i->elemento.homeworld);
        }
        else
        {
            printf("[%d]  ##%s ## %d ## %.1f ##%s ##%s ##%s ##%s ##%s ##%s ## \n", count, i->elemento.nome, i->elemento.altura, i->elemento.peso, i->elemento.corDeCabelo, i->elemento.corDaPele, i->elemento.corDosOlhos, i->elemento.anoNascimento, i->elemento.genero, i->elemento.homeworld);
        }

    }
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

    while (isFim(entrada) == false)
    {
        ler(entrada);
        numEntrada++;
        fgets(entrada, 200, stdin);
    }
    start();
    for (int i = 0; i < numEntrada; i++)
    {
        inserir(personagens[i]);
    }
    countMain = numEntrada;
    numEntrada = 0;
    scanf("%d", &numEntrada);
    getchar();

    for (int i = 0; i < numEntrada; i++)
    {
        fgets(entrada2, 200, stdin);
        // testar se e inserir no inicio, inserir no fim, inserir posicao, remover no incio, remover no fim, remover posicao
        if (entrada2[0] == 'I')
        {
            ler(substring(entrada2, "I ", "\n"));
            inserir(personagens[countMain]);
            countMain++;
        }
        else if (entrada2[0] == 'R')
        {
            printf("(R)%s\n", remover().nome);
        }
    }
    free(entrada2);
    mostraPilha(topo, tamanho);

    return 0;
}