import java.util.*;
import java.io.*;

public class TwentySeven {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String[] l1 = br.readLine().split(" ");
            String[] l2 = br.readLine().split(" ");
            long[] a1 = new long[l1.length];
            long[] a2 = new long[l2.length];
            for (int i = 0; i < a1.length; i++) {
                a1[i] = Long.parseLong(l1[i]);
            }
            for (int i = 0; i < a2.length; i++) {
                a2[i] = Long.parseLong(l2[i]);
            }
            System.out.println(isSubset(a1, a2));

            t--;
        }
    }

    static String isSubset(long[] a1, long[] a2) {
        HashMap<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < a1.length; i++) {
            map.put(i, a1[i]);
        }
        for (int i = 0; i < a2.length; i++) {
            if (!map.containsValue(a2[i]))
                return "No";
        }
        return "Yes";
    }

}
/* input and output
2
1 2 3 4 5 6
7 8
No
3 4 5 1 2 3 4
3 4 5
Yes
TC:O(n) +O(m) + O(nLogm) ----> O(nlogm)
 */