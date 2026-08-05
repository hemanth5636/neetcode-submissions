class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0; 
        int r = arr.length - 1;
        while (r - l >= k) {
            if (Math.abs(x - arr[l]) <= Math.abs(x - arr[r])) {
                r--;
            } else {
                l++;
            }
        }

        List<Integer> result = new ArrayList<>();
        while (l <= r) {
            result.add(arr[l++]);
        }

        return result;
    }
}