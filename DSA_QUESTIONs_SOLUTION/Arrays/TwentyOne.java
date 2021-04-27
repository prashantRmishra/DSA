/*
Example 1:

Input:
5
4 2 -3 1 6

Output: 
True

Explanation: 
2, -3, 1 is the subarray 
with sum 0.*/
import java.io.*;
import java.util.*;
public class TwentyOne{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            String str[] = br.readLine().split(" ");
            int[] arr = new int[str.length];
            for(int i=0;i<arr.length;i++){
                arr[i] = Integer.parseInt(str[i]);
            }
            HashSet<Integer> set = new HashSet<>();
            int sum=0;
            boolean found=false;
            set.add(sum);
            for(int i=0;i<arr.length;i++){
                sum+=arr[i];
                if(set.contains(sum)) {
                    System.out.println(true);
                    found=true;
                }
                else set.add(sum);
            }
            
            if(!found)
            System.out.println(false);
            t--;
        }
    }
}
/*input:
1
4 -2 3 -1 6
output:
true
TC:O(n)
SC:O(n) space allocated for HashSet*/