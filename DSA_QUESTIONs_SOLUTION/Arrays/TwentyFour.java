import java.io.*;
import java.util.*;
public class TwentyFour{
    public static void main(String ars[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        
        while(t > 0){
            String str[] = br.readLine().split(" ");
            int [] arr = new int[str.length];
            for(int i=0;i<arr.length;i++){
                arr[i]= Integer.parseInt(str[i]);
            }
            int lcons =longestConsecutiveSequence(arr,arr.length); 
            System.out.println(lcons);
            t--;
        }
    }
    static int longestConsecutiveSequence(int arr[], int n){
        int count =1;
        ArrayList<Integer>  list = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=1;i<n;i++){
            if(arr[i-1]+1==arr[i]) count++;
            else if(arr[i-1]==arr[i]){}
            else {
                list.add(count);
                count=1;
                
            }
        }
        Collections.sort(list);
        return list.get(list.size()-1);
    }
}
/*
input:
2
1 9 3 10 4 20 2
36 41 56 35 44 33 34 92 43 32 42
output:
4
5

TC:O(n)
SC:O(n) as i used ArrayList
*/