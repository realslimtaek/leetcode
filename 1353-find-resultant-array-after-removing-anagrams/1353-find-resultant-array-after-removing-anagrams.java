class Solution {
    public List<String> removeAnagrams(String[] words) {

        List<String> answer = new ArrayList<>();

        char[] chars, prev;
        prev  = new char[1];
        for (int i = 0; i < words.length; i++) {

            chars = (words[i].toCharArray());
            Arrays.sort(chars);
            if (i == 0 || !Arrays.equals(prev, chars)) {
                prev = chars;
                answer.add(words[i]);
            }
        }

        return answer;
    }
}