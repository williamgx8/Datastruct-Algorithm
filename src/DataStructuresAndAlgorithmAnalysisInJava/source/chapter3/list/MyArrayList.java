package DataStructuresAndAlgorithmAnalysisInJava.source.chapter3.list;

import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {
    private final int DEFAULT_SIZE = 10;
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
        addLast(data);
    }

    private void addLast(T data) {
        items[size++] = data;
    }

    /**
     * 在指定位置添加元素
     *
     * @param data
     * @param index
     */
    public void add(int index, T data) {
        if (index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity();
        if (index == this.size) {
            addLast(data);
        } else {
            System.arraycopy(items, index, items, index + 1, size - index);
            items[index] = data;
            size++;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 移除指定位置元素
     *
     * @param index 删除元素索引
     * @return 被删除的元素
     */
    public T remove(int index) {
        validateIndexRange(index);
        T old = (T) items[index];
        System.arraycopy(items, index + 1, items, index, size - index);
        size--;
        return old;
    }

    /**
     * 数组中真正有效元素的长度
     *
     * @return
     */
    public int size() {
        return this.size;
    }

    /**
     * 扩充原数组容量
     */
    private void ensureCapacity() {
        if (DEFAULT_SIZE > this.size) {
            return;
        }
        int newLength = this.size + (DEFAULT_SIZE >> 1);
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
        int cursor;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            if (cursor < size) {
                return (T) items[cursor++];
            }
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
