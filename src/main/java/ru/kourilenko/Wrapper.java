package ru.kourilenko;

public class Wrapper {

    private Wrapper prev;
    private Wrapper next;
    private Object obj;

    public Wrapper getPrev() {
        return prev;
    }

    public void setPrev(Wrapper prev) {
        this.prev = prev;
    }

    public Wrapper getNext() {
        return next;
    }

    public void setNext(Wrapper next) {
        this.next = next;
    }

    public Object getObj() {
        return obj;
    }

    public Wrapper (Object object){
        obj = object;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Wrapper)) {
            return false;
        }
        Wrapper wrapper = (Wrapper) obj;
        return this.getObj().equals(wrapper.getObj());
    }
}
