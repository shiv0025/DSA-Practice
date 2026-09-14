class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0];
        int y1 = rec1[1];
        int x2 = rec1[2];
        int y2 = rec1[3];

        int a1 = rec2[0];
        int b1 = rec2[1];
        int a2 = rec2[2];
        int b2 = rec2[3];

        boolean xOverlap = x1 < a2 && a1 < x2;

        boolean yOverlap = y1 < b2 && b1 < y2;

        boolean ans = xOverlap && yOverlap;
         return  ans;
    }
    
}