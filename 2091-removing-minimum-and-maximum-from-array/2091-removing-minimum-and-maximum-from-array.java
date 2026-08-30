class Solution {
    public int minimumDeletions(int[] nums) {

        int max = 0;
        int min = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[max] < nums[i]) {
                max = i;
            }

            if (nums[min] > nums[i]) {
                min = i;
            }
        }

        int left = Math.min(min, max);
        int right = Math.max(min, max);

        // Remove both from left
        int option1 = right + 1;

        // Remove both from right
        int option2 = n - left;

        // Remove one from each side
        int option3 = (left + 1) + (n - right);

        return Math.min(option1,
                Math.min(option2, option3));
    }
}