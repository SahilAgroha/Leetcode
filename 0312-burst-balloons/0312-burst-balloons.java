class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        // Add virtual balloons
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        // length of interval
        for (int len = 1; len <= n; len++) {

            for (int left = 1; left <= n - len + 1; left++) {

                int right = left + len - 1;

                // choose last balloon
                for (int k = left; k <= right; k++) {

                    int leftCoins = (k == left) ? 0 : dp[left][k - 1];
                    int rightCoins = (k == right) ? 0 : dp[k + 1][right];

                    int coins =
                            leftCoins +
                            rightCoins +
                            arr[left - 1] * arr[k] * arr[right + 1];

                    dp[left][right] = Math.max(dp[left][right], coins);
                }
            }
        }

        return dp[1][n];
    }
}