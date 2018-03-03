package algorithms.exercise.chapter1.FundamentalsModel;

import algorithms.source.chapter1.FundamentalsModel.StdOut;

/**
 * Created by william on 2018/2/15.
 * 编写一段代码，打印出一个M行N列的二维数组的转置
 */
public class Ex13 {
    public static void main(String[] args) {
        int[][] origin1 = {{1, 2}, {2, 6}};
        int[][] origin2 = {{5, 1, 3}, {1, 7, 9}};
        int[][] origin3 = {{1}};

        Ex13 ex13 = new Ex13();
        ex13.transpose(origin1);
        ex13.transpose(origin2);
        ex13.transpose(origin3);
    }


    private void transpose(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                StdOut.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
    }
}
