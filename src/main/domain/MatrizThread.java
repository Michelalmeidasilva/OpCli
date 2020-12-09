package main.domain;

import java.util.HashMap;
import java.util.Random;

public class MatrizThread extends  Thread{
  int colunaInicial;
  int colunaFinal;
  int qtdRandomInt = 100;
  ModosInsercao modoInsercao;
  HashMap<Integer, int[]> treemap ;
  int tamanhoTotalColunas;
  int tamanhoTotalLinhas;

  MatrizThread(int colunaInicial, int colunaFinal, ModosInsercao modoInsercao,  HashMap<Integer, int[]> treemap){
    this.colunaInicial = colunaInicial;
    this.colunaFinal = colunaFinal;
    this.modoInsercao = modoInsercao;
    this.treemap = treemap;
    this.tamanhoTotalLinhas = Data.MatrizEntrada.length;
    this.tamanhoTotalColunas= Data.MatrizEntrada[0].length;
  }

  void preencherMatrizDiagonal() {
    MatrizDiagonal matrizDiagonal = new MatrizDiagonal();
    matrizDiagonal.execucao();
  }

  /**
   * Aqui  tem todas as posições possiveis da matriz mapeados em uma arvore
   * entao em cada interação até a arvore for 0 ele verifica se existe a posição
   * e insere na matriz
   * Se a variavel interactive estiver com valor true ela imprime as posições randomicas que foram tentadas
   */
  void preencherMatrizRandomicamente(){
    System.out.println("Executando Preenchimento Randomico, aguarde um momento ....");
    Random random = new Random();
    int tam = tamanhoTotalColunas * tamanhoTotalLinhas;
      while(treemap.size() != 0){
        int randomico = (int) (Math.random() * (tam ));
        if(treemap.containsKey(randomico)){
          int linha = treemap.get(randomico)[0];
          int coluna = treemap.get(randomico)[1];
          Data.MatrizEntrada[linha][coluna] = random.nextInt(qtdRandomInt);
          treemap.remove(randomico);
        }
      }
  }


  void preencherMatrizCXC(){
    int rand;
    for(int i=0;i<tamanhoTotalLinhas;i++){
      for(int j=0;j<tamanhoTotalColunas;j++){
        rand=(int)(Math.random()*100);
        while(rand==0){
          rand=(int)(Math.random()*100);
        }
        Data.MatrizEntrada[i][j]=rand;
      }
    }
  }

  void preencherMatrizLXL(){
    int rand;
    for(int i=0;i<tamanhoTotalLinhas;i++){
      for(int j=0;j<tamanhoTotalColunas;j++){
        rand=(int)(Math.random()*100);
        while(rand==0){
          rand=(int)(Math.random()*100);
        }
        Data.MatrizEntrada[j][i]=rand;
      }
    }
  }

  public void run (){

    if(modoInsercao == ModosInsercao.randomico){
      preencherMatrizRandomicamente();
    }

    if(modoInsercao == ModosInsercao.diagonal){
      preencherMatrizDiagonal();
    }

    if(modoInsercao == ModosInsercao.linhaXLinha){
      preencherMatrizLXL();
    }

    if(modoInsercao == ModosInsercao.colunaXColuna){
      preencherMatrizCXC();
    }
  }
}
