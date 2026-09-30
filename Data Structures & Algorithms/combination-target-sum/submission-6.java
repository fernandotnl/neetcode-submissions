class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            dfs(nums, i, target, new LinkedList<>(), results);
        } 
        return results;
    }

    public void dfs(int[] nums, int i, int target, LinkedList<Integer> subset, List<List<Integer>> results) {
        int sum = subset.stream().mapToInt(Integer::intValue)
                          .sum();
        if (sum == target) {
            results.add(new LinkedList<>(subset));
            return;
        }
        int val = nums[i];
        if (sum + val <= target) {
            subset.add(val);
        } else {
            return;
        }
        dfs(nums, i, target, subset, results);
        subset.removeLast();
        if (subset.isEmpty()) {
            return;
        }
        int j=i+1;
        if (j >= nums.length) {
            return;
        }
        val = nums[j];
        if (sum + val <= target) {
            dfs(nums, j, target, subset, results);
        }
    }
}
