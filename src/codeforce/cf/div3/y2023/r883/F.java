/**
 * 07/07/23 evening
 * https://codeforces.com/contest/1846/problem/F
 */
package codeforce.cf.div3.y2023.r883;

import java.util.*;
import java.io.*;

public class F {
    static PrintWriter pw;

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int[] a = fs.readArray(n);
            int tar=-1;
            pr("- 0");
            int[] b =fs.readArray(n);
            int[]cnt= new int[10];
            for(int i = 0; i < n; i++) {
                cnt[a[i]]--;
                cnt[b[i]]++;
            }
            boolean find= false;
            for(int i=0;i <10;i++) {
                if(cnt[i]>0) {
                    tar= i;
                    find  =true;
                    break;
                }
            }
            if(!find) continue;
            List<Integer> res= new ArrayList<>();
            for(int i = 0; i<n;i++) {
                if(b[i] != tar)  res.add(i+1);
            }
        }
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
        new F().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}