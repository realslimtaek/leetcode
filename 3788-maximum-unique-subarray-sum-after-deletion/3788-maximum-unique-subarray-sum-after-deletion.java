import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxSum(int[] nums) {
                int[] dis = IntStream.of(nums).distinct().toArray();
        int[] sortedAndFilterMinus = IntStream.of(nums).distinct().filter(it -> it <= 0).toArray();
        
        if(Arrays.equals(dis, sortedAndFilterMinus)) {
            return Arrays.stream(dis).max().orElse(0);
        } else return Arrays.stream(dis).filter(it -> it >= 0).sum();
        
    }
}