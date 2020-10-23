package main;

import main.domain.Config;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(name = "OpCli", mixinStandardHelpOptions = true, version = "OpCli 1.0",
  description = "Algoritmo de preenchimento de matriz com threads, desenvolvido por Michel Almeida da Silva e Ignacio Garcia.")

class App  implements Callable<Integer>  {
  @Option(names = { "-t", "--threads" },  description = "O numero de threads é baseado no numero informado")
  private int numberOfThreads = -1;

  @Option(names = { "-i", "--interactive" }, description = "Rodar a aplicação em modo interativo, neste modo uma flag booleana é ativa printando algumas partes da execução")
  private boolean interactive = false;

  @Option(names = {  "--randomico" }, description = "Preencher a matriz de forma randomica")
  private boolean randomico;

  @Option(names = {  "--diagonal" }, description = "Preencher a matriz em diagonal")
  private boolean diagonal;

  @Option(names = { "-p", "--processadorThreads" }, description = "O numero de threads é baseado no numero de cores do processador")
  private boolean processadorThread = false;


  public Integer call() {

    if (randomico) {
      System.out.println("preenchimento randomico:");
      return 0;
    }

    if (diagonal) {
      System.out.println("preenchimento diagonal:");
      return 0;
    }

    if (processadorThread) {
      Config config;
      int cores = Runtime.getRuntime().availableProcessors();
      System.out.println("Cores da sua maquina:" + cores);
      if (interactive == true) {
        config = new Config(interactive, 1);
        config.executionWithNumbersOfThreads(cores);
        return 0;
      }
      config = new Config(interactive, 1);
      config.executionWithNumbersOfThreads(cores);
      return 0;
    }

    if (numberOfThreads != -1) {
      Config config;
      if (interactive == true) {
        config = new Config(interactive, 1);
        config.executionWithNumbersOfThreads(numberOfThreads);
        return 0;
      }
      config = new Config(interactive , 1);
      config.executionWithNumbersOfThreads(numberOfThreads);
      return 0;
    }

    return 0;
  }

  public static void main(String[] args) {
    int rc = new CommandLine(new App()).execute(args);
    System.exit(rc);
  }
}