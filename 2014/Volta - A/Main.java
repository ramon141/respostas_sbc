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

        while (tec.hasNext()) {
            int a = tec.nextInt();
            int b = tec.nextInt();
            int c = tec.nextInt();

            if (a == b && b == c) {
                System.out.println("*");
            } else if (a != b && b == c) {
                System.out.println("A");

            } else if (b != a && a == c) {
                System.out.println("B");

            } else {
                System.out.println("C");
            }

        }

    }

}