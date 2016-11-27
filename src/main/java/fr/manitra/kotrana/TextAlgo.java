package fr.manitra.kotrana;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by manitra on 11/11/2016.
 */
public class TextAlgo {

    public static void main(String[] args) {
        String s = "ama-test-amalgamationtest";
        String p = "amalgamationt";
        System.out.println(findKMP(s.toCharArray(), p.toCharArray()));
    }

    public static int findKMP(char[] text, char[] pattern) {
        int n = text.length;
        int m = pattern.length;
        if (m == 0) return 0;
        int[] fail = computeFailKMP(pattern);
        int j = 0;
        int k = 0;
        while (j < n) {
            if (text[j] == pattern[k]) {
                if (k == m - 1) {
                    return j - m + 1;
                }
                j++;
                k++;
            } else if (k > 0) {
                k = fail[k - 1];
            } else {
                j++;
            }
        }
        return -1;
    }

    private static int[] computeFailKMP(char[] pattern) {
        int m = pattern.length;
        int[] fail = new int[m]; // by default, all overlaps are zero
        int j = 1;
        int k = 0;
        while (j < m) {                         // compute fail[j] during this pass, if nonzero
            if (pattern[j] == pattern[k]) {     // k + 1 characters match thus far
                fail[j] = k + 1;
                j++;
                k++;
            } else if (k > 0)
                k = fail[k-1];                  // reuse suffix of P[0..k-1]
            else j++;
        }
        return fail;
    }
}
