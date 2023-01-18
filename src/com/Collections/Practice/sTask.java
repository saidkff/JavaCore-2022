package com.Collections.Practice;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class sTask {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(List.of(5, 2, 6, 1, 3, 2, 2, 6, 5));
        int unique = countUnique(list);
        System.out.println(unique);
    }

    public static int countUnique(List<Integer> list){
        HashSet<Integer> hashSet = new HashSet<>(list);
        return hashSet.size();
    }
}
