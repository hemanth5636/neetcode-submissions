class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int result = 0;
        int[][] data = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            data[i][0] = position[i];
            data[i][1] = speed[i];
        }

        Arrays.sort(data, (a, b) -> {
            return b[0] - a[0];
        });

        Stack<Double> stack = new Stack<>();

        for (int[] p : data) {
            double d = (double)(target - p[0]) / p[1];
            stack.push(d);
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }

        return stack.size();
    }
}
