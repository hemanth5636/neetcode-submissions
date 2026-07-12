class Solution {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int top = -1;

        int index = 0;

        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == ')' || c == ']' || c == '}') {
                if (top < 0) return false;
                if (c == ')' && stack[top] == '(') top--;
                else if (c == ']' && stack[top] == '[') top--;
                else if (c == '}' && stack[top] == '{') top--;
                else return false;
            } else {
                stack[++top] = c;
            }
            index++;
        }

        return top == -1;
    }
}
