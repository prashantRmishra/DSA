

/*with space complexity ofO(1)*/
/*Algorithm:
The following is a detailed algorithm for finding factorial.
factorial(n) 
1) Create an array ‘res[]’ of MAX size where MAX is number of maximum digits in output. 
2) Initialize value stored in ‘res[]’ as 1 and initialize ‘res_size’ (size of ‘res[]’) as 1. 
3) Do following for all numbers from x = 2 to n. 
……a) Multiply x with res[] and update res[] and res_size to store the multiplication result.
How to multiply a number ‘x’ with the number stored in res[]? 
The idea is to use simple school mathematics. We one by one multiply x with every digit of res[]. The important point to note here is digits are multiplied from rightmost digit to leftmost digit. If we store digits in same order in res[], then it becomes difficult to update res[] without extra space. That is why res[] is maintained in reverse way, i.e., digits from right to left are stored.
multiply(res[], x) 
1) Initialize carry as 0. 
2) Do following for i = 0 to res_size – 1 
….a) Find value of res[i] * x + carry. Let this value be prod. 
….b) Update res[i] by storing last digit of prod in it. 
….c) Update carry by storing remaining digits in carry. 
3) Put all digits of carry in res[] and increase res_size by number of digits in carry.

*/
import java.io.*;
import java.util.*;
public class TwentyTwo{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t>0){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[500];//i am setting limit as 500 its your choice
            arr[0] = 1;
            int size=1;
            for(int i=2;i<=N;i++){
                size=findFactorial(arr,i,size);
            }
            /*print in reverse order */
            for(int i=size-1;i>=0;i--){
                System.out.print(arr[i]);
            }
            System.out.println();
            t--;
        }
    }
    static int findFactorial(int[] arr,int x,int size){
        int carry=0;
        for(int i=0;i<size;i++){
            int result = arr[i]*x+carry;
            /*eg: id result =45, then store 5 in arr[i] and carry i.e 4 in 
            carry variable like simple math multiplication*/
            /*As you might have guessed values are stored in reverse order in arr[]
            for multiplication convenience*/
            arr[i] = result % 10; //to get 5 from 45
            carry  = result /10 ; // to get 4 from 45
        }
        /*sometimes carry is greater than 9 eg 11 so store them at the end
        in consecutive indexes*/
        while(carry!=0){
            arr[size] = carry % 10;//eg for 11 : 11% 10 = 1;
            size++;
            carry = carry/10;// 11/ 10 => 1
        }
        return size;
    }
}


/*input:
2
5
100
output:
120
93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000
TC:O(n)
SC:O(1)
*/





/*Solution with TC:O(n) and SC:O(1) */
class Solution {
    static ArrayList<Integer> factorial(int N){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i=1;i<=N;i++){
            
            findFactOfLongNumbers(list,i,list.size());
        }
        Collections.reverse(list);
        return list;
    }
    static void findFactOfLongNumbers(ArrayList<Integer> list,int x,int n){
        int carry=0,prod=0,i=0;
        
        for(i=0;i<n;i++){
            prod = list.get(i)*x+carry;
            list.set(i,prod % 10);
            carry = prod/10;
        }
        while(carry!=0){
             list.add(carry % 10);
             carry=carry/10;
        }
    }
}