/*counting inversion using merge sort
Example:
Input: arr[] = {8, 4, 2, 1}
Output: 6

Explanation: Given array has six inversions:
(8, 4), (4, 2), (8, 2), (8, 1), (4, 1), (2, 1).
as 8>4,8>2,8>1,4>2,4>1,2>1

Input: arr[] = {3, 1, 2}
Output: 2

Explanation: Given array has two inversions:
(3, 1), (3, 2) 
*/
import java.io.*;
import java.util.*;
public class Sixteen{
    public static void main(String a[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            String str[] = br.readLine().split(" ");
            int[] arr = new int[str.length];
            for(int i=0;i<str.length;i++){
                arr[i] = Integer.parseInt(str[i]);
            }
            int count = mergeSort(arr,0,arr.length-1);
            System.out.println(count);
            t--;
        }
    }
    static int mergeSort(int[] arr, int l, int r){
          int count=0;
        if(l<r){
            int m = l+(r-l)/2;
            count+=mergeSort(arr,l,m);
            count+=mergeSort(arr,m+1,r);
            count+=merge(arr,l,m,r);
            
        }
        return count;
    }
    static int merge(int[] arr,int l,int m,int r){
        int n1 = m-l+1;//for elements till m
        int n2 = r-m;//
        int count=0;
        int[] p = new int[n1];
        int [] q = new int[n2];
        for(int i=0;i<n1;i++){
            p[i] = arr[l+i];
        }
        for(int i=0;i<n2;i++){
            q[i] = arr[m+1+i];
        }
        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
            if(p[i] <=q[j]){
                arr[k] = p[i];
                i++;
                k++;
            }
            else{
                arr[k] = q[j];
                count+=(m-l+1)-i;// vv imp 
                /*Explanation: (m-l-1) is length of elements in p or left subarray
                and here ith index value in p is > than the jth index value in 
                q or right subarray.
                example:
                p:|3|4|5| q:|0|1|2|
                at i=0,j=0;
                3 > 0 means all the remaining elelemts in p are also greater than 0 (as the elements in both the array are sorted)
                so ALL_THE_ELEMETS_IN_p_FROM_CURRENT_INDEX=(m-l+1)-i;
                it should be added to the count value;
                */
                j++;
                k++;
            }
        }
        return count;
    }
}
/*
input:
1
8 4 2 1
output:
6
TC:nlogn
space c:O(n) n space allocated for p[] & q[]
*/