class Solution {
    public int largestPerimeter(int[] nums) {

        nums = Arrays.stream(nums)
                .boxed() // int → Integer
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] < nums[j] + nums[k])
                        return nums[i] + nums[j] + nums[k];
                }
            }
        }
        return 0;
    }
}