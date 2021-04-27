import java.io.*;
import java.util.*;
public class Three{
    
    public static void main(String a[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;  
            String str[] = br.readLine().split(" ");
            int k = Integer.parseInt(br.readLine()); 
            int arr[] = new int[str.length];
            for(int i=0;i<str.length;i++){
                arr[i]=Integer.parseInt(str[i]);
            }
            Arrays.sort(arr);
            min  = arr[k-1];
            max = arr[arr.length-k]; 
            System.out.println(min+" "+max);
            
            t--;
        }
    }
}

/*
1
30 28 26 15 10 4
2
output:
10 28
CPU Time: 0.24 sec(s), Memory: 34984 kilobyte(s)
compiled and 
executed in 0.885 sec(s)
TC:O(n)
*/
