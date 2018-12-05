import java.util.*;

public class contadorEstocastico {
    private static int cont=0;
    private static Random rand = new Random();
    private double numRan;
    private double prob;

    public contadorEstocastico(double prob){
        this.prob = prob;
        this.cont = cont;
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
