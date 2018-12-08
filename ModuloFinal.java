import java.util.*;
import java.io.*;

public class ModuloFinal {
    public static void main(String[] args) {
        int nhf = 200, p = 10001, max = 5;
        double thresh = 0.7;
        CountingBloomFilter myFilter = new CountingBloomFilter(0.8, 100000);
       
        //Counting BloomFilter working
        //int[] B = myFilter.startBloom("pg21209.txt");
        //myFilter.checkFilter("eBooks", B);

        

        //Similares sm1 = new Similares(thresh, nhf, p, max);

        //sm1.readToMapaFinal("LoteriaDataSet.csv");
        //sm1.calcDistanceFinal();
    }
}
