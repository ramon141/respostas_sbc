import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

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

    class CidadeIndice implements Comparator<Cidade> {
        @Override
        public int compare(Cidade a, Cidade b) {
            return a.idx - b.idx;
        }
    }

    public int fatorialDeSoma(int i) {
        int soma = i;
        while (i-- > 0)
            soma += i;

        return soma;
    }

    public void calcularInatividade(int ciclos, Rua rua, ArrayList<Cidade> cidades, Cidade origem, Cidade destino) {
        if (rua.tamanho == 1) {
            origem.iic++;

        } else {
            int tempoParaChegar = fatorialDeSoma(rua.tamanho);
            for (int i = 0; i <= ciclos; i++) {
                cidades.get(i).iic += tempoParaChegar;
            }
            destino.iic -= rua.tamanho;
        }
    }

    public ArrayList<Object> aplicarCiclo(ArrayList<Cidade> cidades, ArrayList<Rua> ruas, Cidade cAtual, int ciclos) {
        int inatividadeImperio = 0;
        ArrayList<Object> retorno = new ArrayList<Object>();

        // Escolher cidade
        ArrayList<Cidade> cidadesVizinha = new ArrayList<>();
        // System.out.println("--------------");
        // System.out.println(cAtual);
        // System.out.println("---------------");
        for (int i = 0; i < cAtual.size(); i++) {
            if (cAtual.get(i).c1.idx == cAtual.idx) {
                if (cAtual.get(i).c2.idx != cAtual.idx) {
                    cidadesVizinha.add(cAtual.get(i).c2);
                }
            } else {
                cidadesVizinha.add(cAtual.get(i).c1);
            }
        }
        // System.out.println("----------------");
        // cidadesVizinha.sort(null);

        // System.out.println("Cidades vizinhas: " + cidadesVizinha);

        Cidade cidadeEscolhida = cidadesVizinha.get(0);
        Rua rua = null;
        for (int i = 0; i < cidadeEscolhida.size(); i++) {
            if (cidadeEscolhida.get(i).c1.idx == cAtual.idx || cidadeEscolhida.get(i).c2.idx == cAtual.idx) {
                rua = cidadeEscolhida.get(i);
                break;
            }
        }

        cidadesVizinha.get(0).iic = 0;

        // Um cara anda 1km por ciclo
        // se ele nao conseguir completar o caminho dessa viagem
        if (rua.tamanho > ciclos) {
            // os dias vao passando para cada cidade
            inatividadeImperio = 0;
            for (int i = 1; i <= ciclos; i++) {
                inatividadeImperio += (cidades.size() * i);
            }

            retorno.add(cidades);
            retorno.add(inatividadeImperio);
            retorno.add(cidadeEscolhida);
            retorno.add(inatividadeImperio);
            retorno.add(true);

            return retorno;
        } else {
            System.out.println("cai noutro lugar");
        }

        calcularInatividade(ciclos, rua, cidades, cidadeEscolhida, cidadesVizinha.get(0));

        for (int i = 0; i < cidades.size(); i++) {
            inatividadeImperio += cidades.get(i).iic;
        }

        cidades.sort(new CidadeIndice());

        retorno.add(cidades);
        retorno.add(inatividadeImperio);
        retorno.add(cidadeEscolhida);
        retorno.add(ciclos - rua.tamanho);
        retorno.add(false);

        return retorno;
    }

    public Main() {

        Scanner tec = new Scanner(System.in);

        while (true) {
            int c = tec.nextInt();
            int r = tec.nextInt();
            int ciclos = tec.nextInt();
            int cInicial = tec.nextInt();

            if (c == 0 && r == 0 && ciclos == 0)
                break;

            ArrayList<Rua> ruas = new ArrayList<Rua>();
            ArrayList<Cidade> cidades = new ArrayList<Cidade>(c);

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

            ArrayList<Object> result = new ArrayList<Object>();
            result.add(cidades);
            result.add(0);
            result.add(cidades.get(cInicial - 1));
            result.add(ciclos);

            int ii = 0;

            for (int i = 0; i < ciclos; i++) {
                System.out.println("\n-----Depois Ciclo " + (i + 1) + "-----");
                result = aplicarCiclo(
                        ((ArrayList<Cidade>) result.get(0)),
                        ruas,
                        ((Cidade) result.get(2)),
                        ((int) result.get(3)));

                ii += ((int) result.get(1));

                if ((boolean) result.get(4)) {
                    System.out.println("-->" + ii);
                    break;
                }

                System.out.println(result.get(0));
                System.out.println("iee = " + result.get(1));
                System.out.println(result.get(2));
                System.out.println("ii = " + ii);
                System.out.println("Restam " + (result.get(3)) + "ciclos");
                System.out.println("\n-------------------------\n");
            }
        }
    }

    public static void main(String[] args) {
        new Main();

    }
}