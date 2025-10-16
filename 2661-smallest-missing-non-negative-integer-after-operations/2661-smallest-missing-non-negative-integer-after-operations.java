class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        boolean[] check = new boolean[505050];

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int now : nums) {
            if (now < 0) {
                int temp = Math.abs(now) % value;
                now = temp == 0 ? 0 : value - temp;
            } else {
                now = now % value;
            }
            countMap.put(now, countMap.getOrDefault(now, 0) + 1);
        }
        System.out.println(countMap);
        countMap.forEach( (k, v) -> {
            for (int i = 0; i < v; i++) {
                int tmp = value*i+k;
                if(tmp >= check.length) break;
                check[tmp] = true;
            }
        });
        
        int ans = 0;
        for(boolean b : check) {
            if(!b) break;
            ans++;
        }

        return ans;
    }
}