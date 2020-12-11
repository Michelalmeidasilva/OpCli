package main.oficial;

import main.domain.modos.*;
import main.external.Arquivo;


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


  public static void main(String[] args) {
    executarRandomicoThread(4);
  }

  public static void executarSequencialmente2() {
    Monothread test = new Monothread();
    test.start();
  }

  private static void executarRandomicoThread(int nr) {
    SeparacaoThreads test = new SeparacaoThreads();
    Multithread threads[] = test.setarThreads(nr);
    long tempoInicial = System.currentTimeMillis();
    long tempoFinal = 0;
    System.out.println("Colunas : de x a y");
    System.out.println("\nInicio do processamento");
    ExecutorService pool = Executors.newFixedThreadPool(threads.length);
    for (int i = 0; i < threads.length; i++) {
      pool.execute(threads[i]);
    }
    pool.shutdown();
    try {
      boolean b = pool.awaitTermination(1, TimeUnit.DAYS);
      System.out.println("Final do process de preenchimento");
      tempoFinal = System.currentTimeMillis() - tempoInicial;
      System.out.printf("Tempo Final de Execução : %.3f ms%n", tempoFinal / 1000d);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      Ordenacao ordenacao = new Ordenacao();
      ordenacao.ordenarMatriz();
      System.out.println("Gravando No arquivo txt");
      Arquivo arquivo = new Arquivo();
      arquivo.imprimirMatriz(Data.MatrizSaida.length, Data.MatrizSaida, nr + "");
    }
  }


}


