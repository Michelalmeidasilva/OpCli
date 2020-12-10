package main.domain.modos;

import main.domain.Data;

public class Ordenacao {

  public void ordenarMatriz() {
    System.out.println("\nOrdenando mono thread ...");
    int indexI = 0, indexJ = 0;
    for (int organizer = 0; organizer < 100; organizer++) {
      for (int i = 0; i < 1000; i++) {
        for (int j = 0; j < 1000; j++) {
          if (Data.MatrizEntrada[i][j] == organizer) {
            Data.MatrizSaida[indexI][indexJ] = Data.MatrizEntrada[i][j];
            indexJ++;
            if (indexJ == 1000) {
              indexJ = 0;
              indexI++;
            }
          }
        }
      }
    }
  }

}
