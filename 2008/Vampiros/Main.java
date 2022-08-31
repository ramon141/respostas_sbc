/*
 * Autor: Ramon Barbosa
 * Maratona: Maratona de Programação da SBC 2014
 * Problema: H
 * Link: https://www.beecrowd.com.br/judge/pt/problems/view/1715
 */

import java.util.Scanner;

public class Main {

    class Vampiro {
        int energiaVital;

        Vampiro(int energiaVital) {
            this.energiaVital = energiaVital;
        }
    }

    int D;
    int AT;

    final double probabilidadeDeUmaFace = 100.0 / 6.0;

    public Main() {
        Scanner tec = new Scanner(System.in);

        while (true) {
            int v1EnergiaVital = tec.nextInt();
            int v2EnergiaVital = tec.nextInt();

            if (v1EnergiaVital == 0 && v2EnergiaVital == 0)
                break;

            Vampiro v1 = new Vampiro(v1EnergiaVital);
            Vampiro v2 = new Vampiro(v2EnergiaVital);

            AT = tec.nextInt();
            D = tec.nextInt();

            int vitoriaV1 = 0;
            int vitoriaV2 = 0;

            if (v1EnergiaVital == v2EnergiaVital && AT == 3) {
                System.out.println("50.0");
                continue;
            } else {
                System.out.printf("%.1f\n", (100.0 / 6.0) * (AT);
                continue;
            }

            // int aleatorio;
            // for (int i = 1; i <= 50000; i++) {
            // aleatorio = (int) Math.floor(Math.random() * 6) + 1;

            // simularPartida(v1, v2, aleatorio);

            // if (v1.energiaVital <= 0) {
            // vitoriaV2++;
            // v1.energiaVital = v1EnergiaVital;
            // v2.energiaVital = v2EnergiaVital;
            // } else if (v2.energiaVital <= 0) {
            // vitoriaV1++;
            // v1.energiaVital = v1EnergiaVital;
            // v2.energiaVital = v2EnergiaVital;
            // }
            // }

            // double total = vitoriaV1 + vitoriaV2;

            // System.out.printf("%.1f\n", (vitoriaV1 / total) * 100.0);
        }

    }

    public void simularPartida(Vampiro v1, Vampiro v2, int valorDado) {
        if (valorDado <= AT) {
            v1.energiaVital += D;
            v2.energiaVital -= D;
        } else {
            v2.energiaVital += D;
            v1.energiaVital -= D;
        }
    }

    public static void main(String[] args) {
        new Main();
    }

}