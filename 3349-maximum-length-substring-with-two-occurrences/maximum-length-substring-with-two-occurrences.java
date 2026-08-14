class Solution {
    public int maximumLengthSubstring(String s) {
        int maxx = 0 ; 
        int [] freq = new int [26];
        int left = 0 ; 
        int right = 0 ; 
        while(right < s.length()){
            freq[s.charAt(right) - 'a']++;
            if(freq[s.charAt(right) - 'a'] > 2){
                while(freq[s.charAt(right) - 'a']  > 2){
                    freq[s.charAt(left) - 'a']--;
                   left++; 
                }
                
            }
            maxx = Math.max(maxx, right - left + 1 );
            right++;
        }
        return maxx;
    }
}