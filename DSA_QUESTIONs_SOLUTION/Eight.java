
//kadane's Algorithm (for finding contegious maximum sum subarray)
import java.io.*;
import java.util.*;
public class Eight{
    public static void main(String[] a)throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            
            String str[] = br.readLine().split(" ");
            int arr[] = new int[str.length];
            for(int i=0;i<str.length;i++){
                arr[i]=Integer.parseInt(str[i]);
            }
            System.out.println(maxSubarraySum(arr,arr.length));
            
            t--;
        }
    }
    static int maxSubarraySum(int arr[],int n){
        int maxSoFar=0,maxTillHere=0;
        for(int i=0;i<n;i++){
            maxTillHere+=arr[i];
            if(maxTillHere>maxSoFar){
                maxSoFar=maxTillHere;
            }
            if(maxTillHere<0){
                maxTillHere=0;
            }
        }
        return maxSoFar;
    }
}
/*
input:
2
1 2 3 -2 5
-2 -3 4 -1 -2 1 5 -3
output:
9
7

CPU Time: 0.13 sec(s), Memory: 30536 kilobyte(s)
compiled and 
executed in 0.857 sec(s)
TC:O(n)
*/
