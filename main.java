package Projeto;
import java.util.*;

public class main {
	
	public static void main(String[] args) {
		
		//Defenir vari�veis
		String[] paises = new String[] {"Portugal", "Holanda", "Espanha", "Fran�a", "Alemanha", "Dinamarca"};
		String[] paises2 = new String[] {"Inglaterra","B�lgica","Portugal","Fran�a","Angola","Chile"};
		
		CountingBloomFilter myFilter = new CountingBloomFilter(0.2, 20, 3);
		
		//Inicializar
		int[] B = myFilter.inicialize();
	
		//Inserir 
		for (int i = 0; i < paises.length; i++) {
			B = myFilter.insert(B, paises[i]);
		}
		
//		/verificar
		for (int i = 0; i < paises2.length;i++) {
			int contains = myFilter.contains(B, paises[i]);
			System.out.println(contains);
		}
	}
}
