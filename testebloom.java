import java.util.*;
import java.io.*;

public class testebloom {
	public static void main(String[] args) {
		
                int[] B;
		//Defenir vari�veis
		//String[] paises = new String[] {"Portugal", "Espanha", "Franca","Portugal", "Alemanha", "Dinamarca"};
		//String[] paises2 = new String[] {"Portugal","Bélgica","Inglaterra","Franca","Angola","Chile"};
		
		CountingBloomFilter myFilter = new CountingBloomFilter(0.8, 1000000);
		
                B = myFilter.startBloom("TextFiles/pg21209.txt");
//		/verificar
		for (int i = 0; i < B.length ;i++) {
				Scanner sc1 = new Scanner(System.in);
				//System.out.println("Qual a palavra?");
				String chosen = "amigosole";

				int contains = myFilter.contains(B, chosen);
				if (contains > 0) {
					System.out.println(chosen+ " deve pertencer " + contains + " vezes.");
				}

				else{
					System.out.println(chosen + " não pertence.");
				}

		}
	}
}
