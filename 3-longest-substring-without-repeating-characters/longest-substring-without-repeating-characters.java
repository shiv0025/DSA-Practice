class Solution {
    public int lengthOfLongestSubstring(String s) {
       int maxx = 0 ; 
        int [] freq = new int[150];
        int left = 0 ; 
        int right = 0 ; 
        while (right < s.length()){
            freq[s.charAt(right) ]++;
            
                while(freq[s.charAt(right) ] > 1){
                   freq[ s.charAt(left) ]--;
                  left++;
                }
               
            maxx = Math.max(maxx , right - left +1);
            right++;
        }
        return maxx; 
    }
}