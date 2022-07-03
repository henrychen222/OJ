/**
 * 05/06/21 evening
 * https://www.hackerrank.com/challenges/bigger-is-greater/problem
 */

// Accepted --- https://www.hackerrank.com/challenges/bigger-is-greater/submissions/code/212141116
const biggerIsGreater = (w) => {
   let a = w.split("");
   let has = nextPermutation(a);
   if (!has) return 'no answer';
   return a.join("");
};

const nextPermutation = (a) => {
    let n = a.length;
    let i, j;
    for (i = n - 2; i >= 0 && a[i] >= a[i + 1]; i--);
    if (i === -1) return false;
    for (j = i + 1; j < n && a[i] < a[j]; j++);
    [a[i], a[j - 1]] = [a[j - 1], a[i]];
    for (let p = i + 1, q = n - 1; p < q; p++, q--)[a[p], a[q]] = [a[q], a[p]];
    return true;
};

const pr = console.log;
const main = () => {
    let w1 = 'ab';
    let w2 = 'bb';
    let w3 = 'hefg';
    let w4 = 'dhck';
    let w5 = 'dkhc';
    let w6 = 'lmno';
    let w7 = 'dcba';
    let w8 = 'dcbb';
    let w9 = 'abdc';
    let w10 = 'abcd';
    let w11 = 'fedcbabcd';
    pr(biggerIsGreater(w1));
    pr(biggerIsGreater(w2));
    pr(biggerIsGreater(w3));
    pr(biggerIsGreater(w4));
    pr(biggerIsGreater(w5));
    pr(biggerIsGreater(w6));
    pr(biggerIsGreater(w7));
    pr(biggerIsGreater(w8));
    pr(biggerIsGreater(w9));
    pr(biggerIsGreater(w10));
    pr(biggerIsGreater(w11));
};

main()

// console.log('b' > 'a', 'b' < 'a');