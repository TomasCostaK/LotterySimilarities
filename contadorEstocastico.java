import java.util.*;

public class contadorEstocastico {
    private int max, cont=0;
    private static Random rand = new Random();
    private double numRan;
    private double prob;

    public contadorEstocastico(double prob, int max){
        this.prob = prob;
        this.max = max;
        for (int i = 0; i < max; i++) {
            numRan = rand.nextDouble();
            if (numRan < prob) {
                cont++;
            }
        }
    }
    
    public int getCont(){
        return this.cont;
    }
    
    public double getSucesso(){
        double suc = (double)this.cont/(double)max;
        return 100*suc;
    }
    
}
