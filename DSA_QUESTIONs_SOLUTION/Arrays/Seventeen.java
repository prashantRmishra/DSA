//best time to buy and sell stocks
import java.io.*;
import java.util.*;
public class Seventeen{
    public static void main(String args[])throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0){
            String str[] = br.readLine().split(" ");
            int[] arr = new int[str.length];
            for(int i=0;i<arr.length;i++){
                arr[i] = Integer.parseInt(str[i]);
            }
            ArrayList<ArrayList<Integer>> list;
            list  = buyAndSellStock(arr,arr.length);
            System.out.println(list);
            t--;
        }
    }
    static ArrayList<ArrayList<Integer>> buyAndSellStock(int[] A, int n){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
      ArrayList<Integer> buySellList = new ArrayList<>();
   // ArrayList<Integer> buySellList = new ArrayList<>();
    //finding local minim and maxima and repeating till the last index of the 
    //array
    int localMinima=-1,localMaxima;
    int i=0,count=0;
    while(i<n-1){//as we will compare i with i+1 for local minima
  
   //System.out.println(i);
    
    localMinima=-1;localMaxima=-1;//at every iteration
    if(A[i] < A[i+1]) { 
       
       localMinima=i;
       buySellList.add(i);
       
        
    }
    //once localminima is found we fing local maxima 
    //the ith element should be greater than next i+1th element
    if(localMinima!=-1){
        
        while(i<n-1){//comparing current with next element
        
            if(A[i] > A[i+1]){
                localMaxima=i;
                buySellList.add(i);
               
                
            }
           if(localMaxima!=-1) break;
           i++; 
        }
    }
    if(i==n-1) break;
    else
    i++;
    
    }
    
    if(i==n-1 && localMinima!=-1) {
        localMaxima=i;
        buySellList.add(i);
       
        
    }
   
    for(i=0;i<buySellList.size()-1;i=i+2){
        ArrayList<Integer> l = new ArrayList<>();
        l.add(buySellList.get(i));
        l.add(buySellList.get(i+1));
        list.add(l);
    }
   // list.add(buySellList);
   //  System.out.println(buySellList+" "+list);
    return list;
}
    
}
/*input:
1
100 180 260 310 40 535 695
output:
[[0, 3], [4, 6]]
TC:O(n)
*/