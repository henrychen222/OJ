// 02/21/21 morning

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
const AASCII = 'a'.charCodeAt();
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- 96ms https://atcoder.jp/contests/arc113/submissions/20403639
const solve = (s) => {
    let a = s.split("");
    let f = Array(26).fill(0); // count
    let n = s.length;
    let res = 0;
    let i;
    for (i = 0; i < n; i++) {
        a[i] = a[i].charCodeAt() - AASCII;
    }
    // pr(a, f);
    for (i = n - 1; i >= 1; i--) {
        if (a[i - 1] == a[i]) {
            let j;
            for (j = 0; j < 26; j++) {
                if (a[i] != j) {
                    res += f[j];
                    f[a[i]] += f[j];
                    f[j] = 0;
                }
            }
        }
        f[a[i]]++;
    }
    // pr(a, f);
    pr(res);
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    rl.on('line', (line) => {
        solve(line);
    });
};

main()