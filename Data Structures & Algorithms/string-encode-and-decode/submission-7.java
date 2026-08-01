class Solution {

    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.valueOf(str.substring(i, j));
            result.add(str.substring(j + 1, j + 1 + length));
            i = j + length + 1;
        }

        return result;
    }
}
