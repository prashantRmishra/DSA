It has two types
1. Tabulation : this is nothing but bottom up dp approach
2. Memoization: Top down dp approach

## Memoization
It is when we use array to store the previously computed values so that we don't have to recompute them. We can directly refer the array and return the result from there

## Short cut for solving DP problem : 
1. Try to represent the problem in tems of Index;
2. Do all possible stuffs on that Index according to the problem statement;
3. Sum up all the possible stuffs => if the problem says find all the possible solutions
    Take minimum of all stuffs => if the problem says find minimum;
    Take maximum of all stuffs => if the problem says find maximum;