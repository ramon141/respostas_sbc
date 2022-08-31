/*
 * Autor: Ramon Barbosa
 * Maratona: Maratona de Programação da SBC 2014
 * Problema: B
 * Link: https://www.beecrowd.com.br/judge/pt/problems/view/1709
 */

import java.util.Scanner;

public class Main {
    public static int embaralhar(int baralho[], int quant) {
        int posicaoPrimeiro = 1;

        while (true) {
            posicaoPrimeiro = posicaoPrimeiro * 2;
            if (posicaoPrimeiro > baralho.length)
                posicaoPrimeiro = (posicaoPrimeiro - 1) % baralho.length;

            quant++;

            if (posicaoPrimeiro == 1)
                break;
        }

        return quant;
    }

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        int n = tec.nextInt() / 2;

        int baralho[] = new int[n * 2];
        for (int i = 0; i < baralho.length; i++) {
            baralho[i] = i + 1;
        }

        System.out.println(embaralhar(baralho, 0));
    }

}
