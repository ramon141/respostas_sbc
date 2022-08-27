/*
 * Autor: Ramon Barbosa
 * Maratona: Maratona de Programação da SBC 2017
 * Problema: F
 * Link: https://www.beecrowd.com.br/judge/pt/problems/view/2663
 */

import java.util.*;

public class Main {

    class NewInteger implements Comparable<NewInteger> {
        int valor;

        public NewInteger(int valor) {
            this.valor = valor;
        }

        @Override
        public int compareTo(NewInteger outro) {
            return outro.valor - this.valor;
        }

        @Override
        public boolean equals(Object outro) {
            return this.compareTo((NewInteger) outro) == 0;
        }

        @Override
        public String toString() {
            return this.valor + "";
        }

    }

    public Main() {
        Scanner tec = new Scanner(System.in);

        int n = tec.nextInt();
        int k = tec.nextInt();

        ArrayList<NewInteger> pontuacoes = new ArrayList<NewInteger>();

        for (int i = 0; i < n; i++) {
            pontuacoes.add(new NewInteger(tec.nextInt()));
        }

        pontuacoes.sort(null);

        int quantidade = k;
        for (int i = k; i < n; i++) {
            if (pontuacoes.get(k - 1).equals(pontuacoes.get(i))) {
                quantidade++;
            } else
                break;
        }

        System.out.println(quantidade);
    }

    public static void main(String[] args) {
        new Main();
    }
}
