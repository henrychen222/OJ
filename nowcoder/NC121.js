/**
 * 11/06/21 night
 * https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7
 */

// Accepted --- 48ms
const Permutation = (s) => {
    let a = s.split("");
    a.sort((x, y) => x - y);
    let res = new Set();
    res.add(s);
    do {
        res.add(a.join(""));
    } while (next_permutation(a));
    return [...res];
};

const next_permutation = (a) => { // array inside can be char ('0' ~ '9', 'a' ~ 'z') and number
    let n = a.length;
    let i, j;
    for (i = n - 2; i >= 0 && a[i] >= a[i + 1]; i--);
    if (i === -1) return false;
    for (j = i + 1; j < n && a[i] < a[j]; j++);
    [a[i], a[j - 1]] = [a[j - 1], a[i]];
    for (let p = i + 1, q = n - 1; p < q; p++, q--) [a[p], a[q]] = [a[q], a[p]];
    return true;
};


module.exports = {
    Permutation: Permutation
};