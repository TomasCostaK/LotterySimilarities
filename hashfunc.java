import java.util.*;

public class hashfunc {
    private int k,p,chave;
    private int[] r;
    private int[] r2;

    public hashfunc(int p, int[] r, int[] r2){
        this.p = p;
        this.r = r;
        this.r2 = r2;
    }

    //a fazer com inteiros apenas
    public int generate(int k, int chave){
        int hashcode = (r[k]*chave) % p;
        return hashcode;
    }

    public int generate2(int k, int chave){
        int hashcode = (r[k]*chave + r2[k]) % p;
        return hashcode;
    }
}