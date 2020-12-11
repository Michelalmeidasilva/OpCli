package main;

import main.domain.Data;
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
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      Ordenacao ordenacao = new Ordenacao();
      ordenacao.ordenarMatriz();
      tempoFinal = System.currentTimeMillis() - tempoInicial;
      System.out.printf("Tempo Final de Execução : %.3f ms%n", tempoFinal / 1000d);
    }
  }

  private static void startPreencherSemArvore () {
    for (int i = 0; i < Data.MatrizEntrada.length; i++) {
      for (int j = 0; j < Data.MatrizEntrada[i].length; j++) {
        Data.MatrizEntrada[i][j] = 0;
      }
    }
    Randomico rd = new Randomico();
    rd.startPreencherSemArvore();
  }

}


