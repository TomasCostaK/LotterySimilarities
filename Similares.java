import java.util.*;
import java.io.*;

public class Similares {    
    private int nhf, p, max, Nu;
    private double thresh;
    private String[] args;
    HashMap <Integer, ArrayList<Integer>> Mapa = new HashMap <Integer, ArrayList<Integer>>();
    
    //Com este hashmap ficamos com um Mapa de users/filmes, 
    //ficamos com tamanho de users unico (length map)
    //e tambem com os valores dos users que sao as keys do map

    public Similares(double thresh, int nhf, int p, int max){
        this.thresh = thresh;
        this.nhf = nhf;
        this.p = p;
        this.max = max;
    }

    //Dados User-Filmes.. Guardado em Mapa
    public void readToMapa(String filename){
        ArrayList<Integer> list;
        try (BufferedReader br = new BufferedReader(new FileReader(filename)) ) {
            for (String line = null; (line = br.readLine()) != null;) {
                args = line.split("\\t");
                int user = Integer.parseInt(args[0]);
                int filme = Integer.parseInt(args[1]);

                if(Mapa.containsKey(user)){
                    // if the key has already been used,
                    // we'll just grab the array list and add the value to it
                    list = Mapa.get(user);
                    list.add(filme);
                } else {
                    // if the key hasn't been used yet,
                    // we'll create a new ArrayList<Integer> object, add the value
                    // and put it in the array list with the new key
                    list = new ArrayList<Integer>();
                    list.add(filme);
                    Mapa.put(user, list);
                }
                //talvez fazer unique destes, com ciclos for
                //args[1]-user  args2-filme 
                //o objetivo e guardar num Mapa
            }
            //Mudar isto mais tarde
            //this.Nu = 100;
            this.Nu = Mapa.size();

        } catch (Exception e) {
            System.out.println("Error opening file, exception " + e);
        }
    }

    public double[][] calcDistance(){
        int[] r = new int[nhf];
        Random rand = new Random();

        //Prencher o vetor r com valores aleatorios
        for (int i = 0; i < nhf; i++) {
            r[i]= rand.nextInt(Nu)+1;
        }
        //Nova Hashfunc
        hashfunc h = new hashfunc(p, r);

        int[][] MinHash = new int[nhf][Nu]; //array nhf x Nu

        //Calcular matriz
        for (int u = 1; u < Nu ; u++) { //da nos ind do user
            System.out.println("---Nova entrada---");
            for (int k = 0; k < nhf; k++) {
                int minimo = h.generate(k, Mapa.get(u).get(0));

                for (int v = 0; v < Mapa.get(u).size(); v++) {
                    int tmp = h.generate(k,Mapa.get(u).get(v));
                    //System.out.println(tmp);
                    if(tmp<minimo){
                        minimo=tmp;
                    }
                    //Aqui acabamos a verificaçao e passamos ao proximo user
                }
                MinHash[k][u] = minimo;
                System.out.println("U= " + u + " K= " + k + " MinHash[k][u]= " + MinHash[k][u]);
            }
        }

        //Distancia MinHash
        //Primeiro linhas - depois colunas
        double[][] semMinHash = new double[Nu][Nu];

        //Mudar 4 por Nu, isto percorre 2 users
        for (int u1 = 1; u1 < Nu; u1++) {
            for (int u2 = 0; u2 < u1; u2++) {
                int conta=0;

                for (int k = 0; k < nhf; k++) {
                    //System.out.println(MinHash[k][u1] + " == " + MinHash[k][u2]);
                    if (MinHash[k][u1] == MinHash[k][u2]) {
                        conta++;
                    }
                }

                double sem=((double)conta/nhf);
                semMinHash[u1][u2]=sem;
                semMinHash[u2][u1]=sem;
                //System.out.println(semMinHash[u2][u1]);
            }
        }
        return semMinHash;
    }

    public void similarUsers(double[][] semMinHash){

        for (int u1 = 1; u1 < Nu; u1++) {
            for (int u2 = 0; u2 < u1; u2++) {
                if(semMinHash[u1][u2] > thresh){
                    System.out.println("Users semelhantes: " + u1 + " e " +u2 + ", Semelhança= " + 100*semMinHash[u1][u2]);
                }
            }
        }

    }
}
