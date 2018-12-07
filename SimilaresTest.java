import java.util.*;

public class SimilaresTest {
    public static void main(String[] args) {
        int nhf = 100, p = 10001, max = 5;
        double thresh = 0.4;

        Similares sm1 = new Similares(thresh, nhf, p, max);

        //Ler para o mapa
        sm1.readToMapa("u.data");
        sm1.calcDistance();
    }
}
