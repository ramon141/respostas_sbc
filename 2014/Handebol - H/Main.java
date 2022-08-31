/*
 * Autor: Ramon Barbosa
 * Maratona: Maratona de Programação da SBC 2014
 * Problema: H
 * Link: https://www.beecrowd.com.br/judge/pt/problems/view/1715
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        int n = tec.nextInt();
        int m = tec.nextInt();

        int desempenho[][] = new int[n][m];
        int jogador = 0;

        for (int i = 0; i < n; i++) {
            boolean golEmTodas = true;

            for (int j = 0; j < m; j++) {
                desempenho[i][j] = tec.nextInt();
                if (desempenho[i][j] == 0)
                    golEmTodas = false;
            }

            if (golEmTodas)
                jogador++;
        }

        System.out.println(jogador);

    }

}
