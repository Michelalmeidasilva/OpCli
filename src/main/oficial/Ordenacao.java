package main.oficial;

import main.oficial.Data;

public class Ordenacao {

  public void ordenarMatriz() {
    System.out.println("\nOrdenando mono thread ...");

    long tempoInicial = System.currentTimeMillis();
    long tempoFinal = 0;
    int indexI = 0, indexJ = 0;
    for (int organizer = 1; organizer < 101; organizer++) {
      for (int i = 0; i < Data.MatrizSaida.length; i++) {
        for (int j = 0; j < Data.MatrizSaida.length; j++) {
          if (Data.MatrizEntrada[i][j] == organizer) {
            Data.MatrizSaida[indexI][indexJ] = Data.MatrizEntrada[i][j];
            indexJ++;
            if (indexJ == Data.MatrizSaida.length) {
              indexJ = 0;
              indexI++;
            }
          }
        }
      }
    }
    System.out.println("Final do process de preenchimento");
    tempoFinal = System.currentTimeMillis() - tempoInicial;
    System.out.printf("Tempo Final de Execução : %.3f ms%n\n", tempoFinal / 1000d);

  }

}
