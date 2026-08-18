class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        int[] freq = new int[51];

        for (int num : nums) {
            freq[num]++;
        }

        // Only one subarray: the entire array
        if (k == n) {
            for (int x = 50; x >= 0; x--) {
                if (freq[x] > 0) {
                    return x;
                }
            }
        }

        // Every element is its own subarray
        if (k == 1) {
            for (int x = 50; x >= 0; x--) {
                if (freq[x] == 1) {
                    return x;
                }
            }
            return -1;
        }

        // 1 < k < n
        int ans = -1;

        if (freq[nums[0]] == 1) {
            ans = Math.max(ans, nums[0]);
        }

        if (freq[nums[n - 1]] == 1) {
            ans = Math.max(ans, nums[n - 1]);
        }

        return ans;
    }
}