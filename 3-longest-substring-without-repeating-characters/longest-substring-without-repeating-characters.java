class Solution {
    public int lengthOfLongestSubstring(String s) {
        int [] freq = new int[250];
        int left = 0 ; 
        int right = 0 ; 
        int max = 0; 
        while ( right < s.length()){
            freq[s.charAt(right)]++;
        
        if(freq[s.charAt(right)] > 1){
            while(freq[s.charAt(right)] > 1){
                freq[s.charAt(left)]--;
                left++;
            }
        }
        max = Math.max(max , right-left+1);
        right++;
        }
        return max;
    }
}