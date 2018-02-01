package DataStructuresAndAlgorithmAnalysisInJava.source.chapter3.link;

import com.sun.istack.internal.NotNull;

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
                if (null == temp.data) {
                    return i;
                }
                temp = temp.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (ele.equals(temp.data)) {
                    return i;
                }
                temp = temp.next;
            }
        }
        return -1;
    }

    public T get(int index) {
        checkRange(index);
        int half = this.size >> 2;
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
        checkBoundary(index);
        int half = this.size >> 1;
        if (index > half) {
            for (int i = size - 1; i > half; i--) {
                if (i == index) {
                }
            }
        } else {
            Node temp = first;
            for (int i = 0; i <= half; i++) {
                if (i == index) {
                    T old = (T) temp.data;

                }
            }
        }
        return null;
    }

    public void add(int index, T ele) {

    }

    public T remove(int index) {
        return unlink(index);
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

    private T unlink(int index) {
        checkBoundary(index);
        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            int half = this.size >> 1;
            if (index > half) {
                Node temp = last;
                for (int i = size - 1; i > half; i--) {
                    if (index == i) {
                        temp.next.prev = temp.prev;
                        temp.prev.next = temp.next;
                        size--;
                        return (T) temp.data;
                    }
                    temp = temp.prev;
                }
            } else {
                Node temp = first;
                for (int i = 0; i <= half; i++) {
                    if (index == i) {
                        temp.next.prev = temp.prev;
                        temp.prev.next = temp.next;
                        size--;
                        return (T) temp.data;
                    }
                    temp = temp.next;
                }
            }
        }
        return null;
    }

    private T unlink(@NotNull Node node) {
        T old = (T) node.data;
        Node prev = node.prev;
        Node next = node.next;
        /**
         * 只考虑前节点的后向指针
         */
        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            //此时完成了前向指针的脱离，原来的前向指针就没有用了，置空加速垃圾回收
            node.prev = null;
        }

        /**
         * 只考虑后节点的前向指针
         */
        if (next == null) {
            last = null;
        } else {
            next.prev = prev;
            node.next = null;
        }

        /**
         * 老思路：指针的逻辑合在一起
         */

        /*
            if(node.next==null){
                if(node.prev == null){
                    //只有待删除节点一个节点
                }else{
                    //待删除节点是尾节点
                    node.prev.next = null;
                    last = node.prev;
                }
            }else{
                if(node.prev == null){
                    //待删除节点是首节点
                     node.next.prev = null;
                     first = node.next;
                }else{
                    //中间节点
                    node.next.prev = node.prev;
                    node.prev.next = node.next;
                }
            }

         */

        return old;
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
