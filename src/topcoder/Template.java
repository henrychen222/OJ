package topcoder;

import java.util.*;
import java.io.*;

public class Template {

    static PrintWriter pw;

    void solve() {

    }

    public void run() {

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
        new Template().run();
        pw.close();
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}


