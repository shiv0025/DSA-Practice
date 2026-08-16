class Solution {
    public int minOperations(int[][] grid, int x) {
        int k = 0 ; 
        int count = 0 ; 
       int [] arr = new int[grid.length*grid[0].length];
       for(int i = 0 ; i < grid.length ; i++){
        for(int j = 0 ; j < grid[0].length ; j++){
             arr[k] = grid[i][j];
             k++;
        }
     } 
     Arrays.sort(arr);
    int median = arr.length/2;
    int val = arr[median];
    for ( int i = 0 ; i < arr.length ; i++){
        if(arr[i] > val){
        int val2 = arr[i] - val ;
            if(val2 % x == 0){
             int cc =   val2/x;
          count = count+cc;
        }else{
            return -1;
        }
        
    }else{
        int val3 =   val - arr[i] ;
        if(val3 % x == 0){
          int ccc =   val3/x;
          count = count+ccc;
        }else{
            return -1;
        }
        }
    }
    return count ; 
    }
}