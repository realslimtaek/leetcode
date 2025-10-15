class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {

        int ans = 0, own = 0, cnt = 1, size = nums.size();
        for (int i = 0; i < size - 1; i++) {

            if (nums.get(i) >= nums.get(i + 1)) {
                ans = calc(ans, cnt, own);
                own = cnt;
                cnt = 1;
                continue;
            } else cnt++;
        }

        ans = calc(ans, cnt, own);
        return ans != 0 ? ans : size / 2;
    }

    public int calc(int a, int b, int c) {
        if (a >= b) return a;
        int abMin = Math.min(a, b);
        int abHalfMax = Math.max(a / 2, b / 2);
        return Math.max(Math.min(c, b), Math.max(abMin, abHalfMax));
    }

}