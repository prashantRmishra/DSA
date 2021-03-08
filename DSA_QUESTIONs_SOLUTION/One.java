import java.io.*;
import java.util.*;
public class One{
    
    public static void main(String a[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            String str[] = br.readLine().split(" ");
            for(int i=0;i<str.length;i++){
               if(i<str.length-1-i) {
                    String temp =str[i];
                str[i]=str[str.length-1-i];
                str[str.length-1-i]=temp;
               }
            }
            
            for(int i=0;i<str.length;i++){
                System.out.print(str[i]+" ");
            }
             System.out.println();
            
            t--;
        }
    }
}

/*

input:
2
2 10 1 34 33
56 4 23 4 53 222 2 2 33
output:
33 34 1 10 2 
33 2 2 222 53 4 23 4 56 

CPU Time: 0.20 sec(s), Memory: 34264 kilobyte(s)
compiled and 
executed in 0.889 sec(s)
TC O(n);
*/
