package com.company.list;

public interface List <T> {
    void add(T data);

    T get (int index);

    void delete(int index);

    int getSize();

    IteratorG<T> getIterator();

    void  insert (T data, Position position, IteratorG<T> it);

    IteratorG<T> getReverseIterator();

}
