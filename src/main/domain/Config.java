package main.domain;

import main.external.Arquivo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Config {

  public void withNrX(int nrThreads,boolean interactive) {
    System.out.println("Modo interactive:" + interactive );
    MatrizThread[] threads = new MatrizThread[nrThreads];
    int nrDeColunas = Data.MatrizEntrada[0].length;
    int nrDeLinhas = Data.MatrizEntrada.length;
    int pedacoDeColuna = nrDeColunas / nrThreads;        //um pedaço das colunas exemplo uma matriz 1000X1000 e 4 threads entao tem 1000 colunas /4, logo serão 250 posições pra cada thread
    int partes[] = new int[nrThreads +1];

    /**
     * Definição das partes baseadas no numero de thread
     */
    for (int i = 0; i < partes.length; i++)
      partes[i] = pedacoDeColuna * (i);

    /**
     * Colocação de cada nova thread criada em um pool, as threads estão recebendo um vetor com a posição inicial e final
     * ( dando a ideia de cada uma thread executar uma parte do vetor
     */
    if(interactive) System.out.println("Colunas : de x a y");
    for (int k = 0; k < threads.length; k++) {
      threads[k] = new MatrizThread(partes[k], partes[k + 1], nrDeLinhas, Data.MatrizEntrada[0].length, interactive);
     if(interactive) System.out.print(threads[k].colunaInicial + "-" + threads[k].colunaFinal + "|");
    }
    if(interactive) System.out.println("\nInicio do processamento: com " + nrThreads + " threads");

    long tempoInicial = System.currentTimeMillis();
    long tempoFinal;

    ExecutorService pool = Executors.newFixedThreadPool(threads.length);
    for (int i = 0; i < threads.length; i++)
      pool.execute(threads[i]);

    pool.shutdown();

    try {
      pool.awaitTermination(1, TimeUnit.DAYS);
      geraSaida();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      tempoFinal = System.currentTimeMillis() - tempoInicial;
      System.out.printf("Tempo Final de Execução : %.3f ms%n", tempoFinal / 1000d);
      Arquivo arquivo = new Arquivo();
      arquivo.imprimirMatriz(Data.MatrizSaida.length, Data.MatrizSaida, nrThreads, tempoFinal, interactive);
    }
  }

  static int indexI=0;
  static int indexJ=0;

  void geraSaida(){
    int organizer;
    for(organizer=0;organizer<100;organizer++){
      for (int i = 0; i < 1000; i++) {
        for (int j = 0; j < 1000; j ++){
          if(Data.MatrizEntrada[i][j]==organizer){
            Data.MatrizSaida[indexI][indexJ]=Data.MatrizEntrada[i][j];
            indexJ++;
            if(indexJ==1000){
              indexJ=0;
              indexI++;
            }
          }
        }
      }
    }
  }

}
