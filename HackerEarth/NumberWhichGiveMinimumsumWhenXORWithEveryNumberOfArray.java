
/**

A XOR value
You are given an array  consisting of  integer values. Find an integer  such that the value of the following function is minimized:

 ,  represents a bitwise XOR operation
If multiple such  exist, then print the minimum possible value of .

Input format

The first line contains an integer  denoting the number of test cases. For each test case:
The first line of each test case contains an integer .
The second line of each test case contains  space-separated integers denoting array .
Output format

For each test case, print the value of  in a new line.

Constraints 


SAMPLE INPUT 
1
4
1 4 4 4
SAMPLE OUTPUT 
4
Explanation
For K = 4 ,

A[1] XOR 4 + A[2] XOR 4 + A[3] XOR 4 + A[4] XOR 4 = 1 XOR 4 + 0 + 0 + 0 = 5
5 is the minimum possible value of function, attained when K = 4.



*/

import java.io.*;
import java.util.*;
public class NumberWhichGiveMinimumsumWhenXORWithEveryNumberOfArray {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t  = Integer.parseInt(br.readLine());
        while(t>0){
            int n = Integer.parseInt(br.readLine());
            int arr[]  = new int[n];
            String[] str = br.readLine().split(" ");
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(str[i]);
            }
            Arrays.sort(arr);
            int count=0;
            int k =0;
            int maxBinaryLength  =  Integer.toBinaryString(arr[n-1]).
            length();
           // System.out.println(n);
            for(int i=0;i<maxBinaryLength;i++){
                count=0;
                for(int j=0;j<n;j++){
                    if((arr[j] & 1<<i) !=0){
                        count++;
                    }
                }
                if(count > (n/2)){
                    k+= 1 << i;
                }
            }
            //to find the minimum sum;
            /* int minSum=0;
            for(int i=0;i<n;i++){
                minSum+=k^arr[i];
            } */
            String val = String.valueOf(k);
            System.out.println(val);
            t--;
        }        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here

    }
}

