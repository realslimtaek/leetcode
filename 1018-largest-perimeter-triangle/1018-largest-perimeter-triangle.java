class Solution {
    public int largestPerimeter(int[] nums) {

        nums = Arrays.stream(nums)
                .boxed() // int → Integer
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] < nums[i + 1] + nums[i + 2])
                return nums[i] + nums[i + 1] + nums[i + 2];
        }
        return 0;
    }
}