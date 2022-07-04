package 无重复字符的最长子串;

import java.util.*;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Solution {

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s = "a,b,c,a,b,c,b,b";
        Integer i = lengthOfLongestSubstring(s1);
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s){
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }
    public static Integer delete_lengthOfLongestSubstring(String s) {
        String[] split = s.split(",");
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            if (i == 0 && split.length > 1){
                if (!split[0].equals(split[1])){
                    map.put(0, split[0]);
                }
            } else if (i < split.length - 1){
                String x = split[i];
                String y = split[i-1];
                String z = split[i+1];
                
                if (!x.equals(y) && !x.equals(z)){
                    map.put(i, x);
                }
            } else {
                String x = split[i];
                String z = split[i-1];
                if (!x.equals(z)){
                    map.put(i, x);
                }
            }
            
        }
        
        if (map == null){
            return 1;
        }
        List<Integer> list = new ArrayList<>();
        List<Integer> delList = new ArrayList<>();
        for (Map.Entry<Integer, String> index : map.entrySet()){
            list.add(index.getKey());
        }
        for (int i = 0; i < list.size() - 1; i++) {
            Integer integer = list.get(i + 1);
            Integer del = list.get(i);
            int abs = Math.abs(integer - del);
            delList.add(abs);
        }
        Integer max = null;
        if (delList.size() > 0){
            max = Collections.max(delList);
        }
        
        return max;
    }
}
