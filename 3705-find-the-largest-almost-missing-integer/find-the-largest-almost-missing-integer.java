class Solution {
    public int largestInteger(int[] nums, int k) {

        int n = nums.length;

        // Case 1: k == 1
        if (k == 1) {
            int[] freq = new int[51];

            for (int num : nums) {
                freq[num]++;
            }

            int ans = -1;

            for (int num : nums) {
                if (freq[num] == 1) {
                    ans = Math.max(ans, num);
                }
            }

            return ans;
        }

        // Case 2: k == n
        if (k == n) {
            int ans = 0;

            for (int num : nums) {
                ans = Math.max(ans, num);
            }

            return ans;
        }

        // Case 3: 1 < k < n
        int ans = -1;

        // Only first element can be present in exactly one
        // subarray if it doesn't occur anywhere else.
        int first = nums[0];
        boolean firstUnique = true;

        for (int i = 1; i < n; i++) {
            if (nums[i] == first) {
                firstUnique = false;
                break;
            }
        }

        if (firstUnique) {
            ans = Math.max(ans, first);
        }

        // Only last element can be present in exactly one
        // subarray if it doesn't occur anywhere else.
        int last = nums[n - 1];
        boolean lastUnique = true;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == last) {
                lastUnique = false;
                break;
            }
        }

        if (lastUnique) {
            ans = Math.max(ans, last);
        }

        return ans;
    }
}