/**
 * 09/19/21 noon
 * https://www.codechef.com/COOK133B/problems/ZEBRA
 */
package codechef.contest.cook.b_133;

import java.io.*;
import java.util.*;

class ZebraCrossing {

    static PrintWriter pw;

    // Accepted --- https://www.codechef.com/viewsolution/51341233
    // reference: https://discuss.codechef.com/t/zebra-editorial/94588  setter 1's
    void solve(int n, int k, String s) {
        char[] a = s.toCharArray();
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if (a[i] != a[i - 1]) cnt++;
        }
        // tr(cnt);
        if (cnt >= k) {
            for (int i = n - 1; i >= 0; i--) {
                if ((k % 2 == 1 && a[i] != a[0]) || (k % 2 == 0 && a[i] == a[0])) {
                    pr(i + 1);
                    return;
                }
            }
        } else {
            pr(-1);
        }
    }

    /*
     101010...
     010101...
     */
    // WA have issue of condition k is odd
    void solve2(int n, int k, String s) {
        char[] a = s.toCharArray();
        if (k == 1) {
            int idx = s.lastIndexOf(a[0] == '0' ? '1' : '0');
            pr(idx == -1 ? -1 : idx + 1);
            return;
        }
        List<int[]> l = new ArrayList<>();
        if (a[0] == '1') {
            for (int i = 1; i < n - 1; i++) {
                if (a[i] == '0' && a[i + 1] == '1') {
                    l.add(new int[]{i, i + 1});
                }
            }
        } else {
            for (int i = 1; i < n - 1; i++) {
                if (a[i] == '1' && a[i + 1] == '0') {
                    l.add(new int[]{i, i + 1});
                }
            }
        }
        int len = l.size();
        // tr("len", len, k);
        // for (int[] e : l) tr(e);
        // int max = k % 2 == 0 ? len * 2 : len * 2 + 1;
        int max = len * 2;
        if (k <= max) {
            int[] last = l.get(len - 1);
            // pr(k % 2 == 0 ? last[1] + 1 : last[0] + 1);
            if (k % 2 == 0) {
                pr(last[1] + 1);
            } else {
                int lastIdx = last[1];
                // tr("lastIdx", lastIdx);
                for (int i = n - 1; i > lastIdx; i--) {
                    int lastChar = a[lastIdx] == '0' ? '1' : '0';
                    if (a[i] == lastChar) {
                        pr(i + 1);
                        return;
                    }
                }
                pr(lastIdx);
            }
        } else {
            pr(-1);
        }
    }

//    void solve(int n, int k, String s) {
//        char[] a = s.toCharArray();
//        tr(a);
//        TreeSet<Integer> zero = new TreeSet<>();
//        TreeSet<Integer> one = new TreeSet<>();
//        for (int i = 0; i < n; i++) {
//            if (a[i] == '0') {
//                zero.add(i);
//            } else {
//                one.add(i);
//            }
//        }
//        int pos = 0;
//        while (k-- > 0) {
//            char next = nextChar(a[pos]);
//            tr("next", next);
//            Integer nextPos;
//            if (next == '1') {
//                if (one.size() == 0) break;
//                if (one.last() > pos) {
//                    nextPos = one.pollLast();
//                } else {
//                    nextPos = one.higher(pos);
//                }
//                tr("next 1111111", nextPos, a[nextPos]);
//            } else {
//                if (zero.size() == 0) break;
//                if (zero.last() > pos) {
//                    nextPos = zero.pollLast();
//                } else {
//                    nextPos = zero.higher(pos);
//                }
//                tr("next 0000000", nextPos, a[nextPos]);
//            }
//            pos = nextPos;
//        }
//        pr(pos == 0 ? -1 : pos + 1);
//    }
//
//    char nextChar(char c) {
//        return c == '0' ? '1' : '0';
//    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = fs.nextInt();
        while (t-- > 0) {
            int n = fs.nextInt();
            int k = fs.nextInt();
            String s = fs.next();
            solve(n, k, s);
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
        new ZebraCrossing().run();
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
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        Integer[] readIntegerArray(int n) {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    void tr(Object... o) {
        pw.println(Arrays.deepToString(o));
    }
}