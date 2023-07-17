#define _GNU_SOURCE
#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>

typedef struct
{
    char nome[20];
    int altura;
    double peso;
    char corDeCabelo[20];
    char corDaPele[20];
    char corDosOlhos[20];
    char anoNascimento[20];
    char genero[20];
    char homeworld[20];

} Personagens; // end personagens

// Variaveis globais
Personagens p;

// Class Personagens functions
void personagens_start(Personagens personagens)
{
    strcpy(personagens.nome, "");
    strcpy(personagens.corDeCabelo, "");
    strcpy(personagens.corDaPele, "");
    strcpy(personagens.corDosOlhos, "");
    strcpy(personagens.anoNascimento, "");
    strcpy(personagens.genero, "");
    strcpy(personagens.homeworld, "");
    personagens.altura = 0;
    personagens.peso = 0.0;
} // end contrutor

void nome(char nome[])
{
    strcpy(p.nome, nome);
}

void corDeCabelo(char corDeCabelo[])
{
    strcpy(p.corDeCabelo, corDeCabelo);
}

void corDaPele(char corDaPele[])
{
    strcpy(p.corDaPele, corDaPele);
}

void corDosOlhos(char corDosOlhos[])
{
    strcpy(p.corDosOlhos, corDosOlhos);
}

void anoNascimento(char anoNascimento[])
{
    strcpy(p.anoNascimento, anoNascimento);
}

void genero(char genero[])
{
    strcpy(p.genero, genero);
}

void homeworld(char homeworld[])
{
    strcpy(p.homeworld, homeworld);
}

void altura(char altura[])
{
    p.altura = atoi(altura);
}

void peso(char peso[])
{
    p.peso = atof(peso);
}

char *replace(char s[])
{
    char nova[300] = "";
    int j = 0;
    int ult = strlen(s);

    for (int i = 0; i < strlen(s) - 1; i++)
    {

        if (s[i] == ',' && s[i - 1] == ',')
        {
            setbuf(stdin, NULL);
            strcat(nova, "nao informado");
            j = strlen(nova);
        }
        nova[j] = s[i];

        j++;
    }

    if (nova[strlen(nova) - 1] == ',')
        strcat(nova, "nao informado");

    char *saida = nova;
    return saida;
}

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

    //  printf("%c-%c-%c\n",str[0],str[1],str[2]);

    if (str[0] == 'F' && str[1] == 'I' && str[2] == 'M')
    {
        resposta = true;
    } // end if

    return resposta;
} // end isFim

char* json_substring(const char* const str, const char* const key, size_t* const index) {
    size_t start = *index + str_len(key) + 4;
    *index = start;
    while(str[++*index] != '\'');
    *index += 4;
    return str_substring(str, start, *index - 4);
}

void imprimir();

/**
 * ler - metodo para ler e tratar o arquivo aberto pelo caminho
 * e retirar os espacos vazios.
 *
 * @param str - string contendo o caminho do arquivo.
 *
 */
void ler(char caminho[])
{
    char* json = (char*)malloc(1000 * sizeof(char));
    char* str = NULL;
    char aux[200], aux2[50];
    char *sep;
    char *palavra;
    size_t index = 2;
    // leitura do arquivo
    caminho[strcspn(caminho, "\n")] = 0;
    FILE *arq = fopen((caminho), "r");
    char linha[500];
    if (!arq)
        printf("Erro, nao foi possivel abrir o arquivo\n");
    else
    {
        fgets(linha, sizeof(linha), arq);
        char matriz[50][20]; // matriz com 3 linhas, 10 colunas e cada string com no máximo 10 caracteres
        for (int i = 0; i < sizeof(linha); i++)
        {
            if (linha[i] != '{' && linha[i] != '}' && linha[i] != 39 && linha[i] != ',')
            {
                aux[k] = linha[i];
                k++;
            }
        }
        // sep = strtok(aux, ":");
        sep = strtok(aux, " ");
        while (sep)
        {
            strcpy(matriz[l], sep); // copia a palavra para a matriz
            l++;
            j++;
            sep = strtok(NULL, " ");
        }
        for (int i = 0; i < l; i++)
        {
            ;
        }
        nome(matriz[1]);
        altura(matriz[3]);
        if (strcmp(matriz[5], "unknown") == 0)
        {
            peso(0);
        }
        else
        {
            peso(matriz[5]);
        }
        corDeCabelo(matriz[7]);
        corDaPele(matriz[9]);
        if (strcmp(matriz[10], "eye_color") == 0)
        {
            corDosOlhos(matriz[11]);
            anoNascimento(matriz[13]);
            genero(matriz[15]);
            if (strcmp(matriz[18], "films") == 0)
            {
                homeworld(matriz[17]);
            }
            else
            {
                strcpy(aux2, "");
            }
        }
        else
        {
            strcpy(aux2, strcat(matriz[9], " "));
            corDaPele(strcat(aux2, matriz[10]));
            corDosOlhos(matriz[12]);
            anoNascimento(matriz[14]);
            genero(matriz[16]);
            homeworld(matriz[18]);
        }

        imprimir();
    }

    fclose(arq);
}
void imprimir()
{
    printf("## %s ## %d ## %.f ## %s ## %s ## %s ## %s ## %s ## %s", p.nome, p.altura, p.peso, p.corDeCabelo, p.corDaPele, p.corDosOlhos, p.anoNascimento, p.genero, p.homeworld);
}

int main(void)
{
    Personagens personagem;
    char entrada[1000][1000];
    char aux[1000];
    int numEntrada = 0;
    // Leitura da entrada padrao
    while (isFim(aux) == false)
    {
        fgets(aux, 200, stdin);
        strcpy(entrada[numEntrada], aux);
        numEntrada++;
    }
    numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

    for (int i = 0; i < numEntrada; i++)
    {
        // printf("%s\n", entrada[i]);
        ler(entrada[i]);
    }

} // end main