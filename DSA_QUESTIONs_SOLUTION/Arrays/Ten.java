/*
inteval:[[1,3],[2,6],[8,10],[15,18]]
firstly sort the interval based on increasing order of starting point
interval:[[1,3],[2,6],[8,10],[15,18]]
if interval i.start does not lie between (i-1).start and (i-1).end then they cant
be overlapping. but if it lies && (i-1).end >=i.end then then updated interval will be
as (stat,end)=> ((i-1).start,i.end).

*/
import java.io.*;
import java.util.*;
public class Ten{
    public static void main(String ar[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            String str [] = br.readLine().split(" ");
            Interval[] res = new Interval[str.length/2];
            int j=0;
            for(int i=0;i<str.length;i=i+2,j++){
                res[j] = new Interval(Integer.parseInt(str[i]),
                Integer.parseInt(str[i+1]));
            }
            
            Arrays.sort(res,new Comparator<Interval>(){
                public int compare(Interval i1,Interval i2){
                    return (i1.s) < i2.s ? -1:1;
                }
            });
            Stack<Interval> st = new Stack<>();
            st.push(res[0]);
            for(int i=1;i<res.length;i++){
                Interval top = st.peek();
                if(res[i].s < top.e && res[i].e >= top.e){
                    top = st.pop();
                    top.e = res[i].e;
                    st.push(top);
                }
                else {
                    st.push(res[i]);
                }
            }
            while(!st.isEmpty()){
                Interval in = st.pop();
                System.out.println("{"+in.s+","+in.e+"}");
            }
            
            t--;
        }
        
     }
}
class Interval{
    int s,e;
    public Interval(int s,int e){
        this.s=s;
        this.e=e;
    }
}
/*
input:
1
1 3 2 4 5 7 6 8
output:
{5,8}
{1,4}
TC:NlogN for sorting and O(1) for merging or updating Interval Array
Auxillery space complexity : O(n) as Stack is used.
dont usse stack if you want O(1) space time complexity
*/