package com.sjiyuan.offer;

/**
 * 二维数组中的查找
 * 查找一个固定的数值，返回是否查找成功或者失败
 */
public class Subject04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int lengthX = matrix.length;
        if(lengthX == 0) return false;
        int lengthY = matrix[0].length;
        if(lengthY == 0) return false;

        int i, j;

        /**
         * [
         *   [1,   4,  7, 11, 15],
         *   [2,   5,  8, 12, 19],
         *   [3,   6,  9, 16, 22],
         *   [10, 13, 14, 17, 24],
         *   [18, 21, 23, 26, 30]
         * ]
         * 思想：
         * 从右上角开始，如果
         * 相等：查找到
         * 大于target：说明所在下面列，都会大于target
         * 小于target：说明所在左边行，都会小于target
         * 所以是向下或者向左走，超出范围(i < lengthX, j >= 0)后就返回false
         */
        for (i = 0, j = lengthY - 1; i < lengthX && j >= 0;) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i = i + 1;
            } else {
                j = j - 1;
            }
        }
        return false;
    }
}
