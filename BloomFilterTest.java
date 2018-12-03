import java.util.*;

public class BloomFilterTest {
    private int numElementos, sizeArr;
    private double fatorC;
    final int [] bloomfilter;
    
    public BloomFilterTest(double fatorC, int numElementos){
        this.fatorC = fatorC;
        this.numElementos = numElementos;
        this.sizeArr = (int) Math.round( (double)numElementos/fatorC) ;
        System.out.println(sizeArr);
        bloomfilter = new int[sizeArr];
    }
    
    public void printBloom(){
        for(int val : bloomfilter){
            System.out.print(val + " -- ");
        }
    }
}
