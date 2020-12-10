package main.domain.modos;

import main.domain.Data;
import main.domain.modos.ModosInsercao;

import java.util.HashMap;
import java.util.Random;

public class RandomicoParalelo extends Thread{
  public int colunaInicial;
  public int colunaFinal;
  public int qtdRandomInt = 100;
  public ModosInsercao modoInsercao;
  public HashMap<Integer, int[]> treemap;
  public int tamanhoTotalColunas;
  public int tamanhoTotalLinhas;

  public RandomicoParalelo(int colunaInicial, int colunaFinal, ModosInsercao modoInsercao, HashMap<Integer, int[]> treemap) {
    this.colunaInicial = colunaInicial;
    this.colunaFinal = colunaFinal;
    this.modoInsercao = modoInsercao;
    this.treemap = treemap;
    this.tamanhoTotalLinhas = Data.MatrizEntrada.length;
    this.tamanhoTotalColunas = Data.MatrizEntrada[0].length;
  }

  public void preencherMatrizRandomicamente() {
    System.out.println("Executando Preenchimento Randomico, aguarde um momento ....");
    Random random = new Random();
    int tam = tamanhoTotalColunas * tamanhoTotalLinhas;
    while (treemap.size() != 0) {
      int randomico = (int) (Math.random() * (tam));
      if (treemap.containsKey(randomico)) {
        int linha = treemap.get(randomico)[0];
        int coluna = treemap.get(randomico)[1];
        Data.MatrizEntrada[linha][coluna] = random.nextInt(qtdRandomInt);
        treemap.remove(randomico);
      }
    }
  }

  public void preencherMatrizRandomicamenteSemArvore(int count){
    System.out.println("Executando Preenchimento Sequencial, aguarde um momento ....");
    Random random = new Random();
    if(count <= 0){
      return;
    }
    for (int i = 0; i < Data.MatrizEntrada.length; i++) {
      for (int j = 0; j < Data.MatrizEntrada[i].length; j++) {

        int posI = random.nextInt(1000);
        int posJ = random.nextInt(1000);
        if(Data.MatrizEntrada[posI][posJ] == -1){
          count --;
          Data.MatrizEntrada[posI][posJ] = random.nextInt(100);
        }

      }
    }
    if(count > 0){
      preencherMatrizRandomicamenteSemArvore(count);
    }
  }

}

