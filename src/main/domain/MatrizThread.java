package main.domain;

import java.util.Random;
import java.util.TreeMap;

public class MatrizThread extends  Thread{
  boolean interactive;
  int colunaInicial;
  int colunaFinal;
  int tamanhoTotalLinhas;
  int tamanhoTotalColunas;
  int qtdRandomInt = 100;
  TreeMap<Integer, int[]> treemap = new TreeMap<Integer, int[]>();

  MatrizThread(int colunaInicial, int colunaFinal, int tamanhoTotalLinhas, int tamanhoTotalColunas, boolean interactive){
    this.colunaInicial = colunaInicial;
    this.colunaFinal = colunaFinal;
    this.tamanhoTotalLinhas = tamanhoTotalLinhas;
    this.tamanhoTotalColunas= tamanhoTotalColunas;
    this.interactive = interactive;
  }

  /**
   * Carrega para uma arvore todas posições possiveis da matriz
   */
  void processamentoAuxiliar(){
    for (int i = 0 ; i < tamanhoTotalLinhas; i ++){
      for (int j = colunaInicial; j < colunaFinal; j ++){
        int posicao = tamanhoTotalLinhas * i + j;
        treemap.put(posicao, new int[]{i, j});
      }
    }
  }

  void preencherMatrizDiagonal() {

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
          System.out.print(" opa ocorreu um acerto na inserção desta posicao O/ \n");
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

  public void run (){
    processamentoAuxiliar();
    preencherMatrizRandomicamente();
//    preencherMatrizDiagonal();
  }
}
