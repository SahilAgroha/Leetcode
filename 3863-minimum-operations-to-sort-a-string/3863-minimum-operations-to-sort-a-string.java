class Solution {
    public int minOperations(String s) {
        int n = s.length();
        boolean sorted = true;

        char min = s.charAt(0);
        char max = s.charAt(0);

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            min = (char) Math.min(min, ch);
            max = (char) Math.max(max, ch);

            if (i > 0 && s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
            }
        }

        // Case 1: Already sorted
        if (sorted) return 0;

        // Case 2: Cannot sort a reversed string of length 2
        if (n == 2) return -1;

        // Case 3: Minimum is already first, or maximum is already last
        if (s.charAt(0) == min || s.charAt(n - 1) == max) {
            return 1;
        }

        // Case 4: Minimum or maximum is somewhere in the middle
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == min || s.charAt(i) == max) {
                return 2;
            }
        }

        // Case 5: Both extremes are at the wrong ends
        return 3;
    }
}