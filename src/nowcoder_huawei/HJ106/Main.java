/**
 * 11/01/21 morning
 * https://www.nowcoder.com/practice/cc57022cb4194697ac30bcb566aeb47b?tpId=37
 */
package nowcoder_huawei.HJ106;

import java.util.*;
import java.io.*;

public class Main {

    static PrintWriter pw;

    // Accepted --- https://www.nowcoder.com/profile/410775365/codeBookDetail?submissionId=122057240
    private void run() {
        read_write_file(); // comment this before submission
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine(), res = "";
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) res += s.charAt(i);
        pr(res);
    }

    private final String INPUT = "input.txt";
    private final String OUTPUT = "output.txt";

    void read_write_file() {
        FileInputStream instream = null;
        PrintStream outstream = null;
        try {
            instream = new FileInputStream(INPUT);
            outstream = new PrintStream(new FileOutputStream(OUTPUT));
            System.setIn(instream);
            System.setOut(outstream);
        } catch (Exception e) {
        }
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