#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>

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

/**
 * isPalindromo - funcao recursiva que recebe uma cadeia de caracteres e a
 * classifica como palindromo, ou nao.
 *
 * @param str - cadeia de caracteres a ser classificada,
 * @return true - se a cadeia de caracteres for um palindromo;
 *         false- caso contrario.
 */

bool isPalindromo(char str[], int i)
{
    bool resposta = true;
    int tamanho = strlen(str)-1;
    char ultimoChar = str[tamanho];
   // printf("%i\n",tamanho);    
    // condicao de parada
    if (i < strlen(str))
    {
        /**se o caracter na posicao i for diferente do caracter na posicao (tamanho-i),
        entao a string nao e um palindromo -> retornar falso.
        */
        //printf("%c - %c\n",str[i],ultimoChar);
        if (str[i] != ultimoChar)
        {
            resposta = false;
           
        } // end if
        else{
        //motor da recursividade.
         resposta = isPalindromo(str, (i + 1));
        }
      
    }
    return resposta;
} // end isPalindromo

int main(void)
{
    char entrada[1000][1000];
    char aux[1000];
    int numEntrada = 0;
    // Leitura da entrada padrao
    while (isFim(aux) == false)
    {
        fgets(aux, 200, stdin);
        strcpy(entrada[numEntrada],limpar(aux,0));
        numEntrada++;
    }             // end while
    numEntrada--; // Desconsiderar ultima linha contendo a palavra FIM

    for (int i = 0; i < numEntrada; i++)
    {
        if ((isPalindromo(entrada[i], 0)) == true)
        {
            printf("SIM\n");
        } // end if
        else
        {
            printf("NAO\n");
        } // end else
    }     // end for
} // end main
