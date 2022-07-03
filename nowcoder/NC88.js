/**
 * 11/02/21 moring
 * https://www.nowcoder.com/practice/e016ad9b7f0b45048c58a9f27ba618bf?tpId=188
 */

const counter = (a_or_s) => { let m = new Map(); for (const x of a_or_s) m.set(x, m.get(x) + 1 || 1); return m; };

// Accepted --- 61ms
function findKth(a, n, k) {
    a.sort((x, y) => y - x);
    let m = counter(a), i = 1;
    for (const [x, occ] of m) {
        if (i >= k) {
            return x;
        }
        i += occ;
    }
}