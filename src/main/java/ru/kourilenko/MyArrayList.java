package ru.kourilenko;


public class MyArrayList {

    private int size;
    private static final int INIT_SIZE = 50;
    private Object[] myarray;

    public MyArrayList() {
        myarray = new Object[INIT_SIZE];
        size = 0;
    }

    public void add(Object object) {
        if (object == null) {
            throw new RuntimeException("Пытаемся добавить ничего!");
        }
        if (size == myarray.length) {
            Object[] newmyarray = new Object[myarray.length + INIT_SIZE];
            System.arraycopy(myarray, 0, newmyarray, 0, myarray.length);
            myarray = newmyarray;
        }
        myarray[size] = object;
        size++;
    }

    public void add(int position, Object object) {
        if (position < 0 || position > size) {
            throw new IllegalArgumentException("Некорректное значение переменной position");
        }
        if (object == null) {
            throw new RuntimeException("Пытаемся добавить ничего!");
        }
        if (size == myarray.length) {
            Object[] newmyarray = new Object[myarray.length + INIT_SIZE];
            System.arraycopy(myarray, 0, newmyarray, 0, myarray.length);
            myarray = newmyarray;
        }
        System.arraycopy(myarray, position, myarray, position + 1, size - position);
        myarray[position] = object;
        size++;
    }

    public void remove() {
        if (this.isEmpty()) {
            throw new RuntimeException("Массив пуст");
        }
        myarray[size - 1] = null;
        size--;
    }

    public void remove(int position) {
        if (position < 0 || position >= size) {
            throw new IllegalArgumentException("Некорректное значение переменной position");
        }
        myarray[position] = null;
        if (this.isEmpty()) {
            throw new RuntimeException("Массив пуст");
        }
        System.arraycopy(myarray, position + 1, myarray, position, size - position - 1);
        size--;
    }

    public Object get(int position) {
        if (position < 0 || position >= size) {
            throw new IllegalArgumentException("Некорректное значение переменной position");
        }
        return myarray[position];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        while (size > 0) {
            myarray[size - 1] = null;
            size--;
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof MyArrayList)) {
            return false;
        }

        MyArrayList myArrayList = (MyArrayList) obj;

        if (this.size != myArrayList.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!(this.myarray[i].equals(myArrayList.myarray[i]))) {
                return false;
            }
        }

        return true;

    }
}
