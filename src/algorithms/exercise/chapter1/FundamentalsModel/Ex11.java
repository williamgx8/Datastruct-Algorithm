package algorithms.exercise.chapter1.FundamentalsModel;

import algorithms.source.chapter1.FundamentalsModel.StdOut;

/**
 * 编写一段代码，打印出一个二维布尔数组的内容。其中使用*表示真，空格表示假，打印出行号和列号
 *
 * @author gongxun
 * @create 2018-02-09 22:57
 **/
public class Ex11 {

    private void printTwoDimensionArray(boolean[][] array) {
        if (array == null)
            return;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                printMessage(i, j, array[i][j] ? "*" : " ");
            }
        }
    }

    private void printMessage(int i, int j, String message) {
        StdOut.println((i + 1) + "行" + (j + 1) + "列 = " + message);
    }


    public static void main(String[] args) {
        Ex11 ex11 = new Ex11();
        boolean[][] array = {{true, false}, {false, false}, {false, true}};
        ex11.printTwoDimensionArray(array);
        array = new boolean[][]{{true}};
        ex11.printTwoDimensionArray(array);
    }
}
