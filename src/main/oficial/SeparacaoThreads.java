package main.oficial;

public class SeparacaoThreads {

  /**
   * Retorna um vetor de threads instanciado por N threads
   * @param nrThreads
   * @return
   */
  public Multithread[] setarThreads(int nrThreads){
    int[] partes;
    int pedacoDeLinha;
    int nrDelLinha;

    nrDelLinha = Data.MatrizEntrada[0].length;
    pedacoDeLinha = nrDelLinha / nrThreads;
    partes = new int[nrThreads + 1];

    for (int i = 0; i < partes.length; i++)
      partes[i] = pedacoDeLinha * (i);

    Multithread threads[] = new Multithread[nrThreads];

    for (int k = 0; k < threads.length; k++) {
      threads[k] = new Multithread(partes[k], partes[k + 1], nrThreads);
    }

    return threads;
  }
}
