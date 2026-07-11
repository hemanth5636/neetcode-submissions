class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String hashKey = getHashKey(s);
            map.computeIfAbsent(hashKey, k -> new ArrayList<>());
            map.get(hashKey).add(s);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> ss : map.values()) {
            result.add(ss);
        }

        return result;
    }

    private String getHashKey(String s) {
        int[] freq = new int[26];
        
        for (char c : s.toCharArray()) {
            freq[c-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int f : freq) {
            sb.append(f).append("#");
        }

        return sb.toString();
    }
}
