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

    //  printf("%c-%c-%c\n",str[0],str[1],str[2]);

    if (str[0] == 'F' && str[1] == 'I' && str[2] == 'M')
    {
        resposta = true;
    } // end if

    return resposta;
} // end isFim
/**
 * isVogal - metodo para dizer se a string recebida
 * e composta toda de vogais.
 *
 * @param str - string a ser analizada.
 * @return true - se a string for composta somente por vogais;
 *         false- caso contrario.
 */
bool isVogal(char str[])
{
    bool resposta = true;
    int tamanho = strlen(str);
    int i = 0;
    do
    {
        if ((str[i] == 'a' ||
             str[i] == 'e' ||
             str[i] == 'i' ||
             str[i] == 'o' ||
             str[i] == 'u') ||
            (str[i] == 'A' ||
             str[i] == 'E' ||
             str[i] == 'I' ||
             str[i] == 'O' ||
             str[i] == 'U'))
        {
            // se for uma vogal continuar o teste
            i++;
        } // end if
        else
        {
            // se nao for uma vogal parar contador e retornar falso
            i = tamanho;
            resposta = false;
        } // end else
    } while (i < tamanho);
    return resposta;

} // end isVogal

/**
 * isConsoante - metodo para dizer se a string recebida
 * e composta toda de consoantes.
 *
 * @param str - string a ser analizada.
 * @return true - se a string for composta somente por consoantes;
 *         false- caso contrario.
 */
bool isConsoante(char str[])
{
    bool resposta = true;
    int tamanho = strlen(str);
    int i = 0;
    do
    {
        // testar se e uma letra
        if ((str[i] > 65 && str[i] <= 90) || (str[i] > 97 && str[i] <= 122))
        {
            // testar se nao e vogal
            if (!(str[i] == 'a' ||
                  str[i] == 'e' ||
                  str[i] == 'i' ||
                  str[i] == 'o' ||
                  str[i] == 'u') ||
                !(str[i] == 'A' ||
                  str[i] == 'E' ||
                  str[i] == 'I' ||
                  str[i] == 'O' ||
                  str[i] == 'U'))
            {
                // se for uma letra e nao for uma vogal -> continuar o teste
                i++;
            } // end if
            else
            {
                // se for uma vogal parar contador e retornar falso
                i = tamanho;
                resposta = false;
            } // end else
        }     // end if
        else
        {
            // se nao for uma letra parar contador e retornar falso
            i = tamanho;
            resposta = false;
        } // end else
    } while (i < tamanho);
    return resposta;
} // end isConsoante

/**
 * isInteiro - metodo para dizer se a string recebida
 * e composta por um numero inteiro.
 *
 * @param str - string a ser analizada.
 * @return true - se a string e um numero inteiro;
 *         false- caso contrario.
 */
bool isInteiro(char str[])
{
    bool resposta = true;
    int tamanho = strlen(str);
    int i = 0;
    do
    {
        if (str[i] >= 48 && str[i] <= 57)
        {
            // se for um algarismo continuar o teste
            i++;
        }
        else
        {
            // se nao for um algarismo parar contador e retornar falso
            i = tamanho;
            resposta = false;
        } // end else
    } while (i < tamanho);
    return resposta;
} // end isInteiro

/**
 * isReal - metodo para dizer se a string recebida
 * e composta por um numero real.
 *
 * @param str - string a ser analizada.
 * @return true - se a string e um numero real;
 *         false- caso contrario.
 */
bool isReal(char str[])
{
    bool resposta = false;
    int tamanho = strlen(str);
    int i = 0;
    do
    {
        // testar se e uma letra
        if ((str[i] > 65 && str[i] <= 90) || (str[i] > 97 && str[i] <= 122))
        {
            // se for uma letra parar contador e retornar falso
            i = tamanho;
            resposta = false;
        }
        else if (str[i] == 44)
        {
            // se nao for uma letra mas for virgula retornar verdadeiro
            resposta = true;
        }
        i++;

    } while (i < tamanho);
    return resposta;
} // end isReal

int main(void)
{
    char entrada[1000][1000];
    char aux[1000];
    int numEntrada = 0;
    char vogal[3];
    char consoante[3];
    char inteiro[3];
    char real[3];
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
        if (isVogal(entrada[i]) == true)
        {
            printf("SIM NAO NAO NAO\n");
        } // end else if
        else if (isConsoante(entrada[i]) == true)
        {
            printf("NAO SIM NAO NAO\n");
        } // end else if
        else if (isInteiro(entrada[i]) == true)
        {
            printf("NAO NAO SIM NAO\n");
        } // end else if
        else if(isReal(entrada[i]) == true)
        {
            printf("NAO NAO NAO SIM\n");
        } // end else if
        else
        {
            printf("NAO NAO NAO NAO\n");
        }//end else
    } // end for

} // end main
