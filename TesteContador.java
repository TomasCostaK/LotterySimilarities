import java.util.*;

public class TesteContador {
    public static void main(String[] args) {
        try {
            int x,max=100000;
            double prob=0.5;
            ContadorEstocastico e1 = new ContadorEstocastico(prob);
            for (int i=0;i<max ; i++) {
                e1.cont();
            }
            x=e1.getCont();

            //Calculamos sucesso aqui
            double suc = ((double) x) / max * 100;
            System.out.println(x + " -- " + suc + "%");
        } catch(ArithmeticException e){
            System.out.println("O maximo nao pode ser 0, exceçao : " + e);
        }
    }
    
}
