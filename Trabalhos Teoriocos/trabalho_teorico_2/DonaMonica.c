#include <stdio.h>

/**
 * filhoMaisVelho - funcao para dizer a idade do filho mais velho
 *
 * @param filhoUm   - idade de um dos filho.
 * @param filhoDois - idade de outro filho.
 * @param mae       - idade da mae.
 * @return idade do filho mais velho.
 */
int filhoMaisVelho(int filhoUm, int filhoDois, int mae)
{
    int resultado = 0;
    int filhoTres = 0;
    filhoTres = mae - (filhoUm + filhoDois);
    if (filhoUm > filhoDois && filhoUm > filhoTres)
    {
        resultado = filhoUm;
    }
    else if (filhoDois > filhoUm && filhoDois > filhoTres)
    {
        resultado = filhoDois;
    }
    else if (filhoTres > filhoUm && filhoTres > filhoDois)
    {
        resultado = filhoTres;
    }
    return resultado;
} // end filhoMaisVelho
int main(void)
{
    int entrada[1000][3];
    int separada[1000];
    int numEntrada = 0;
    int filhoUm = 0, filhoDois = 0, mae = 0, linha = 0;
    // Leitura da entrada padrao
    do
    {
        scanf("%i", &entrada[numEntrada][0]);
        scanf("%i", &entrada[numEntrada][1]);
        scanf("%i", &entrada[numEntrada][2]);
    } while (entrada[numEntrada++][0] != 0);
    numEntrada--; // Desconsiderar ultima linha contendo o 0

    do
    {
        mae = entrada[linha][0];
        filhoUm = entrada[linha][1];
        filhoDois = entrada[linha][2];
        printf("%i\n", filhoMaisVelho(filhoUm, filhoDois, mae));
        linha++;
    } while (linha < numEntrada);

} // end main
