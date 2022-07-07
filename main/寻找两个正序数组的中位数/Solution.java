package 寻找两个正序数组的中位数;

import java.util.Arrays;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
 */

public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double d = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        int num[] = new int[n1 + n2];
        
        for (int i = 0;i< nums1.length; i++){
            num[i] = nums1[i];
        }
        
        for (int i = nums1.length ; i< num.length; i++){
            num[i] = nums2[i - nums1.length];
        }
        
        Arrays.sort(num);
        if (num.length % 2 == 1){
            int dex = num.length / 2;
            d = num[dex];
        } else {
            int dex = num.length / 2;
            int dex_2 = dex - 1;
            d = (double) (num[dex] + num[dex_2]) / 2;
        }
        return d;
    } 
}
