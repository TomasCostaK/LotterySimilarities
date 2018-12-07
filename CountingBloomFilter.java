package Projeto;

import java.util.*;

public class CountingBloomFilter {
    private int numElementos, sizeArr, hashFunctions;
    private double fatorC; //Fator carga
    
    public CountingBloomFilter(double fatorC, int numElementos, int hashFunctions){
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
			int h = (hashvalue % m) + 1; //+1 para o caso do resto = 0;
			bloomfilter[h] += 1; //Vai incrementar de modo a ficar o count no BloomFilter
		}
		return bloomfilter;
    }
    
    //Eliminar 1 ocorrência do elemento do CountingBloomFilter
    public int[] deleteElem(int[] bloomfilter, String elem) {
    	int m = bloomfilter.length;
    	for (int i = 0; i < this.hashFunctions; i++) {
			String elem2 = Integer.toString(i);
			String elem3 = elem + elem2;
			int hashvalue = string2hash(elem3);
			int h = (hashvalue % m) + 1; //+1 para o caso do resto = 0;
			if (bloomfilter[h] > 0) { //Caso seja <0 não podemos decrementar
				bloomfilter[h] -= 1; //Vai decrementar			
			}
			else {
				System.out.print("O elemento não pertence ao BloomFilter");
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
			int h = (hashvalue % m) + 1; //+1 para o caso do resto = 0;
			if (bloomfilter[h] > 0) { 
				bloomfilter[h] = 0; //O nº de ocorrências do elemento vai passar a ser 0			
			}
			else {
				System.out.println("O elemento não pertence ao BloomFilter");
			}
		}
    	return bloomfilter;
    }
    
    //Verificar se o BloomFilter contêm ou não o elemento e quantas vezes este já foi inserido
    public int contains(int[] bloomfilter, String elem) {
    	int m = bloomfilter.length;
    	int contains = 1;
    	int [] a = new int[this.hashFunctions];
    	int min = a[0];
    	
    	for (int i = 0; i < this.hashFunctions; i++) {
			String elem2 = Integer.toString(i);
			String elem3 = elem + elem2;
			int hashvalue = string2hash(elem3);
			int h = (hashvalue % m) + 1; //+1 para o caso do resto = 0;
			a[i] = bloomfilter[h]; //Vai incrementar de modo a ficar o count no BloomFilter
		}
    	
    	//Determinar o menor valor do array
    	for (int j = 0; j < a.length; j++) {
    		if(a[j] < min) {
    			min = a[j];
    		}
    	}
    	contains = min; //if contains = 0  -> o elem não pertence ao BloomFilter 
    	
    	return contains;
    }
}