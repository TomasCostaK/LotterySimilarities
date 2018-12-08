import java.util.*;
import java.io.*;

public class ModuloFinal {
    public static void main(String[] args) {
        int nfinal = 1725, flagmal=0, choice, nhf = 200, p = 10001, flagcontador = 0, flagbloom = 0;
        double thresh = 0.7;
        int[] B = new int[1725];
        Scanner kb = new Scanner(System.in);
        CountingBloomFilter myFilter = new CountingBloomFilter(0.8, 100000);
        
        try{
            do{
            menu();
            choice = kb.nextInt();
            System.out.println("");
            
            switch (choice) {
                case 1:
                    B = myFilter.startBloom("TextFiles/names.txt");
                    System.out.println("Bloom Iniciado, usa a opçao (2) para verificar alguma palavra");
                    flagbloom = 1;
                    break;
                    
                case 2:
                    if(flagbloom==1){
                        System.out.println("Que nome pretendes procurar?");
                        String palavra = kb.next();
                        myFilter.checkFilter(palavra, B);
                    }
                    else{
                        System.out.println("Inicia primeiro o bloom. Opção (1)");
                    }
                    break;
                    
                case 3:
                    if(flagbloom==1){
                        //Caso mais provavel
                        myFilter.checkSortudo("TextFiles/names.txt", B);
                    }
                    else{
                        System.out.println("Inicia primeiro o bloom. Opção (1)");
                    }
                    break;
                        
                case 4:
                    int n;
                    double na = 1400;
                    do{
                        System.out.println("O nosso dataset tem 1725 entradas.\nQuantas aproximadamente queres contabilizar? (Recomendamos 700+)");
                        n = kb.nextInt();
                        na = (double)n/1725;
                    }while( na<=0 || na>1 );
                    ContadorEstocastico contador = new ContadorEstocastico(na);
                    for (int i = 0; i < 1725; i++) {
                        contador.cont();
                    }
                    nfinal = contador.getCont();
                    flagcontador=1;
                    break;
                    
                case 5:;
                    if (flagcontador == 1) {
                        System.out.println("Vamos contabilizar " + nfinal);
                        do{
                            System.out.println("Qual a semelhança desejada? (0 a 1)");
                            thresh = kb.nextDouble();
                        }while( thresh<0 || thresh>1 );
                        Similares sm1 = new Similares(thresh, nhf, p, nfinal);
                        sm1.readToMapaFinal("TextFiles/LoteriaDataSet.csv");
                        sm1.calcDistanceFinal();
                    }
                    else{
                        System.out.println("Inicia primeiro o contador. Opção (3)");
                    }
                    break;
                    
                case 6:
                    System.out.println("Obrigado por experimentar!");
                    flagmal=1;
                    break;
                    
                default:
                    System.out.println("Opção inválida, escolhe outra.");
                    break;
                }
            }while(flagmal != 1);
        }catch(Exception e){
            System.out.println("Utiliza as opções disponiveis, erro: "+ e);
        }
       
        kb.close();
    }
    
    public static void menu() {
            System.out.println("");
            System.out.println("Choose from these choices");
            System.out.println("-------------------------");
            System.out.println("1 - Criar BloomFilter com vencedores do Mega Milhoes");
            System.out.println("2 - Verificar nome de vencedores");
            System.out.println("3 - Ver nome mais sortudo");
            System.out.println("4 - Definir número de sorteios ");
            System.out.println("5 - Semelhança da lotaria");
            System.out.println("6 - Sair do programa"); 
    }
}

