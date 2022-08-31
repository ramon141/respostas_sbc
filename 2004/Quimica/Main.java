/*
 * Autor: Ramon Barbosa
 * Maratona: Maratona de Programação da SBC 2004
 * Problema: D
 * Link: https://www.beecrowd.com.br/judge/pt/problems/view/1290
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    class Reacao {
        String substancias[] = new String[2];
        String resultado;

        public Reacao(String sub1, String sub2, String resultado) {
            substancias[0] = sub1;
            substancias[1] = sub2;
            this.resultado = resultado;
        }

        @Override
        public String toString() {
            return substancias[0] + " + " + substancias[1] + " --> " + resultado;
        }

    }

    public Main() {
        Scanner tec = new Scanner(System.in);

        while (true) {
            int r = tec.nextInt();
            if (r == 0)
                break;

            ArrayList<Reacao> reacoes = new ArrayList<Reacao>();
            for (int i = 0; i < r; i++) {

                String sub1 = tec.next();
                tec.next();// pega o +
                String sub2 = tec.next();
                tec.next();// pega o ->
                String resultado = tec.next();

                reacoes.add(new Reacao(sub1, sub2, resultado));
            }

            System.out.println(reacoes.get(r - 1).resultado + " requires " + quantContainer(reacoes) + " containers");
        }
    }

    public int quantContainer(ArrayList<Reacao> reacoes) {
        System.out.println(reacoes);
        return 0;
    }

    public static void main(String[] args) {
        new Main();
    }

}
