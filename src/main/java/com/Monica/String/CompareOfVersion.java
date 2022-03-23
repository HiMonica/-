package com.Monica.String;

/**
 * 比较版本号
 */
public class CompareOfVersion {

    /**
     * 思路：将字符串用.隔开，然后转化为整数
     */
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        for (int i = 0; i < str1.length || i < str2.length; i++) {
            int x = 0;
            int y = 0;
            if (i < str1.length){
                x = Integer.parseInt(str1[i]);
            }
            if (i < str2.length){
                y = Integer.parseInt(str2[i]);
            }
            if (x < y){
                return -1;
            }
            if (x > y){
                return 1;
            }
        }
        return 0;
    }
}
