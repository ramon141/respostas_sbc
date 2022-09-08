/*
 * Autor: Ramon Barbosa
 * Maratona: Maratona de Programação da SBC 2005
 * Problema: A
 * Link: https://www.beecrowd.com.br/judge/pt/problems/view/1483
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    ArrayList<ArrayList<Tecla>> caminhos = new ArrayList<>();

    //Se a é vizinho de b
    public boolean isNeighborhood(int a, long b){
        int neighborhoods[][] = {
            {7,8,9},//0
            {2,5,4},//1
            {1,4,5,6,3},//2
            {2,5,6},//3
            {1,2,5,7,8},//4
            {1,2,3,4,6,7,8,9},//5
            {2,3,5,8,9},//6
            {4,5,8,0},//7
            {4,5,6,7,9,0},//8
            {0,8,5,6}
        };

        for(int i = 0; i < neighborhoods[a].length; i++){
            if(neighborhoods[a][i] == b)
                return true;
        }

        return false;
    }

    public int[] getNeighborhoods(int i){
        int neighborhoods[][] = {
            {7,8,9},//0
            {2,5,4},//1
            {1,4,5,6,3},//2
            {2,5,6},//3
            {1,2,5,7,8},//4
            {1,2,3,4,6,7,8,9},//5
            {2,3,5,8,9},//6
            {4,5,8,0},//7
            {4,5,6,7,9,0},//8
            {0,8,5,6}
        };

        return neighborhoods[i];
    }

    class Tecla {
        boolean used = false;
        String numero;
        public Tecla(String n){
            numero = n;
        }

        public long getNumero(){ return Long.parseLong(numero); }

        @Override
        public String toString() {
            return String.format("{used: %b, number: %s}", used, numero);
        }
    }

    class Teclado {
        Tecla teclas[] = new Tecla[10];
        Teclado(){
            for(short i = 0; i < 10; i++){
                teclas[i] = new Tecla(i+"");
            }
        }

        Teclado(Teclado t){
            for(short i = 0; i < t.teclas.length; i++){
                Tecla newT = new Tecla(t.teclas[i].numero+"");
                newT.used = t.teclas[i].used? true : false;
                this.teclas[i] = newT;
            }
        }

        @Override
        public String toString() {
            String result = "";
            for(short i = 0; i < teclas.length; i++){
                result += teclas[i] + ", ";
            }
            return result;
        }
    }

    public Main(){
        Scanner tec = new Scanner(System.in);
        int counter = 0;

        while(true){
            counter++;

            //soma dos numeros
            long s = tec.nextLong();
            //quantidade de digitos
            int d = tec.nextInt();

            if(s == -1 && d == -1)
                break;

            Teclado teclado = new Teclado();

            System.out.println("#"+counter);
            encontrarCaminho(teclado, 0, s, new ArrayList<Tecla>(), -1, d, d);

            if(caminhos.size() == 0){
                System.out.println("impossivel");
            } else {
                for(int i = 0; i < caminhos.size(); i++){
                    for(int j = 0; j+1 < caminhos.get(i).size(); j++){
                        System.out.print(caminhos.get(i).get(j).numero+" ");
                    }
                    try{
                        System.out.println(caminhos.get(i).get(caminhos.get(i).size()-1).numero);
                    } catch(Exception erro) {
                        System.out.println("0");
                    }
                }
            }

            caminhos.clear();
        }
    }

    public int mesclar(ArrayList<Tecla> caminho, int originalD, int soma){
        int total = 0;

        //Remove os ultimos d digitos
        for(int i = 0; i < originalD; i++){
            soma -= caminho.get(caminho.size()-1).getNumero();
            total += (int) ((Math.pow(10, i) * caminho.get(caminho.size()-1).getNumero()));
            caminho.remove(caminho.size()-1);
        }

        return total;
    }

    public long getSum(ArrayList<Tecla> caminho){
        long soma = 0;
        for(int i = 0; i < caminho.size(); i++){
            soma += caminho.get(i).getNumero();
        }

        return soma;
    }

    public void encontrarCaminho(Teclado teclado, long soma, long somaTotal, ArrayList<Tecla> caminho, int lastDigit, int d, int originalD){
        
        if(somaTotal < getSum(caminho)){
            // System.out.println("Negado - " + caminho);
            return;
        } else if(somaTotal == getSum(caminho)){
            caminhos.add(caminho);

            //verifica se é possivel colocar um com 0 no final
            if(caminho.size() > 0 && caminho.get(caminho.size() - 1).numero.length() == originalD && isNeighborhood((int)(caminho.get(caminho.size() - 1).getNumero()%10), 0) && !teclado.teclas[0].used){
                ArrayList<Tecla> copia = makeCopyWalk(caminho);
                copia.add(new Tecla(0+""));
                caminhos.add(copia);
            }
            return;
        }
        
        boolean log = lastDigit == 1 && caminho.size() > 0 && caminho.get(0).getNumero() == 85 && caminho.get(caminho.size()-1).getNumero() == 14214213;

        for(int i = 0; i < teclado.teclas.length; i++){
            boolean isFirst = d == originalD || caminho.get(caminho.size()-1).numero.length() == originalD;
            
            Tecla tecla = teclado.teclas[i];
            if(!tecla.used && (lastDigit == -1 || isNeighborhood(i, lastDigit))){

                if(log)
                    System.out.println(tecla);

                Teclado tecladoCopia = new Teclado(teclado);//Cria uma copia
                tecladoCopia.teclas[i].used = true;
                ArrayList<Tecla> copyCaminho = makeCopyWalk(caminho);

                if(isFirst) {
                    copyCaminho.add(tecladoCopia.teclas[i]);
                } else {
                    copyCaminho.get(copyCaminho.size()-1).numero = copyCaminho.get(copyCaminho.size()-1).numero + tecladoCopia.teclas[i].numero;
                }

                if(!log)
                    encontrarCaminho(tecladoCopia, getSum(copyCaminho), somaTotal, copyCaminho, i, d-1, originalD);
                else{
                    System.out.printf("encontrarCaminho([%s], %d, %d, [%s], %d, %d, %d);\n",tecladoCopia+"", getSum(copyCaminho), somaTotal, copyCaminho+"", i, d-1, originalD);
                }
            }
        }

        if(log){
            System.out.println("\n\nTeclado: " + teclado);
            System.exit(0); 
        }
    }

    public ArrayList<Tecla> makeCopyWalk(ArrayList<Tecla> original){
        ArrayList<Tecla> copyCaminho = new ArrayList<>();

        for(Tecla tecla: original){
            Tecla copyTecla = new Tecla(tecla.numero);
            copyTecla.used = tecla.used;

            copyCaminho.add(copyTecla);
        }

        return copyCaminho;
    }


    public static void main(String[] args) {
        new Main();
    }

}
