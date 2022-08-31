/*
 * Autor: Ramon Barbosa
 * Maratona: Maratona de Programação da SBC 2005
 * Problema: A
 * Link: https://www.beecrowd.com.br/judge/pt/problems/view/1129
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);

        while (true) {
            int n = tec.nextInt();
            if (n == 0)
                break;

            String result[] = new String[n];
            for (int i = 0; i < n; i++) {
                int a = tec.nextInt();
                int b = tec.nextInt();
                int c = tec.nextInt();
                int d = tec.nextInt();
                int e = tec.nextInt();

                String questaoMarcada = null;
                boolean maisDeUma = false;

                if (a <= 127)
                    questaoMarcada = "A";

                if (b <= 127)
                    if (questaoMarcada == null)
                        questaoMarcada = "B";
                    else
                        maisDeUma = true;

                if (c <= 127)
                    if (questaoMarcada == null)
                        questaoMarcada = "C";
                    else
                        maisDeUma = true;

                if (d <= 127)
                    if (questaoMarcada == null)
                        questaoMarcada = "D";
                    else
                        maisDeUma = true;

                if (e <= 127)
                    if (questaoMarcada == null)
                        questaoMarcada = "E";
                    else
                        maisDeUma = true;

                if (questaoMarcada == null || maisDeUma)
                    result[i] = ("*");
                else
                    result[i] = (questaoMarcada);
            }

            for (int i = 0; i < n; i++) {
                System.out.println(result[i]);
            }

        }

    }

}