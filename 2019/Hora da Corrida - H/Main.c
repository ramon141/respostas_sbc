/*
 * Autor: Ramon Barbosa
 * Maratona: Maratona de Programação da SBC 2019
 * Problema: H
 * Link: https://www.beecrowd.com.br/judge/pt/problems/view/2968
 */

#include <stdio.h>

int main()
{
    int v, p;
    scanf("%d %d", &v, &p);

    for (int i = 10; i < 99; i += 10)
    {

        double placas = ((i / 100.0) * (v * p));
        int placasint = (int)placas;
        if (placasint != placas)
            placasint = (int)(placas + 1);

        printf("%d", placasint);
        if (i != 90)
            printf(" ");
    }

    printf("\n");

    return 0;
}