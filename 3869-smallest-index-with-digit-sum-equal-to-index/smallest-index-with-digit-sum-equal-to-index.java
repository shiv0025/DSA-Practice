class Solution {
    public int smallestIndex(int[] nums) {
        int ans = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            int n = nums[i];
            ans = 0 ;
            while (n > 0){
                int rem = n % 10 ;
                
                ans += rem;
                n = n / 10;
            }
            if (ans == i){
                return i;
            }
        }
        return -1;
    }
}