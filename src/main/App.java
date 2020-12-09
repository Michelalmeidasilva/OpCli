//package main;
//
//import main.domain.Config;
//import main.domain.ModosInsercao;
//import picocli.CommandLine;
//import picocli.CommandLine.Command;
//import picocli.CommandLine.Option;
//
//import java.util.concurrent.Callable;
//
//@Command(name = "OpCli", mixinStandardHelpOptions = true, version = "OpCli 1.0",
//  description = "Algoritmo de preenchimento de matriz com threads\ndesenvolvido por Michel Almeida da Silva e Ignacio Garcia.\nAcesse o repositorio com codigo fonte em:\nhttps://github.com/Michelalmeidasilva/OpCli")
//
//class App  implements Callable<Integer>  {
//  @Option(names = { "-t", "--threads" },  description = "O numero de threads é baseado no numero informado")
//  private int numberOfThreads = -1;
//
//  @Option(names = { "-i", "--interactive" }, description = "Rodar a aplicação em modo interativo, neste modo uma flag booleana é ativa printando algumas partes da execução")
//  private boolean interactive = false;
//
//
//  @Option(names = {  "--randomico" }, description = "Preencher a matriz de forma randomica")
//  private boolean randomico;
//
//  @Option(names = {  "--diagonal" }, description = "Preencher a matriz em diagonal")
//  private boolean diagonal;
//
//  @Option(names = {  "--linhaporlinha" }, description = "Preencher a matriz em linha por linha")
//  private boolean linhaPorLinha;
//
//  @Option(names = {  "--colunaPorColuna" }, description = "Preencher a matriz em coluna por coluna")
//  private boolean colunaPorColuna;
//
//  @Option(names = { "-p", "--processadorThreads" }, description = "O numero de threads é baseado no numero de cores do processador")
//  private boolean processadorThread = false;
//
//
//  public Integer call() {
//
//    if (colunaPorColuna ) {
//      System.out.println("Por padrão o modo coluna por coluna está setado com 1 thread apenas");
//      Config config= new Config(interactive, ModosInsercao.diagonal);
//      config.executionWithNumbersOfThreads(1);
//      return 0;
//    }
//
//    if (linhaPorLinha ) {
//      System.out.println("Por padrão o modo linhaPorLinha está setado com 1 thread apenas");
//      Config config= new Config(interactive, ModosInsercao.diagonal);
//      config.executionWithNumbersOfThreads(1);
//      return 0;
//    }
//
//    if (diagonal && interactive ) {
//        System.out.println("Por padrão o modo diagonal está setado com 1 thread apenas");
//        Config config= new Config(interactive, ModosInsercao.diagonal);
//        config.executionWithNumbersOfThreads(1);
//        return 0;
//    }
//
//    if(diagonal && interactive == false){
//      System.out.println("Por padrão o modo diagonal está setado com 1 thread apenas");
//      Config config= new Config(false, ModosInsercao.diagonal);
//      config.executionWithNumbersOfThreads(1);
//      return 0;
//    }
//
//    if(randomico && numberOfThreads == -1 ){
//      System.out.println("Para o modo randomico voce deve selecionar a quantidade de   opção --threads (nrThreads) ou -t (nrThreads)");
//    }
//
//    if (randomico && numberOfThreads != -1) {
//      Config config;
//      if (interactive == true) {
//        config = new Config(interactive, ModosInsercao.randomico);
//        config.executionWithNumbersOfThreads(numberOfThreads);
//        return 0;
//      }
//      config = new Config(interactive , ModosInsercao.randomico);
//      config.executionWithNumbersOfThreads(numberOfThreads);
//      return 0;
//    }
//
//    if (processadorThread) {
//      Config config;
//      int cores = Runtime.getRuntime().availableProcessors();
//      System.out.println("Cores da sua maquina:" + cores);
//      if (interactive == true) {
//        config = new Config(interactive, ModosInsercao.randomico);
//        config.executionWithNumbersOfThreads(cores);
//        return 0;
//      }
//      config = new Config(interactive, ModosInsercao.randomico);
//      config.executionWithNumbersOfThreads(cores);
//      return 0;
//    }
//    return 0;
//  }
//
//  public static void main(String[] args) {
//    int rc = new CommandLine(new App()).execute(args);
//    System.exit(rc);
//  }
//}