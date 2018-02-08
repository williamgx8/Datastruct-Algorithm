import DataStructuresAndAlgorithmAnalysisInJava.source.chapter3.link.MyLinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class MyLinkedListTest {

    @Test
    public void fun() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(0, 1);
//        linkedList.set(1, 1);
//        linkedList.removeFirst();
//        linkedList.getFirst();
//        System.out.println(linkedList);
    }

    MyLinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void normalAdd() {
        Assert.assertEquals("[1, 2, 3]", list.toString());
    }

    @Test
    public void removeFirst() {
        Integer removeFirst = list.removeFirst();
        Assert.assertEquals(1, (long) removeFirst);
        Assert.assertEquals("[2, 3]", list.toString());
        removeFirst = list.removeFirst();
        Assert.assertEquals(2, (long) removeFirst);
        Assert.assertEquals("[3]", list.toString());
        removeFirst = list.removeFirst();
        Assert.assertEquals(3, (long) removeFirst);
        Assert.assertEquals("[]", list.toString());
//        list.removeFirst();
    }

    @Test
    public void removeLast() {
        Integer removeLast = list.removeLast();
        Assert.assertEquals(3, (long) removeLast);
        Assert.assertEquals("[1, 2]", list.toString());
        removeLast = list.removeLast();
        Assert.assertEquals(2, (long) removeLast);
        Assert.assertEquals("[1]", list.toString());
        removeLast = list.removeLast();
        Assert.assertEquals(1, (long) removeLast);
        Assert.assertEquals("[]", list.toString());
    }

    @Test
    public void mixRemove() {
        Integer remove = list.removeFirst();
        Assert.assertEquals(1, (long) remove);
        Assert.assertEquals("[2, 3]", list.toString());
        remove = list.removeLast();
        Assert.assertEquals(3, (long) remove);
        Assert.assertEquals("[2]", list.toString());
    }

    @Test
    public void getFirstTest() {
        Integer first = list.getFirst();
        Assert.assertEquals(1, (long) first);
        list.removeLast();
        Assert.assertEquals(1, (long) list.getFirst());
    }

    @Test
    public void getLastTest() {
        Integer last = list.getLast();
        Assert.assertEquals(3, (long) last);
    }

    @Test
    public void addFirstTest() {
        list.addFirst(10);
        Assert.assertEquals("[10, 1, 2, 3]", list.toString());
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addFirst(0);
        Assert.assertEquals("[0]", linkedList.toString());
    }

    @Test
    public void addLastTest() {
        list.addLast(8);
        Assert.assertEquals("[1, 2, 3, 8]", list.toString());
        list.removeFirst();
        Assert.assertEquals("[2, 3, 8]", list.toString());
        list.addLast(4);
        Assert.assertEquals("[2, 3, 8, 4]", list.toString());
    }

    @Test
    public void getTest() {
        Assert.assertEquals(2, (long) list.get(1));
        Assert.assertEquals(3, (long) list.get(2));
        list.addLast(8);
        list.addFirst(9);
        Assert.assertEquals(8, (long) list.get(4));
    }

    @Test
    public void containsTest() {
        Assert.assertEquals(true, list.contains(3));
        Assert.assertEquals(false, list.contains(8));
        Assert.assertEquals(false, list.contains(null));
    }

    @Test
    public void remove() {
        Integer remove = list.remove(1);
        Assert.assertEquals(2, (long) remove);
        Assert.assertEquals("[1, 3]", list.toString());

        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("1");
        linkedList.add("4");
        linkedList.addLast("9");
        linkedList.addFirst("0");

        Assert.assertEquals("[0, 1, 4, 9]", linkedList.toString());

        linkedList.remove("4");
        Assert.assertEquals("[0, 1, 9]", linkedList.toString());
        linkedList.remove("0");
        Assert.assertEquals("[1, 9]", linkedList.toString());
    }

    @Test
    public void addIndexTest() {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add(0, "1");
        linkedList.add(0, "9");
        linkedList.add(2, "2");
        linkedList.add(1, "6");
        Assert.assertEquals("[9, 6, 1, 2]", linkedList.toString());
    }

    @Test
    public void setTest() {
        list.set(0, -2);
        list.set(2, 0);
        Assert.assertEquals("[-2, 2, 0]", list.toString());
        list.set(0, 100);
        Assert.assertEquals("[100, 2, 0]", list.toString());
        list.set(1, 50);
        Assert.assertEquals("[100, 50, 0]", list.toString());
    }

}
