#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>
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
            printf("## %s ## %d ## %.f ## %s ##%s ##%s ##%s ##%s ##%s ##\n", personagens[i].nome, personagens[i].altura, personagens[i].peso, personagens[i].corDeCabelo, personagens[i].corDaPele, personagens[i].corDosOlhos, personagens[i].anoNascimento, personagens[i].genero, personagens[i].homeworld);
        }
        else
        {
            printf("## %s ## %d ## %.1f ## %s ##%s ##%s ##%s ##%s ##%s ##\n", personagens[i].nome, personagens[i].altura, personagens[i].peso, personagens[i].corDeCabelo, personagens[i].corDaPele, personagens[i].corDosOlhos, personagens[i].anoNascimento, personagens[i].genero, personagens[i].homeworld);
        }
    }
}
//------------------------------------FUNCOES LISTA---------------------------------------------------
int n = 0;
/**
 * Insere um elemento na primeira posicao da lista e move os demais
 * elementos para o fim da
 * @param x int elemento a ser inserido.
 */
void inserirInicio(Personagem x)
{
    int i;

    // validar insercao
    if (n >= COUNT)
    {
        printf("Erro ao inserir!");
        exit(1);
    }

    // levar elementos para o fim do personagens
    for (i = n; i > 0; i--)
    {
        personagens[i] = personagens[i - 1];
    }

    personagens[0] = x;
    n++;
}

/**
 * Insere um elemento na ultima posicao da
 * @param x int elemento a ser inserido.
 */
void inserirFim(Personagem x)
{

    // validar insercao
    if (n >= COUNT)
    {
        printf("Erro ao inserir!");
        exit(1);
    }

    personagens[n] = x;
    n++;
}

/**
 * Insere um elemento em uma posicao especifica e move os demais
 * elementos para o fim da
 * @param x int elemento a ser inserido.
 * @param pos Posicao de insercao.
 */
void inserir(Personagem x, int pos)
{
    int i;

    // validar insercao
    if (n >= COUNT || pos < 0 || pos > n)
    {
        printf("Erro ao inserir!");
        exit(1);
    }

    // levar elementos para o fim do personagens
    for (i = n; i > pos; i--)
    {
        personagens[i] = personagens[i - 1];
    }

    personagens[pos] = x;
    n++;
}

/**
 * Remove um elemento da primeira posicao da lista e movimenta
 * os demais elementos para o inicio da mesma.
 * @return resp int elemento a ser removido.
 */
Personagem removerInicio()
{
    int i;
    Personagem resp;

    // validar remocao
    if (n == 0)
    {
        printf("Erro ao remover!");
        exit(1);
    }

    resp = personagens[0];
    n--;

    for (i = 0; i < n; i++)
    {
        personagens[i] = personagens[i + 1];
    }
    COUNT--;
    return resp;
}

/**
 * Remove um elemento da ultima posicao da
 * @return resp int elemento a ser removido.
 */
Personagem removerFim()
{

    // validar remocao
    if (n == 0)
    {
        printf("Erro ao remover!");
        exit(1);
    }
    COUNT--;
    return personagens[--n];
}

/**
 * Remove um elemento de uma posicao especifica da lista e
 * movimenta os demais elementos para o inicio da mesma.
 * @param pos Posicao de remocao.
 * @return resp int elemento a ser removido.
 */
Personagem remover(int pos)
{
    int i;
    Personagem resp;

    // validar remocao
    if (n == 0 || pos < 0 || pos >= n)
    {
        printf("Erro ao remover!");
        exit(1);
    }

    resp = personagens[pos];
    n--;

    for (i = pos; i < n; i++)
    {
        personagens[i] = personagens[i + 1];
    }
    COUNT--;
    return resp;
}

/**
 * Mostra os personagens separados por espacos.
 */
void mostrar()
{
    int i;

    for (i = 0; i < n; i++)
    {
        if (personagens[i].peso == (int)personagens[i].peso)
        {
            printf("[%d]  ## %s ## %d ## %.f ##%s ##%s ##%s ##%s ##%s ##%s ##\n", i, personagens[i].nome, personagens[i].altura, personagens[i].peso, personagens[i].corDeCabelo, personagens[i].corDaPele, personagens[i].corDosOlhos, personagens[i].anoNascimento, personagens[i].genero, personagens[i].homeworld);
        }
        else
        {
            printf("[%d]  ## %s ## %d ## %.1f ##%s ##%s ##%s ##%s ##%s ##%s ##\n", i, personagens[i].nome, personagens[i].altura, personagens[i].peso, personagens[i].corDeCabelo, personagens[i].corDaPele, personagens[i].corDosOlhos, personagens[i].anoNascimento, personagens[i].genero, personagens[i].homeworld);
        }
    }
}

/**
 * Procura um personagens e retorna se ele existe.
 * @param x int elemento a ser pesquisado.
 * @return <code>true</code> se o personagens existir,
 * <code>false</code> em caso contrario.
 */
bool pesquisaBinaria(char *chave)
{
    bool resp = false;
    int dir = (n - 1), esq = 0, meio;

    while (esq <= dir)
    {
        meio = (esq + dir) / 2;
        if (strcmp(chave, personagens[meio].nome) == 0)
        {
            esq = dir + 1;
            resp = true;
        }
        else if (strcmp(chave, personagens[meio].nome) > 0)
        {
            esq = meio + 1;
        }
        else
        {
            dir = meio - 1;
        }
    }

    return resp;
}

void swap(int i, int j)
{
    Personagem temp = personagens[i];
    personagens[i] = personagens[j];
    personagens[j] = temp;
}

void bolha()
{
    int i, j;
    for (i = (n - 1); i > 0; i--)
    {
        for (j = 0; j < i; j++)
        {
            if (strcmp(personagens[j].anoNascimento, personagens[j + 1].anoNascimento) > 0)
            {
                swap(j, j + 1);
            }
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
        inserirFim(personagens[countMain]);
        countMain++;
        numEntrada++;
        fgets(entrada, 200, stdin);
    }

    bolha();
    imprimir();

    return 0;
}