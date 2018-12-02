import java.util.*;

public class TesteContador {
    public static void main(String[] args) {
        try {
            int x,max=100000;
            double y,prob=0.5;
            contadorEstocastico e1 = new contadorEstocastico(prob,max);
            x=e1.getCont();
            y=e1.getSucesso();
            System.out.println(x + " -- " + y + "%");
        }catch(ArithmeticException e){
            System.out.println("O maximo nao pode ser 0, exceçao : " + e);
        }
    }
    
}
