/*
 * Autor: Ramon Barbosa
 * Maratona: Maratona de Programação da SBC 2004
 * Problema: D
 * Link: https://www.beecrowd.com.br/judge/pt/problems/view/1290
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        class Caixa implements Comparable<Caixa> {

            int x, y, z, quantidade;

            public Caixa(int x, int y, int z) {
                ArrayList<Integer> dimensao = new ArrayList<Integer>();
                dimensao.add(x);
                dimensao.add(y);
                dimensao.add(z);
                dimensao.sort(null);

                this.x = dimensao.get(2);
                this.y = dimensao.get(1);
                this.z = dimensao.get(0);
                quantidade = 1;
            }

            public int compareTo(Caixa caixa) {
                return this.getVolume() - caixa.getVolume();
            }

            public int getVolume() {
                return this.x * this.y * this.z;
            }

            public boolean hasInside(Caixa caixa) {
                return caixa.x >= this.x && caixa.y >= this.y
                        && caixa.z >= this.z;
            }

            @Override
            public String toString() {
                return "Caixa: {x: " + x + ", y: " + y + ", z: " + z
                        + ", vol: " + getVolume() + ", quant: " + quantidade
                        + "}";
            }

            public void addBox() {
                this.quantidade++;
            }

        }

        // caixas a mais
        // lista registrando dimensoes
        // cliente quer n caixas do mesmo tamanho
        // cada caixa tem quer embalar itens de tamanho x,y,z
        // x,y,z encaixa perfeitamente
        // se nao tiver n caixas xyz ele quer n que fique mais apertada
        // xyz == yzx

        Scanner tec = new Scanner(System.in);

        while (true) {
            int n = tec.nextInt();// numero de caixas
            if (n == 0)
                break;

            int m = tec.nextInt();// numero de caixas no estoque

            // o maior é x, o segundo é y, o z é o menor numero
            Caixa caixaDesejada = new Caixa(tec.nextInt(), tec.nextInt(),
                    tec.nextInt());

            // Cada uma das M linhas seguintes contém três inteiros A, B e C
            List<Caixa> caixasEmEstoque = new ArrayList<Caixa>(m);

            for (int i = 0; i < m; i++) {
                Caixa newBox = new Caixa(tec.nextInt(), tec.nextInt(),
                        tec.nextInt());

                int index = -1;
                int xBox = newBox.x;
                int yBox = newBox.y;
                int zBox = newBox.z;
                for (int j = 0; j < caixasEmEstoque.size(); j++) {
                    if (caixasEmEstoque.get(j).x == xBox && caixasEmEstoque.get(j).y == yBox
                            && caixasEmEstoque.get(j).z == zBox) {
                        index = j;
                        break;
                    }
                }

                if (index < 0) {
                    caixasEmEstoque.add(newBox);
                } else {
                    caixasEmEstoque.get(index).addBox();
                }
            }

            caixasEmEstoque.sort(null);

            Caixa melhorCaixa = null;
            for (int i = 0; i < caixasEmEstoque.size(); i++) {
                Caixa currentBox = caixasEmEstoque.get(i);

                if (caixaDesejada.hasInside(currentBox)) {
                    if (currentBox.quantidade >= n) {
                        if (melhorCaixa == null
                                || (melhorCaixa.compareTo(caixaDesejada) > currentBox
                                        .compareTo(caixaDesejada))) {
                            melhorCaixa = currentBox;
                        }
                    }
                }
            }

            if (melhorCaixa == null) {
                System.out.println("impossible");
            } else {
                System.out.println(melhorCaixa.compareTo(caixaDesejada));
            }

        }

    }

}
