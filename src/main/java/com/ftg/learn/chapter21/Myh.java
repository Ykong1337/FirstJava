package com.ftg.learn.chapter21;

import java.util.Arrays;

public class Myh<T> {

    private Object[] data;

    private int init_length;

    private int index;

    private int add_length;

    public Myh(int init_length, int add_length) {

        if (init_length < 0) {
            throw new IllegalArgumentException();
        }
        this.data = new Object[init_length];
        this.add_length = add_length;
    }

    public void dilatation(int min) {
        int old_data = data.length;
        int new_data = old_data + ((add_length > 0) ? add_length : old_data);
        if (new_data - min < 0) {
            new_data = min;
        }
        if (new_data - Integer.MAX_VALUE - 8 > 0) {
            new_data = (min > Integer.MAX_VALUE - 8) ? Integer.MAX_VALUE : Integer.MAX_VALUE - 8;
        }
        data = Arrays.copyOf(data, new_data);
    }

    public void add(T x) {
        if (index + 1 - data.length > 0) {
            dilatation(index + 1);
        }
        data[index++] = x;
    }

    public void remove(int index) {
        if (index >= this.index) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " + this.index);
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int j = this.index - index - 1;
        if (j > 0) {
            System.arraycopy(data, index + 1, data, index, j);
        }
        this.index--;
        data[this.index] = null;
    }

    public void update(int index, T x) {
        data[index] = x;
    }

    public int size(){
        return this.index;
    }

    public T get(int index) {
        if (index >= this.index) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return (T) data[index];
    }
}
