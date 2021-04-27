//left end
import java.io.*;
import java.util.*;
public class Five{
    
    public static void main(String a[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            ArrayList<String> list = new ArrayList<>();
            String str[] = br.readLine().split(" ");
            String arr[] = new String[str.length];
            int j=0;
            for(int i=0;i<str.length;i++){
              
             if(Integer.parseInt(str[i]) < 0){
                 arr[j] = str[i];
                 j++;
                }
                else{
                    list.add(str[i]);
                }
            }
            Iterator<String> it = list.iterator();
            while(it.hasNext()){
                arr[j]=it.next();
                j++;
            }
            
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
             System.out.println();
            
            t--;
        }
    }
}


/*Right end
class Compute {
    
    public void segregateElements(int arr[], int n)
    {
          ArrayList<Integer> list = new ArrayList<>();
          
            int arr2[] = new int[arr.length];
            int j=arr.length-1;
            for(int i=arr.length-1;i>=0;i--){
              
             if(arr[i] < 0){
                 arr2[j] = arr[i];
                 j--;
                }
                else{
                    list.add(arr[i]);
                }
            }
         
            Iterator<Integer> it = list.iterator();
            while(it.hasNext()){
                arr2[j]=it.next();
                j--;
            }
            for(int i=0;i<arr.length;i++){
                arr[i]=arr2[i];
            }
    }
}

*/


/*
input:
1
-2 3 4 -7 -6 -5 4 5 6 78 56 555 -2323 343 -5
output:
-2 -7 -6 -5 -2323 -5 3 4 4 5 6 78 56 555 343 
CPU Time: 0.20 sec(s), Memory: 33232 kilobyte(s)
compiled and 
executed in 0.798 sec(s)
TC:O(n)
*/
