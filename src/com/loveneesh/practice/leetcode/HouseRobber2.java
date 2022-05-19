package com.loveneesh.practice.leetcode;

import java.util.Arrays;

public class HouseRobber2 {
    int[] values;
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }else if(nums.length == 3){
            return Math.max(Math.max(nums[0],nums[1]),nums[2]);
        }
        values = new int[101];
        Arrays.fill(values, -1);
        int value1 = robbing(nums,0, 0);
        Arrays.fill(values, -1);
        int value2 = robbing(nums, 1, 1);
        return Math.max(value1,value2);
    }

    public int robbing(int[] nums, int houseNo, int robbingInitiated){
        if(robbingInitiated == 0 && houseNo == nums.length - 1){
            return 0;
        }

        if(houseNo >= nums.length){
            return 0;
        }

        if(values[houseNo] != -1){
            return values[houseNo];
        }

        values[houseNo] = Math.max(robbing(nums,houseNo+1, robbingInitiated),nums[houseNo] + robbing(nums,houseNo+2, robbingInitiated));
        return values[houseNo];
    }
}
