/*
 * Autor: Ramon Barbosa
 * Maratona: Maratona de Programação da SBC 2014
 * Problema: H
 * Link: https://www.beecrowd.com.br/judge/pt/problems/view/1715
 */

import java.util.Scanner;

public class Main {

    public static int fatorial(int n) {
        int produto = n;
        while (--n > 0)
            produto *= n;

        return produto;
    }

    public static int menorValor(int n) {
        int valor = 1;
        while (fatorial(++valor) <= n)
            ;

        return valor - 1;
    }

    public static void main(String[] args) {
        Scanner tec = new java.util.Scanner(System.in);

        int n = tec.nextInt();

        int quantidade = 0;
        while (n > 0) {
            n = n - fatorial(menorValor(n));
            quantidade++;
        }

        System.out.println(quantidade);

    }

}