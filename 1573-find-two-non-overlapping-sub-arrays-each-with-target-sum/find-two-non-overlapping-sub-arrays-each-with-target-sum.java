class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;
        int INF = 1000000;

        int[] dp = new int[n];
        Arrays.fill(dp, INF);

        int left = 0;
        int sum = 0;
        int ans = INF;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {

                int len = right - left + 1;

                // Combine with the best previous subarray
                if (left > 0 && dp[left - 1] != INF) {
                    ans = Math.min(ans, len + dp[left - 1]);
                }

                // Store minimum length ending at or before right
                if (right == 0) {
                    dp[right] = len;
                } else {
                    dp[right] = Math.min(dp[right - 1], len);
                }

            } else {

                if (right > 0) {
                    dp[right] = dp[right - 1];
                }

            }
        }

        return ans == INF ? -1 : ans;
    }
}