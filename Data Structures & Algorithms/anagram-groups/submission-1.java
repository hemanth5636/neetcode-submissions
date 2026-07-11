class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> groupAnagramsMap = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
              String sortedS = new String(charArray);
            if (!groupAnagramsMap.containsKey(sortedS)) {
                groupAnagramsMap.put(sortedS, new ArrayList<>());
            }
            groupAnagramsMap.get(sortedS).add(str);
        }
        return new ArrayList<>(groupAnagramsMap.values());
    }
}
