/**
 * 11/08/21 morning
 * https://www.luogu.com.cn/problem/P1008
 */
package luogu.level2_orange.P1008;

import java.util.*;
import java.io.*;

class Main {

    static PrintWriter pw;

    // Accepted --- https://www.luogu.com.cn/record/62056753
    private void run() {
        int maxSum = 999 * 3;
        int one = (int) Math.ceil((double) maxSum / 6);
        int two = one * 2, three = one * 3;
        for (int x = 100; x < one; x++) {
            for (int y = 200; y < two; y++) {
                if (x * 2 == y) {
                    for (int z = 300; z < Math.min(1000, three); z++) {
                        if (x * 3 == z && y * 1.5 == z) {
                            if (ok(x, y, z)) pr(x + " " + y + " " + z);
                        }
                    }
                }
            }
        }
    }

    boolean ok(int x, int y, int z) {
        String sx = x + "", sy = y + "", sz = z + "";
        Set<Character> se = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            char cx = sx.charAt(i), cy = sy.charAt(i), cz = sz.charAt(i);
            if (cx == '0' || cy == '0' || cz == '0') return false;
            se.add(cx);
            se.add(cy);
            se.add(cz);
        }
        return se.size() == 9;
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new Main().run();
        pw.close();
    }

    void pr(int num) {
        pw.println(num);
    }

    void pr(long num) {
        pw.println(num);
    }

    void pr(double num) {
        pw.println(num);
    }

    void pr(String s) {
        pw.println(s);
    }

    void pr(char c) {
        pw.println(c);
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}