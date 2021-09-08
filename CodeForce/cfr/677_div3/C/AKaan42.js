const mx = Math.max;
const amax = (a) => { if (a.length <= 1e5) return mx(...a); let res = Number.MIN_SAFE_INTEGER; for (const x of a) if (x > res) res = x; return res; }

/**
 * 10/20/20 noon    09/06/21 night fixed
 */

// https://codeforces.com/profile/A.Kaan42
// need to fix

// Accepted --- https://codeforces.com/problemset/submission/1433/128090687 358ms
// Accepted ---- https://codeforces.com/problemset/submission/1433/128091445 343ms
const pr = console.log;
const MAX = Number.MAX_SAFE_INTEGER;
let a = Array(500005).fill(0);
const solve = (n, p) => {
    // let max = Math.max.apply(Math, p); // bug: when array length is too long // RE on Test 3  Maximum call stack size exceeded
    let max = amax(p);
    // let max = 0;
    // for (const x of p) max = Math.max(max, x);
    for (let i = 1; i <= n; i++) a[i] = p[i - 1];
    // pr(a);
    a[0] = MAX;
    a[n + 1] = MAX;
    // pr(a);
    let res = -1;
    for (let i = 1; i <= n; i++) {
        if (a[i] == max && a[i] > a[i - 1]) {
            res = i;
            break;
        }
        if (a[i] == max && a[i] > a[i + 1]) {
            res = i;
            break;
        }
    }
    return res;
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(line.split(" ").map(x => Number(x)));
    });
    rl.on('close', () => {
        let t = input[0][0];
        let i = 1;
        while (t--) {
            pr(solve(input[i][0], input[i + 1]));
            i += 2;
        }
    });
};

main()
