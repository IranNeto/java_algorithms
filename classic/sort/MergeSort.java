package classic.sort;

import java.util.Arrays;

/*
    Divide and Conquer algorithm which consists in divide the array until len(sub_arr) = 1 and then start to compare and order
    O(1) for divide the array + O(n/2) + O(n/2) for recursion in each half + O(n) for merge
    T(n) = c1 + 2*T(n/2) + c2*n

    c2*n                            |
    c2*n/2 c2*n/2                   |
    c2*n/4 c2*n/4 c2*n/4 c2*n/4     | log n + 1
    ...                             |
    c2 ... c2                       |
    ---------------------------------
            n elements

    T(n) = c2*n * (1 + log n)
    T(n) = c2*n + c2*n*log n (n log n tends to increase faster than n)
    T(n) = c2*n*log n
    T(n) = n log(n)

    ---------------------------------------------------

    Space-complexity
    S(n) auxiliary space in order to create left and right arrays

 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3,1,9,7,2,6,8,0};
        sort(0, arr.length - 1, arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int l, int r, int[] arr){
        if(l < r){
            //find middle point
            int m = (r + l) / 2;
            sort(l, m, arr);
            sort(m+1, r, arr);

            merge(l, m, r, arr);
        }
    }

    public static void merge(int l, int m, int r, int[] arr){
        //create aux arrays
        int left_length = m - l + 1;
        int right_length = r - m;
        int[] left = new int[left_length];
        int[] right = new int[right_length];

        System.arraycopy(arr, l, left, 0, left_length);
        System.arraycopy(arr, m + 1, right, 0, right_length);

        //compare elements and insert into arr
        int i = 0, j = 0;
        while(i < left_length && j < right_length){
            if(left[i] <= right[j]){
               arr[l + i + j] = left[i];
               i++;
            } else {
                arr[l + i + j] = right[j];
                j++;
            }
        }

        //copy the remaining elements from one of the array
        if(i < left_length){
            System.arraycopy(left, i, arr, l + i + j, left_length + right_length - (i + j));
        }

        if(j < right_length){
            System.arraycopy(right, j, arr, l + i + j, left_length + right_length - (i + j));
        }
    }
}
