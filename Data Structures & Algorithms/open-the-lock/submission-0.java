class Solution {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) return 0;

        Set<String> seen = new HashSet<>(Arrays.asList(deadends));
        if (seen.contains("0000")) return -1;

        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        seen.add("0000");
        int result = 0;

        while (!q.isEmpty()) {
            result++;
            for (int i = q.size(); i > 0; i--) {
                String lock = q.poll();
                for (int j = 0; j < 4; j++) {
                    for (int move : new int[]{1, -1}) {
                        char[] arr = lock.toCharArray();
                        arr[j] = (char)((arr[j] - '0' + move + 10) % 10 + '0');
                        String nextLock = new String(arr);
                        if (seen.contains(nextLock)) continue;
                        if (nextLock.equals(target)) return result;
                        q.offer(nextLock);
                        seen.add(nextLock);
                    }
                }
            }
        }

        return -1;
    }
}