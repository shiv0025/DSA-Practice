class Solution {
    public int countCommas(int n) {
        int count = 0 ; 
        if (n < 1000){
            return 0;
        }
               int res = n/1000;
               if(res >= 1 && res <= 100){
                count = n - 1000 + 1 ;
               
            }
        
        
      return count; 
    }
}