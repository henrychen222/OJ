/**
 * 07/19/23 evening
 * https://leetcode.com/contest/weekly-contest-354/problems/length-of-the-longest-valid-substring/
 */
package leetcode.weekly.r354;

import java.util.*;

public class D {
    public int longestValidSubstring(String word, List<String> forbidden) {
        int n = word.length(), l = 0, res = 0;
        Trie tree = new Trie();
        for (String s : forbidden) tree.insert(s);
        for (int i = 0; i < n; i++) {
            while (tree.isValid(word, l, i)) l++;
            res = Math.max(res, i - l + 1);
        }
        return res;
    }

    class Trie {
        Trie[] next;
        int cnt;
        boolean end;

        Trie() {
            this.next = new Trie[26];
            this.cnt = 0;
            this.end = false;
        }

        void insert(String s) {
            Trie cur = this;
            for (int i = s.length() - 1; i >= 0; i--) {
                int idx = s.charAt(i) - 'a';
                if (cur.next[idx] == null) cur.next[idx] = new Trie();
                cur = cur.next[idx];
                cur.cnt++;
            }
            cur.end = true;
        }

        boolean isValid(String s, int l, int r) {
            Trie cur = this;
            for (int i = r; i >= l; i--) {
                int idx = s.charAt(i) - 'a';
                if (cur.next[idx] == null) return false;
                cur = cur.next[idx];
                if (cur.end) return true;
            }
            return false;
        }
    }

    public void run() {
        String word = "cbaaaabc";
        String[] forbidden = {"aaa", "cb"};
        String word2 = "leetcode";
        String[] forbidden2 = {"de", "le", "e"};
        pr(longestValidSubstring(word, Arrays.asList(forbidden)));
        pr(longestValidSubstring(word2, Arrays.asList(forbidden2)));
    }

    public static void main(String[] args) {
        new D().run();
    }

    <T> void pr(T t) {
        System.out.println(t);
    }

    void tr(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
}