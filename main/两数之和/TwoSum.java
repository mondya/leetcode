package 两数之和;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定一个整数数组 num 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum
 */

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(getIndex(nums, target)));
    }
    
    public static int[] getIndex(int[] nums, int target){
        /**
         * 思路：把target - nums[i] 的值作为key，i作为value存入map中
         * 当 map 
         */
        int[] index = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                index[0] = i;
                index[1] = map.get(nums[i]);
                return index;
            }
            map.put(target - nums[i], i);
        }
        return index;
    }
}
