package ru.kourilenko;

public interface MyList {
    public void add(Object object);
    public void add(int position, Object object);
    public void remove();
    public void remove(int position);
    public Object get(int position);
    public int size();
    public boolean isEmpty();
    public void clear();
    public boolean equals(Object obj);
}
