package main;

import main.domain.Config;
import main.domain.modos.ModosInsercao;
import main.domain.modos.Sequencial;

/**
 * @author Ignacio, Michel
 *  2,50
 *  0.60
 *  provas + atividades = 3.10
 *  trabalho precisa: 2.9/4.0  = 7,20
 *  pfv!"!!!!!!! presente de final de ano
 */


public class Main {

  public static void main(String[] args) {
   executarSequencialmente();

//    executarRandomico1Thread();
//    executarRandomico2Thread();
//    executarRandomico4Thread();

  }

  public static void executarSequencialmente(){
    Sequencial executar = new Sequencial();
    executar.start();
  }

  public static void executarSemArvore(){

  }

//
  private static void executarRandomico4Thread() {
  }

  private static void executarRandomico2Thread() {
  }

  private static void executarRandomico1Thread() {
    Config config = new Config(false, ModosInsercao.randomico);
    config.executionWithNumbersOfThreads(4);
  }
}
