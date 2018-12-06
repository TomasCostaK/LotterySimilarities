import java.util.*;
import java.io.*;

public class Similares {    
    private int nhf, p, max, users, Nu;
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
    
    public void readToMapa(String filename){
        try (BufferedReader br = new BufferedReader(new FileReader(filename)) ) {
            for (String line = null; (line = br.readLine()) != null;) {
                args = line.split("\\t");
                int user = Integer.parseInt(args[0]);
                int filme = Integer.parseInt(args[1]);

                ArrayList<Integer> list;
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
            System.out.println(Mapa);
        } catch (Exception e) {
            System.out.println("Error opening file, exception " + e);
        }
    }
}
