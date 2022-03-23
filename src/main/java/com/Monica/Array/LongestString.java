package com.Monica.Array;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 无重复字符最长子串
 */
public class LongestString {

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        new ReentrantLock();
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int l = -1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0){
                set.remove(s.charAt(i - 1));
            }
            while (l + 1 < n && !set.contains(s.charAt(l + 1))){
                set.add(s.charAt(l + 1));
                ++l;
            }
            ans = Math.max(ans,l - i + 1);
        }
        return ans;
    }
}
