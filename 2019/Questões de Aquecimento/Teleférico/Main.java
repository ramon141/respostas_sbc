/*
 * Autor: Ramon Barbosa
 * Maratona: Maratona de Programação da SBC 2021
 * Problema: J
 * Link: https://www.beecrowd.com.br/judge/pt/problems/view/2667
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        int c = tec.nextInt();
        int a = tec.nextInt();

        int quantidadeDeViagens = a / (c - 1);
        if (a % (c - 1) != 0)
            quantidadeDeViagens++;

        System.out.println(quantidadeDeViagens);
    }
}
