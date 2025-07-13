class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int ans = 0;

        // 1. ë¨¼ì  trainersì playersë¥¼ ì¤ë¦ì°¨ìì¼ë¡ ì ë ¬í©ëë¤.
        Arrays.sort(trainers);
        Arrays.sort(players);

        // ê°ê°ì pointerë¥¼ ì ì¸í©ëë¤.
        int player_idx = 0;
        int trainer_idx = 0;

        // ë°ë³µ ì, ë°°ì´ì indexë¥¼ ë²ì´ëì§ ìê², ì¡°ê±´ì ì¤ì í´ì¤ëë¤.
        while (player_idx < players.length && trainer_idx < trainers.length) {

            // í´ë¹ í¬ì¸í°ê° ê°ë¦¬í¤ë playerì ë¥ë ¥ì¹ê° trainerì ìì ë¥ë ¥ë³´ë¤ ìê±°ë ê°ì ê²½ì°ë ì§ì´ ë  ì ììµëë¤.
            // ê·¸ë ê¸°ì ansì 1ì ëíê³ , playerì í¬ì¸í°ë¥¼ 1 ì¦ê°ìíµëë¤.
            if(players[player_idx] <= trainers[trainer_idx]) {
                ans++;
                player_idx++;
            }
            // playerì ë¥ë ¥ì¹ê° ë í¬ë¤ë©´ trainerì í¬ì¸í°ë§ 1 ì¦ê°ìíµëë¤.
            trainer_idx++;
        }

        return ans;
    }
}