/**
 * 02/05/21 evening night
 * https://leetcode.com/contest/weekly-contest-279/problems/design-bitset/
 */
package leetcode.weekly.r279;

import java.util.*;

// TLE 44/48
public class Bitset {
    BitSet bs;
    int n;
    public Bitset(int size) {
        bs = new BitSet(size);
        n = size;
    }

    public void fix(int idx) {
        bs.set(idx);
        // tr("fix", debugBitSet(bs, n));
    }

    public void unfix(int idx) {
        bs.set(idx, false);
        // tr("unfix", debugBitSet(bs, n));
    }

    public void flip() {
        bs.flip(0, n);
        // tr("flip", debugBitSet(bs, n));
    }

    public boolean all() {
        // tr("all", debugBitSet(bs, n), bs.cardinality());
        return bs.cardinality() == n;
    }

    public boolean one() {
        // tr("one", debugBitSet(bs, n), bs.cardinality());
        return bs.cardinality() >= 1;
    }

    public int count() {
        // tr("count", debugBitSet(bs, n), bs.cardinality());
        return bs.cardinality();
    }

    public String toString() {
        return debugBitSet(bs, n);
    }

    public static void main(String[] args) {
        Bitset bs = new Bitset(5); // bitset = "00000".
        bs.fix(3);
        bs.fix(1);
        bs.flip();
        System.out.println(bs.all());      // false
        bs.unfix(0);
        bs.flip();
        System.out.println(bs.one());      // true
        bs.unfix(0);
        System.out.println(bs.count());    // 2
        System.out.println(bs.toString()); // "01010"
    }

    static String debugBitSet(BitSet bs, int n) {
        String s = "";
        for (int i = 0; i < n; i++) {
            s += bs.get(i) ? "1" : "0";
        }
        return s;
    }

    static void tr(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

}