package com.loveneesh.practice.leetcode;

import java.util.Arrays;

public class HouseRobber {
    int[] values;
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }else if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        values = new int[101];
        Arrays.fill(values, -1);
        return robbing(nums,0);
    }

    public int robbing(int[] nums, int houseNo){
        if(houseNo >= nums.length){
            return 0;
        }

        if(values[houseNo] != -1){
            return values[houseNo];
        }

        values[houseNo] = Math.max(robbing(nums,houseNo+1),nums[houseNo] + robbing(nums,houseNo+2));
        return values[houseNo];
    }
}
