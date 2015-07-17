package ru.kourilenko;


public class MyLinkedList {

    private int size = 0;
    Wrapper head = null;


    public MyLinkedList() {

    }


    public void add(Object object) {
        if (head == null) {
            head = new Wrapper(object);
        } else {
            Wrapper wrapper = new Wrapper(object);
            getLast().setNext(wrapper);
            wrapper.setPrev(getLast());
        }
    }

    public Wrapper getLast() {
        if (head == null) {
            throw new IllegalStateException("Пустой список");
        }
        Wrapper current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current;
    }

//    public Wrapper getLastSafe(){
//        try{
//            return getLast();
//        } catch (IllegalStateException e){
//            return null;
//        }
//    }

    public void add(int position, Object object) {

    }

    public void remove() {

    }

    public void remove(int position) {

    }

    public Object get(int position) {
        if (head == null) {
            throw new IllegalStateException("Пустой список");
        }
        Wrapper current = head;
        for (int i = 0; i < position; i++) {
            current = current.getNext();
            if(current==null){
                throw new IllegalArgumentException("Некорректное значение переменной");
            }
        }
        return current;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return false;
    }

    public void clear() {

    }

    @Override
    public boolean equals(Object obj) {
        return false;

    }


}
