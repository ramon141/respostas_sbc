/*
 * Autor: Ramon Barbosa
 * Maratona: Maratona de Programação da SBC 2004
 * Problema: 
 * Link: https://www.beecrowd.com.br/judge/pt/problems/view/1367
 */

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);

        int n;
        do {
            int totalTime = 0;
            int totalCorrect = 0;

            n = tec.nextInt();

            HashMap<String, Integer> map = new HashMap<String, Integer>();

            for (int i = 0; i < n; i++) {
                String letter = tec.next();
                int tempo = tec.nextInt();
                String isCorrect = tec.next();

                if (isCorrect.equals("incorrect")) {
                    Integer value = map.get(letter);
                    if (value == null) {
                        map.put(letter, 1);
                    } else
                        map.put(letter, map.get(letter) + 1);
                } else {
                    Integer value = map.get(letter);
                    if (value == null) {
                        value = 0;
                    }

                    totalCorrect++;
                    totalTime += (value * 20);
                    totalTime += tempo;
                }
            }

            if (n != 0)
                System.out.println(totalCorrect + " " + totalTime);

        } while (n != 0);
    }

}
