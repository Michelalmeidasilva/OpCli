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

  /**
   * METODO SEQUENCIAL com 1/2/4/8 thread FORÇANDO REPETIÇÃO ( FORÇA BRUTA )
   * Sem Arvore
   * acesso O(n²)
   */

  /**
   * METODO Paralelo Randomico 1 com 1/2/4/8 thread FORÇANDO REPETIÇÃO ( FORÇA BRUTA )
   * com arvore
   *    explicação:
   *    * O randomico é em cima de cada tentativa de 0 a 1000000, portanto cada thread faz de 0  a 1000000
   *    * 0 a 250000
   *    * 250000 a 500000
   *    * 500000 a 750000
   *    * 750000 a 100000
   * acesso O(log n)
   */

  /**
   * METODO Paralelo Randomico 1 com 1/2/4/8 thread FORÇANDO REPETIÇÃO ( FORÇA BRUTA )
   * com Tabela Hash
   *    explicação:
   *    * O randomico é em cima de cada tentativa de 0 a 1000000, portanto cada thread faz de 0  a 1000000
   *    * 0 a 250000
   *    * 250000 a 500000
   *    * 500000 a 750000
   *    * 750000 a 100000
   * acesso O(1)
   */


  /**
   * METODO Paralelo Randomico 1 com 1/2/4/8 thread EVITANDO REPETIÇÃO
   *    explicação:
   *    * O randomico é em cima de cada tentativa de inicial até o tam final , portanto cada thread faz de tamanho inicial ao tamanho final designado
   * Distribuir um intervalo a cada thread
   *
   *          Pararelo diminuindo a ocorrencia de repetições
   *          0 a 250000         cada thread faz de 0  a 2500000
   *          250000 a 500000      250000  a 500000
   *          500000 a 750000      500000  a 500000
   *          750000 a 100000      750000  a 500000
   * arvore: acesso O(log n)
   * hash: O(1)
   */


  /**
   * DIMINUIÇÂO REPETIÇÂO
   * procurar outra forma de embaralhar o vetor ou algo assim
   */


  /**
   * Forma do Thiago leal
   * 0  a 1.000.000
   * O vetor é embaralhado e as posições sao retiradas dele
   */


  /**
   * Tentar enxergar alguma forma de ordenar paralelamente com pilha, arvore ou algo assim
   */

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

  /***
   *
   *
   */


  /**
   * Teste
   */
  void preencherMatrizSequencial(){
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


  void preencherMatrizCXCSequencial(){
    int rand;
    for(int i=colunaInicial;i<colunaFinal;i++){
      for(int j=0;j<colunaFinal;j++){
        rand=(int)(Math.random()*100);
        while(rand==0){
          rand=(int)(Math.random()*100);
        }
        Data.MatrizEntrada[i][j]=rand;
      }
    }
  }

  void preencherMatrizLXLSequencial(){
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
      preencherMatrizLXLSequencial();
    }

    if(modoInsercao == ModosInsercao.colunaXColuna){
      preencherMatrizCXCSequencial();
    }
  }
}
