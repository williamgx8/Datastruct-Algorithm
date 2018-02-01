package DataStructuresAndAlgorithmAnalysisInJava.source.chapter3.link;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements Iterable<T> {
    private int size;
    private Node<T> first;
    private Node<T> last;

    public T getFirst() {
        checkBoundary(0);
        return first.data;
    }

    public T getLast() {
        checkBoundary(this.size - 1);
        return last.data;
    }

    public T removeFirst() {
        checkBoundary(0);
        T old = first.data;
        if (first.next == null) {
            first = last = null;
        } else {
            first.next.prev = null;
            first = first.next;
        }
        size--;
        return old;
    }

    public T removeLast() {
        checkBoundary(this.size - 1);
        T old = last.data;
        if (last == first) {
            first = last = null;
        } else {
            last.prev.next = null;
            last = last.prev;
        }
        size--;
        return old;
    }

    public void addFirst(T ele) {
        Node<T> newFirst = new Node<>(ele);
        if (first == null) {
            last = first = newFirst;
        } else {
            first.prev = newFirst;
            newFirst.next = first;
            first = newFirst;
        }
        size++;
    }

    public void addLast(T ele) {
        Node<T> newLast = new Node<>(ele);
        if (last == null) {
            last = first = newLast;
        } else {
            last.next = newLast;
            newLast.prev = last;
            last = newLast;
        }
        size++;
    }

    public boolean contains(Object ele) {
        return indexFor(ele) != -1;
    }

    public int size() {
        return this.size;
    }

    public boolean add(T ele) {
        addLast(ele);
        return true;
    }

    public boolean remove(Object ele) {
        int index = indexFor(ele);
        remove(index);
        return true;
    }

    private int indexFor(Object ele) {
        Node temp = first;
        if (null == ele) {
            for (int i = 0; i < size; i++) {
                if (null == ele) {
                    return i;
                }
                temp = temp.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (ele.equals(first.data)) {
                    return i;
                }
                temp = temp.next;
            }
        }
        return -1;
    }

    public T get(int index) {
        checkRange(index);
        int half = this.size / 2;
        Node temp;
        if (half < index) {
            temp = last;
            for (int i = this.size - 1; i > half; i--) {
                if (i == index) {
                    return (T) temp.data;
                }
                temp = temp.prev;
            }
        } else {
            temp = first;
            for (int i = 0; i <= half; i++) {
                if (i == index) {
                    return (T) temp.data;
                }
                temp = temp.next;
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
        checkBoundary(index);

        return null;
    }

    private void checkRange(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkBoundary(int index) {
        if (index >= size || index < 0) {
            throw new NoSuchElementException();
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
