/*Exercicios iniciais - Nivelamento - Unidade 00b
Autor: Barbara Maria Sampaio Portes - 631948
*/
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

/*
Faça um método que receba um array de inteiros e um
número inteiro x e retorne um valor booleano informando se o
elemento x está contido no array
--
verificaContido
@return - true, se o numero inteiro x estiver contido no array
          false, caso contrario
@param array - arranjo de inteiros
@param x - numero inteiro
*/
bool verificaContido(int array[], int x)
{
    bool result = false;
    for (int i = 0; i < 10; i++)
    {

        if (array[i] == x)
        {
            result = true;
        } // end if
    }     // end for
    return result;
} // end verificaContido

/*
Repita o exercício acima considerando que os elementos do
array estão ordenados de forma crescente. Uma sugestão
seria começar a pesquisa pelo meio do array
--
O metodo acima ja considera se os elementos estiverem ordenados de forma crescente.
*/

/*
Faça um método que receba um array de inteiros e mostre na tela
o maior e o menor elementos do array.
--
maiorMenor
@param array - arranjo de inteiros
*/
void maiorMenor(int array[])
{
    int maior = array[0];
    int menor = array[0];
    for (int i = 0; i < 10; i++)
    {
        if (array[i] > maior)
        {
            maior = array[i];
        } // end if
        if (array[i] < menor)
        {
            menor = array[i];
        } // end if
    }     // end for
    printf("O maior numero do arranjo e %i\n", maior);
    printf("O menor numero do arranjo e %i\n", menor);

} // end maiorMenor

/*
Repita o exercício acima considerando que os elementos do
array estão ordenados de forma crescente. Uma sugestão
seria começar a pesquisa pelo meio do array
--
O metodo acima ja considera se os elementos estiverem ordenados de forma crescente.
*/

int main(void)
{
    int arranjo[10];
    char c = c;
    for (int i = 0; i < 10; i++)
    {
        scanf("%i", &arranjo[i]);
    }
    int x = 5;
    if (verificaContido(arranjo, x) == true)
    {
        printf("x esta contido\n");
    }
    else
    {
        printf("x nao esta contido\n");
    }

    maiorMenor(arranjo);

    
    return 0;
}