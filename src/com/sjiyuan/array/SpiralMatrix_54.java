package com.sjiyuan.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SpiralMatrix_54
 * @Description TODO 螺旋形打印矩阵
 * @Author sjy
 * @Date 2020/1/25 21:36
 * @Version 1.0
 **/
public class SpiralMatrix_54 {
    /**
     * 我的思想：
     * 1.方法打印矩阵的一圈
     * 2.更新打印的矩阵起始范围，再打印
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int rowLength = matrix.length;
        if (rowLength == 0) return result;
        int columnLength = matrix[0].length;
        if (columnLength == 0) return result;

        int rowStart = 0;
        int rowEnd = rowLength - 1;
        int columnStart = 0;
        int columnEnd = columnLength - 1;

        while (rowStart <= rowEnd && columnStart <= columnEnd) {
            addCircularData(matrix, rowStart, rowEnd, columnStart, columnEnd, result);
            rowStart++;
            rowEnd--;
            columnStart++;
            columnEnd--;
        }


        return result;
    }

    /**
     * 指定一个矩阵范围，按照顺时针访问
     * 1.先打印顺时针的上边
     * 2.打印顺时针的右边
     * 3.打印顺时针的下边
     * 4.打印顺时针的左边
     */
    public void addCircularData(int[][] matrix, int rowStart, int rowEnd, int columnStart, int columnEnd, List<Integer> list) {

        for (int i = columnStart; i <= columnEnd; i++) {
            list.add(matrix[rowStart][i]);
        }

        for (int i = rowStart + 1; i <= rowEnd; i++) {
            list.add(matrix[i][columnEnd]);
        }

        //如果只有一行，就不需要底下那一层打印了
        if (rowStart != rowEnd) {
            for (int i = columnEnd - 1; i >= columnStart; i--) {
                list.add(matrix[rowEnd][i]);
            }
        }

        //如果只有一列，就不需要左边的那一层打印了
        if (columnStart != columnEnd) {
            for (int i = rowEnd - 1; i >= rowStart + 1; i--) {
                list.add(matrix[i][columnStart]);
            }
        }

    }

    public static void main(String args[]) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        SpiralMatrix_54 spiralMatrix_54 = new SpiralMatrix_54();
        List<Integer> integers = spiralMatrix_54.spiralOrder(matrix);
    }
}
