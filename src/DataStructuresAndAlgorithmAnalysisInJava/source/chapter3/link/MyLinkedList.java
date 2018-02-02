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
        /*
            //老思路，抽取T unlink(Node node)后，可直接调用

            T old = first.data;
            if (first.next == null) {
                first = last = null;
            } else {
                first.next.prev = null;
                first = first.next;
            }
            size--;
        */
        return unlink(first);
    }

    public T removeLast() {
        checkBoundary(this.size - 1);
        /*
                老思路，抽取T unlink(Node node)后，可直接调用

                T old = last.data;
                if (last == first) {
                    first = last = null;
                } else {
                    last.prev.next = null;
                    last = last.prev;
                }
                size--;
                return old;

         */
        return unlink(last);
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
        Node temp = first;
        if (ele == null) {
            for (int i = 0; i < size; i++) {
                if (null == temp.data) {
                    unlink(temp);
                    return true;
                }
                temp = temp.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (ele.equals(temp.data)) {
                    unlink(temp);
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    public T get(int index) {
        checkBoundary(index);
        int half = this.size >> 1;
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
            Node temp = last;
            for (int i = size - 1; i > half; i--) {
                if (i == index) {
                    T old = (T) temp.data;
                    temp.data = ele;
                    return old;
                }
                temp = temp.prev;
            }
        } else {
            Node temp = first;
            for (int i = 0; i <= half; i++) {
                if (i == index) {
                    T old = (T) temp.data;
                    temp.data = ele;
                    return old;
                }
                temp = temp.next;
            }
        }
        return null;
    }

    public void add(int index, T ele) {
        checkRange(index);
        if (index == 0) {
            addFirst(ele);
        } else if (index == size) {
            addLast(ele);
        } else {
            int half = index >> 1;
            if (index > half) {
                Node temp = last;
                for (int i = size - 1; i > half; i--) {
                    if (i == index) {
                        Node newNode = new Node(ele, temp.prev, temp);
                        temp.prev.next = newNode;
                        temp.next.prev = newNode;
                        size++;
                        return;
                    }
                    temp = last.prev;
                }
            } else {
                Node temp = first;
                for (int i = 0; i <= half; i++) {
                    if (i == index) {
                        Node<T> newNode = new Node<>(ele, temp.prev, temp);
                        temp.prev.next = newNode;
                        temp.next.prev = newNode;
                        size++;
                        return;
                    }
                    temp = first.next;
                }
            }
        }
    }

    public T remove(int index) {
        return unlink(node(index));
    }

    private void checkRange(int index) {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkBoundary(int index) {
        if (index >= size || index < 0) {
            throw new NoSuchElementException();
        }
    }

//    private T unlink(int index) {
//        checkBoundary(index);
//        if (index == 0) {
//            return removeFirst();
//        } else if (index == size - 1) {
//            return removeLast();
//        } else {
//            int half = this.size >> 1;
//            if (index > half) {
//                Node temp = last;
//                for (int i = size - 1; i > half; i--) {
//                    if (index == i) {
//                        temp.next.prev = temp.prev;
//                        temp.prev.next = temp.next;
//                        size--;
//                        return (T) temp.data;
//                    }
//                    temp = temp.prev;
//                }
//            } else {
//                Node temp = first;
//                for (int i = 0; i <= half; i++) {
//                    if (index == i) {
//                        temp.next.prev = temp.prev;
//                        temp.prev.next = temp.next;
//                        size--;
//                        return (T) temp.data;
//                    }
//                    temp = temp.next;
//                }
//            }
//        }
//        return null;
//    }

    /**
     * 根据元素值找到第一个元素值与之相等的节点
     * 时间复杂度:O(n)
     *
     * @param ele
     * @return
     */
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

    /**
     * 根据索引查找对应的节点对象
     * 时间复杂度:O(n)
     *
     * @param index
     * @return
     */
    private Node node(int index) {
        checkBoundary(index);
        Node temp = first;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return temp;
            }
            temp = temp.next;
        }
        return temp;
    }


    /**
     * 移除一个非空节点
     * 时间复杂度:O(1)
     * <p>
     * 可供使用的方法有
     * removeFirst();
     * removeLast();
     * remove(int index);
     * </p>
     *
     * @param node
     * @return
     */
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
            /**
             不需要考虑待删除节点的下一个节点是什么，有值也好null也好，直接赋值
             因为这段不用建立next与prev的关联，所以没有next.prev的非null判断
             */
            prev.next = next;
            /**
             此时完成了前向指针的脱离，原来的前向指针就没有用了，置空加速垃圾回收
             没有也行
             */
            node.prev = null;
        }

        /**
         * 只考虑后节点的前向指针
         */
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        size--;
        /**
         * 老思路：指针的逻辑合在一起
         */

        /*
            Node next = node.next;
            Node prev = node.prev;
            if(next==null){
                if(prev == null){
                    //只有待删除节点一个节点
                }else{
                    //待删除节点是尾节点
                    prev.next = null;
                    last = prev;
                }
            }else{
                if(prev == null){
                    //待删除节点是首节点
                     next.prev = null;
                     first = next;
                }else{
                    //中间节点
                    next.prev = prev;
                    prev.next = next;
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

        Node(T data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
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
