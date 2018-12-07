import java.util.*;

public class CountingBloomFilter {
    private int numElementos, sizeArr, hashFunctions;
	private double fatorC; //Fator carga
    
    public CountingBloomFilter(double fatorC, int numElementos){
        this.fatorC = fatorC;
        this.numElementos = numElementos;
        this.sizeArr = (int) Math.round( (double)numElementos/fatorC) ;
        this.hashFunctions = (int) Math.round((sizeArr / numElementos) * Math.log(2));
    }
    
    //Inicialize BloomFilter
    public int[] inicialize () {
    	int[] bloomfilter = new int[this.sizeArr];
    	return bloomfilter;
    }
    
    //String2Hash
    public  int string2hash(String str) {
		int hashvalue = str.hashCode();
		return hashvalue;
	}
    
    //Inserir elemento no CountingBloomFilter
    public int[] insert(int[] bloomfilter, String elem) {
    	int m = bloomfilter.length;
		for (int i = 0; i < this.hashFunctions; i++) {
			String elem2 = Integer.toString(i);
			String elem3 = elem + elem2;
			int hashvalue = string2hash(elem3);
			int h = Math.abs((hashvalue % m));
			bloomfilter[h] += 1; //Vai incrementar de modo a ficar o count no BloomFilter
		}
		return bloomfilter;
    }
    
    //Eliminar 1 ocorr�ncia do elemento do CountingBloomFilter
    public int[] deleteElem(int[] bloomfilter, String elem) {
    	int m = bloomfilter.length;
    	for (int i = 0; i < this.hashFunctions; i++) {
			String elem2 = Integer.toString(i);
			String elem3 = elem + elem2;
			int hashvalue = string2hash(elem3);
			int h = Math.abs(hashvalue % m);
			if (bloomfilter[h] > 0) { //Caso seja <0 n�o podemos decrementar
				bloomfilter[h] -= 1; //Vai decrementar			
			}
			else {
				System.out.print("O elemento n�o pertence ao BloomFilter");
			}
		}
    	return bloomfilter;
    }
    
  //Eliminar todos os elementos iguais do CountingBloomFilter
    public int[] deleteAll(int[] bloomfilter, String elem) {
    	int m = bloomfilter.length;
    	for (int i = 0; i < this.hashFunctions; i++) {
			String elem2 = Integer.toString(i);
			String elem3 = elem + elem2;
			int hashvalue = string2hash(elem3);
			int h = Math.abs(hashvalue % m);
			if (bloomfilter[h] > 0) { 
				bloomfilter[h] = 0; //O n� de ocorr�ncias do elemento vai passar a ser 0			
			}
			else {
				System.out.println("O elemento n�o pertence ao BloomFilter");
			}
		}
    	return bloomfilter;
    }
    
    //Verificar se o BloomFilter cont�m ou n�o o elemento e quantas vezes este j� foi inserido
    public int contains(int[] bloomfilter, String elem) {
    	int m = bloomfilter.length;
    	int contains = 1;
    	int [] a = new int[this.hashFunctions];
    	
    	for (int i = 0; i < this.hashFunctions; i++) {
			String elem2 = Integer.toString(i);
			String elem3 = elem + elem2;
			int hashvalue = string2hash(elem3);
			int h = Math.abs(hashvalue % m);
			a[i] = bloomfilter[h]; //Vai incrementar de modo a ficar o count no BloomFilter
		}

		int min = a[0];

    	//Determinar o menor valor do array
    	for (int j = 0; j < a.length; j++) {
    		if(a[j] < min) {
    			min = a[j];
    		}
    	}
    	contains = min; //if contains = 0  -> o elem n�o pertence ao BloomFilter 
    	
    	return contains;
    }
}