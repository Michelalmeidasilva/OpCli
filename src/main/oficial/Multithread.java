package main.oficial;
import main.oficial.Data;
import java.util.Random;

public class Multithread extends Thread{
  public int colunaMax = Data.MatrizEntrada[0].length;
  public int linhaMax= Data.MatrizEntrada.length;
  public int posicaoInicial;
  public int posicaoFinal;
  public int nrThreads;

  public Multithread(int posicaoInicial, int posicaoFinal, int nrThreads){
    this.posicaoInicial = posicaoInicial;
    this.posicaoFinal= posicaoFinal;
    this.nrThreads = nrThreads;
  }

  public void preencher(){
    Random gerador = new Random();
    int tam = (linhaMax * colunaMax) / nrThreads;
    int count=0,linha,coluna;
    Random geradorLinha = new Random();
    Random geradorColuna = new Random();
    while (count!=tam){
      linha =  geradorLinha.nextInt(posicaoFinal - posicaoInicial) + posicaoInicial;
      coluna = geradorColuna.nextInt(colunaMax);
      if (Data.MatrizEntrada[linha][coluna] == 0) {
        Data.MatrizEntrada[linha][coluna] = gerador.nextInt(100)+1;
        count++;
      }}
  }

  @Override
  public void run() {
    preencher();
    super.run();
  }
}
