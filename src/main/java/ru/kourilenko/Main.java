package ru.kourilenko;


import java.util.ArrayList;
import java.util.List;

public class Main {
    private static MyList method1(){
        if(Math.random() > 0.5){
            return new MyArrayList();
        } else {
            return new MyLinkedList();
        }
    }

    public static void main(String[] args) {
        int [] a1 = new int[10];
        int [] a2 = new int[10];

        List<String> l = new ArrayList<>();
        l.add("1241");
        l.add("12");
        l.add("214");

        int a = Integer.parseInt(l.get(0));




    }
}
