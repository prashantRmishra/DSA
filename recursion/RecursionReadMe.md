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