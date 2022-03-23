package com.Monica.String;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 */
public class LongestString {
    public static void main(String[] args) {
        String s = "abcabcabcd";
        Solution solution = new Solution();
        int i = solution.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}

//滑动窗口
class Solution{
    public int lengthOfLongestSubstring(String s){
        if (s.length() == 0){
            return 0;
        }
        int len = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0 ; i < len ; ++i){
            if (map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }
}



//复习
class Solution1{
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        int length = s.length();
        int left = 0;
        int max = 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i - left + 1);
        }
        return max;
    }

}
























