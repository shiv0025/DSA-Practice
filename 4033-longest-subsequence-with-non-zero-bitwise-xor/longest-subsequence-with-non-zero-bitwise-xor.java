class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int xor = 0;
        int zero = 0;

        for (int num : nums) {
            xor ^= num;

            if (num == 0) {
                zero++;
            }
        }

        // Whole array already has non-zero XOR
        if (xor != 0) {
            return n;
        }

        // All elements are zero
        if (zero == n) {
            return 0;
        }

        // XOR is zero, but at least one non-zero exists
        return n - 1;
    }
}