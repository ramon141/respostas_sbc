/*
 * Autor: Ramon Barbosa
 * Maratona: Maratona de Programação da SBC 2004
 * Problema: E
 * Link: https://www.beecrowd.com.br/judge/pt/problems/view/1327
 */

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner tec = new Scanner(System.in);

        int n;

        while (true) {
            n = tec.nextInt();
            if (n == 0)
                break;

            String names[] = new String[n];
            int sortCarts[] = new int[52];

            for (int i = 0; i < n; i++) {
                names[i] = tec.next();
            }

            for (int i = 0; i < 52; i++) {
                sortCarts[i] = tec.nextInt();
            }

            int jogaresInativos = 0;

            int counter = 0;

            while (jogaresInativos < n && counter < 52) {
                HashMap<String, Integer> map = new HashMap<String, Integer>();
                int minCart = Integer.MAX_VALUE;

                if (n - jogaresInativos >= 52 - counter)
                    break;

                // Dando as cartas
                for (int j = 0; j < n && counter < 52; j++) {
                    String currentName = names[j];
                    if (!currentName.startsWith("d|")) {
                        int cart = sortCarts[counter++];

                        if (minCart > cart)
                            minCart = cart;

                        map.put(currentName, cart);
                    }
                }

                int deletados = 0;
                // Depois de ter dado as cartas
                for (int j = 0; j < n; j++) {
                    String currentName = names[j];
                    if (!currentName.startsWith("d|")) {
                        if (map.get(currentName) != null && map.get(currentName) == minCart) {
                            names[j] = "d|" + counter + names[j];
                            jogaresInativos++;
                            deletados++;
                        }
                    }
                }

                if (jogaresInativos == n || deletados > 4) {
                    for (int j = 0; j < n; j++) {
                        String currentName = names[j];
                        String prefix = "d|" + counter;
                        if (currentName.startsWith(prefix)) {
                            names[j] = names[j].replace(prefix, "");
                        }
                    }
                }
            }

            StringBuilder str = new StringBuilder();

            for (int j = 0; j < n; j++) {
                String currentName = names[j];
                if (!currentName.startsWith("d|")) {
                    str.append(names[j] + " ");
                }
            }

            String convert = str.toString();
            // System.out.println( convert.substring(0, convert.length()-1) );
            System.out.println(convert);

        }
    }

}
