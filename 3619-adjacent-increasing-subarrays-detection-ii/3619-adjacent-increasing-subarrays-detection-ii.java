class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {

        int ans = 0;
        int own = 0;
        int size = nums.size();
        int cnt = 1;
        for (int i = 0; i < size - 1; i++) {

            if (nums.get(i) >= nums.get(i + 1)) {
                if (cnt > ans) {
                    ans = calc(ans, cnt, own);
                }
                own = cnt;
                cnt = 1;
                continue;
            }
            cnt++;
        }
        if (cnt > ans) {
            ans = calc(ans, cnt, own);
        }
        return ans != 0 ? ans : size / 2;
    }

    public int calc(int a, int b, int c) {
        int abMin = Math.min(a, b);
        int abHalfMax = Math.max(a / 2, b / 2);
        return Math.max(Math.min(c, b), Math.max(abMin, abHalfMax));
    }

}