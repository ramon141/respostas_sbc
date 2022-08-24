/*
 * Autor: Ramon Barbosa
 * Maratona: Maratona de Programação da SBC 2004
 * Problema: B
 * Link: https://www.beecrowd.com.br/judge/pt/problems/view/2963
 */

#include <stdio.h>

int main()
{
    int n;
    scanf("%d", &n);

    int index = 0;
    int first = -1;
    for (int i = 0; i <= n; i++)
    {
        int temp;
        scanf("%d", &temp);
        if (temp > first)
        {
            first = temp;
            index = i;
        }
    }

    printf("%c\n", index == 0 ? 'S' : 'N');

    return 0;
}
