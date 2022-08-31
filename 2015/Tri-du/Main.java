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

        int a = tec.nextInt();
        int b = tec.nextInt();

        if (a == b)
            System.out.println(a);
        else
            System.out.println("" + ((a > b) ? a : b));

    }

}