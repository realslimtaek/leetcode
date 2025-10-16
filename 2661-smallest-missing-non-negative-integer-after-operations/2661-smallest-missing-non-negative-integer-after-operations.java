class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        boolean[] check = new boolean[nums.length];

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int now : nums) {
            
            if (now < 0) {
                int temp = Math.abs(now) % value;
                now = temp == 0 ? 0 : value - temp;
            } else {
                now = now % value;
            }

            countMap.put(now, countMap.getOrDefault(now, -1) + 1);

            if ((value * (countMap.get(now)) + now) < check.length) {
                check[value * (countMap.get(now)) + now] = true;
            }
        }

        int ans = 0;
        for (boolean b : check) {
            if (!b)
                break;
            ans++;
        }

        return ans;
    }
}