class Solution {
    public int[] twoSum(int[] nums, int target) {
            int [] ans = new int[2];
        int i = 0 ; 
        int j = i+1;
        while(i <  nums.length -1){
            while(j < nums.length){
            int val = nums[i] + nums[j];
            if(val == target){
                ans[0] = i ;
                ans[1] = j ; 
                return ans ;
            }
            j++;

        } 
        i++;
        j = i+1;
    }
    return ans ;
    }
}