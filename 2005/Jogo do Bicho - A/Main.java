/*
 * Autor: Ramon Barbosa
 * Maratona: Maratona de Programação da SBC 2005
 * Problema: A
 * Link: https://www.beecrowd.com.br/judge/pt/problems/view/1483
 */

import java.util.Scanner;

public class Main {

    public static String ultimosNDigitos(int numero, int n) {
        int mod = (int) Math.pow(10, n);

        String ret = (numero % mod) + "";
        while (ret.length() < n)
            ret = "0" + ret;

        return ret;
    }

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        while (true) {
            double v = tec.nextDouble();
            int n = tec.nextInt();
            int m = tec.nextInt();

            if (v == 0 && n == 0 && m == 0) {
                break;
            }

            if (ultimosNDigitos(n, 4).equals(ultimosNDigitos(m, 4))) {
                System.out.printf("%.2f\n", v * 3000);
                continue;
            }

            if (ultimosNDigitos(n, 3).equals(ultimosNDigitos(m, 3))) {
                System.out.printf("%.2f\n", v * 500);
                continue;
            }

            if (ultimosNDigitos(n, 2).equals(ultimosNDigitos(m, 2))) {
                System.out.printf("%.2f\n", v * 50);
                continue;
            }

            int doisUltimosM = m % 100;
            int doisUltimosN = n % 100;

            if (doisUltimosM == 0)
                doisUltimosM = 100;
            if (doisUltimosN == 0)
                doisUltimosN = 100;

            if ((doisUltimosM - 1) / 4 == (doisUltimosN - 1) / 4) {
                System.out.printf("%.2f\n", v * 16);
                continue;
            }

            System.out.printf("0.00\n");

        }

    }

}
