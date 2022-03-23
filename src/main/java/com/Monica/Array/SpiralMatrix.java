package com.Monica.Array;

import java.util.*;

/**
 * 螺旋矩阵
 */
public class SpiralMatrix {

    // TODO: 2022/2/25 不是很想做，方法是模拟，就是跟着逻辑思路写出来就好了
    public List<Integer> spiralOrder(int[][] matrix) {
        //set就好
        Set<Integer> store = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        int row = matrix.length;
        int column = matrix[0].length;

        int r = 0;
        int c = 0;
        //思考：怎么去判断每次遍历的长度
        //循环的交件是不碰壁就一只遍历，碰壁的话就换一个方向
        while (r < row || c < column || store.contains(matrix[r][c])){
            //思考：怎么判断碰壁之后的方向呢？
            if (r == row - 1){

            }
            if (c == column - 1){

            }
            store.add(matrix[r][c]);

        }
        return null;
    }
}
