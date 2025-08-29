import java.util.*;

class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        boolean[] checked = new boolean[baskets.length];
        int ans = 0;
        for(int fruit: fruits) {
            boolean flag = false;
            for(int j = 0; j< baskets.length; j++) {
                if(flag) break;
                if(fruit > baskets[j]) continue;
                else {
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