class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;

        for (int num : nums) {
            if (num != 0) {
                nums[index] = num;
                index++;
            }
        }

        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }
}

/*
Input:
nums = [0,1,0,3,12]

Output:
[1,3,12,0,0]
*/