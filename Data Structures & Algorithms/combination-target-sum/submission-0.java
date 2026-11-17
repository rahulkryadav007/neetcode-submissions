
class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(0, nums, target, current, result);

        return result;
    }

    private void backtrack(int index, int[] nums, int target,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // Target achieved
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Invalid condition
        if (index == nums.length || target < 0) {
            return;
        }

        // Choice 1: Include current element
        current.add(nums[index]);

        // Same index because element can be reused
        backtrack(index, nums, target - nums[index],
                  current, result);

        // Backtrack
        current.remove(current.size() - 1);

        // Choice 2: Exclude current element
        backtrack(index + 1, nums, target,
                  current, result);
    }
}
