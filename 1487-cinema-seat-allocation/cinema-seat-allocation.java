import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Store reserved seats row-wise
        for (int i = 0; i < reservedSeats.length; i++) {

            int row = reservedSeats[i][0];
            int seat = reservedSeats[i][1];

            // Sirf seats 2 to 9 matter karti hain
            if (seat >= 2 && seat <= 9) {

                int bit = 1 << (seat - 2);

                map.put(row, map.getOrDefault(row, 0) | bit);
            }
        }

        // Initially har row mein 2 families possible
        int ans = (n - map.size()) * 2;

        // Rows having reserved seats
        for (int row : map.keySet()) {

            int mask = map.get(row);

            // Seats 2,3,4,5
            boolean left = (mask & 15) == 0;

            // Seats 6,7,8,9
            boolean right = (mask & (15 << 4)) == 0;

            // Seats 4,5,6,7
            boolean middle = (mask & (15 << 2)) == 0;

            if (left && right) {
                ans += 2;
            } 
            else if (left || right || middle) {
                ans += 1;
            }
        }

        return ans;
    }
}