class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {

        List<Integer> data = new ArrayList<Integer>();
        int ans = 0;
        int size = nums.size();
        int cnt = 1;
        for (int i = 0; i < size - 1; i++) {

            if (nums.get(i) >= nums.get(i + 1)) {
                data.add(cnt);
                cnt = 1;
                continue;
            }
            cnt++;
        }
        data.add(cnt);
        if (data.size() == 1) {
            return data.get(0) / 2;
        }

        for (int i = 0; i < data.size() - 1; i++) {
            ans = Math.max(ans, calc(data.get(i), data.get(i + 1)));
        }

        return ans;
    }

    public int calc(int a, int b) {
        return Math.max(b / 2, Math.max(a / 2, Math.min(a, b)));
    }
}