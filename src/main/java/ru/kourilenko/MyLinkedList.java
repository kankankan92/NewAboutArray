package ru.kourilenko;


public class MyLinkedList implements MyList {

    private int size = 0;
    Wrapper head = null;

    public void add(Object object) {
        if (object == null) {
            throw new RuntimeException("Пытаемся добавить ничего!");
        }
        if (head == null) {
            head = new Wrapper(object);
        } else {
            Wrapper wrapper = new Wrapper(object);
            Wrapper last = getLast();
            last.setNext(wrapper);
            wrapper.setPrev(last);
        }
        size++;
    }

    public void add(int position, Object object) {
        if (object == null) {
            throw new RuntimeException("Пытаемся добавить ничего!");
        }
        if (head == null) {
            if (position > 0) {
                throw new IllegalStateException("Пустой список");
            }
            if (position == 0) {
                head = new Wrapper(object);
            }
        } else {
            Wrapper wrapper = new Wrapper(object);
            Wrapper a = getWrapper(position);
            Wrapper b = a.getPrev();
            wrapper.setPrev(b);
            wrapper.setNext(a);
            a.setPrev(wrapper);
            if (position == 0) {
                head = wrapper;
            } else {
                b.setNext(wrapper);
            }
        }
        size++;
    }

    public void remove() {
        if (head == null) {
            throw new IllegalStateException("Пустой список");
        }
        Wrapper last = getLast();
        if (last == head) {
            head = null;
        } else {
            last.getPrev().setNext(null);
            last.setPrev(null);
        }
        size--;
    }

    public void remove(int position) {
        if (head == null) {
            throw new IllegalStateException("Пустой список");
        }
        Wrapper a = getWrapper(position);
        if (position == 0) {
            head = a.getNext();
            if (a.getNext() != null) {
                a.getNext().setPrev(a.getPrev());
                a.setNext(null);
            }
        } else {
            a.getPrev().setNext(a.getNext());
            if (a == getLast()) {
                a.setPrev(null);
            } else {
                a.getNext().setPrev(a.getPrev());
            }
        }
        size--;
    }

    private Wrapper getWrapper(int position) {
        if (head == null) {
            throw new IllegalStateException("Пустой список");
        }
        Wrapper current = head;
        for (int i = 0; i < position; i++) {
            current = current.getNext();
            if (current == null) {
                throw new IllegalArgumentException("Некорректное значение переменной");
            }
        }
        return current;
    }

    public Object get(int position) {
        return getWrapper(position).getObj();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
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

/*    public Wrapper getLastSafe(){
        try{
            return getLast();
        } catch (IllegalStateException e){
            return null;
        }
    }*/

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof MyLinkedList)) {
            return false;
        }

        MyLinkedList myLinkedList = (MyLinkedList) obj;

        if (this.size != myLinkedList.size) {
            return false;
        }
        Wrapper a = head;
        Wrapper b = myLinkedList.head;
        while (a.getNext() != null && b.getNext() != null) {
            if (!(a.equals(b))) {
                return false;
            } else {
                a = a.getNext();
                b = b.getNext();
            }
        }
        return true;
    }


}
