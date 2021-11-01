package codeforce.cf.div2.r742;

import java.util.*;
import java.io.*;

// Accepted --- 1544ms
public class E2 {

    static PrintWriter pw;

    Data combine(Data l, Data r) {
        if (l == null) return r;
        if (r == null) return l;
        int newSize = l.size + r.size;
        int newL = -1;
        int newR = -1;
        long newM = -1;
        if (l.uninterrupted()) {
            newM = r.middleSum;
            newL = l.size + r.leftStraight;
        } else {
            newL = l.leftStraight;
        }
        if (r.uninterrupted()) {
            newR = r.size + l.rightStraight;
            newM = l.middleSum;
        } else {
            newR = r.rightStraight;
        }
        if (newM == -1) {
            newM = l.middleSum + r.middleSum + cal(l.rightStraight + r.leftStraight);
        }
        Data ans = new Data(newL, newR, newSize, newM);
        return ans;
    }

    long cal(int n) {
        return n * (long) (n + 1) / 2;
    }

    class SegmentTree {
        int leftmost, rightmost;
        SegmentTree lChild, rChild;
        Data data;

        public SegmentTree(int l, int r) {
            this.leftmost = l;
            this.rightmost = r;
            if (l != r) {
                int mid = (l + r) / 2;
                lChild = new SegmentTree(l, mid);
                rChild = new SegmentTree(mid + 1, r);
                recalculate();
            } else {
                data = new Data(1, 1, 1, 0);
            }
        }

        void pointUpdate(int position, boolean isCutPoint) {
            if (leftmost == rightmost) {
                data = new Data(1, isCutPoint ? 0 : 1, 1, 0);
                return;
            }
            if (position <= lChild.rightmost) {
                lChild.pointUpdate(position, isCutPoint);
            } else {
                rChild.pointUpdate(position, isCutPoint);
            }
            recalculate();
        }

        Data rangeQuery(int l, int r) {
            if (l > rightmost || r < leftmost) return null;
            if (l <= leftmost && r >= rightmost) return data;
            Data lRes = lChild.rangeQuery(l, r);
            Data rRes = rChild.rangeQuery(l, r);
            return combine(lRes, rRes);
        }

        void recalculate() {
            if (leftmost == rightmost) return;
            data = combine(lChild.data, rChild.data);
        }
    }

    class Data {
        int leftStraight, rightStraight, size;
        long middleSum;

        public Data(int leftStraight, int rightStraight, int size, long middleSum) {
            this.leftStraight = leftStraight;
            this.rightStraight = rightStraight;
            this.size = size;
            this.middleSum = middleSum;
        }

        long value() {
            if (size == leftStraight) return cal(leftStraight);
            return middleSum + cal(leftStraight) + cal(rightStraight);
        }

        boolean uninterrupted() {
            return rightStraight == size;
        }

        public String toString() {
            return "{ " + leftStraight + " ... " + middleSum + " ... " + rightStraight + " } size: " + size;
        }
    }

    private void run() {
        read_write_file(); // comment this before submission
        FastScanner fs = new FastScanner();
        int t = 1;
        while (t-- > 0) {
            int n = fs.nextInt();
            int q = fs.nextInt();
            int[] a = fs.readArray(n);
            SegmentTree st = new SegmentTree(0, n - 1);
            for (int i = 0; i < n - 1; i++) {
                if (a[i] > a[i + 1]) st.pointUpdate(i, true);
            }
            for (int i = 0; i < q; i++) {
                int type = fs.nextInt();
                int position = fs.nextInt() - 1;
                int value = fs.nextInt();
                if (type == 1) {
                    a[position] = value;
                    if (position != 0) st.pointUpdate(position - 1, a[position] < a[position - 1]);
                    if (position != n - 1) st.pointUpdate(position, a[position + 1] < a[position]);
                } else {
                    int l = position, r = value - 1;
                    long res = st.rangeQuery(l, r).value();
                    pr(res);
                }
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
        new E2().run();
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