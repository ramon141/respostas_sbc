/*
 * Autor: Ramon Barbosa
 * Maratona: Maratona de Programação da SBC 2018
 * Problema: D
 * Link: https://www.beecrowd.com.br/judge/pt/problems/view/2879
 */

#include <stdio.h>

int main()
{

    int n, quantidadeDeAcertos;

    scanf("%d", &n);

    for (int i = 0; i < n; i++)
    {
        int portaCorreta;
        scanf("%d", &portaCorreta);

        if (portaCorreta != 1)
        {
            quantidadeDeAcertos = quantidadeDeAcertos + 1;
        }
    }

    printf("%d\n", quantidadeDeAcertos);

    return 0;
}