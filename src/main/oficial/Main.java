package main.oficial;

import main.domain.modos.*;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Ignacio, Michel
 *  2,50
 *  0.60
 *  provas + atividades = 3.10
 *  trabalho precisa: 2.9/4.0  = 7,20
 *  pfv!"!!!!!!! presente de final de ano
 */

public class Main {
  static long valorTotal = 0;

  public static void main(String[] args) {
    int amostras = 20;
    for (int i = 0; i < amostras; i++) {
      executarRandomicoThread(1, false);
      Data.MatrizEntrada = new int[1000][1000];
      Data.MatrizSaida = new int[1000][1000];
      Data.VetorAuxiliar = new int[101];
    }

    System.out.println("valor total:" + valorTotal);
    System.out.println("Media>" + valorTotal/ amostras);
  }


  private static void executarRandomicoThread(int nr,boolean isEscrita) {
    SeparacaoThreads test = new SeparacaoThreads();
    Multithread threads[] = test.setarThreads(nr);
    long tempoInicial = System.currentTimeMillis();
    long tempoFinal = 0;
    System.out.println("\nInicio do processamento");
    ExecutorService pool = Executors.newFixedThreadPool(threads.length);
    for (int i = 0; i < threads.length; i++) {
      pool.execute(threads[i]);
    }
    pool.shutdown();
    try {
      boolean b = pool.awaitTermination(1, TimeUnit.DAYS);

    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      Ordenacao ordenacao = new Ordenacao();
      ordenacao.ordenarOtimizado();
      System.out.println("Final do process de preenchimento");
      tempoFinal = System.currentTimeMillis() - tempoInicial;
      System.out.printf("Tempo Final de Execução : %.3f ms%n\n", tempoFinal / 1000d);
      valorTotal = valorTotal + tempoFinal;
      if(isEscrita){
        System.out.println("Gravando No arquivo txt");
        Arquivo arquivo = new Arquivo();
        arquivo.imprimirMatriz(Data.MatrizSaida.length, Data.MatrizSaida, nr + "");
      }
    }
  }


}


