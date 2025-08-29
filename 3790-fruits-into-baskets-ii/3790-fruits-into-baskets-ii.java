import java.util.*;

class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        boolean[] checked = new boolean[baskets.length];
        int ans = 0;
        for(int i = 0; i<fruits.length; i++) {
            boolean flag = false;
            for(int j = 0; j< baskets.length; j++) {
                if(flag) break;
                if(checked[j]) continue;
                if(fruits[i] > baskets[j]) continue;
                else {
                    checked[j] = true;
                    flag = true;
                    break;
                }
            }

            if(!flag) ans += 1;
        }
        return ans;
    }
}