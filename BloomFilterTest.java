import java.util.*;

public class BloomFilterTest {
    private int numElementos, sizeArr;
    private double probFalso;
    final int [] bloomfilter;
    
    public BloomFilterTest(double probFalso, int numElementos){
        this.probFalso = probFalso;
        this.numElementos = numElementos;
        this.sizeArr = numElementos*3;
        System.out.println(sizeArr);
        bloomfilter = new int[sizeArr];
    }
    
    public void initialize(){
        for (int i = 0; i < sizeArr; i++) {
            bloomfilter[i]=0;
        }
    }    
    
    public void printBloom(){
        for(int val : bloomfilter){
            System.out.print(val + " -- ");
        }
    }
}
