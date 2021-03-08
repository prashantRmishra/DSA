
import java.util.*;
import java.io.*;
public class Six{
    public static void main(String a[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            
            String arr1[] =br.readLine().split(" ");
            String arr2[] =br.readLine().split(" ");
            HashSet<String> union = new HashSet<>();
            HashSet<String> intersection = new HashSet<>();
            for(int i=0;i<arr1.length;i++){
               union.add(arr1[i]);
               
            }
      	    for(int i=0;i<arr2.length;i++){
            
		     if(union.contains(arr2[i])){
			 intersection.add(arr2[i]);
		     }
		     else{
			   union.add(arr2[i]);
		     }
            }
            System.out.println(union + " "+intersection);
            t--;
        }
    }
}
/*
input:
2
1 3 4 5 7
2 3 5 6
2 5 6
4 6 8 10
output:
[1, 2, 3, 4, 5, 6, 7] [3, 5]
[2, 4, 5, 6, 8, 10] [6]
CPU Time: 0.22 sec(s), Memory: 35408 kilobyte(s)
compiled and 
executed in 0.985 sec(s)
TC:O(n+m) where n:size off arr1, m:size of arr2
*/
