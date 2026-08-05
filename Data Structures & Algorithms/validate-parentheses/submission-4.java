class Solution {
    public boolean isValid(String s) {
        int[] stack = new int[s.length()];
        int top = -1;

        for (int val : s.toCharArray()) {
            if (val == ')') {
                if (top == -1 || stack[top] != '(') return false;
                top--;
            } else if (val == ']') {
                if (top == -1 || stack[top] != '[') return false;
                top--;
            } else if (val == '}') {
                if (top == -1 || stack[top] != '{') return false;
                top--;
            } else {
                stack[++top] = val;
            }
        }

        return top == -1;
    }
}
