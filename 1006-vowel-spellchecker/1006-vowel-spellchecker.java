import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelInsensitive = new HashMap<>();

        for (String word : wordlist) {
            String lower = word.toLowerCase();
            caseInsensitive.putIfAbsent(lower, word);

            String noVowel = lower.replaceAll("[aeiou]", "_");
            vowelInsensitive.putIfAbsent(noVowel, word);
        }

        String[] answer = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];

            if (words.contains(query)) {
                answer[i] = query;
                continue;
            }

            String lower = query.toLowerCase();
            if (caseInsensitive.containsKey(lower)) {
                answer[i] = caseInsensitive.get(lower);
                continue;
            }

            String noVowel = lower.replaceAll("[aeiou]", "_");
            if (vowelInsensitive.containsKey(noVowel)) {
                answer[i] = vowelInsensitive.get(noVowel);
                continue;
            }

            answer[i] = "";
        }
        return answer;
    }
}
