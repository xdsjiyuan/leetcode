package com.sjiyuan.array;

/**
 * @ClassName FindDuplicateData_287
 * @Description TODO 寻找重复数
 * @Author sjy
 * @Date 2020/1/1 17:41
 * @Version 1.0
 **/
public class FindDuplicateData_287 {


    /**
     * 二分法
     * nums的范围是 0 - n，一共n+1个
     * nums里存储的数据范围为 1 - n，n为nums.length - 1
     *
     * @param nums
     * @return
     */
    public int dichotomy(int nums[]) {

        int left = 1;
        int right = nums.length - 1;

        while (left < right) {
            int count = 0;
            /**
             * 二分法取中间数
             * 个数是偶数的，取前一个，奇数的，取中间
             * 比如从5 - 10，7为分界线，6 - 12，9为分界线
             */
            int middle = left + (right - left) / 2;
            for (int temp : nums) {
                if (temp <= middle && temp >= left) {
                    count++;
                }
            }
            /**
             * 比如1,2,3,4，计数的数量大于4时，说明重复的数字在1 - 4之间
             * 否则，在另外的部分
             * 重复此操作，直到找到中间的那个重复的数字
             */
            if (count > (middle - left + 1)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    /**
     * 1,1,3,4,5,6,7,8
     * @param args
     */
    public static void main(String args[]) {
        //0-7
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 1};
        FindDuplicateData_287 f = new FindDuplicateData_287();
        System.out.println("答案：" + f.dichotomy(nums));

    }


}
