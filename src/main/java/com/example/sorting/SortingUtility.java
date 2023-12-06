package com.example.sorting;

public class SortingUtility {


    public static <T extends Comparable<T>> void gnomeSort(T[] data) {
        int index = 0;
        while (index < data.length) {
            if (index == 0 || data[index].compareTo(data[index - 1]) >= 0) {
                index++;

            }else{
                swap(data, index, index-1);
                index--;

            }
        }


    }


    public static <T extends Comparable<T>> void cocktailShakerSort(T[] data) {
        boolean swapped = true;
        int start = 0;
        int end = data.length;
        while (swapped) {
            swapped = false;
            for (int i = start; i < end-1; i++){
                if (data[i].compareTo(data[i+1]) > 0){
                    swap(data, i, i+1);
                    swapped = true;
                }
            }
            if(!swapped) {
                break;
            }
            end = end - 1;
            swapped = false;
            for (int i = end - 1; i >= start; i--){
                if (data[i].compareTo(data[i+1]) > 0){
                    swap(data, i, i+1);
                    swapped = true;
                }
            }
            start = start + 1;
        }

    }


    public static <T extends Comparable<T>> void shellSort(T[] data) {
        int[] gaps = {701, 301, 132, 57, 23, 10, 4, 1};
        T temp;
        for (int i = 0; i < gaps.length; i++){
            for (int j = gaps[i]; j < data.length; j++) {
                temp = data[j];
                int k;
                for (k = j; (k >= gaps[i]) && (data[k - gaps[i]].compareTo(temp) > 0); k -= gaps[i]) {
                    data[k] = data[k - gaps[i]];
                }
                data[k] = temp;
            }
        }
    }

    private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {

        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;

    }
}





