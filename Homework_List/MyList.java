package Homework_List;

import java.util.*;
import java.util.function.Consumer;

public class MyList<T> implements MyCollection<T>{
    private Object[] array;
    private static final Object[] emptyList = {};
    private static int size = 0;
    private static int BASE_CAPACITY = 10;

    public MyList(){
        this.array= new Object[BASE_CAPACITY];
    }

    public MyList(int capacity){
        if (capacity>0){
            this.array=new Object[capacity];
        } else {
            if (capacity == 0){
                this.array = new Object[BASE_CAPACITY];

            }
        }
    }
    @Override
    public void add(T element) {
        if (size==BASE_CAPACITY) grow();
        this.array[size++]= element;
    }
    @Override
    public void add(int index, T element){
        if (size == BASE_CAPACITY) grow();
        for (int i=size;i>index;i--){
            this.array[i]=this.array[i-1];
        }
        this.array[index]=element;
        size++;
    }


    @Override
    public T get(int index){
        if (index >=this.size || index <0){
            throw new IndexOutOfBoundsException("Index out of Bound!!");
        }
        return (T) this.array[index];
    }

    @Override
    public boolean remove(int index){
        this.size-=1;
        if(size>index){
            System.arraycopy(this.array,index+1,this.array,index,size-index);
            this.array[size]=null;

        }
        return true;
    }
    @Override
    public boolean addAll(Collection<? extends T> c){
        Object[] a = c.toArray();
        int plusSize = a.length;
        if (plusSize==0) return false;
        Object[] newArray=this.array;
        if (plusSize >(this.array.length - size)){
            newArray = grow(size + plusSize);
        }
        System.arraycopy(a,0,newArray,size,plusSize);
        size+=plusSize;
        return true;


    }

    private void grow(){
        BASE_CAPACITY >>= 1;
        this.array=Arrays.copyOf(array,BASE_CAPACITY);
    }

    private Object[] grow(int capacity){
        while(capacity>array.length - size){
            grow();
        }
        return this.array;
    }
    public void set(int index,T element){
        array[index]=element;
    }

    public static <T extends Comparable<T>> void bubbleSort(MyList<T> sort){
        for (int i=sort.size-1;i>=1;i--){
            boolean sorted = true;
            for (int j = 0;j<i;j++){
                if (sort.get(j).compareTo(sort.get(j+1))>0){
                    T temp=sort.get(j);
                    sort.set(j,sort.get(j+1));
                    sort.set(j+1,temp);
                    sorted=false;
                }
            }
            if(sorted) break;
        }
    }


}