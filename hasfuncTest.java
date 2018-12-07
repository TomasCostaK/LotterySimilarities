import java.util.*;

public class SimilaresTest {
    public static void main(String[] args) {
        int chave, p = 10001, nhf = 100;
        int[] r = new int[nhf];
        Random rand = new Random();
        
        //Prencher o vetor r com valores aleatorios
        for (int i = 0; i < nhf; i++) {
            r[i]= rand.nextInt(p)+1;
        }

        hashfunc h = new hashfunc(p, r);

        for (int i = 0; i < nhf; i++) {
            chave = rand.nextInt(1000)+1;
            int hashcode = h.generate(i, chave);
            System.out.println("HashIndex - " + hashcode);
        }
    }
}
