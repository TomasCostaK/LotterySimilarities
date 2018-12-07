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
            this.Nu = Mapa.size();

        } catch (Exception e) {
            System.out.println("Error opening file, exception " + e);
        }
    }

    public int calcDistance(){
        int[] r = new int[nhf];
        Random rand = new Random();
        //Prencher o vetor r com valores aleatorios
        for (int i = 0; i < nhf; i++) {
            r[i]= rand.nextInt(Nu)+1;
        }
        hashfunc h = new hashfunc(p, r);

        //System.out.println(Mapa);
        //System.out.println(Mapa.get(941).size());
        

        int[][] MinHash = new int[nhf][Nu]; //array nhf x Nu

        for (int u = 1; u < Nu ; u+=4) { //da nos ind do user
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
            System.out.println("---Nova entrada---");
        }


        
        return 0;
    }

}
