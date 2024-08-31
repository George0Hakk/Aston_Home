package Homework_List;

import java.util.Collection;

public interface MyCollection<T> {
    public void add(T element);
    public void add(int index,T element);
    public T get(int index);
    public boolean remove(int index);
    public boolean addAll(Collection<? extends T> c);
    private void grow(){}
    private Object[] grow(int capacity){
        return new Object[3];
    }
    public static  <T extends Comparable<T>> void bubbleSort(MyList<T> sort){}
    public void set(int index,T element);

}
