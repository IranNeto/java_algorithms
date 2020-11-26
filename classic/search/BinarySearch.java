package classic.search;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    public static void main(String[] args) {
        Random rd = new Random();
        int[] arr = new int[62];

        //populating arr
        for (int i = 0; i < 62; i++) {
            arr[i] = rd.nextInt();
        }

        //inserting target on arr
        int target = 12344321;
        arr[0] = target;

        Arrays.sort(arr);
        System.out.println(searchElement(arr, target));
    }

    public static int searchElement(int[] arr, int target){
        int start = 0, end = arr.length;
        int target_pos = end / 2;

        while(arr[target_pos] != target){

            if (arr[target_pos] > target){
                end = target_pos;
            } else if(arr[target_pos] < target){
                start = target_pos;
            }

            target_pos = (start + end) / 2;
        }

        return target_pos;
    }
}