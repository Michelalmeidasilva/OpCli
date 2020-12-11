package main.domain.modos;
import main.domain.Data;

public class SeparacaoThreads {

  /**
   * Retorna um vetor de threads instanciado por N threads
   * @param nrThreads
   * @return
   */
  public Multithread[] setarThreads(int nrThreads){
    int[] partes;
    int pedacoDeColuna;
    int nrDeColunas;

    nrDeColunas = Data.MatrizEntrada[0].length;
    pedacoDeColuna = nrDeColunas / nrThreads;
    partes = new int[nrThreads + 1];

    for (int i = 0; i < partes.length; i++)
      partes[i] = pedacoDeColuna * (i);

    Multithread threads[] = new Multithread[nrThreads];

    for (int k = 0; k < threads.length; k++) {
      threads[k] = new Multithread(partes[k], partes[k + 1]);
    }

    return threads;
  }
}
