class Solution {
    public List<String> removeAnagrams(String[] words) {

        List<String> answer = new ArrayList<>();

        List<Map<Character, Integer>> anagramList = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            Map<Character, Integer> count = new HashMap<>();

            for (char c : words[i].toCharArray()) {
                count.put(c, count.getOrDefault(c, 0) + 1);
            }
            anagramList.add(count);

            if (i == 0 || !anagramList.get(i - 1).equals(count)) {
                answer.add(words[i]);
            }
        }

        return answer;
    }
}