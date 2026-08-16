class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            for (Character c : words[i].toCharArray()) {
                adjList.put(c, new ArrayList<>());
                counts.put(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char one = word1.charAt(j);
                char two = word2.charAt(j);

                if (one != two) {
                    adjList.get(one).add(two);
                    counts.put(two, counts.get(two) + 1);
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();

        for (Character c : counts.keySet()) {
            if (counts.get(c) == 0) q.add(c);
        }

        while (!q.isEmpty()) {
            Character c = q.poll();
            sb.append(c);
            for (Character next : adjList.get(c)) {
                counts.put(next, counts.get(next) - 1);
                if (counts.get(next) == 0) q.add(next);
            }
        }

        if (sb.length() != counts.size()) return "";
        return sb.toString();
    }
}
