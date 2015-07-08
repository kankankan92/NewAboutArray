package ru.kourilenko;


public class MyArray {

    private int size;
    private static final int INIT_SIZE = 50;
    private Object[] myarray;

    public MyArray() {
        myarray = new Object[INIT_SIZE];
        size = 0;
    }

    public void add(Object object) {
        if (size == myarray.length) {
            Object[] newmyarray = new Object[myarray.length + INIT_SIZE];
            System.arraycopy(myarray, 0, newmyarray, 0, myarray.length);
            myarray = newmyarray;
        }
        myarray[size] = object;
        size++;
    }

    public void add(int position, Object object) {
        if (position < 0 || position > myarray.length) {
            throw new IllegalArgumentException("Некорректное значение переменной position");
        }
        if (size == myarray.length) {
            Object[] newmyarray = new Object[myarray.length + INIT_SIZE];
            System.arraycopy(myarray, 0, newmyarray, 0, myarray.length);
            myarray = newmyarray;
        }
        System.arraycopy(myarray, position, myarray, position + 1, myarray.length - position);
        myarray[position] = object;
        size++;

    }

    public void remove() {

    }

    public void removw(int position) {

    }

    public Object get(int position) {
        if (position < 0 || position > myarray.length) {
            throw new IllegalArgumentException("Некорректное значение переменной position");
        }
        return myarray[position];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return true;
    }

    public void clear() {

    }
}
