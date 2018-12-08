import java.util.*;

public class ContadorEstocastico {
    private int cont=0;
    private static Random rand = new Random();
    private double numRan;
    private double prob;

    public ContadorEstocastico(double prob){
        this.prob = prob;
    }
    
    public void cont(){
        numRan = rand.nextDouble();
            if (numRan < prob) {
                cont++;
            }
    }

    public int getCont(){
        return this.cont;
    }
    
}
