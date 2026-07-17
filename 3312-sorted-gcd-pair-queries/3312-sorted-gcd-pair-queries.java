import java.util.*;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);

        // freq[x] = frequency of x
        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;

        // exact[g] = number of pairs whose gcd is exactly g
        long[] exact = new long[max + 1];

        // Process from largest gcd to smallest
        for (int g = max; g >= 1; g--) {

            long cnt = 0;

            // Count numbers divisible by g
            for (int multiple = g; multiple <= max; multiple += g) {
                cnt += freq[multiple];
            }

            // Total pairs divisible by g
            exact[g] = cnt * (cnt - 1) / 2;

            // Remove pairs already counted for multiples of g
            for (int multiple = 2 * g; multiple <= max; multiple += g) {
                exact[g] -= exact[multiple];
            }
        }

        // Prefix sum of pair counts
        long[] prefix = new long[max + 1];
        for (int g = 1; g <= max; g++) {
            prefix[g] = prefix[g - 1] + exact[g];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long k = queries[i] + 1; // queries are 0-indexed

            int lo = 1, hi = max;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                if (prefix[mid] >= k)
                    hi = mid;
                else
                    lo = mid + 1;
            }
            ans[i] = lo;
        }

        return ans;
    }
}