// 09/06/21 night

const pr = console.log;
const initialize2DArrayNew = (n, m) => { let data = []; for (let i = 0; i < n; i++) { let tmp = Array(m).fill(0); data.push(tmp); } return data; };
const int = parseInt;

const sieveEratosthenes = (n) => { // n: int
    if (n < 32) {
        let primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31];
        for (let i = 0; i < primes.length; i++) {
            if (n < primes[i]) return primes.slice(0, i);
        }
        return primes;
    }
    let u = n + 32;
    let lu = Math.log(u);
    let divide = u / lu;
    let divideT = divide / lu;
    let len = divide + divideT * 1.5;
    let res = Array(len >> 0).fill(0);
    res[0] = 2;
    let pos = 1;
    let sup = (((n + 1) / 32 >> 0) >> 1) + 1;
    let isnp = Array(sup).fill(0);
    let tprimes = [3, 5, 7, 11, 13, 17, 19, 23, 29, 31];
    for (const tp of tprimes) {
        res[pos++] = tp;
        let ptn = Array(tp).fill(0);
        for (let i = tp - 3 >> 1; i < tp << 5; i += tp) ptn[i >> 5] |= 1 << (i & 31);
        for (let j = 0; j < sup; j += tp) {
            for (let i = 0; i < tp && i + j < sup; i++) {
                isnp[j + i] |= ptn[i];
            }
        }
    }
    let magic = [0, 1, 23, 2, 29, 24, 19, 3, 30, 27, 25, 11, 20, 8, 4, 13, 31, 22, 28, 18, 26, 10, 7, 12, 21, 17, 9, 6, 16, 5, 15, 14];
    let h = n >> 1;
    for (let i = 0; i < sup; i++) {
        for (let j = ~isnp[i]; j != 0; j &= j - 1) {
            let pp = i << 5 | magic[(j & -j) * 0x076be629 >>> 27];
            let p = 2 * pp + 3;
            if (p > n) break;
            res[pos++] = p;
            if (BigInt(p) * BigInt(p) > n) continue;
            for (let q = (p * p - 3) >> 1; q <= h; q += p) isnp[q >> 5] |= 1 << q;
        }
    }
    return res.slice(0, pos);
};

const primes = sieveEratosthenes(1e5);

// Accepted --- https://codeforces.com/problemset/submission/1454/128092804 233ms
const solve = (n) => {
    let fs = factorl(n, primes);
    let max = 0;
    for (const u of fs) max = Math.max(max, u[1]);
    let res = Array(max).fill(1);
    for (const u of fs) {
        for (let i = 0; i < u[1]; i++) res[max - 1 - i] *= u[0];
    }
    pr(max);
    pr(res.join(" "));
};

const factorl = (n, primes) => {
    let res = initialize2DArrayNew(20, 2), rp = 0;
    for (const p of primes) {
        if (p * p > n) break;
        let i;
        for (i = 0; n % p == 0; n = int(n / p), i++);
        if (i > 0) {
            res[rp][0] = p;
            res[rp][1] = i;
            rp++;
        }
    }
    if (n != 1) {
        res[rp][0] = n;
        res[rp][1] = 1;
        rp++;
    }
    return res.slice(0, rp);
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(Number(line));
    });
    rl.on('close', () => {
        let t = Number(input[0]);
        let i = 1;
        while (t--) {
            let data = input[i];
            solve(data);
            i++;
        }
    });
};

main()