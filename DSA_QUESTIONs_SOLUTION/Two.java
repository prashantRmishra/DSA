import java.io.*;
import java.util.*;
public class Two{
    
    public static void main(String a[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;  
            String str[] = br.readLine().split(" ");
            int arr[] = new int[str.length];
            for(int i=0;i<str.length;i++){
                arr[i]=Integer.parseInt(str[i]);
            }
            for(int i=0;i<str.length;i++){
                if(arr[i]<min){
                    min=arr[i];
                }
                if(arr[i] > max){
                    max=arr[i];
                }
            }
            System.out.println(min+" "+max);
            
            t--;
        }
    }
}

/*
input:
2
23 4 5 65 43 22
1 1000 23 43 454 5555 333 2222 11 0 1
output:
4 65
0 5555
CPU Time: 0.21 sec(s), Memory: 34700 kilobyte(s)
compiled and 
executed in 0.834 sec(s)
TC:O(n)
*/
