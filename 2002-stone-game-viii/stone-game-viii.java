class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] pre = new int[n];

        pre[0] = stones[0];

        for (int i = 1; i < n; i++)
            pre[i] = pre[i - 1] + stones[i];

        int ans = pre[n - 1];

        for (int i = n - 2; i >= 1; i--)
            ans = Math.max(ans, pre[i] - ans);

        return ans;
    }
}
