package main.domain.modos;

import main.domain.Data;
import main.external.Arquivo;

import java.util.Random;

public class Sequencial {

  public void start(){
    long tempoInicial = System.currentTimeMillis();
    long tempoFinal = 0;

    System.out.println("\nInicio do processamento");

    preencherMatrizSequencialmente(1000000);
    Ordenacao ordenar = new Ordenacao();
    ordenar.ordenarMatriz();
    tempoFinal = System.currentTimeMillis() - tempoInicial;

    System.out.printf("Tempo Final de Execução : %.3f ms%n", tempoFinal / 1000d);

    Arquivo arquivo = new Arquivo();

    System.out.println("Gravando No arquivo txt");
    arquivo.imprimirMatriz(Data.MatrizSaida.length, Data.MatrizSaida, "Sequencial");
  }


  void preencherMatrizSequencialmente(int count){
    System.out.println("Executando Preenchimento Sequencial, aguarde um momento ....");
    Random random = new Random();
    for (int i = 0; i < Data.MatrizEntrada.length; i++) {
      for (int j = 0; j < Data.MatrizEntrada[i].length; j++) {
        Data.MatrizEntrada[i][j] = random.nextInt(100);
      }
    }
  }

  void preencherMatrizCXCSequencial(int colunaInicial, int colunaFinal) {
    int rand;
    for (int i = colunaInicial; i < colunaFinal; i++) {
      for (int j = 0; j < colunaFinal; j++) {
        rand = (int) (Math.random() * 100);
        while (rand == 0) {
          rand = (int) (Math.random() * 100);
        }
        Data.MatrizEntrada[i][j] = rand;
      }
    }
  }

  void preencherMatrizLXLSequencial(int tamanhoTotalLinhas, int tamanhoTotalColunas) {
    int rand;
    for (int i = 0; i < tamanhoTotalLinhas; i++) {
      for (int j = 0; j < tamanhoTotalColunas; j++) {
        rand = (int) (Math.random() * 100);
        while (rand == 0) {
          rand = (int) (Math.random() * 100);
        }
        Data.MatrizEntrada[j][i] = rand;
      }
    }
  }



}
