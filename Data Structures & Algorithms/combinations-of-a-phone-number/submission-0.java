class Solution {
    char[][] data = new char[][]{{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    public List<String> letterCombinations(String digits) {
        List<String> response = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return response;
        backtrack(new StringBuilder(), response, 0, digits);
        
        return response;
    }
    
    private void backtrack(StringBuilder curr, List<String> response, int index, String digits) {
        if (curr.length() == digits.length()) {
            response.add(curr.toString());
            return;
        }
        
        for (char nextLetter : data[getDigit(digits.charAt(index))]) {
            curr.append(nextLetter);
            backtrack(curr, response, index + 1, digits);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
    
    private int getDigit(char c) {
        return Character.getNumericValue(c);
    }
}