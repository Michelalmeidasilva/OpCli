package main.domain;

import main.external.Arquivo;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Config {
  private int nrDeLinhas ;
  private int pedacoDeColuna ;        //um pedaço das colunas exemplo uma matriz 1000X1000 e 4 threads entao tem 1000 colunas /4, logo serão 250 posições pra cada thread
  private int[] partes;
  private MatrizThread[] threads;
  private final boolean interactive;
  private   ModosInsercao modoInsercao;
  int tamanhoTotalLinhas;
  int tamanhoTotalColunas;


  HashMap<Integer, int[]> instanciacaoDeHashMap(int colunaInicial,int colunaFinal, HashMap<Integer, int[]> treeMap){
    for (int i = 0 ; i < tamanhoTotalLinhas; i ++){
      for (int j = colunaInicial; j < colunaFinal; j ++){
        int posicao = tamanhoTotalLinhas * i + j;
        treeMap.put(posicao, new int[]{i, j});
      }
    }
    return treeMap;
  }

  public Config(boolean interactive, ModosInsercao modoInsercao){
    this.modoInsercao = modoInsercao;
    this.interactive = interactive;
    System.out.println("Modo interactive:" + interactive );
    this.tamanhoTotalLinhas = Data.MatrizEntrada.length;
    this.tamanhoTotalColunas= Data.MatrizEntrada[0].length;
  }

  /**
   * Atributos de configuração da execução
   */
  private void setAtributtesBasedOnThreads(int nrThreads){
     int nrDeColunas ;
     threads = new MatrizThread[nrThreads];
     nrDeColunas = Data.MatrizEntrada[0].length;
     nrDeLinhas = Data.MatrizEntrada.length;
     pedacoDeColuna = nrDeColunas / nrThreads;        //um pedaço das colunas exemplo uma matriz 1000X1000 e 4 threads entao tem 1000 colunas /4, logo serão 250 posições pra cada threa
     partes = new int[nrThreads +1];

  }

  /**
   * Colocação de cada nova thread criada em um pool, as threads estão recebendo um vetor com a posição inicial e final
   * ( dando a ideia de cada uma thread executar uma parte do vetor
   * @return ExecutorService
   */
  private long execucaoPool(ModosInsercao modoInsercao){
    long tempoInicial = System.currentTimeMillis();
    if(interactive) System.out.println("Colunas : de x a y");
    long tempoFinal =0;

    for (int k = 0; k < threads.length; k++) {
      HashMap<Integer, int[]> auxiliar= instanciacaoDeHashMap(partes[k], partes[k+1], new HashMap<>());
      threads[k] = new MatrizThread(partes[k], partes[k + 1], interactive, modoInsercao, auxiliar);
      if(interactive) System.out.print(threads[k].colunaInicial + "-" + threads[k].colunaFinal + "|");
    }

    if(interactive) System.out.println("\nInicio do processamento");
    ExecutorService pool = Executors.newFixedThreadPool(threads.length);
    for (int i = 0; i < threads.length; i++){
      pool.execute(threads[i]);
    }
    pool.shutdown();

    try {
      boolean b = pool.awaitTermination(1, TimeUnit.DAYS);
      geraSaida();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      tempoFinal = System.currentTimeMillis() - tempoInicial;
      System.out.printf("Tempo Final de Execução : %.3f ms%n", tempoFinal / 1000d);
    }

    return tempoFinal;
  }

  /**
   * Definição das partes que vao ser divididas as colunas, o calculo é baseado no numero de thread
   */
  private void populatePartes(){
    for (int i = 0; i < partes.length; i++)
      partes[i] = pedacoDeColuna * (i);
  }

  /**
   * Executa o processamento com o numero baseado de threads setado
   * @param nrThreads
   */
  public void executionWithNumbersOfThreads(int nrThreads) {
    setAtributtesBasedOnThreads(nrThreads);
    populatePartes();

    long tempoFinal = execucaoPool(this.modoInsercao);

    System.out.println( "Gravando No arquivo txt");
    Arquivo arquivo = new Arquivo();
    arquivo.imprimirMatriz(Data.MatrizSaida.length, Data.MatrizSaida, nrThreads, tempoFinal, interactive);
  }

  /**
   * Ordenação da matriz
   */
  void geraSaida(){
    int indexI=0, indexJ=0;
    for(int organizer=0;organizer<100;organizer++){
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
