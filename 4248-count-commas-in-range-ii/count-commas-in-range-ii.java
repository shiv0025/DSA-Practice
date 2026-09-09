class Solution {
    public long countCommas(long n) {

        if (n < 1000) {
            return 0;
        }

        long result = 0;

        for (int i = 3; i < 19; i += 3) {

            long val = (long) Math.pow(10, i);

            if (val > n) {
                break;
            }

            long end = Math.min(n, val * 1000 - 1);

            long count = end - val + 1;

            int commas = i / 3;

            result += count * commas;
        }

        return result;
    }
}