import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    int ii = 0, ciclos;
    ArrayList<Cidade> cidades;
    ArrayList<Rua> ruas;

    public void addII(int value) {
        ii += value;
    }

    class Rua {
        Cidade c1, c2;
        int tamanho;

        public Rua(Cidade c1, Cidade c2, int tamanho) {
            this.c1 = c1;
            this.c2 = c2;
            this.tamanho = tamanho;
        }

        @Override
        public String toString() {
            return (c1.idx + 1) + "<--" + tamanho + "-->" + (1 + c2.idx);
        }
    }

    class Cidade extends ArrayList<Rua> implements Comparable<Cidade> {
        int idx, iic;

        public Cidade(int idx) {
            this.idx = idx;
        }

        @Override
        public String toString() {
            return "[" + (idx + 1) + "] = { iic:" + iic + ", " + super.toString() + " }";
        }

        @Override
        public int compareTo(Cidade o) {
            int ret = o.iic - this.iic;
            if (ret != 0)
                return ret;

            return this.idx - o.idx;
        }
    }

    public int fatorialDeSoma(int i, int prefx) {
        int soma = i;
        while (i-- > 0)
            soma += (i + prefx);

        return soma;
    }

    public void calcularInatividade(Rua rua, Cidade origem, Cidade destino) {
        // Se a rua tiver tamanho 1 é simples, todas as demais cidades
        // ganham +1 de inatividade, e a cidade destino fica com 0
        if (rua.tamanho == 1) {
            int tempoParaChegar = 0;

            for (int i = 0; i < cidades.size(); i++) {
                if (cidades.get(i).idx != destino.idx) {
                    cidades.get(i).iic++;
                    tempoParaChegar += cidades.get(i).iic;
                }
            }

            destino.iic = 0;
            ciclos -= rua.tamanho;

            // Quando o tamanho da rua é 1, entao basta adicionar 1 para corresponder a
            // todas as cidades e o -1 serve para eliminar o ii do destino
            addII(tempoParaChegar);

        } else {
            // Caso o caminho não tenha somente 1km, temos que apelar
            // para o trecho:
            // "Assumindo que um patruleiro viaja um quilômetro em uma
            // unidade de tempo (uma simulação de ciclo) e que o tempo
            // para visitar a cidade é neglicenciável (igual a zero)"

            // Ou seja, imaginamos que o caminho entre a cidade A e B,
            // seja 2km, e só haja essas duas cidades (input: 2 1 1 1 1 2 2)

            // 1º Ciclo - Anda 1km
            // A<-------웃-------->B
            // IIC A = 1 ciclo
            // IIC B = 1 ciclo
            // IIE = 2
            // II = 2
            // Isto ocorre porque a após o primeiro ciclo o 웃 não está
            // em nenhuma cidade, então o ICC deve ser incrementado em cada
            // cidade

            // 2º Ciclo - Anda mais 1km
            // A<---------------->웃B
            // IIC A = 2 ciclo
            // IIC B = 0 ciclo
            // IIE = 2
            // II = 2 + 2 = 4

            // Agora ele chegou a cidade destino, e a II da cidade B é zerada

            // Podemos perceber que há dois casos:
            // 1º - Que o tamanho da rua é menor ou igual a quantidade de ciclos restantes
            // (consegue atravessar)
            // 2º - Nao consegue atravessar a cidade, mas ainda sim o icc deve ser calculado

            // Vamos inicialmente considerar o primeiro caso
            if (/* primeiro caso */ rua.tamanho <= ciclos) {
                // Esta variável guardará o IIE dos "rua.tamanho" ciclos que ocorrerem
                int tempoParaChegar = 0;

                // Quando todos o ciclo terminar o ii do reino será a soma das inatividades a
                // cada ciclo
                // Para todo A != destino
                // 1º Ciclo - Inatividade Cidade A = Y + X
                // 2º Ciclo - Inatividade Cidade A = Y + X + 1
                // 3º Ciclo - Inatividade Cidade A = Y + X + 2
                // .........
                // Tº Ciclo - Inatividade Cidade A = Y + X + T, considere X = tamanho da rua
                // II = (x + x+2 + ... + x+C)
                // O Y é a inatividade anterior da cidade, aqui nomeada como
                // "cidades.get(i).iic"
                for (int i = 0; i < cidades.size(); i++) {
                    if (cidades.get(i).idx != destino.idx) {
                        tempoParaChegar += fatorialDeSoma(rua.tamanho, cidades.get(i).iic);
                        cidades.get(i).iic += rua.tamanho;

                    } else {
                        // Se for a cidade destino, então o último ciclo não irá "contar", pois neste o
                        // usuário já chegou na cidade, e a inatividade é zerada
                        tempoParaChegar += fatorialDeSoma(rua.tamanho - 1, cidades.get(i).iic);
                    }
                }

                // O destino é zerado, pois o cidadão chegou na cidade
                destino.iic = 0;

                // Agora que eu já calcurei o iic, basta eu adicioná-lo
                addII(tempoParaChegar);

                // A quantidade de ciclos "usadas" é equivalente ao tamanho da rua
                ciclos -= rua.tamanho;
            } else {
                /*
                 * 2º Caso: Nao consegue atravessar a cidade, mas ainda sim o icc deve ser
                 * calculado
                 */

                // Para calcular o icc para toda cidade, basta utilizar a mesma lógica anterior
                // 1º Ciclo - Inatividade Cidade A = Y + X
                // .........
                // Tº Ciclo - Inatividade Cidade A = Y + X + T, considere X = a quantidade de
                // ciclos, pois não há ciclos suficientes para conseguir completar o caminho
                int tempoParaChegar = 0;
                for (int i = 0; i < cidades.size(); i++) {
                    tempoParaChegar += fatorialDeSoma(ciclos, cidades.get(i).iic);
                    cidades.get(i).iic += ciclos;
                }

                destino.iic = 0;
                addII(tempoParaChegar);
                ciclos = 0;
            }
        }
    }

    public Cidade choiceCity(Cidade currentCity) {
        ArrayList<Cidade> cidadesVizinha = new ArrayList<>();

        for (Rua rua : currentCity) {
            Cidade outraCidade = rua.c1.idx == currentCity.idx ? rua.c2 : rua.c1;
            cidadesVizinha.add(outraCidade);
        }

        // Ordena por inatividade, se forem iguais ele considera o index
        cidadesVizinha.sort(null);
        return cidadesVizinha.get(0);
    }

    public Rua choiceWalk(Cidade a, Cidade b) {
        for (Rua rua : ruas) {
            if (rua.c1.idx == a.idx && rua.c2.idx == b.idx)
                return rua;

            if (rua.c2.idx == a.idx && rua.c1.idx == b.idx)
                return rua;
        }

        return null;
    }

    public void aplicarCiclo(Cidade currentCity) {
        // Vai aplicando os ciclos enquanto ele for superior a 0
        if (ciclos > 0) {
            Cidade nextCity = choiceCity(currentCity);
            Rua rua = choiceWalk(currentCity, nextCity);
            calcularInatividade(rua, currentCity, nextCity);
            aplicarCiclo(nextCity);
        }
    }

    public Main() {

        Scanner tec = new Scanner(System.in);

        while (true) {
            ii = 0;
            if (cidades != null)
                cidades.clear();
            if (ruas != null)
                ruas.clear();

            int c = tec.nextInt();
            int r = tec.nextInt();
            ciclos = tec.nextInt();
            int cInicial = tec.nextInt();

            if (c == 0 && r == 0 && ciclos == 0)
                break;

            ruas = new ArrayList<Rua>();
            cidades = new ArrayList<Cidade>(c);

            for (int i = 0; i < c; i++) {
                cidades.add(new Cidade(i));
            }

            for (int i = 0; i < r; i++) {
                int c1 = tec.nextInt();
                int c2 = tec.nextInt();
                int tamanho = tec.nextInt();
                Rua rua = new Rua(cidades.get(c1 - 1), cidades.get(c2 - 1), tamanho);

                cidades.get(c1 - 1).add(rua);
                cidades.get(c2 - 1).add(rua);
                ruas.add(rua);
            }

            aplicarCiclo(cidades.get(cInicial - 1));
            System.out.println(ii);
        }
    }

    public static void main(String[] args) {
        new Main();

    }
}