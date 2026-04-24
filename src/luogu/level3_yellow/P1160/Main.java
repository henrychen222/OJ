/**
 * 04/10/26 afternoon
 * https://www.luogu.com.cn/problem/P1160
 */
package luogu.level3_yellow.P1160;

import java.util.*;
import java.io.*;

class Main {
    static PrintWriter pw;

    // Accepted --- https://www.luogu.com.cn/record/273262655
    // reference: https://www.luogu.com.cn/problem/solution/P1160 BT狸
    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        DoubleLinkedList list = new DoubleLinkedList(n + 1);
        list.addLeft(0, 1);
        for (int i = 2; i <= n; i++) {
            int[] e = fs.readArray(2);
            if (e[1] == 0) {
                list.addLeft(i, e[0]);
            } else {
                list.addRight(i, e[0]);
            }
            // tr(list.show());
        }
        int m = fs.nextInt();
        for (int i = 0; i < m; i++) {
            list.remove(fs.nextInt());
        }
        var res = list.show();
        outputL(res);
    }

    class Node {
        int prev, next;
        boolean isRemove;

        Node() {
            this.prev = 0;
            this.next = 0;
            this.isRemove = false;
        }
    }

    class DoubleLinkedList {
        Node[] nodes;

        DoubleLinkedList(int n) {
            nodes = new Node[n];
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node();
            }
            nodes[0].next = 0;
            nodes[0].prev = 0;
        }

        void addLeft(int cur, int exist) {
            nodes[cur].next = exist;
            nodes[cur].prev = nodes[exist].prev;
            nodes[nodes[exist].prev].next = cur;
            nodes[exist].prev = cur;
        }

        void addRight(int cur, int exist) {
            nodes[cur].prev = exist;
            nodes[cur].next = nodes[exist].next;
            nodes[nodes[exist].next].prev = cur;
            nodes[exist].next = cur;
        }

        void remove(int studentId) {
            nodes[studentId].isRemove = true;
        }

        List<Integer> show() {
            List<Integer> res = new ArrayList<>();
            for (int i = nodes[0].next; i != 0; i = nodes[i].next) {
                if (!nodes[i].isRemove) {
                    res.add(i);
                }
            }
            return res;
        }
    }

    void outputL(List<Integer> l) {
        for (int e : l) pw.print(e + " ");
        pr("");
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    void read_write_file() {
        FileInputStream instream = null;
        PrintStream outstream = null;
        try {
            String INPUT = "input.txt";
            instream = new FileInputStream(INPUT);
            String OUTPUT = "output.txt";
            outstream = new PrintStream(new FileOutputStream(OUTPUT));
            System.setIn(instream);
            System.setOut(outstream);
        } catch (Exception ignore) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new Main().run();
        pw.close();
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ignore) {
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