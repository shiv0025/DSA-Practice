class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int [] prefixmax = new int[nums.length]; 
        int [] suffixmin = new int[nums.length]; 
        int max = 0 ;
        int min = Integer.MAX_VALUE;
        for (int i = 0 ; i < nums.length ; i++){
            if(nums[i] > max){
                max = nums[i];
            }
            prefixmax[i] = max;
        }
        for (int i = nums.length-1  ; i >= 0 ; i--){
            if(nums[i] < min){
                min = nums[i];
            }
            suffixmin[i] = min;
        }
        for(int j = 0 ; j < nums.length ; j++){
            int res = prefixmax[j] - suffixmin[j];
           if(res <= k){
            return j;
           }
           
        }
        return -1;
    }
}