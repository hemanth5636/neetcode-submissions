class Solution {
    public int calPoints(String[] operations) {
        int[] stack = new int[operations.length];
        int top = -1;
        int result = 0;
        for (String op : operations) {
            if (op.equals("+")) {
                stack[top + 1] = stack[top] + stack[top - 1];
                top++;
                result += stack[top];
            } else if (op.equals("D")) {
                stack[top + 1] = (stack[top] * 2);
                top++;
                result += stack[top];
            } else if (op.equals("C")) {
                result -= stack[top];
                top--;
            } else {
                int score = Integer.parseInt(op);
                stack[++top] = score;
                result += score;
            }
        }
        // if (top < 0) return 0;

        return result;
    }
}