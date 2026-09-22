class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;

        while(start <= end) {
          int pivot = (end - start)/2 + start;
          if (nums[pivot] < target) {
            start = pivot + 1;
          } else if(nums[pivot] > target) {
            end = pivot - 1;
          } else {
            return pivot;
          }
        }
        return -1;
    }

}
