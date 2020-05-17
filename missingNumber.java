class Solution {
    public int missingNumber(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        
        int totalSum = 0;
        for(int i = 0; i <= nums.length; i++){
            totalSum^=i;
        }
        
        int numsSum = 0;
        for(int j = 0; j < nums.length; j++){
            numsSum^=nums[j];
        }
        
        return totalSum ^ numsSum;
    }
}