# There could be two types of recursion
1. Parameterized recursion
2. Functional recursion

Print sum from 1 to n 

##### Parameterized Recursion

```java
f(int i ,int sum ){
    if(i <1) return sum ;
    return f(i-1,sum+i);
}
//call as f(3,0) // will give 6 
```
##### Functional Recusion

```java
f(int i ){
    if(i==0) return 0;
    return i + f(i-1);
}
//call as f(3); // this will also return 6;
```

__Space And Time Complexity of the above alorithm__
    Remember the time complexity of the above algorith will be O(N) as n times the functinos was called 
    And the space complexity will be O(N) as the n auxillary stack space was taken during the excecution of of the above algorithm.
    Note: Similary we can  calculate the factorial of the given number n (we can use both Parameterized as well as functional recursion approach)


#### Subsequences 
A subsequence is contiguous or non-contiguous sequence which follows the order

```java
int arr[] = {3,2,1}; // subsequences are 3,2,1,{3,2},{2,1},{3,1},{3,2,1} // see the positioning order of the elements are followed. 
```
Approaches to solve this above problem 
1. power set:  _you have solved this on leetcode go checkout it you have to_ (non recursive way) 
2. Recursive way: (This is extremely important. You need to remember this)
    We have taken the same example [3,2,1] for every subsequence we will either consider the element at the given index or we will not consider it that all. 
    i.e. take, don't take, take =>(3,1) as 2 was not taken
         ----,-----------,-----
```java
class Solution {
     // approach one : power set()
   /*
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
       
        for(Integer i : nums){
             int n = list.size();
           for(int j =0;j<n;j++){
               List<Integer> tempList = new ArrayList(list.get(j));
               tempList.add(i);
               System.out.println(tempList);
               list.add(tempList);
           } 
        }
        return list;
    }*/
    // approach two recursion 
    List<List<Integer>> list  = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums){
        findAllSubsets(0,new ArrayList<>(),nums);
        return list;
    }
    
    public void findAllSubsets(int i ,List<Integer> l, int[] nums){
        if(i>=nums.length){
            System.out.println(l);
            list.add(new ArrayList<>(l));
            return;
        }
        
        l.add(nums[i]); // take
        findAllSubsets(i+1,l,nums);
        l.remove(l.size()-1); //don't take
        findAllSubsets(i+1,l,nums);
    }
}
```
## Similary return only those subsequences whose sum is equals to target

Now, we can just sum the subsequences and check if its equal to or not to the target value in the base case itself

__Extending the same above example__
```java
 List<List<Integer>> list  = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums, int target)){
        findAllSubsets(0,0,new ArrayList<>(),nums,int target);
        return list;
    }
    
    public void findAllSubsets(int i ,int sum, List<Integer> l, int[] nums,int target){
        if(i>=nums.length){
           if(sum == target)
            list.add(new ArrayList<>(l));
            return;
        }
        
        l.add(nums[i]); // take
        sum+=nums[i]; // add that value to sum 
        findAllSubsets(i+1,sum,l,nums,target);
        l.remove(l.size()-1); //don't take
        sum-=nums[i];// remove that value from the sum
        findAllSubsets(i+1,sum,l,nums,target);
    }

```
## Similary return only the count of  those subsequences whose sums are equals to the target

# Important 
Remember whenever we have to find the count of such patters we will use **left + right** approach

__Extending the same above example__
we don't have to maintain the datastructure now , that is we don't need list array as we just have to return the count ;
```java
List<List<Integer>> list  = new ArrayList<>();
    public int  findCountOfSubsetsThatAddsUpToTheTarget(int[] nums, int target)){
        return findAllSubsets(0,0,nums,int target);
        return list;
    }
    
    public int  findAllSubsets(int i ,int sum,int[] nums,int target){
        if(i>=nums.length){
           if(sum == target)
            return 1;
        }
        else return 0;
        
        l.add(nums[i]); // take
        sum+=nums[i]; // add that value to sum 
        int left = findAllSubsets(i+1,sum,nums,target);
        l.remove(l.size()-1); //don't take
        sum-=nums[i];// remove that value from the sum
        int right = findAllSubsets(i+1,sum,nums,target);
        return left + right;
    }

```
#### find all subsets of an array (that may have duplicate value ) avoid any duplicate subsets

Now, This problem is stright as that of finding all the possible subsets of the array
for this we could have used same powerset or recursion solutions, but that will require additional 
time complexity of klogk as we will have to avoid the duplicate subsets 

Hence we will have to device an optimal solution in the recursion itself instead of having additional time complexity of klogk.

``
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
``
```java

// approach one : using recursion : though this solutions works but,
 // if we think of tc its o(2^n)k.logk // as o(2^n) for recursion , k : if we assume average length of each subset is k , then k subsets are put in another List i.e. 'list', hence klogk for sorting list of size k 
// moral of the story is we will have to optimize this solution to get a better tc
/*
class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // for getting all the possible subsets we can use recursion the 
        // way we used for subset I 
        // but we will have to avoid having duplicates 
        findSubsets(0,nums,new ArrayList<>());
        return list;
        
    }
    public void findSubsets(int i, int[] nums, List<Integer> l){
        if(i>=nums.length) {
            List<Integer> temp = new ArrayList<>(l);
            Collections.sort(temp);
            if(!list.contains(temp))
                list.add(temp);
            return;
        }
        l.add(nums[i]);
        findSubsets(i+1,nums,l);
        l.remove(l.size()-1);
        findSubsets(i+1,nums,l);
    }
}
**/

// solution 2 
// optimal sol :tc o(2^n)*k
// for reference https://www.youtube.com/watch?v=RIn3gOkbhQE&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=11
class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        findSubsets(0,nums,new ArrayList<>());
        return list;
        
    }
    public void findSubsets(int i, int[] nums, List<Integer> l){
        List<Integer> temp = new ArrayList<>(l);
        list.add(temp);
        for(int p = i;p<nums.length;p++){
            if(p>i && nums[p]==nums[p-1]) continue;
            l.add(nums[p]);
            findSubsets(p+1,nums,l);
            l.remove(l.size()-1);
        }
        
    }
}
```

## Get All Permutations of an array if all the elements of the array are unique


```java
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        getAllPermutations(0,nums,list);
        return list;
    }
    public void getAllPermutations(int ind, int[] nums,List<List<Integer>> list){
        if(ind==nums.length) {
            List<Integer> temp = new ArrayList<>(Arrays.stream(nums).boxed().toList());
           // Collections.sort(temp);
                list.add(temp);
            return;
        }
        for(int i =ind;i<nums.length;i++){
          
            swap(nums,i,ind);
            getAllPermutations(ind+1,nums,list);
            swap(nums,i,ind);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```
``Another way ``
```java
public class GetPermutations{
  // second approach ,this gives the right solution
    int count = 0;
    List<List<Integer>> l = new ArrayList<>();
    public List<List<Integer>> getPermutation(int[] arr){
        boolean check[] = new boolean[arr.length];
    
        if(getAllPermutations(arr,new ArrayList<>(), check, k)
      
        return l;
    }
    
    public void getAllPermutations(int[] arr, List<Integer> list, boolean[] check){
        if(list.size()==arr.length){
               list.add( new ArrayList<>(list)); 
            }
        
        for(int i =0;i<arr.length;i++){
            if(!check[i]){
                check[i] = true;
                list.add(arr[i]);
                getAllPermutations(arr,list,check);
                list.remove(list.size()-1);
                check[i] = false;
            }
        }
    }
}
```

## Get all permutations of the array if it contains duplicate values as well so return all unique permutations

```java
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        getAllPermutations(0,nums,list);
        return list;
    }
    public void getAllPermutations(int ind, int[] nums,List<List<Integer>> list){
        if(ind==nums.length) {
            List<Integer> temp = new ArrayList<>(Arrays.stream(nums).boxed().toList());
           // Collections.sort(temp);
            if(!list.contains(temp))
                list.add(temp);
            return;
        }
        for(int i =ind;i<nums.length;i++){
          
            swap(nums,i,ind);
            getAllPermutations(ind+1,nums,list);
            swap(nums,i,ind);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```