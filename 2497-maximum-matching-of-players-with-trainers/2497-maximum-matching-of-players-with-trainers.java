class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int ans = 0;
        
        Arrays.sort(trainers);
        Arrays.sort(players);

        int player_cnt = 0;
        int trainer_cnt = 0;

        while (player_cnt < players.length && trainer_cnt < trainers.length) {

            if(players[player_cnt] <= trainers[trainer_cnt]) {
                ans++;
                player_cnt++;
            }
            trainer_cnt++;
        }

        return ans;
    }

}