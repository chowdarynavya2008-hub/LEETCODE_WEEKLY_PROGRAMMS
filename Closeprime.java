class Solution {
    public int[] closestPrimes(int left, int right) {
        // Sieve of Eratosthenes up to 'right'
        boolean[] isComposite = new boolean[right + 1];
        if (right >= 0) isComposite[0] = true;
        if (right >= 1) isComposite[1] = true;

        for (int i = 2; i * i <= right; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isComposite[j] = true;
                }
            }
        }

        int prevPrime = -1;
        int minDiff = Integer.MAX_VALUE;
        int[] ans = new int[] { -1, -1 };

        // Scan primes in [left, right] in increasing order
        for (int i = Math.max(2, left); i <= right; i++) {
            if (!isComposite[i]) {
                if (prevPrime != -1) {
                    int diff = i - prevPrime;
                    // Strictly '<' ensures we keep the pair with the smallest num1 on ties
                    if (diff < minDiff) {
                        minDiff = diff;
                        ans[0] = prevPrime;
                        ans[1] = i;
                    }
                    // Smallest possible gap between odd primes is 2 (or 1 for [2, 3])
                    if (minDiff <= 2) {
                        return ans;
                    }
                }
                prevPrime = i;
            }
        }

        return ans;
    }
}