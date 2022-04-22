package com.knowledge.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Jinkang He
 * @version 1.0
 * @date 2022/3/8 11:57
 */

public class ArrayDemo {
    public static void main(String[] args) {
        Integer[] ids = {1,2,3,4,5};
        List<Integer> idList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            idList.add(i);
        }

        List<Integer> integers = Arrays.asList(ids);

        ArrayList arrayList = new ArrayList<>(integers);


        idList.forEach(integer -> {
            arrayList.remove(integer);
        });
        System.out.println(arrayList);
    }
}
