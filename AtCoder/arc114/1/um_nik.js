/**
 * 03/14/21 afternoon
 * https://atcoder.jp/contests/arc114/submissions?f.User=Um_nik
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- 274ms https://atcoder.jp/contests/arc114/submissions/20952561
const N = 50;
const solve = (n, a) => {
    let p = Array(N).fill(0);
    let primes = Array(N).fill(0n);
    let m = 0;
    for (let i = 2; i < N; i++) p[i] = 1;
    for (let x = 2n; x < N; x++) {
        if (!p[x]) continue;
        primes[m++] = x;
        for (let y = x * 2n; y < N; y += x) p[y] = 0;
    }
    // pr(primes, p);
    let res = 1n;
    for (let i = 0; i < m; i++) res *= primes[i];
    for (let mask = 0; mask < 1 << m; mask++) {
        let ok = 1;
        for (let i = 0; ok && i < n; i++) {
            let curok = 0;
            for (let j = 0; !curok && j < m; j++) {
                if ((mask >> j & 1) == 0) continue;
                curok |= a[i] % primes[j] == 0;
            }
            ok &= curok;
        }
        if (!ok) continue;
        let x = 1n;
        for (let j = 0; j < m; j++) {
            if (mask >> j & 1) x *= primes[j];
        }
        // pr(x);
        if (x < res) res = x;
    }
    pr(res.toString());
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(line.split(" ").map(x => BigInt(x)));
    });
    rl.on('close', () => {
        solve(input[0][0], input[1]);
    });
};

main()