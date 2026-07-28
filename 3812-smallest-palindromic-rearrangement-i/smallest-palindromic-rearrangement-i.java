class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

  
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        char middle = 0;

        
        for (int i = 0; i < 26; i++) {
            int half = freq[i] / 2;

            for (int j = 0; j < half; j++) {
                char ch = (char) ('a' + i);
                sb.append(ch);
            }

            
            if (freq[i] % 2 == 1) {
                middle = (char) ('a' + i);
            }
        }

        
        String firstHalf = sb.toString();

        
        if (middle != 0) {
            sb.append(middle);
        }

       
        sb.append(new StringBuilder(firstHalf).reverse());

        return sb.toString();
    }
}