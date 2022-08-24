/*
 * Autor: Ramon Barbosa
 * Maratona: Maratona de Programação da SBC 2004
 * Problema:
 * Link: https://www.beecrowd.com.br/judge/pt/problems/view/1329
 */

#include <stdio.h>

int main()
{
    int n = -1;

    do
    {
        scanf("%d", &n);

        int maryVictory = 0;
        int johnVictory = 0;
        int temp;

        for (int i = 0; i < n; i++)
        {
            scanf("%d", &temp);

            if (temp == 0)
                maryVictory++;
            else
                johnVictory++;
        }

        if (n != 0)
            printf("Mary won %d times and John won %d times\n", maryVictory, johnVictory);

    } while (n != 0);
}
