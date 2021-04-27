import java.io.*;
import java.util.*;

public class Nine {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while( t > 0 ){
            String str[] = br.readLine().split(" ");
            int k = Integer.parseInt(br.readLine());
            int[] arr= new int[str.length];
            for(int i=0;i<arr.length;i++){
                arr[i] = Integer.parseInt(str[i]);
            }
            Arrays.sort(arr);
            if(arr.length == 0 ) System.out.println(-1);
            if(arr[0]==0) System.out.println(-1);
            if(arr.length==1) System.out.println(0);
            int ans = arr[arr.length-1]-arr[0];
            int big = arr[arr.length-1]-k;
            int small = arr[0]+k;
            if(small > big){
                int temp;
                temp = small;
                small=big;
                big=temp;
            }
            //iterating from index 1 to latindex-1 as 0,last are served already
            for(int i=1;i<arr.length-1;i++){
                int substract = arr[i]-k;
                int add = arr[i]+k;
                if(substract>=small || add <= big ) continue;
                if(big-substract<=add-small){
                    small = substract;
                }
                else big=add;
            }
            System.out.println(Math.min(ans,big-small));
            
            t--;
        } 
     
    }
}
/*
input:
1
1 5 15 10
3
output:
8
TC:nlogn*/