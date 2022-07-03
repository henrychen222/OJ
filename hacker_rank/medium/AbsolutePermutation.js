/**
 * 02/08/22 evening
 * https://www.hackerrank.com/challenges/absolute-permutation/problem?isFullScreen=true
 * 
 * https://www.hackerrank.com/challenges/absolute-permutation/forum
 */

// Accepted --- https://www.hackerrank.com/challenges/absolute-permutation/submissions/code/255537613
let n;
const absolutePermutation = (N, k) => {
    n = N;
    let a = Array(n).fill(-1), used = new Set();
    // judge if exist
    for (let i = 0; i < n; i++) { // build only 1 exist
        let idx = i + 1;
        let x = k + idx, y = idx - k;
        // pr(x, y);
        if (ok(x)) {
            if (ok(y)) {
            } else { // only 1 available cannot be reused
                if (used.has(x)) {
                    return [-1];
                } else {
                    a[i] = x;
                    used.add(x);
                }
            }
        } else {
            if (ok(y)) {
                if (used.has(y)) {
                    return [-1];
                } else {
                    a[i] = y;
                    used.add(y);
                }
            } else {
                return [-1];
            }
        }
    }
    // pr("step 1", a);
    for (let i = 0; i < n; i++) { // build both exist
        if (a[i] == -1) {
            let idx = i + 1;
            let x = k + idx, y = idx - k;
            let min = Math.min(x, y), max = Math.max(x, y);
            if (ok(min) && !used.has(min)) { // lexicographically smallest, min first
                a[i] = min;
                used.add(min);
                continue;
            }
            if (ok(max) && !used.has(max)) {
                a[i] = max;
                used.add(max);
                continue;
            }
            return [-1]; // both used, not exist
        }
    }
    // pr(test(a, k), new Set(a).size)
    return a;
};

const ok = (x) => x >= 1 && x <= n;

const test = (a, k) => {
    for (let i = 0; i < n; i++) {
        if (Math.abs(a[i] - (i + 1)) != k) return false;
    }
    return true;
};

const pr = console.log;
const main = () => {
    let n0 = 4, k0 = 2;
    let n = 2, k = 1;
    let n2 = 3, k2 = 0;
    let n3 = 3, k3 = 2;

    let n_test1 = 5, k_test1 = 2;
    let n_test2 = 15, k_test2 = 3;
    pr(absolutePermutation(n0, k0))
    pr(absolutePermutation(n, k))
    pr(absolutePermutation(n2, k2))
    pr(absolutePermutation(n3, k3))
    pr(absolutePermutation(n_test1, k_test1)) // -1
    pr(absolutePermutation(n_test2, k_test2)) // -1
};

main()