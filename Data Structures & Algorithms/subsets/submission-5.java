class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(nums, 0, new LinkedList<>(), results);
        return results;
    }

    public void dfs(int[] nums, int i, LinkedList<Integer> subset, List<List<Integer>> results) {
        if (i >= nums.length) {
            results.add(new LinkedList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(nums, i + 1, subset, results);
        subset.removeLast();
        dfs(nums, i + 1, subset, results);
    }
}
