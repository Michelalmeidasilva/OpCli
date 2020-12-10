package main.domain.modos;
import main.domain.Data;
import java.util.HashMap;
import java.util.Random;

public class Randomico extends Thread{
  public int colunaInicial;
  public int colunaFinal;
  public int qtdRandomInt = 100;
  public ModosInsercao modoInsercao;
  public HashMap<Integer, int[]> treemap;
  public int tamanhoTotalColunas;
  public int tamanhoTotalLinhas;

  public Randomico(int colunaInicial, int colunaFinal, ModosInsercao modoInsercao, HashMap<Integer, int[]> treemap) {
    this.colunaInicial = colunaInicial;
    this.colunaFinal = colunaFinal;
    this.modoInsercao = modoInsercao;
    this.treemap = treemap;
    this.tamanhoTotalLinhas = Data.MatrizEntrada.length;
    this.tamanhoTotalColunas = Data.MatrizEntrada[0].length;
  }


  public Randomico(){

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


  public void startPreencherSemArvore(){
    long tempoInicial = System.currentTimeMillis();
    long tempoFinal = 0;
    for (int i = 0; i < Data.MatrizEntrada.length; i++) {
      for (int j = 0; j < Data.MatrizEntrada[i].length; j++) {
        Data.MatrizEntrada[i][j] = -1;
      }
    }
    preencherMatrizRandomicamenteSemArvore(1000000);
    Ordenacao ordenacao = new Ordenacao();
    ordenacao.ordenarMatriz();
    tempoFinal = System.currentTimeMillis() - tempoInicial;
    System.out.printf("Tempo Final de Execução : %.3f ms%n", tempoFinal / 1000d);
  }

  public void preencherMatrizRandomicamenteSemArvore(int count){
    System.out.println("Executando Preenchimento Sequencial, aguarde um momento ....");
    Random random = new Random();
    if(count == 0){
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

