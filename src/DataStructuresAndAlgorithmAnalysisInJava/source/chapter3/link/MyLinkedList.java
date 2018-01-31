package DataStructuresAndAlgorithmAnalysisInJava.source.chapter3.link;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {
    private int size;
    private Node<T> first;
    private Node<T> last;

    public T getFirst() {
        return null;
    }

    public T getLast() {
        return null;
    }

    public T removeFirst() {
        return null;
    }

    public T removeLast() {
        return null;
    }

    public T addFirst() {
        return null;
    }

    public T addLast() {
        return null;
    }

    public boolean conatins(Object ele) {
        return false;
    }

    public int size() {
        return this.size;
    }

    public boolean add(T ele) {
        if (first == null) {
            last = first = new Node<>(ele);
        } else {
            Node newLast = new Node(ele, last);
            last.next = newLast;
            last = newLast;
        }
        size++;
        return true;
    }

    public boolean remove(Object ele) {
        return true;
    }

    public T get(int index) {
        checkRange(index);
        int half = this.size / 2;
        Node temp;
        if (half >= index) {
            temp = last;
            for (int i = this.size - 1; i >= half; i--) {
                if (i == index) {
                    temp.prev.next = temp.next;
                }
            }
        } else {
            temp = first;
            for (int i = 0; i < half; i++) {

            }
        }
        return null;
    }

    public T set(int index, T ele) {
        return null;
    }

    public void add(int index, T ele) {

    }

    public T remove(int index) {
        return null;
    }

    private void checkRange(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private class Node<T> {
        Node prev;
        Node next;
        T data;

        Node(T data) {
            this.data = data;
        }

        Node(T data, Node prev) {
            this.data = data;
            this.prev = prev;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter<>();
    }

    private class Iter<T> implements Iterator<T> {
        int cursor;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            return (T) get(cursor++);
        }
    }

    @Override
    public String toString() {
        Iterator<T> iterator = iterator();
        if (!iterator.hasNext()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (; ; ) {
            T ele = iterator.next();
            sb.append(ele);
            if (!iterator.hasNext()) {
                return sb.append("]").toString();
            }
            sb.append(", ");
        }
    }
}
