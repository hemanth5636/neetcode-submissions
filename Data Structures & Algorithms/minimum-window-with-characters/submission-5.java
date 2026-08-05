class Solution {
    public String minWindow(String s, String t) {
        Map<Integer, Integer> tFreq = new HashMap<>();

        for (int index : t.toCharArray()) {
            tFreq.put(index, tFreq.getOrDefault(index, 0) + 1);
        }

        int l = 0;
        int r = 0;
        int remainLen = t.length();
        int resultLen = s.length() + 1;
        String result = "";
        Map<Integer, Integer> sFreq = new HashMap<>();

        while (r < s.length()) {
            int curIndex = s.charAt(r);
            
            if (tFreq.containsKey(curIndex)) {
                sFreq.put(curIndex, sFreq.getOrDefault(curIndex, 0) + 1);

                if (tFreq.get(curIndex) >= sFreq.get(curIndex)) {
                    remainLen--;
                }

                while (l <= r && remainLen == 0) {
                    int curWindowLen = r - l + 1;

                    if (remainLen == 0 && curWindowLen < resultLen) {
                        resultLen = curWindowLen;
                        result = s.substring(l, r + 1);
                    }

                    int leftIndex = s.charAt(l++);
                    if (tFreq.containsKey(leftIndex)) {
                        sFreq.put(leftIndex, sFreq.get(leftIndex) - 1);
                        
                        if (tFreq.get(leftIndex) > sFreq.get(leftIndex)) remainLen++;
                    }
                }
            }

            r++;
        }

        return result;
    }
}
