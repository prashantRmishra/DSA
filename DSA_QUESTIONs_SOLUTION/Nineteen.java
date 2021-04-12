import java.io.*;
import java.util.*;
public class Nineteen{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t > 0){
            String str[] = br.readLine().split(" ");
            String str2[] = br.readLine().split(" ");
            String str3[] = br.readLine().split(" ");
            ArrayList<Integer> v1 = new ArrayList<>();
            ArrayList<Integer> v2 = new ArrayList<>();
            ArrayList<Integer> v3 = new ArrayList<>();
            for(int i=0;i<str.length;i++){
                v1.add(Integer.parseInt(str[i]));
            }
            for(int i=0;i<str2.length;i++){
                v2.add(Integer.parseInt(str2[i]));
            }
            for(int i=0;i<str3.length;i++){
                v3.add(Integer.parseInt(str3[i]));
            }
            ArrayList<Integer> list = common_element(v1,v2,v3);
            System.out.println(list);
            
            t--;
        }
    }
    public static ArrayList<Integer> common_element(ArrayList<Integer>v1, ArrayList<Integer>v2,ArrayList<Integer> v3){
        TreeMap<Integer,Integer> t1 = new TreeMap<>();
        TreeMap<Integer,Integer> t2 = new TreeMap<>();
        TreeMap<Integer,Integer> t3 = new TreeMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        //calculating frequency of all elemets in all 3 Lists
        for(Integer i:v1){
            if(t1.containsKey(i)){
                t1.put(i,t1.get(i)+1);
            }
            else{
                t1.put(i,1);
            }
        }
        for(Integer i:v2){
            if(t2.containsKey(i)){
                t2.put(i,t2.get(i)+1);
            }
            else{
                t2.put(i,1);
            }
        }
        for(Integer i:v3){
            if(t3.containsKey(i)){
                t3.put(i,t3.get(i)+1);
            }
            else{
                t3.put(i,1);
            }
        }
       // int n = v1.size() < v2.size() ? v1.size():v2.size();
        //int size = n < v3.size() ? n: v3.size();
        
        for(Integer i:v1){
            if(t2.containsKey(i) && t3.containsKey(i)){
                list.add(i);
                t2.put(i,t2.get(i)-1);
                t3.put(i,t3.get(i)-1);
                if(t2.get(i)==0){
                    t2.remove(i);
                }
                if(t3.get(i)==0){
                    t3.remove(i);
                }
            }
        }
        return list;
    }
}
/*
input:
1
1 5 5
3 4 5 5 10
5 5 10 20
output:
[5, 5]

TC:O(n)
space c:O(p+q+r) i.e space occupies by three Treemaps.
*/