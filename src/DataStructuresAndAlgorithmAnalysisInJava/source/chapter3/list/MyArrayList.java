package DataStructuresAndAlgorithmAnalysisInJava.source.chapter3.list;

import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {
    private final int DEFAULT_SIZE = 4;
    private Object[] items = new Object[DEFAULT_SIZE];
    private int size;

    /**
     * 获得指定位置元素
     *
     * @param index
     * @return
     */
    public T get(int index) {
        validateIndexRange(index);
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return (T) items[i];
            }
        }
        return null;
    }

    /**
     * 在指定位置替换原有元素
     *
     * @param data 替换元素
     * @param index 替换位置
     * @return 被替换元素
     */
    public T set(T data, int index) {
        validateIndexRange(index);
        for (int i = 0; i < size; i++) {
            if (index != i) {
                continue;
            }
            T old = (T) items[i];
            items[i] = data;
            return old;
        }
        return null;
    }

    /**
     * 添加元素到末尾
     *
     * @param data
     */
    public void add(T data) {
        ensureCapacity();
        items[size++] = data;
    }

    /**
     * 数组中真正有效元素的长度
     *
     * @return
     */
    public int size() {
        return this.size;
    }

    private void ensureCapacity() {
        if (DEFAULT_SIZE > this.size) {
            return;
        }
        int newLength = this.size + DEFAULT_SIZE >> 1;
        Object[] newItems = new Object[newLength];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }

    private void validateIndexRange(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iter<>();
    }

    private class Iter<T> implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(items[i])
                    .append(", ");
        }
        return sb.substring(0, sb.lastIndexOf(",")) + "]";
    }
}
