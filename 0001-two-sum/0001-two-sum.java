class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<nums.length; i++) {
            int now = target - nums[i];
            if(map.containsKey(now)) {
                return new int[]{i, map.get(now)};
            } else map.put(nums[i],i);
        }
        return new int[]{ 0, 0};
    }
}