class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101];
        int goodPairs = 0;

        for (int num : nums) {
            // Every previous occurrence of 'num' forms a good pair with the current one
            goodPairs += count[num];
            count[num]++;
        }

        return goodPairs;
    }
}