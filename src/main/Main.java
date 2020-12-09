package main;

import main.domain.Config;
import main.domain.ModosInsercao;

public class Main {
  public static void main(String[] args) {
    executarRandomico1Thread();
  }

  private static void executarRandomico1Thread() {
    Config config = new Config(false, ModosInsercao.randomico);
    config.executionWithNumbersOfThreads(1);
  }
}
