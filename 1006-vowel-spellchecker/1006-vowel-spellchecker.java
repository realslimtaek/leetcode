class Solution {

    public String[] spellchecker(String[] wordlist, String[] queries) {

        String[] answer = new String[queries.length];

        Set<String> words = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> lowerMap = new HashMap<>();
        Map<String, String> noVowelMap = new HashMap<>();


        for (String s : wordlist) {
            String lower = s.toLowerCase();
            lowerMap.putIfAbsent(lower, s);
            String noVowel = lower.replaceAll("[aeiou]", "_");
            noVowelMap.putIfAbsent(noVowel, s);
        }


        for(int i = 0; i < queries.length; i++) {
            String query = queries[i];
            if(words.contains(query)) {
                answer[i] = query;
                continue;
            }

            String lower = query.toLowerCase();
            if(lowerMap.containsKey(lower)) {
                answer[i] = lowerMap.get(lower);
                continue;
            }

            String noVowel = lower.replaceAll("[aeiou]","_");
            if(noVowelMap.containsKey(noVowel)) {
                answer[i] = noVowelMap.get(noVowel);
                continue;
            }

            answer[i] = "";
        }

        return answer;
    }
}
