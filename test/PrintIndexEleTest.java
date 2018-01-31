import DataStructuresAndAlgorithmAnalysisInJava.exercise.chapter3.list.PrintIndexEle;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PrintIndexEleTest {
    List<Integer> left;
    List<Integer> right;

    @Before
    public void setUp() {
        left = new ArrayList<>();
        right = new ArrayList<>();
    }

    @Test
    public void fun1() {
        left.add(3);
        left.add(1);
        left.add(9);
        left.add(0);

        right.add(2);
        right.add(0);
        right.add(10);

        PrintIndexEle<Integer> print = new PrintIndexEle<>();
        print.printIndexEle(left, right);
    }
}
