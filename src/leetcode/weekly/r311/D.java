/*
 * 09/17/22 night
 * https://leetcode.com/contest/weekly-contest-311/problems/sum-of-prefix-scores-of-strings/
 */

package leetcode.weekly.r311;

// Accepted --- 471ms
class D {
    public int[] sumPrefixScores(String[] a) {
        Trie trie = new Trie();
        int[] res = new int[a.length];
        for (String s : a) trie.insert(s);
        int p = 0;
        for (String s : a) res[p++] = trie.query(s);
        return res;
    }

    class TrieNode {
        int cnt;
        TrieNode[] next;
        TrieNode() {
            cnt = 0;
            next = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }
        void insert(String s) {
            TrieNode cur = root;
            for (int i = 0; i < s.length(); i++) {
                int idx = s.charAt(i) - 'a';
                if (cur.next[idx] == null) cur.next[idx] = new TrieNode();
                cur = cur.next[idx];
                cur.cnt++;
            }
        }
        int query(String s) {
            TrieNode cur = root;
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                int idx = s.charAt(i) - 'a';
                cur = cur.next[idx];
                res += cur.cnt;
            }
            return res;
        }
    }
}