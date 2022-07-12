It has two types
1. Tabulation : this is nothing but bottom up dp approach
2. Memoization: Top down dp approach

## Memoization
It is when we use array to store the previously computed values so that we don't have to recompute them. We can directly refer the array and return the result from there

## Short cut for solving DP problem : 
1. Try to represent the problem in terms of Index;
2. Do all possible stuffs on that Index according to the problem statement;
3. Sum up all the possible stuffs => if the problem says find all the possible solutions
    Take minimum of all stuffs => if the problem says find minimum;
    Take maximum of all stuffs => if the problem says find maximum;


### Max sum without Adjacent

`Note : its like finding sum of all the subsequence except the adjacent subsequenes sum`

```java
class Solution {
    //memoization top down  approach tc  : O(n) and space is O(n) space we used for creating dp array
    int findMaxSum(int arr[], int n) {
        // code here
        
        // we are starting in reverse Order
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return solve(arr,n-1,dp);
    }
    public int solve(int arr[], int index,int dp[]){
       
        if(index==0) return arr[0];
        if(index<0) return 0;
        if(dp[index]!=-1) return dp[index];
        int takeIt = arr[index] + solve(arr,index-2,dp);// as we have taken i we can't take i-1, we have to take i-2
        int donttakeIt = 0+solve(arr,index-1,dp); // as we didnt take the i the element we can take the i-1 th element.
        return dp[index] = Integer.max(takeIt,donttakeIt);
    }
    bottom up approach ie tabulation tc and space complexity is same
    int findMaxSum(int arr[], int n){
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        dp[0] = arr[0];
        int negativeIndexVal = 0;
        for(int i =1;i<n;i++){
            int take  = arr[i]; 
            if(i>1) take+=dp[i-2];
            int dontTake = 0 + dp[i-1];
            
            dp[i] = Math.max(take,dontTake);
        }
        return dp[n-1];
        
    }
    
    //tabulations with memory optimization tc O(n) and space complexity is O(1)
    
     int findMaxSum(int arr[], int n){
       
        int prev = arr[0];
        int prev2 = 0;
        for(int i =1;i<n;i++){
            int take  = arr[i]; 
            if(i>1) take+=prev2;
            int dontTake = 0 + prev;
            
            int currenti = Math.max(take,dontTake);
            prev2 = prev;
            prev = currenti;
        }
        return prev;
        
    }
    
}
```

## Conveting memoization to tabulation (bottom up approch);

    Declare base case
    express all states in for loop
    copy the recurrence relation

for example the see the below problem

Unique path: 

```There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.
```
```java
// memoization dp solution
class Solution {
    int count  = 0;
    public int uniquePaths(int m, int n) {
        int[][] grid = new int [m][n];
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return solve(grid,0,0,dp);
        
    }
    public int solve(int[][] grid , int i, int j,int[][] dp){
        
        if(i == grid.length-1 && j == grid[0].length-1){
            return 1;
        }
        
        if(i<0 || i>= grid.length || j<0 || j>=grid[0].length){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        
        int left = solve(grid,i+1,j,dp);
        int right = solve(grid,i,j+1,dp);
        return dp[i][j] = left+right;
    }
}
```
```java
```