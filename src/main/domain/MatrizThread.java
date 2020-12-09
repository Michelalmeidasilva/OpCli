package main.domain;

import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;

public class MatrizThread extends  Thread{
  boolean interactive;
  int colunaInicial;
  int colunaFinal;
  int tamanhoTotalLinhas;
  int tamanhoTotalColunas;
  int qtdRandomInt = 100;
  ModosInsercao modoInsercao;
//  TreeMap<Integer, int[]> treemap = new TreeMap<Integer, int[]>();  // alterações possiveis treeMap ou HashMap verificar melhor desempenho
  HashMap<Integer, int[]> treemap;

  MatrizThread(int colunaInicial, int colunaFinal,  boolean interactive, ModosInsercao modoInsercao){
    this.colunaInicial = colunaInicial;
    this.colunaFinal = colunaFinal;
    this.interactive = interactive;
    this.modoInsercao = modoInsercao;
  }

  /**
   * Carrega para uma arvore todas posições possiveis da matriz
   */
  void processamentoAuxiliar(){
    treemap = new HashMap<Integer, int[]>();
    for (int i = 0 ; i < tamanhoTotalLinhas; i ++){
      for (int j = colunaInicial; j < colunaFinal; j ++){
        int posicao = tamanhoTotalLinhas * i + j;
        treemap.put(posicao, new int[]{i, j});
      }
    }
  }

  void preencherMatrizDiagonal() {
    MatrizDiagonal matrizDiagonal = new MatrizDiagonal(interactive);
    matrizDiagonal.execucao();
  }

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
      while(treemap.size() != 0){
        int randomico = (int) (Math.random() * (tam ));
        boolean contains = treemap.containsKey(randomico) == true;
        int erros = 0;
        System.out.print("Tentativa na posicao:" + randomico);
        if(contains){
          System.out.print(" e contextoopa ocorreu um acerto na inserção desta posicao O/ \n");
          int linha = treemap.get(randomico)[0];
          int coluna = treemap.get(randomico)[1];
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
      processamentoAuxiliar();
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
