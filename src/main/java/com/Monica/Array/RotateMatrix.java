package com.Monica.Array;

/**
 * 旋转图像
 */
public class RotateMatrix {

    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return;
        }
        int len = matrix.length;
        int time = 0;
        while (time <= (len >> 1)){
            int nums = len - (time << 1);
            for (int i = 0; i < nums - 1; i++) {
                int temp = matrix[time][time + i];
                matrix[time][time + i] = matrix[time + nums - i - 1][time];
                matrix[time + nums - i - 1][time] = matrix[time + nums - 1][time + nums - i - 1];
                matrix[time + nums - 1][time + nums - i - 1] = matrix[time + i][time + nums - 1];
                matrix[time + i][time + nums - 1] = temp;
            }
            ++time;
        }
    }
}
