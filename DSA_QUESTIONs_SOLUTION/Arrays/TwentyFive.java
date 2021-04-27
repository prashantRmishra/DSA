import java.io.*;
import java.util.*;
public class TwentyFive{
    public static void main(String args[])throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());
        while(t > 0){
            int k = Integer.parseInt(br.readLine());
            String str[] = br.readLine().split(" ");
            
            int q = str.length/k;
            int[] arr = new int[str.length];
            for(int i=0;i<arr.length;i++){
                arr[i]=Integer.parseInt(str[i]);
            }
            ArrayList<Integer> list = getAllNumbers(arr,arr.length,q);
            System.out.println(list);
            t--;
        }
    }
    static ArrayList<Integer> getAllNumbers(int arr[],int n,int q){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.get(arr[i])!=null){
                map.put(arr[i],map.get(arr[i])+1);
            }
            else{
                map.put(arr[i],1);
            }
            
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if(e.getValue() > q) list.add(e.getKey());
        }
        return list;
    }
}
/*input:
1
4
3 1 2 2 1 2 3 3
output:
[2, 3]

TC:O(n)
SC:O(N)  as list and map used*/
