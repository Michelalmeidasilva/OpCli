package main.domain.modos;
import main.domain.Data;
import java.util.Random;

public class Multithread extends Thread{
  public int colunaMax = Data.MatrizEntrada.length;
  public int posicaoInicial;
  public int posicaoFinal;

  public Multithread(int posicaoInicial, int posicaoFinal){
    this.posicaoInicial = posicaoInicial;
    this.posicaoFinal= posicaoFinal;
  }

  public void preencher(){
    int count = posicaoFinal;
    Random gerador = new Random();
    Random geradorPosI = new Random();
    Random geradorPosJ = new Random();
    // 4 threads          0 250
    //                    1000
    while (count >0){
      for (int i = posicaoInicial; i < posicaoFinal; i++) {
        for (int j = 0; j < colunaMax; j++) {
          int posI =geradorPosI.nextInt(posicaoFinal);
          int posJ= geradorPosJ.nextInt(colunaMax);
          if(Data.MatrizEntrada[posI][posJ] == 0){
            Data.MatrizEntrada[posI][posJ]=gerador.nextInt(101);
            count --;
          }
        }
      }
    }
  }

  public Multithread(){

  }

  @Override
  public void run() {
    preencher();
    super.run();
  }
}
