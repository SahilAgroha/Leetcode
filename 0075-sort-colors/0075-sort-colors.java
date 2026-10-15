
class Solution {
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void sortColors(int[] nums) {
        int start = 0;
        int i = 0;
        int end = nums.length - 1;

        while (i <= end) {
            if (nums[i] == 0) {
                swap(nums, i, start);
                start++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, end);
                end--;
            }
        }
    }
}
