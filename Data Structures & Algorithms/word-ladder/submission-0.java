class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();

        for (String word : wordList) {
            char[] wcs = word.toCharArray();
            for (int i = 0; i < wcs.length; i++) {
                char temp = wcs[i];
                wcs[i] = '.';
                String key = new String(wcs);
                if (!graph.containsKey(key)) graph.put(key, new ArrayList<>());
                graph.get(key).add(word);
                wcs[i] = temp;
            }
        }

        int result = 0;
        Queue<String> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        seen.add(beginWord);
        q.offer(beginWord);

        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int j = 0; j < qSize; j++) {
                String curr = q.poll();
                seen.add(curr);
                if (curr.equals(endWord)) return result + 1;
                char[] ccs = curr.toCharArray();

                for (int i = 0; i < ccs.length; i++) {
                    char temp = ccs[i];
                    ccs[i] = '.';
                    String key = new String(ccs);
                    if (!seen.contains(key) && graph.containsKey(key)) {
                        for (String ne : graph.get(key)) {
                            if (!seen.contains(ne)) q.offer(ne);
                        }
                    }
                    ccs[i] = temp;
                }
            }
            result++;
        }

        return 0;
    }
}
