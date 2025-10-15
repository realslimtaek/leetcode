class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        /*
        int answer = 0;
        int base = nums.get(0);
        int prev = 1;
        int cur_count = 1;
        for (int i = 1; i < nums.size(); i++) {
            System.out.println("=============================");
        
            if (nums.get(i) > base) {
                cur_count += 1;
                if (i != nums.size() - 1) {
                    base = nums.get(i);
                    System.out.println("이전값 보다 크므로 넘어갑니다.");
                    continue;
                }
            }
        
            base = nums.get(i);
        
            System.out.println("cc = " + cur_count + "  i = " + i + "  prev = " + prev);
            // 지금 나올수 있는 최선의 수는 쭉 이어지는 가장 큰 값 /2 or 이전에 한 번 끊겨서 이어진 값과 지금까지 이어진 값중 작은 값.
            int current_best = Math.max((cur_count - cur_count % 2) / 2, Math.min(prev, cur_count));
            System.out.println("cb = " + current_best + "    ans =" + answer);
            answer = Math.max(current_best, answer);
            prev = cur_count;
            System.out.println("answer = " + answer);
            cur_count = 1;
            base = nums.get(i);
        }
        return answer;
        */
        List<Integer> data = new ArrayList<Integer>();
        int ans = 0;
        int size = nums.size();
        int cnt = 1;
        for (int i = 0; i < size - 1; i++) {

            if (nums.get(i) >= nums.get(i + 1)) {
                System.out.println("i = " + nums.get(i));
                data.add(cnt);
                cnt = 1;
                continue;
            }
            cnt++;
        }
        data.add(cnt);
        System.out.println(data);
        if(data.size() == 1) {
            return data.get(0) / 2;
        }

        for( int i = 0; i < data.size() - 1; i ++) {
            ans = Math.max(ans, calc(data.get(i), data.get(i+1)));
        }

        return ans;
    }

    public int calc(int a, int b) {
        return Math.max( b / 2, Math.max( a / 2 , Math.min(a,b)));
    }


    public boolean check(List<Integer> nums, int idx, int k) {
        for (int i = idx + 1; i < idx + k; i++) {
            if (nums.get(i) <= nums.get(i - 1))
                return false;
        }
        return true;
    }
}

/**

class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        for (int i = 0; i + 2 * k <= nums.size(); i++) {
            if(check(nums, i , k) && check(nums, i + k, k)) return true;
        }

        return false;
    }

    public boolean check(List<Integer> nums, int idx, int k) {
        for (int i = idx+1; i < idx + k ; i++) {
            if(nums.get(i) <= nums.get(i-1)) return false;
        }
        return true;
    }
}
 */