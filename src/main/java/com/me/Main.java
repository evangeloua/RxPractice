package com.me;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] arr2 = {5,6,7,8};
        List<int[]> bigList = Arrays.asList(arr, arr2);
        List<int[]> bigList2 = Arrays.asList(arr, arr2);

        List<int[]> l = flattenListOfListsStream(Arrays.asList(bigList, bigList2));
        for(int[] a: l) {
            for(int alma: a) {
                System.out.println(alma);
            }
        }
    }

    @SafeVarargs
    static <T extends Number> Float addWrappers(T... t) {
        Float total = 0f;
        for(T i: t){
            total += i.floatValue();
        }
        return total;
    }

    static <T> List<T> flattenListOfListsStream(List<List<T>> list) {
        return list.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    static <T extends List> void addPrim(T... t) {
//        return Stream.concat(
//                Stream.of(this),
//                subOrders.stream().flatMap(Order::streamOrders));

//        Arrays.stream(t).flatMap()
        for(T i: t){
            for(Object a: i){
                System.out.println(a.toString());
            }
        }
    }
}
