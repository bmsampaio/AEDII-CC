#include <stdio.h>
/**
 * anoCometa - metodo para dizer qual o proximo ano da passagem do cometa
 * Halley.
 *
 *  @param ano - ano atual.
 * @return proximo ano de passagem do cometa.
 */
int anoCometa(int ano)
{

    int resposta = 0;
    int ultimaPassagem = 1986;
    int auxilio = 0;
    int passagens[14];
    // Preencher um vetor com as proximas 14 passagens do cometa
    for (int i = 0; i < 14; i++)
    {
        passagens[i] = ultimaPassagem + 76;
        ultimaPassagem = passagens[i];
    } // end for
    for (int i = 0; i < 14; i++)
    {
        // Se -> ano de passagem da posicao i - ano atual >= 76
        // -> o proximo ano de passagem do cometa e o proprio ano de passagem da posicao i
        auxilio = passagens[i] - ano;
        if (auxilio <= 76)
        {
            resposta = passagens[i];
        } // end if
    }     // end for
    return resposta;
} // end anoCometa

int main(void)
{
    int entrada[1000];
    int numEntrada = 0;
    int i = 0;
    // Leitura da entrada padrao
    do
    {
        scanf("%i", &entrada[numEntrada]);
    } while (entrada[numEntrada++] != 0);
    numEntrada--; // Desconsiderar ultima linha contendo o 0

    do
    {
        printf("%i\n", anoCometa(entrada[i]));
        i++;
    } while (i < numEntrada);

} // end main
