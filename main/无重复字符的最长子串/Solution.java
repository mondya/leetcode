package 无重复字符的最长子串;

import java.util.*;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Solution {

    public static void main(String[] args) {
    }

    public static int lengthOfLongestSubstring(String s){
        return 0;
    }
    public static int delete_lengthOfLongestSubstring(String s) {
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
                String z = split[i];
                
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
        if (list.size() > 0){
            max = Collections.max(delList);
        }
        
        return max;
    }
}
