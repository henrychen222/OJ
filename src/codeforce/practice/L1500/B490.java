/**
 * 05/02/26 afternoon
 * https://codeforces.com/problemset/problem/490/B
 */
package codeforce.practice.L1500;

import java.util.*;
import java.io.*;

public class B490 {
    static PrintWriter pw;

    /*
     Accepted
     https://codeforces.com/problemset/submission/490/373370124
     https://codeforces.com/problemset/submission/490/373370335
     */
    private void run() {
        read_write_file();
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int[] a = new int[n];
        Map<Integer, Integer> nextMap = new HashMap<>();
        Set<Integer> allFronts = new HashSet<>();
        Set<Integer> allBacks = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int front = fs.nextInt(), back = fs.nextInt(); // back - front = 2
            if (front == 0) {
                a[1] = back;
                allBacks.add(back);
            } else if (back == 0) {
                a[n - 2] = front;
                allFronts.add(front);
            } else {
                nextMap.put(front, back);
                allFronts.add(front);
                allBacks.add(back);
            }
        }
//        tr(a, nextMap, allFronts, allBacks);
        int first = -1; // the one that appears as a front but never as a back
        for (int x : allFronts) {
            if (!allBacks.contains(x)) {
                first = x;
                break;
            }
        }
//        tr("first", first);
        a[0] = first;
        go(nextMap, a[1], 1, a);
        go(nextMap, a[0], 0, a);
        outputA(a);
    }

    void go(Map<Integer, Integer> nextMap, int cur, int idx, int[] a) {
        while (!nextMap.isEmpty()) {
            Integer next = nextMap.get(cur);
            if (next == null) break;
            nextMap.remove(cur);
//            tr("front start", cur, nextMap);
            cur = next;
            idx += 2;
            a[idx] = next;
        }
    }

    void outputA(int[] a) {
        for (int e : a) pw.print(e + " ");
        pr("");
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
        } catch (Exception ignored) {
        }
    }

    public static void main(String[] args) {
        pw = new PrintWriter(System.out);
        new B490().run();
        pw.close();
    }

    <T> void pr(T t) {
        pw.println(t);
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException ignored) {
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