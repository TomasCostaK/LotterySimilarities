import java.util.*;

public class hashfunc {
    private int k,p,chave;
    private int[] r;

    public hashfunc(int p, int[] r){
        this.p = p;
        this.r = r;
    }

    //a fazer com inteiros apenas
    public int generate(int k, int chave){
        int hashcode = (r[k]*chave) % p;
        return hashcode;
    }
}