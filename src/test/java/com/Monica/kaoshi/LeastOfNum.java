package com.Monica.kaoshi;

public class LeastOfNum {

    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     * 将 sourceX, sourceY 转换成 targetX, targetY 最少需要多少次计算
     * @param sourceX long长整型  x初始值
     * @param sourceY long长整型  y初始值
     * @param targetX long长整型  x目标值
     * @param targetY long长整型  y目标值
     * @return long长整型
     */
    public long GetMinCalculateCount(long sourceX, long sourceY, long targetX, long targetY) {
        // write code here
        //反向算
        if (sourceX > targetX || sourceY > targetY){
            return -1;
        }
        long result = 0;
        if (sourceX == targetX && sourceY == targetY){
            return result;
        }
        long tx = targetX;
        long ty = targetY;
        while (sourceX < targetX && sourceY < targetY){
            tx = targetX;
            ty = targetY;
            targetX = targetX / 2;
            targetY = targetY / 2;
            result++;
        }
        result--;
        while (sourceX < tx && sourceY < ty){
            tx--;
            ty--;
            result++;
        }
        if (result == 0){
            return -1;
        }
        return result;
    }

    public static void main(String[] args) {
        LeastOfNum num = new LeastOfNum();
        long l = num.GetMinCalculateCount(1,1,3,3);
        System.out.println(l);
    }
}
