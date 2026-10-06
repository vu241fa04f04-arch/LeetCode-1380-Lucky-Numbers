class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int result = 0;

        while (a >= b) {
            long temp = b;
            int count = 1;

            while (a >= (temp << 1)) {
                temp = temp << 1;
                count = count << 1;
            }

            a -= temp;
            result += count;
        }

        if ((dividend < 0) ^ (divisor < 0)) {
            result = -result;
        }

        return result;
    }
}