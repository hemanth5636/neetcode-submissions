class Solution {

    public String encode(List<String> strs) {
        if (strs == null || strs.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
            sb.append("#");
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();

        int right = 0;
        StringBuilder currString = new StringBuilder();
        int size = 0;
        boolean sizeComputed = false;

        while (right < str.length()) {
            if (!sizeComputed) {
                if (str.charAt(right) == '#') {
                    sizeComputed = true;
                    size = right + size;
                } else {
                    size = size * 10 + str.charAt(right) - '0';
                }
            } else {
                if (right <= size) {
                    currString.append(str.charAt(right));
                } else {
                    result.add(currString.toString());
                    currString = new StringBuilder();
                    sizeComputed = false;
                    size = 0;
                }
            }
            right++;
        }

        return result;
    }
}
