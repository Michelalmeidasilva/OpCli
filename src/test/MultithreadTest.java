package test;

import main.domain.Config;
import main.domain.ModosInsercao;
import org.junit.Test;

public class MultithreadTest {


  @Test
  public void executarCom2ThreadsRandomicamente(){
    Config config = new Config(false, ModosInsercao.randomico);
    config.executionWithNumbersOfThreads(2);
  }
}
