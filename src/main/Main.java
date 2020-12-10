package main;

import main.domain.Config;
import main.domain.ModosInsercao;

import java.util.ArrayList;
import java.util.Collections;

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

    ArrayList<Integer> vetor = new ArrayList<Integer>();

    for (int i = 0; i < 1000000; i++) {
      vetor.add(i);
    }
    Collections.shuffle(vetor);

    for (int i = 0; i < vetor.size(); i++) {
      System.out.println(vetor.get(i));
    }

//    executarRandomico1Thread();
//    executarRandomico2Thread();
//    executarRandomico4Thread();

  }


//  public static void sortbyColumn(int arr[][], int col)
//  {
//    // Using built-in sort function Arrays.sort
//    Arrays.sort(arr, new Comparator<int[]>() {
//
//      @Override
//      // Compare values according to columns
//      public int compare(final int[] entry1,
//                         final int[] entry2) {
//
//        // To sort in descending order revert
//        // the '>' Operator
//        if (entry1[col] > entry2[col])
//          return 1;
//        else
//          return -1;
//      }
//    });  // End of function call sort().
//  }
//
//  // Driver Code
//  public static void main(String args[])
//  {
//    int matrix[][] = { { 39, 27, 11, 42 },
//      { 10, 93, 91, 90 },
//      { 54, 78, 56, 89 },
//      { 24, 64, 20, 65 } };
//    // Sort this matrix by 3rd Column
//    int col = 3;
//    sortbyColumn(matrix, col - 1);
//
//    // Display the sorted Matrix
//    for (int i = 0; i < matrix.length; i++) {
//      for (int j = 0; j < matrix[i].length; j++)
//        System.out.print(matrix[i][j] + " ");
//      System.out.println();
//    }
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
