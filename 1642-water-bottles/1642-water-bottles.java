class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int answer = numBottles;
        while(numBottles / numExchange >= 1) {
            int temp = numBottles/numExchange;
            answer += temp;
            numBottles = numBottles/numExchange + numBottles%numExchange;
        }
        return answer;
    }
}