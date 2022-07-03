/**
 * 02/08/22 evening
 * https://www.hackerrank.com/challenges/pairs/problem
 */

const pr = console.log;

const counter = (a_or_s) => { let m = new Map(); for (const x of a_or_s) m.set(x, m.get(x) + 1 || 1); return m; };

// Accepted --- https://www.hackerrank.com/challenges/pairs/submissions/code/255542234
const pairs = (k, a) => {
    let m = counter(a), res = 0, used = new Set();
    for (const [x, occ] of m) {
        let v = [x - k, x + k];
        for (const y of v) {
            let p = [x, y];
            p.sort((x, y) => x - y);
            // pr('pair', p);
            let ke = p[0] + ' ' + p[1];
            if (x == y && occ < 2) continue;
            if (m.has(y) && !used.has(ke)) {
                // pr(x, y);
                let yocc = m.get(y);
                res += Math.min(occ, yocc);
                used.add(ke);
            }
        }
    }
    return res;
};

const main = () => {
    let k = 2, a = [1, 5, 3, 4, 2];
    pr(pairs(k, a));
};

main()