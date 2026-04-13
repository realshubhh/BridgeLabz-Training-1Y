package com.gla.workshop;

import java.util.*;

public class RemoveDupe {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 3, 5, 1, 6));
        System.out.println("Original List : " + list);

        List<Integer> result1 = new ArrayList<>(new LinkedHashSet<>(list));
        System.out.println("LinkedHashSet  : " + result1);

        List<Integer> result2 = new ArrayList<>(new HashSet<>(list));
        System.out.println("HashSet        : " + result2);

        List<Integer> result3 = new ArrayList<>(new TreeSet<>(list));
        System.out.println("TreeSet        : " + result3);
    }
}