import java.util.*;
import java.math.*;

public class hashfunc {
    private String chave;
    private int nhf,k,p,hashCode;
    private int [] r;
    private static Random rand = new Random();

    public hashfunc(int nhf, String chave){
        this.chave = chave;
        this.nhf = nhf;
        r = new int[nhf];

        p=10001;
        for (int i = 0; i < nhf; i++) {
            int tmp = nextDouble(1.0)*p;
            //r[i] = tmp;
            System.out.println(tmp);
        }
    }

    //assumindo que r = nhf (nr de hash functions) (0...p-1)
    //p é primo
    public int generate(){
        hashCode=3;
        return hashCode;
    }
}