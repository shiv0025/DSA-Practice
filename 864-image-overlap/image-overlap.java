class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
         int result=0;
         int len = img1.length;
         for(int row=-len;row<len;row++){
            for(int col=-len;col<len;col++){
                result = Math.max(result,count(img1,img2,row,col));
            }
         }
         return result;

    }

    private int count(int[][] img1,int[][] img2,int row,int col){
        int counter =0;
        for(int r=0;r<img1.length;r++){
            for(int c=0;c<img2.length;c++){
                 if(r+row<0 || r+row>=img1.length || c+col<0 || c+col>=img2.length){
                    continue;
                 }

                 if(img1[r+row][c+col]==1 && img2[r][c]==1){
                    counter++;
                 }
            }
        }
        return counter;

    }
}