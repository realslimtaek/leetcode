class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        for (int i = 0; i + 2 * k <= nums.size(); i++) {
            if(check(nums, i , k) && check(nums, i + k, k)) return true;
        }

        return false;
    }

    public boolean check(List<Integer> nums, int idx, int k) {
        System.out.println(idx);
        for (int i = idx+1; i < idx + k ; i++) {
            if(nums.get(i) <= nums.get(i-1)) return false;
        }
        return true;
    }
}