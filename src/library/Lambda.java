/**
 * created 09/19/21 night
 */

package library;

import java.io.PrintWriter;
import java.util.*;

public class Lambda {

    static PrintWriter pw;

    public void run() {
        int[][] a = {{1, 2}, {2, 3}, {3, 1}};
        Integer[] am = Arrays.stream(a).map(x -> x[1]).toArray(Integer[]::new);
        tr(am);

        int[] b = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        long sum0 = Arrays.stream(b).sum(); // wrong this is int sum
        long sum1 = Arrays.stream(b).mapToLong(Long::valueOf).sum();
        tr(sum0, sum1);
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

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new Lambda().run();
        pw.close();
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}
