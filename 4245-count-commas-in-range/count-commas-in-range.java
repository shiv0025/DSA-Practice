class Solution {
    public int countCommas(int n) {
        int count = 0 ; 
        if (n < 1000){
            return 0;
        }
            for(int i = 1 ; i < 4; i++){
               int val = (int)Math.pow(10 , i);
               int res = n/val;
               if(res >= 1 && res <= 100){
                count = n - val + 1 ;
               }
            }
        
        
      return count; 
    }
}