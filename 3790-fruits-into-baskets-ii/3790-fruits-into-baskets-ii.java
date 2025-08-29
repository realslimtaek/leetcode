class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int ans = 0;
        for(int fruit: fruits) {
            boolean flag = false;
            for(int j = 0; j< baskets.length; j++) {
                if(flag) break;
                if(fruit <= baskets[j]) {
                    baskets[j] = 0;
                    flag = true;
                    break;
                }
            }

            if(!flag) ans += 1;
        }
        return ans;
    }
}