package classic.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7,3,4,5,9,0};
        System.out.println(Arrays.toString(sort(arr)));
    }
/*
    Insertion sort consists in swap elements position
    Best case => Array is already sorted O(n)
    Worst case => Array is reversed sorted O(n2)
    Avg case => O(n2)

    Time complexity => n2 compares and n2 swaps
    Space complexity => O(n) total, O(1) aux (don't use any auxiliary array space)
 */
    public static int[] sort(int[] arr){
        int aux;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(i != j && arr[i] <= arr[j]){
                    aux = arr[i];
                    arr[i] = arr[j];
                    arr[j] = aux;
                }
            }
        }
        return arr;
    }
}
