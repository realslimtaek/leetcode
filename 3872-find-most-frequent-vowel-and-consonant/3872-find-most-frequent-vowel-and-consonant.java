class Solution {
    public int maxFreqSum(String s) {
        Map<String, Integer> map = new HashMap<>();

        for (String str : s.split("")) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        int vowelMax = 0;
        int notVowelMax = 0;

        String[] vowel = {"a", "e", "i", "o", "u"};

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String k = entry.getKey();
            int v = entry.getValue();

            if (Arrays.asList(vowel).contains(k)) {
                if (vowelMax < v) vowelMax = v;
            } else {
                if (notVowelMax < v) notVowelMax = v;
            }
        }
        return vowelMax+notVowelMax;
    }
}