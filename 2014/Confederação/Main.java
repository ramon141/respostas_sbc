/*
 * Autor: Ramon Barbosa
 * Maratona: Maratona de Programação da SBC 2014
 * Problema: B
 * Link: https://www.beecrowd.com.br/judge/pt/problems/view/1709
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    class Plano implements Comparable<Plano> {
        int a, b, c, d;

        @Override
        public int compareTo(Plano o) {
            return this.d - o.d;
        }

        public String toString() {
            return a + "x + " + b + "y + " + c + "z = " + d;
        }

    }

    Main() {

        Scanner tec = new Scanner(System.in);
        int m = tec.nextInt();
        int n = tec.nextInt();

        int regioesQuantPlanetas[] = new int[m + 1];
        ArrayList<Plano> plano = new ArrayList<Plano>(m);
        int posicoes[][] = new int[n][3];

        for (int i = 0; i < m; i++) {
            Plano planoTemp = new Plano();
            planoTemp.a = tec.nextInt();
            planoTemp.b = tec.nextInt();
            planoTemp.c = tec.nextInt();
            planoTemp.d = tec.nextInt();

            plano.add(planoTemp);

            regioesQuantPlanetas[i] = 0;
        }

        plano.sort(null);

        // System.out.println(plano );

        for (int i = 0; i < n; i++) {
            posicoes[i][0] = tec.nextInt();
            posicoes[i][1] = tec.nextInt();
            posicoes[i][2] = tec.nextInt();

            int regiaoPlaneta = qualRegiao(plano, posicoes[i]);
            System.out.printf("Planeta [%d, %d, %d] regiao %d\n", posicoes[i][0], posicoes[i][1], posicoes[i][2],
                    regiaoPlaneta);

            regioesQuantPlanetas[regiaoPlaneta]++;
        }

        int max = -1;
        for (int i = 0; i <= m; i++) {
            if (max == -1 || regioesQuantPlanetas[i] > regioesQuantPlanetas[max])
                max = i;
        }

        System.out.println(plano.get(1));
    }

    public static int qualRegiao(ArrayList<Plano> plano, int posicao[]) {

        double menorDistancia = -1;
        int idxMenorDistancia = -1;

        for (int i = 0; i < plano.size(); i++) {
            // double distancia = (plano.get(i).a * posicao[0]) + (plano.get(i).b *
            // posicao[1]) + (plano.get(i).c * posicao[2]);
            int a = plano.get(i).a;
            int b = plano.get(i).b;
            int c = plano.get(i).c;
            int d = plano.get(i).d;

            int x = posicao[0];
            int y = posicao[1];
            int z = posicao[2];

            double distancia = (Math.abs((a * x) + (b * y) + (c * z) - d)) / (Math.sqrt((a * a) + (b * b) + (c * c)));

            if (distancia < menorDistancia) {
                menorDistancia = distancia;
                idxMenorDistancia = i;
            }

            // if (d < plano.get(i).d) {
            // return i;
            // }
        }

        // System.out.printf("Nao encontrou [%d, %d, %d]", posicao[0], posicao[1],
        // posicao[2]);
        // return plano.size();
        return idxMenorDistancia;
    }

    public static void main(String[] args) {

        new Main();

    }

}
