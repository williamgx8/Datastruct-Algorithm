import DataStructuresAndAlgorithmAnalysisInJava.source.chapter3.list.MyArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MyArrayListTest {

    private MyArrayList<Integer> list;

    @Before
    public void init() {
        list = new MyArrayList<>();
    }

    @Test
    public void fun1() {
        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
        System.out.println(list);
    }

    @Test
    public void normalAdd() {
        list.add(1);
        list.add(2);
        Assert.assertEquals("[1, 2]", list.toString());
        Assert.assertEquals(2, list.size());
    }

    @Test
    public void nullAdd() {
        Assert.assertEquals("[]", list.toString());
        Assert.assertEquals(0, list.size());
    }

    @Test
    public void replace() {
        list.add(1);
        list.add(2);
        Assert.assertEquals(2l, (long) list.set(0, 1));
        Assert.assertEquals("[1, 0]", list.toString());
        Assert.assertEquals(1l, (long) list.set(8, 0));
        Assert.assertEquals("[8, 0]", list.toString());
    }

    @Test
    public void ensureCapacity() {
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        list.add(0);
        Assert.assertEquals("[0, 0, 0, 0, 0]", list.toString());
        Assert.assertEquals(5, list.size());
    }
}
