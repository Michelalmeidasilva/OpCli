package main.external;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {

  public void imprimirMatriz(int tamanho, int[][] matriz, int nrThreads, long tempoExecucao, boolean interactive){
    String curDir = System.getProperty("user.dir");
    System.out.println("Escrevendo no arquivo ...");
    String caminhoAbsoluto = curDir +"/"+ nrThreads+ "threads.txt";
    FileWriter arq = null;
    try {
      arq = new FileWriter(caminhoAbsoluto);
    } catch (IOException e) {
      e.printStackTrace();
    }
    PrintWriter gravarArq = new PrintWriter(arq);

    if(debug) gravarArq.println("\nPreenchimento com  " + nrThreads  + " threads, tempo final de "  + tempoExecucao / 1000d+"ms" )  ;

    for (int i=0; i<tamanho; i++) {
      for (int j = 0 ; j < matriz[i].length; j++){
        gravarArq.printf("%d|", matriz[i][j]);
      }
    }
    if(debug) gravarArq.println("\nPreenchimento com  " + nrThreads  + " threads, tempo final de "  + tempoExecucao / 1000d+"ms" )  ;

    try {
      arq.close();
      System.out.println("Escrita no arquivo finalizada, salvo em: " + caminhoAbsoluto);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
