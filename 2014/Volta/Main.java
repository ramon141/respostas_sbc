/*
 * Autor: Ramon Barbosa
 * Maratona: Maratona de Programação da SBC 2014
 * Problema: 
 * Link: https://www.beecrowd.com.br/judge/pt/problems/view/1708
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        int segundosRapido = tec.nextInt();
        int segundosLento = tec.nextInt();

        System.out.println((int) Math.ceil((double) segundosLento / (segundosLento - segundosRapido)));
    }

}
