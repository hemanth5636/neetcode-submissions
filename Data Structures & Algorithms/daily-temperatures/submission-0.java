class Solution {
    public int[] dailyTemperatures(int[] ts) {
        int[] result = new int[ts.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < ts.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && ts[i] > ts[stack.peek()]) {
                    int index = stack.pop();
                    result[index] = i - index;
                }
                stack.push(i);
            }
        }
        
        return result;
    }
}
