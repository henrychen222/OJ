/**
 * 09/17/21 morning
 * https://arena.topcoder.com/index.html#/u/coding/18868/17159/2
 * <p>
 * https://arena.topcoder.com/#/u/practiceCode/18870/212173/17159/2/336365 (practice)
 */

package topcoder.srm.r813;

import java.util.*;
import java.io.*;

// Passed 122.62 point   Hacked

/*
<<<<S>S>S>
>>>>S>
S>S>S>S>S
 */
public class LightbulbRow {

    static PrintWriter pw;

    // failed System Test
    public String solve(String s, int startIndex, int goalCount) {
        int n = s.length();
        char[] a = s.toCharArray();
        HashSet<Integer> on = new HashSet<>();
        HashSet<Integer> off = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (a[i] == 'O') {
                on.add(i);
            } else {
                off.add(i);
            }
        }
        int initialOn = on.size();
        tr(initialOn, goalCount);
        if (initialOn < goalCount) { // add
            tr("add");
            String res = "";
            int i;
            int add = goalCount - initialOn;
            for (i = startIndex; i < n && add > 0; i++) {
                if (!on.contains(i)) {
                    res += "S";
                    on.add(i);
                    add--;
                }
                if (i != n - 1) res += ">";
            }
            if (add == 0) return res;
            for (int j = i; j >= 0 && add > 0; j--) {
                if (!on.contains(i)) {
                    res += "S";
                    on.add(i);
                    add--;
                }
                if (j != 0) res += "<";
            }
            return res;
        } else if (initialOn > goalCount) { // delete
            tr("delete");
            String res = "";
            int i;
            int delete = initialOn - goalCount;
            for (i = startIndex; i < n && delete > 0; i++) {
                if (!off.contains(i)) {
                    res += "S";
                    off.add(i);
                    delete--;
                }
                if (i != n - 1) res += ">";
            }
            if (delete == 0) return res;
            for (int j = i; j >= 0 && delete > 0; j--) {
                if (!off.contains(i)) {
                    res += "S";
                    off.add(i);
                    delete--;
                }
                if (j != 0) res += "<";
            }
            return res;
        } else {
            return "";
        }
    }

    public void run() {
//        String bulbStates = "XXXXXXXXXX";
//        int startIndex = 4, goalCount = 3;
//
//        String bulbStates2 = "XXXXOOOXXX";
//        int startIndex2 = 0, goalCount2 = 3;
//
//        String bulbStates3 = "XXXXOOOXXX";
//        int startIndex3 = 0, goalCount3 = 2;
//
//        pw.println(solve(bulbStates, startIndex, goalCount));
//        pw.println(solve(bulbStates2, startIndex2, goalCount2));
//        pw.println(solve(bulbStates3, startIndex3, goalCount3));
//
//        String bulbStates_test = "XXXXX";
//        int startIndex_test = 0, goalCount_test = 5;
//        pw.println(solve(bulbStates_test, startIndex_test, goalCount_test));

        ////////////////////////////////////////////////////////////////////////
        String bulbStates_sys_test1 = "OOXOOOXOOOOOOOOOOOOOOOOOXOOOOXOOOOOOOOOOOOOOOOOOXOOOOOOOOOOOOXOOOOOOOOOOXXOOOOOOOOOOXOOOXOOOOOOOOOOOOOOOXOOOOOOOOOOOOOOOOOOOOOXOOOOOOOOOOOXOOOOXXOOOOOOOOOOOXOXOOOOOOXOOOOOOOOOOOOOOOOOOXOXOXOOOOOOOOOOOOOOOXXOOOOXOOOOXOOOOOXOOOOOOOOXOOOOOOXOOOOOOOOXOOOOOOOOOOOOXOOOOOOOOOXOOOOXOOOOOOOOOOOOOOOOOOOOOOOXOOXOXOOXOOOOOOOOXOXOOOOOOXOOOOOOOOOOOXXOOXOOOOOOOXOOOOOOOOOXOOOOOOOOOOOOOOOOOOOXOOOOOXOXOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOXOXOOXOOOOOOOOOOOOOOOOOOOOOOXOOOXOXOOOOOO";
        int startIndex_sys_test1 = 47, goalCount_sys_test1 = 460;
        String res_sys1 = solve(bulbStates_sys_test1, startIndex_sys_test1, goalCount_sys_test1);
        pw.println(res_sys1); // ""
        test(res_sys1, bulbStates_sys_test1, goalCount_sys_test1);

//        String bulbStates_sys_test2 = "O";
//        int startIndex_sys_test2 = 0, goalCount_sys_test2 = 0;
//        String res_sys2 = solve(bulbStates_sys_test2, startIndex_sys_test2, goalCount_sys_test2);
//        pw.println(res_sys2); // ""
//        test(res_sys2, bulbStates_sys_test2, goalCount_sys_test2);
    }

    void test(String res, String ss, int cnt) {
        tr(ss);
        char[] r = res.toCharArray();
        char[] s = ss.toCharArray();
        int i = 0;
        for (char c : r) {
            if (c == '>') {
                i++;
            } else if (c == '<') {
                i--;
            } else {
                if (s[i] == 'O') {
                    s[i] = 'X';
                } else {
                    s[i] = 'O';
                }
            }
        }
        tr(new String(s));
        int ct = 0;
        for (char c : s) {
            if (c == 'O') {
                ct++;
            }
        }
        tr(ct, cnt, ct == cnt);
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new LightbulbRow().run();
        pw.close();
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}


