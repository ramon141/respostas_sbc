/*
 * Autor: Ramon Barbosa
 * Maratona: Maratona de Programação da SBC 2017
 * Problema: M
 * Link: https://www.beecrowd.com.br/judge/pt/problems/view/2670
 */

import java.util.Scanner;

public class Main {

    public static int menor(int a, int b) {
        return a > b ? b : a;
    }

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        int a1 = tec.nextInt();
        int a2 = tec.nextInt();
        int a3 = tec.nextInt();

        int andar1 = (a2 + (a3 * 2)) * 2;
        int andar2 = (a1 + a3) * 2;
        int andar3 = ((a1 * 2) + a2) * 2;

        System.out.println(menor(menor(andar1, andar2), andar3));

    }
}
