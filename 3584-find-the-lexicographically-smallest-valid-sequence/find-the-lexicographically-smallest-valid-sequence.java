class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] arr = new int[m];

        // suffix[j] = earliest index in word1
        // from which word2[j...] can be matched
        int[] suffix = new int[m + 1];

        suffix[m] = n;

        int i = n - 1;

        for (int j = m - 1; j >= 0; j--) {

            while (i >= 0 && word1.charAt(i) != word2.charAt(j)) {
                i--;
            }

            if (i < 0) {
                suffix[j] = -1;
            } else {
                suffix[j] = i;
                i--;
            }
        }

        i = 0;
        int j = 0;
        int count = 1;
        int k = 0;

        while (i < n && j < m) {

            // Case 1: characters match
            if (word1.charAt(i) == word2.charAt(j)) {

                arr[k] = i;
                k++;
                i++;
                j++;

            }

            // Case 2: mismatch
            else if (count == 1) {

                // Check whether remaining word2 can be matched
                if (j + 1 == m || suffix[j + 1] > i) {

                    arr[k] = i;
                    k++;

                    count--;
                    i++;
                    j++;

                } else {
                    i++;
                }
            }

            // mismatch already used
            else {
                i++;
            }
        }

        if (k == m) {
            return arr;
        }

        return new int[0];
    }
}