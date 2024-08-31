package Homework_List;

import java.util.ArrayList;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        MyList<String> myList=new MyList<>();
        myList.add("Barrie");
        myList.add("Tom");
        myList.add("Silver");

        List<String> list= new ArrayList<>();
        for(String s:list){
            System.out.println(s);
        }


    }
}
