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
}
```
