package com.sjiyuan.offer;

/**
 * 剪绳子
 * 动态规划：
 * 先从最短的开始，逐步算出最长的绳子的最大乘积
 */
public class Subject14_1 {

    /**
     * 存放对应位数，整数拆分，作为其中一个数字时，最优解
     */
    private int[] max = new int[100];

    public int cuttingRope(int n) {
        if (n == 0 || n == 1) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;

        max[0] = 0;
        max[1] = 1;
        /**
         * 2：作为一个整数，只有1,1一种拆法，解为1。作为整数拆分的一份子，其算作2
         * 3：作为一个整数，只有1,2和1,1,1两种拆法，解为2。作为整数拆分的一份子，其算作3
         */
        max[2] = 2;
        max[3] = 3;

        /**
         * 求n的整数拆分后的最大乘积，根据动态规划，需要把子问题，全都求解清楚
         * 大于4的情况，不会出现 1*n > i*j的情况了
         */
        for (int i = 4; i <= n; i++) {
            /**
             * i = 4,j <= 2
             * i = 5,j <= 2
             * i = 6,j <= 3
             * 长度可划分为j与n-j，j的范围 1 - i/2，其中最大的乘积即为所求
             * temp存的是过去划分的乘积
             */
            int temp = 0;
            for (int j = 1; j <= i / 2; j++) {
                if ((max[j] * max[i - j]) > temp) temp = (max[j] * max[i - j]);
            }
            max[i] = temp;
        }

        return max[n];
    }
}
