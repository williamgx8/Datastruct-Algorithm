import DataStructuresAndAlgorithmAnalysisInJava.source.chapter3.link.MyLinkedList;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class MyLinkedListTest {

    @Test
    public void fun() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println(linkedList);
    }

    MyLinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new MyLinkedList<>();
    }

    @Test
    public void normalAdd() {
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
    }
}
