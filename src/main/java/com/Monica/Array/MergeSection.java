package com.Monica.Array;

/**
 * 合并区间
 */
public class MergeSection {

    // TODO: 2022/2/25 还没想出来
    //暴力法
    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if (length == 0){
            return new int[][]{};
        }
        if (length == 1){
            return intervals;
        }
        int i = 0;
        int j = 1;
        while (i < length){
            if (j < length && intervals[i][1] <= intervals[j][0]){
                j++;
            }else {

            }
        }
        return null;
    }

}
