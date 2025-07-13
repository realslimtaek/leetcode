class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int ans = 0;

        int[] sortedPlayers = Arrays.stream(players).sorted().toArray();
        int[] sortedTrainers = Arrays.stream(trainers).sorted().toArray();

        int player_cnt = 0;
        int trainer_cnt = 0;

        while (player_cnt < players.length && trainer_cnt < trainers.length) {

            if(sortedPlayers[player_cnt] <= sortedTrainers[trainer_cnt]) {
                ans++;
                player_cnt++;
            }
            trainer_cnt++;
        }

        return ans;
    }

}