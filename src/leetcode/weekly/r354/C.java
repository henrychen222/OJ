/**
 * 07/15/23 evening
 * https://leetcode.com/contest/weekly-contest-354/problems/minimum-index-of-a-valid-split/
 */
package leetcode.weekly.r354;

import java.util.*;

public class C {

    // Accepted 1:25AM
    public int minimumIndex(List<Integer> a) {
        int n = a.size();
        Map<Integer, Integer> rm = counter(a), lm = new HashMap<>();
        TreeSet<Node> r = new TreeSet<>(), l = new TreeSet<>();
        for (int x : rm.keySet()) r.add(new Node(x, rm.get(x)));
        for (int i = 0; i < n; i++) {
            int v = a.get(i), lcntOld = lm.getOrDefault(v, 0), rcntOld = rm.getOrDefault(v, 0);
            l.remove(new Node(v, lcntOld));
            l.add(new Node(v, lcntOld + 1));
            r.remove(new Node(v, rcntOld));
            r.add(new Node(v, rcntOld - 1));
            lm.merge(v, 1, Integer::sum);
            rm.merge(v, -1, Integer::sum);
            int lenL = i + 1, rlenL = n - lenL;
//            tr(lm, rm);
//            debugNodeTreeSet(l);
//            debugNodeTreeSet(r);
//            tr("L", a.subList(0, i + 1), l.first().cnt, "lenL", lenL, "R", a.subList(i + 1, n), r.first().cnt);
            if (l.first().v == r.first().v && dominant(l.first().cnt, lenL) && dominant(r.first().cnt, rlenL)) {
                boolean atMostOne = true;
                if (l.size() >= 2) {
                    if (dominant(findKth(l, 2).cnt, lenL)) {
                        atMostOne = false;
                    }
                }
                if (r.size() >= 2) {
                    if (dominant(findKth(r, 2).cnt, rlenL)) {
                        atMostOne = false;
                    }
                }
                if (atMostOne) return i;
            }
        }
        return -1;
    }

    boolean dominant(int freq, int m) {
        return freq * 2 > m;
    }

    Map<Integer, Integer> counter(List<Integer> a) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int x : a) m.merge(x, 1, Integer::sum);
        return m;
    }

    Node findKth(TreeSet<Node> ts, int k) {
        Iterator<Node> it = ts.iterator();
        int i = 0;
        Node cur = null;
        while (it.hasNext() && i < k) {
            cur = it.next();
            i++;
        }
        return cur;
    }

    class Node implements Comparable<Node> {
        int v, cnt;

        Node(int v, int cnt) {
            this.v = v;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node y) {
            if (cnt != y.cnt) return y.cnt - cnt;
            return v - y.v; // cannot return 0, some node will missing
        }

        public String toString() {
            return this.v + "=" + this.cnt;
        }
    }

    public void run() {
        Integer[] a = {1, 2, 2, 2};
        Integer[] a2 = {2, 1, 3, 1, 1, 1, 7, 1, 2, 1};
        Integer[] a3 = {3, 3, 3, 3, 7, 2, 2};
        pr(minimumIndex(Arrays.asList(a)));
        pr(minimumIndex(Arrays.asList(a2)));
        pr(minimumIndex(Arrays.asList(a3)));
    }

    public static void main(String[] args) {
        new C().run();
    }

    <T> void pr(T t) {
        System.out.println(t);
    }

    void tr(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    void debugNodeTreeSet(TreeSet<Node> ts) {
        List<String> res = new ArrayList<>();
        for (Node node : ts) {
            res.add(node.toString());
        }
        tr("set", res);
    }
}