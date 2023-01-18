package com.Collections.Practice;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class fTask {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>(List.of(5, -3, 7, -4, -8, 86, -3, 32));
        List<Integer> check = check(list);
        System.out.println(check);
    }
    public static List<Integer> check(List<Integer> list){
        ListIterator<Integer> listIterator = list.listIterator();
        while(listIterator.hasNext()){
            Integer next = listIterator.next();
            if (next<0){
                listIterator.remove();
            }
        }
        return list;
    }
}
