#define _GNU_SOURCE
#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>

typedef struct
{
    char nome[50];
    char tituloOriginal[50];
    char dataDeLancamento[8];
    int duracao;
    char genero[20];
    char idiomaOriginal[20];
    char situacao[15];
    float orcamento;
    char palavrasChave[][20];
} Filme; // end filmes

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

bool isFimHTML(char *str)
{
    bool resposta = false;
    int tamanho = strlen(str);

    //  printf("%c-%c-%c\n",str[0],str[1],str[2]);

    if (str[0] == '<' && str[1] == '/' && str[2] == 'h' && str[3] == 't' && str[4] == 'm')
    {
        resposta = true;
    } // end if

    return resposta;
} // end isFim

/**
 * limpar - metodo para "limpar" uma string recebida
 * e retirar os espacos vazios.
 *
 * @param str - string a ser limpada.
 * @return a string depois do tratamento;
 *
 */
char *limpar(char *str, int i)
{
    int tamanho = strlen(str) - 1;
    if (i < tamanho && str[tamanho] == '\n')
    {
        str[tamanho] = '\0';
    }
    return str;
} // end limpar

char *removeTags(char entrada[])
{
    char *saida;
    int i = 0;

    do
    {

        if (entrada[i] == '>')
        {
            i++;
            while (entrada[i] != '<')
            {

                saida = saida + entrada[i];
                i++;
            }
        }
        else
        {
            i++;
        }
    } while (i < (strlen(entrada) - 1));
    return saida;
}

void ler(char nomeArquivo[])
{
    // leitura do arquivo
    char caminho[100];
    char *aux;
    char linha[100];
    strcat(strcpy(caminho, "/tmp/filmes/"), nomeArquivo);
    FILE *arq = fopen(caminho, "r");
    if (arq == NULL)
        printf("Erro, nao foi possivel abrir o arquivo\n");
    else
    {
        while (isFimHTML(linha) != false)
        fgets(linha, sizeof(linha), arq);
        aux = strcasestr(linha, "h2 class");
        // printf("%s", linha);
        if (aux)
        {
            fgets(linha, sizeof(linha), arq);
        }
        fgets(linha, sizeof(linha), arq);
        printf("%s\n", removeTags(limpar(linha, 0)));
    }

    fclose(arq);
 
    // // receber os atributos
    // String linha = br.readLine();
    // // atributo nome
    // while (!linha.contains("h2 class"))
    // {
    //     linha = br.readLine();
    // }
    // linha = br.readLine().trim();

    // filmes.setNome(removeTags(linha));

    // // atributo data lancamento
    // linha = br.readLine();
    // while (!linha.contains("class=\"release\""))
    // {
    //     linha = br.readLine();
    // }
    // linha = br.readLine().trim().split(" ")[0];
    // filmes.setDataDeLancamento(tratarData(linha));

    // // atributo genero
    // linha = br.readLine();
    // while (!(linha.contains("class=\"genres\"")))
    // {
    //     linha = br.readLine();
    // }
    // linha = br.readLine();
    // linha = br.readLine().trim();
    // filmes.setGenero(removeTags(linha).replace("&nbsp;", ""));

    // // atributo duracao
    // while (!linha.contains("span class=\"runtime\""))
    // {
    //     linha = br.readLine();
    // }
    // linha = br.readLine();
    // linha = br.readLine().trim();
    // filmes.setDuracao(tratarDuracao(linha));

    // // atributo titulo original

    // while (!linha.contains("class=\"social_links\""))
    // {
    //     linha = br.readLine();
    // }
    // while (!linha.contains("strong"))
    // {
    //     linha = br.readLine();
    // }

    // if (linha.contains("Título original"))
    // {
    //     filmes.setTituloOriginal(removeTags(linha).replace("Título original", "").trim());
    // }
    // else
    // {
    //     filmes.setTituloOriginal(filmes.getNome());
    // }

    // // atributo situacao
    // while (!linha.contains("bdi>Situação"))
    // {
    //     linha = br.readLine();
    // }
    // filmes.setSituacao(linha.replace("<strong><bdi>Situação</bdi></strong>", "").trim());

    // // atributo idioma original
    // while (!linha.contains("Idioma original"))
    // {
    //     linha = br.readLine();
    // }
    // filmes.setIdiomaOriginal(removeTags(linha).replace("Idioma original", "").trim());

    // // atributo Orçamento
    // while (!linha.contains("Orçamento"))
    // {
    //     linha = br.readLine();
    // }
    // filmes.setOrcamento(tratarOrcamento(removeTags(linha).replace("Orçamento", "").trim()));

    // String palavrasTemp[] = new String[30];
    // int contador = 0;
    // // atributo palavras-chave
    // while (!linha.contains("Palavras-chave"))
    // {
    //     linha = br.readLine();
    // } // end while
    // linha = br.readLine();
    // linha = br.readLine();
    // if (linha.contains("Nenhuma palavra-chave foi adicionada."))
    // {
    //     palavrasTemp[0] = new String("");
    // }
    // else
    // {
    //     linha = br.readLine();
    //     while (!linha.contains("</ul>"))
    //     {
    //         linha = br.readLine();
    //         if (linha.contains("li"))
    //         {
    //             palavrasTemp[contador] = removeTags(linha.trim());
    //             contador++;
    //         } // end if
    //     }     // end while
    // }         // end else
    // filmes.setPalavrasChave(palavrasTemp);
    // br.close();
}
int main(void)
{
    Filme filmes;
    char entrada[1000][1000];
    char aux[1000];
    int numEntrada = 0;
    // Leitura da entrada padrao
    while (isFim(aux) == false)
    {
        fgets(aux, 200, stdin);
        strcpy(entrada[numEntrada], limpar(aux, 0));
        numEntrada++;
    }
    numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

    for (int i = 0; i < numEntrada; i++)
    {
        printf("%s\n", entrada[i]);
        ler(entrada[i]);
    }

} // end main