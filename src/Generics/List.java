package Generics;

public class List<T> {
    private int size;
    private T[] objects;

    public List(int initSize){
        objects = (T[]) new Object[initSize];
    }

    public void add(T object){
        objects[size++] = object;
    }

    public T get(int index){
        return objects[index];
    }
}
