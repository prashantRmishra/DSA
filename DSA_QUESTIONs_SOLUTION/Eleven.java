import java.io.*;
import java.util.*;
public class Eleven{
    public static void main(String a[])throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        HashMap<String,Integer> mp = new HashMap<>();
        while(t>0){
            String str [] = br.readLine().split(" ");
            for(int i=0;i<str.length;i++){
                if(mp.containsKey(str[i])){
                    int temp =mp.get(str[i]);
                    mp.put(str[i],++temp);
                }
                else{
                    mp.put(str[i],1);
                }
            }
           // int count=0;
            for(Map.Entry<String,Integer> e:mp.entrySet()){
                if(e.getValue() > 1)
                { 
                   // count++;
                    System.out.print(e.getKey()+" ");
                }
            }
            mp.clear();
            //System.out.println(count);
            System.out.println();
            
            t--;
        }
    }
}
/*
In constant time:
class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
       String str="";
       
       for(int i=0;i<n;i++){
           str+=arr[i];
       }
       
        
        ArrayList<Integer> list = new ArrayList<Integer>();
     
        for(int i=0;i<n;i++){
             str=str.replaceFirst(Integer.toString(arr[i]),"");
            if(str.contains(Integer.toString(arr[i]))){
               //System.out.println(str+" e: "+arr[i]);
                list.add(arr[i]);
               
            }
            
        }
        if(list.isEmpty()){
            list.add(-1);
        }
        return list;
    }
}
*/
