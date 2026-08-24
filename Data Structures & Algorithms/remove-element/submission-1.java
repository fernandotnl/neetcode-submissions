class Solution {
    public int removeElement(int[] nums, int val) {
        int shifts = 0;
        int i =0;
        while(i< nums.length-shifts) {
            int num = nums[i];
            if (num == val) {
                for(int j=i; j < nums.length-shifts-1; j++) {
                    nums[j] = nums[j+1];
                }
                shifts++;
            } else {
                i++;
            }
        }
        return nums.length-shifts;
    }

   
}