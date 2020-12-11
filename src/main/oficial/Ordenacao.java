package main.oficial;

public class Ordenacao {

  public void ordenarMatriz() {
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
  }

  public void ordenarOtimizado() {
    System.out.println("Ordenando otimizado...");
    int msI = 0, msJ = 0;
    int found, qtValor;
    for (int i = 0; i < 1000; i++) {
      for (int j = 0; j < 1000; j++) {
        found = Data.MatrizEntrada[i][j];
        Data.VetorAuxiliar[found] = Data.VetorAuxiliar[found] + 1;
      }
    }
    for (int x = 1; x <= 100; x++) {
      qtValor = Data.VetorAuxiliar[x];
      for (int y = 0; y < qtValor; y++) {
        Data.MatrizSaida[msI][msJ] = x;
        msJ++;
        if (msJ == 1000) {
          msJ = 0;
          msI++;
        }
      }
    }
  }
}
