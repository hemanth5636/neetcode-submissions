class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int result = 0;
        int l = 0;
        int r = people.length - 1;

        while (l < r) {
            int sum = people[l] + people[r];
            if (sum <= limit) {
                result++;
                l++;
                r--;
            } else {
                result++;
                r--;
            }
        }

        if (l == r) result++;

        return result;
    }
}