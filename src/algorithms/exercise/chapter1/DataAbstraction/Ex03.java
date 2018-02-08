package algorithms.exercise.chapter1.DataAbstraction;

import algorithms.source.chapter1.FundamentalsModel.StdIn;

/**
 * 编写一个程序，从命令行得到三个整数。如果它们都相等则打印equal，否则打印not equal
 *
 * @author gongxun
 * @create 2018-02-08 22:22
 **/
public class Ex03 {

    public static void main(String[] args) {
        int first = StdIn.readInt();
        boolean flag = true;
        for (int i = 0; i < 2; i++) {
            if (first == StdIn.readInt())
                continue;
            flag = false;
            break;
        }
        System.out.println(flag ? "equal" : "not equal");
    }
}
