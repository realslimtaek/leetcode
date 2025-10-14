class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {

        int y = -1001;
        int cnt = 0;
        int tot = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (y >= nums.get(i)) {
                y = -1001;
                cnt = 0;
            }

            y = nums.get(i);
            cnt += 1;

            if (cnt == k) {
                if (i + k >= nums.size())
                    break;
                boolean t = checkB(nums, i + 1, k);
                if (t)
                    return true;
                else {
                    i = i - k + 1;
                    cnt = 1;
                }
            }
        }

        return false;
    }

    public boolean checkB(List<Integer> nums, int idx, int k) {
        for (int i = idx+1; i < idx+ k ; i++) {
            if(nums.get(i) <= nums.get(i-1)) return false;
        }
        return true;
    }
}