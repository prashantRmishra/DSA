import java.util.*;
import java.io.*;

public class TwentyEight {
    static void find3Nubers(int[] arr, int k) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int p = i + 1, q = arr.length - 1;
            while (p < arr.length && p < q) {
                int val = arr[i] + arr[p] + arr[q];
                if (k == val) {
                    // System.out.println("{"+arr[i]+","+arr[p]+","+arr[q]+"}");
                    count++;
                }
                if (val > k)
                    q--;
                else
                    p++;
            }
        }
        System.out.println(count);

    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];
            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            find3Nubers(arr, k);
            t--;
        }
        /*
         * input: 1 1 2 4 3 6 10 output:
         * 
         * {1,3,6}
         */
    }

}
