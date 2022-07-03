// 02/21/21 morning

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
const AASCII = 'a'.charCodeAt();
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- 101ms https://atcoder.jp/contests/arc113/submissions/20403164
const solve = (s) => {
    let n = s.length;
    let pre = n;
    let prec = '';
    let res = 0;
    let f = Array(26).fill(0);
    for (let i = n - 1; ~i; i--) {
        if (i <= n - 3 && s[i] == s[i + 1] && s[i + 1] != s[i + 2]) {
            if (prec == s[i]) {
                res += pre - i - 2 - (f[s[i].charCodeAt() - AASCII] - 1);
            } else {
                res += n - i - 2 - (f[s[i].charCodeAt() - AASCII] - 1);
            }
            f = Array(26).fill(0);
            pre = i;
            prec = s[i];
        } else {
            f[s[i].charCodeAt() - AASCII]++;
        }
    }
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