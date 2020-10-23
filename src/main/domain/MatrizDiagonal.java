package main.domain;

import java.util.Random;

public class MatrizDiagonal {

  final String ANSI_RED = "\u001B[31m";
  final String ANSI_RESET = "\u001B[0m";
  final String ANSI_WHITE = "\u001B[37m";
  boolean interactive;

  MatrizDiagonal(boolean interactive){
    this.interactive = interactive;
  }

  public void execucao(){
    int i = 0, j = 0;
    int tam = 0;
    if(interactive){
      int matriz[][]= new int[10][10];
      preenchePrimeiraParte(i, j, tam, matriz);
      preencheSegundaParte(i, j, tam, matriz);
    }else {
      preenchePrimeiraParte(i, j, tam, Data.MatrizEntrada);
      preencheSegundaParte(i, j, tam, Data.MatrizEntrada);
    }

  }

  void preenchePrimeiraParte(int i, int j, int tam, int matriz [][]){
    Random random = new Random();
    System.out.print("Preenchimento Diagonal .....");
    for (;  ; tam++ ) {
      j = matriz.length - 1;
      i = tam;
      for (int o = 0; o <= tam; o++){
        if(interactive) matriz[i][j] = 1;
        else matriz[i][j] = random.nextInt(100);
        j -- ;
        i -- ;
        if( i < 0) break;
        if( j > matriz.length - 1) break;
      }
      if(interactive) imprimirMatriz(matriz);
      if(tam == matriz.length - 1){
        break;
      }
    }
  }
  void preencheSegundaParte(int i, int j, int tam, int matriz[][]){
    Random random = new Random();
    tam = matriz.length - 1;
    for (;  ; tam-- ) {
      j = 0;
      i = matriz.length  - (tam + 1);
      for (int o = 0; o <= tam; o++){
        if(interactive) matriz[i][j] = 1;
        else matriz[i][j] = random.nextInt(100);

        j ++ ;
        i ++ ;
        if( i > matriz.length - 1) break;
        if( j > matriz.length - 1) break;
      }
      if(interactive) imprimirMatriz(matriz);
      if(tam == 0){
        break;
      }
    }
    System.out.println("");
  }

  void imprimirMatriz(int matriz[][]){
    for (int k = 0; k < matriz.length ; k ++){
      for (int l = 0; l < matriz[k].length; l++) {
        if( matriz[k][l] == 1 ){
          System.out.print(ANSI_RED + "[" + k + "]" + "[" + l+ "] "+ ANSI_RESET);
        } else {
          System.out.print(ANSI_WHITE + "[" + k + "]" + "[" + l+ "] "+ ANSI_RESET);
        }
      }
      System.out.println();
    }
    System.out.println("");
  }

}
