import java.io.*;
import java.util.*;
public class Four{
    
    public static void main(String a[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
          
            String str[] = br.readLine().split(" ");
            int arr[] = new int[str.length];
            for(int i=0;i<str.length;i++){
                arr[i]=Integer.parseInt(str[i]);
            }
       
            mergeSort(arr,0,arr.length-1);
            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            t--;
        }
      
    }
      static void mergeSort(int arr[],int l,int r){
            if(l<r){
                int mid = l+(r-l)/2;
                mergeSort(arr,l,mid);
                mergeSort(arr,mid+1,r);
                sort(arr,l,mid,r);
            }
        }
        static void sort(int arr[],int l,int m,int r){
            int n1 = m-l+1;
            int n2 = r-m;
            int p[] = new int[n1];
            int q[] = new int[n2];
            for(int i=0;i<n1;i++){
                p[i]=arr[i+l];
            }
             for(int i=0;i<n2;i++){
                q[i]=arr[m+1+i];
            }
            int i=0,j=0,k=l;
            while(i<n1 &&  j<n2){
                if(p[i]<=q[j]){
                    arr[k] =p[i];
                    i++;
                }
                else{
                    arr[k]=q[j];
                    j++;
                }
                k++;
            }
            
            while(i<n1){
                arr[k] = p[i]; 
                i++;k++;
            }
            while(j<n2){
                arr[k]=q[j];
                j++;k++;
            }
        }
}


/*
input:
1
0 2 1 0 0 0 0 0 1 1 1 2
output:
0 0 0 0 0 0 1 1 1 1 2 2 
CPU Time: 0.25 sec(s), Memory: 35000 kilobyte(s)
compiled and 
executed in 0.87 sec(s)
TC:O(nlogn)


*/
