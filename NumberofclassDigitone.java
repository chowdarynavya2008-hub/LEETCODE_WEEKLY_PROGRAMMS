class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        
        // Use long for 'i' to prevent integer overflow when i * 10 exceeds Integer.MAX_VALUE
        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            count += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0L), i);
        }
        
        return count;
    }
}