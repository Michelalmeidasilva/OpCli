package main;

import main.domain.Config;
import main.domain.ModosInsercao;

public class Main {
  public static void main(String[] args) {
    Config config = new Config(false, ModosInsercao.randomico);
    config.executionWithNumbersOfThreads(1);
  }
}
