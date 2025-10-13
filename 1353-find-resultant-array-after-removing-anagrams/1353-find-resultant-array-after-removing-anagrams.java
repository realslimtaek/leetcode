class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> answer = new ArrayList<>();

        List<Map<Character, Integer>> anagramList = new ArrayList<>();

        Map<Character, Integer> count = new HashMap<>();

        for (char c : words[0].toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        anagramList.add(count);
        answer.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            count = new HashMap<>();

            for (char c : words[i].toCharArray()) {
                count.put(c, count.getOrDefault(c, 0) + 1);
            }
            anagramList.add(count);

            // 여기서 부터 words[i-1] 비교하여 애너그램이 있는지 확인.
            if (!anagramList.get(i - 1).equals(count)) {
                answer.add(words[i]);
            }
        }

        return answer;
    }
}