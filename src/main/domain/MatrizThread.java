package main.domain;

import java.util.HashMap;
import java.util.Random;

public class MatrizThread extends  Thread{
  boolean interactive;
  int colunaInicial;
  int colunaFinal;
  int qtdRandomInt = 100;
  ModosInsercao modoInsercao;
  HashMap<Integer, int[]> treemap = new HashMap<>();
  int tamanhoTotalColunas;
  int tamanhoTotalLinhas;


//  TreeMap<Integer, int[]> treemap = new TreeMap<Integer, int[]>();  // alterações possiveis treeMap ou HashMap verificar melhor desempenho

  MatrizThread(int colunaInicial, int colunaFinal,  boolean interactive, ModosInsercao modoInsercao,  HashMap<Integer, int[]> treemap){
    this.colunaInicial = colunaInicial;
    this.colunaFinal = colunaFinal;
    this.interactive = interactive;
    this.modoInsercao = modoInsercao;
    this.treemap = treemap;
    this.tamanhoTotalLinhas = Data.MatrizEntrada.length;
    this.tamanhoTotalColunas= Data.MatrizEntrada[0].length;
  }

  /**
   * Carrega para uma arvore todas posições possiveis da matriz
   */




//  void preencherMatrizDiagonal() {
//    MatrizDiagonal matrizDiagonal = new MatrizDiagonal(interactive);
//    matrizDiagonal.execucao();
//  }

  /**
   * Aqui  tem todas as posições possiveis da matriz mapeados em uma arvore
   * entao em cada interação até a arvore for 0 ele verifica se existe a posição
   * e insere na matriz
   * Se a variavel interactive estiver com valor true ela imprime as posições randomicas que foram tentadas
   */
  void preencherMatrizRandomicamente(){
    System.out.println("Executando Preenchimento Randomico, aguarde um momento");
    System.out.print("...........");
    Random random = new Random();
    int tam = tamanhoTotalColunas * tamanhoTotalLinhas;
    if(interactive)
    {
      while(this.treemap.size() != 0){
        int randomico = (int) (Math.random() * (tam ));
        boolean contains = this.treemap.containsKey(randomico);
        int erros = 0;
        System.out.print("Tentativa na posicao:" + randomico);
        if(contains){
          System.out.print(" e contextoopa ocorreu um acerto na inserção desta posicao O/ \n");
          int linha = this.treemap.get(randomico)[0];
          int coluna = this.treemap.get(randomico)[1];
          Data.MatrizEntrada[linha][coluna] = random.nextInt(qtdRandomInt);
          treemap.remove(randomico);
        }else {
          erros++;
          System.out.print(" foi mal, ocorreu um erro na inserção ;( até agora há "+ erros + " erros acumulados\n");
        }
      }
    }
    else{

      while(treemap.size() != 0){
        int randomico = (int) (Math.random() * (tam ));
        if(treemap.containsKey(randomico) == true){
          int linha = treemap.get(randomico)[0];
          int coluna = treemap.get(randomico)[1];
          Data.MatrizEntrada[linha][coluna] = random.nextInt(qtdRandomInt);
          treemap.remove(randomico);
        }
      }
    }
    System.out.println("\nFinal da execução aguarde mais um momento ...");
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

//    if(modoInsercao == ModosInsercao.diagonal){
//      preencherMatrizDiagonal();
//    }

    if(modoInsercao == ModosInsercao.linhaXLinha){
      preencherMatrizLXL();
    }

    if(modoInsercao == ModosInsercao.colunaXColuna){
      preencherMatrizCXC();
    }
  }
}
