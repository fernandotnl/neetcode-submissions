class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> values = new HashMap<>();
        values.put(nums[0], 0);
        for(int j=1; j<nums.length; j++) {
            int val = nums[j];
            int diff = target - val;
            int i = values.getOrDefault(diff, -1);
            if(i != -1){
                return new int[]{i, j};
            }
            values.put(val, j);
        }
        return new int[0];
    }
}
