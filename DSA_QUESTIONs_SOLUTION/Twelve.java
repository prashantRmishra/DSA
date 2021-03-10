import java.io.*;
import java.util.*;
public class Twelve{
    public static void main(String ar[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            String a[] = br.readLine().split(" ");
            String b[] = br.readLine().split(" ");
            int gap = getGap(a.length+b.length);
            while(gap > 0){
                int i,j;
                //sorting 1st array only
                for(i=0;i+gap<a.length && i< a.length;i++){
                    String temp;
                    if(Integer.parseInt(a[i]) > Integer.parseInt(a[i+gap]) ){
                        temp  = a[i];
                        a[i] = a[i+gap];
                        a[i+gap] = temp;
                    }
                }
                //sorting both the arrays
                for(j=gap > a.length-1 ? i+gap-a.length : 0;
                j<b.length && i< a.length; i++,j++){
                    if( Integer.parseInt(a[i]) > Integer.parseInt(b[j])){
                        String temp;
                        temp = a[i];
                        a[i] = b[j];
                        b[j] = temp;
                    }
                }
                //sorting 2nd array only
                for(j=0;j+gap<b.length && j<b.length;j++){
                    if( Integer.parseInt(b[j]) > Integer.parseInt(b[j+gap]) ){
                        String temp;
                        temp = b[j];
                        b[j] = b[j+gap];
                        b[j+gap] = temp;
                    }
                }
                gap = getGap(gap);
            }
            for(int i=0;i<a.length;i++){
                
                System.out.print(a[i]+ " ");
            }
             System.out.println();
             
            for(int i=0;i<b.length;i++){
                
                System.out.print(b[i]+ " ");
            }
            
            System.out.println();
            t--;
        }
    }
    static int getGap(int gap){
        if(gap<2) return 0;
        if(gap % 2 ==0) return gap/2;
        else return (gap/2)+1;
    }
}



/*
input:
2
10
2 3
1 5 9 10 15 20
2 3 8 13
output:
2 
3 10 
1 2 3 5 8 9 
10 13 15 20 

CPU Time: 0.22 sec(s), Memory: 33344 kilobyte(s)
compiled and 
executed in 0.991 sec(s)
TC:O(Nlog(N)) where N=n+m
Auxillery space: O(1)*/
