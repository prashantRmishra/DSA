import java.io.*;
import java.util.*;
public class Fiteen{
     
   
     static ArrayList<String> str = new ArrayList<>();
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            String a = br.readLine();
            permute("",a);
            Collections.sort(str);
            //System.out.println(str);
            int index = str.indexOf(a);
            if(index==str.size()-1) System.out.println(-1);
            else System.out.println(str.get(index+1));
            str.clear();
            t--;
        }
      
    }
    static void permute(String p,String a){
        int n = a.length();
        if(n==0) {
            if(!str.contains(p)){
                str.add(p);
            }
        }
        else {
            for(int i=0;i<n;i++){
                permute( p+a.charAt(i),a.substring(0,i)+a.substring(i+1));
            }
        }
    }
}
/*
input:
2
abc
gfg
output:
acb
ggf
TC: NlogN for sorting + O(n*m) where n is length of array and m is the max depth of recursion*/