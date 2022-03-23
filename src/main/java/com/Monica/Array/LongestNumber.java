package com.Monica.Array;

/**
 * 最长回文数
 */
public class LongestNumber {

    //暴力法
    //但是怎么去判断括号里面的是否是回文数呢
    public String longestPalindrome(String s) {
        int length;
        if (s == null || (length = s.length()) == 0){
            return null;
        }
        if (s.length() < 2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                String substring = s.substring(i, j + 1);
                if (j - i + 1 > maxLen && isPalindrome(substring)){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin + maxLen);
    }

    //中心扩散
    public String longestPalindrome1(String s){
        int length;
        if (s == null || (length = s.length()) == 0){
            return null;
        }
        if (s.length() < 2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        for (int i = 0; i < length - 1; i++) {
            //如果为基数的中心扩散
            int len1 = getPalindromeCenterLen(s, length, i, i);
            int len2 = getPalindromeCenterLen(s,length,i,i + 1);
            len1 = Math.max(len1, len2);
            if (len1 > maxLen){
                maxLen = len1;
                begin = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(begin,begin + maxLen);
    }

    /**
     * 判断是否为回文数
     */
    public boolean isPalindrome(String s){
        int i = 0;
        int j = s.length() - 1;
        while (i <= j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 中心扩散，判断是否回文
     */
    public int getPalindromeCenterLen(String s,int len,int left,int right){
        int l = left;
        int r = right;
        while (l >= 0 && r < len){
            if (s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }else {
                break;
            }
        }
        return r - l - 1;
    }

    public static void main(String[] args) {
        LongestNumber number = new LongestNumber();
        String  s = number.longestPalindrome1("acddc");
        System.out.println(s);
    }

}
