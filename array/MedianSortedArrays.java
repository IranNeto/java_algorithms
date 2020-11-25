package array;//https://leetcode.com/problems/median-of-two-sorted-arrays/
/*
    Good explanation video: https://www.youtube.com/watch?v=LPFhl65R7ww&t=983s
 */

public class MedianSortedArrays {

    public static void main(String[] args) {
        int[] x = new int[]{1,3};
        int[] y = new int[]{2};

        System.out.println(findMedianSortedArrays(x, y));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        int start = 0;
        int end = nums1.length;
        int pos_1, pos_2, left_1, left_2, right_1, right_2;

        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }

        while(start <= end){

            pos_1 = (start + end) / 2;
            pos_2 = ((nums1.length + nums2.length + 1) / 2) - pos_1;

            /*
                If one of pos_1 or pos_2 is equals to 0 the other is equals to the length of the array
                knowing that is possible to affirm that every element from the left is smaller than every element from the right.
                Since that happens is possible just to repeat the value in edge cases
             */
            left_1 = pos_1 == 0 ? nums2[pos_2 - 1] : nums1[pos_1 - 1];
            right_1 = pos_1 == nums1.length ? nums2[pos_2] : nums1[pos_1];
            left_2 = pos_2 == 0 ? nums1[pos_1 - 1] : nums2[pos_2 - 1];
            right_2 = pos_2 == nums2.length ? nums1[pos_1] : nums2[pos_2];

            if(left_1 > right_2){
                end = pos_1 - 1;
            } else if(left_2 > right_1){
                start = pos_1 + 1;
            } else {
                if((nums1.length + nums2.length) % 2 == 0){
                    return (Math.max(left_1, right_2) + Math.min(right_1, left_2)) / 2.0;
                } else {
                    return Math.max(left_1, left_2);
                }
            }

        }
        return 0.0;
    }
}
