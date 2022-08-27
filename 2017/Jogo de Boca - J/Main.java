/*
 * Autor: Ramon Barbosa
 * Maratona: Maratona de Programação da SBC 2017
 * Problema: J
 * Link: https://www.beecrowd.com.br/judge/pt/problems/view/2667
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        String numero = tec.next(); // '12341234123412341234123412341234';

        int soma = 0;
        for (int i = 0; i < numero.length(); i++) {
            soma += Integer.parseInt(numero.charAt(i) + "");
        }

        System.out.println(soma % 3);

    }
}
