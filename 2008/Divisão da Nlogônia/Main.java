/*
 * Autor: Ramon Barbosa
 * Maratona: Maratona de Programação da SBC 2014
 * Problema: A
 * Link: https://www.beecrowd.com.br/judge/pt/problems/view/1091
 */

import java.util.Scanner;

public class Main {

    public static String qualQuadrante(int n, int m, int x, int y) {
        if (n > x) {
            if (m > y)
                return "SO";
            else if (m < y)
                return "NO";
            else
                return "divisa";

        } else if (n < x) {
            if (m > y)
                return "SE";
            else if (m < y)
                return "NE";
            else
                return "divisa";

        } else
            return "divisa";
    }

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        while (true) {
            int k = tec.nextInt();
            if (k == 0)
                break;

            int n = tec.nextInt();
            int m = tec.nextInt();

            while (k-- > 0) {
                System.out.println(qualQuadrante(n, m, tec.nextInt(), tec.nextInt()));
            }

        }

    }

}