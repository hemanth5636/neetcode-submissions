class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ass : asteroids) {
            while (!stack.isEmpty() && ass < 0 && stack.peek() > 0) {
                int diff = ass + stack.peek();
                if (diff < 0) {
                    stack.pop();
                } else if (diff > 0) {
                    ass = 0;
                } else {
                    ass = 0;
                    stack.pop();
                }
            }

            if (ass != 0) stack.add(ass);
        }

        return stack.stream().mapToInt(i -> i).toArray();
    }
}