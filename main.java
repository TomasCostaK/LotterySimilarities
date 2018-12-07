import java.util.*;
import java.io.*;

public class main {
	public static void main(String[] args) {
		
		//Defenir vari�veis
		//String[] paises = new String[] {"Portugal", "Espanha", "Franca","Portugal", "Alemanha", "Dinamarca"};
		//String[] paises2 = new String[] {"Portugal","Bélgica","Inglaterra","Franca","Angola","Chile"};
		
		CountingBloomFilter myFilter = new CountingBloomFilter(0.8, 1000000);
		
		//Inicializar
		int[] B = myFilter.inicialize();
	
		//Inserir 
        try {
			File file = new File("pg21209.txt");
			Scanner sc = new Scanner(file);


			while (sc.hasNext()) {
				String palavra = sc.next();
				B = myFilter.insert(B, palavra);
				System.out.println(palavra + " foi adicionada ao bloomfilter.");
			}
			sc.close();

		} catch (Exception e) {
			System.out.println("Deu erro " + e);
		}
		
//		/verificar
		//for (int i = 0; i < paises2.length;i++) {
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

		//}
	}
}
