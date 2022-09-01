/*
 * Autor: Ramon Barbosa
 * Maratona: Maratona de Programação da SBC 2019
 * Problema: J
 * Link: https://www.beecrowd.com.br/judge/pt/problems/view/2667
 */

import java.util.Scanner;

public class Main {

    public static int fatorial(int n) {
        int produtorio = 1;
        for (int i = 1; i <= n; i++)
            produtorio *= i;

        return produtorio;
    }

    public static int maxFatorial(int n) {
        int result = 1;
        while (fatorial(++result) <= n)
            ;
        return result - 1;
    }

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        int n = tec.nextInt();
        int counter = 0;

        while (n > 0) {
            n = n - fatorial(maxFatorial(n));
            counter++;
        }
        System.out.println(counter);

    }
}
