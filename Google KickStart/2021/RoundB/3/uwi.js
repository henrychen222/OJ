// 04/19/21 afternoon + evening debug

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
const mi = Math.min;
const mx = Math.max;
const mxbi = (...args) => args.reduce((m, e) => e > m ? e : m);
const mibi = (...args) => args.reduce((m, e) => e < m ? e : m);
const abs = Math.abs;
const fl = Math.floor;
const ce = Math.ceil;
const sq = Math.sqrt;
const sqbi = (v) => {
    if (v < 0n) throw 'square root of negative numbers is not supported';
    if (v < 2n) return v;
    const dfs = (n, x0) => {
        let x1 = ((n / x0) + x0) >> 1n;
        if (x0 === x1 || x0 === (x1 - 1n)) return x0;
        return dfs(n, x1);
    }
    return dfs(v, 1n); // has >> 0
};
const lge = Math.log;
const lg10 = Math.log10;
const counter = (a_or_s) => {
    let map = new Map();
    for (const i of a_or_s) map.set(i, map.get(i) + 1 || 1);
    return map;
};
///////////////////////////////////////////////////////////////////////////////////

// Accepted
const solve = (z) => {
    let primes = sieveEratosthenes(100000);
    // pr(primes);
    let s = sqbi(z);
    let inf = mxbi(1n, s - 5000n);
    let sup = s + 5000n;
    // pr(inf, sup, primes[primes.length - 1]);
    let ss = sieveBySegment(inf, sup, primes);
    // pr(ss.length);
    // pr(counter(ss));
    let pre = 0n;
    for (let i = ss.length - 1; i >= 0; i--) {
        // pr("idx", i, ss[i]);
        if (ss[i]) {
            // pr("1111")
            let v = inf + BigInt(i);
            // pr(v)
            if (pre != 0n && pre * v <= z) return pre * v;
            pre = v;
        }
    }
};

const sieveBySegment = (low, high, primes) => { // low: BigInt, high: BigInt, primes: int[]
    let m = Number(high - low + 1n);
    let isp = Array(m).fill(true);
    if (low == 1n) isp[0] = false;
    for (const p of primes) {
        let pb = BigInt(p);
        let ppb = pb * pb;
        if (ppb > high) break;
        let sp = (-low) % pb;
        if (sp < 0) sp += pb;
        if (sp + low <= ppb) sp = ppb - low;
        // pr("sp, p ", sp, p, counter(isp)) // issue
        // let cnt = 0;
        for (let u = Number(sp); u < m; u += p) { // issue
            // pr("u", u)
            // cnt++;
            isp[u] = false;
        }
        // pr('cnt', cnt); // issue
    }
    // pr("m", m);
    return isp;
};

const sieveEratosthenes = (n) => { // n: int
    if (n < 32) {
        let primes = [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31];
        for (let i = 0; i < primes.length; i++) {
            if (n < primes[i]) return primes.slice(0, i);
        }
        return primes;
    }
    let u = n + 32;
    let lu = lge(u);
    // pr(u, lu);
    let divide = u / lu;
    let divideT = divide / lu;
    let len = divide + divideT * 1.5;
    let res = Array(len >> 0).fill(0);
    // pr(len >> 0);
    // res[0] = 1; // fuck here, final issue
    res[0] = 2;
    let pos = 1;
    let sup = (((n + 1) / 32 >> 0) >> 1) + 1;
    // pr(sup);
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
            let pp = i << 5 | magic[(j & -j) * 0x076be629 >>> 27]; // wrote << here
            // pr("pp", pp, 0x076be629 >> 27, (j & -j) * 0x076be629 >> 27, (j & -j) * 0x076be629 >>> 27) // see diff
            let p = 2 * pp + 3;
            if (p > n) break;
            // pr("p", p)
            res[pos++] = p;
            if (BigInt(p) * BigInt(p) > n) continue;
            // pr("p go", p)
            for (let q = (p * p - 3) >> 1; q <= h; q += p) isnp[q >> 5] |= 1 << q;
        }
        // pr(res);
    }
    // pr(res, pos)
    return res.slice(0, pos);
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(BigInt(line));
    });
    rl.on('close', () => {
        let t = input[0];
        let i = 1;
        for (let cas = 1; cas <= t; cas++) {
            let show = solve(input[i]);
            pr('Case #' + cas + ': ' + show);
            i++;
        }
    });
};

main()

// pr(sieveEratosthenes(100000));
// pr(sieveEratosthenes(100005));

// pr(sieveEratosthenes(40)); // issue
// pr(sieveEratosthenes(50)); // [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47] issue
// pr(sieveEratosthenes(100));
// pr(sieveEratosthenes(1000)[sieveEratosthenes(1000).length - 1]); // 997
// pr(sieveEratosthenes(100000)[sieveEratosthenes(100000).length - 1]); // 99991

// pr(counter(sieveBySegment(1n, 10n, sieveEratosthenes(10)))); // correct
// pr(counter(sieveBySegment(1n, 5044n, sieveEratosthenes(10)))); // correct
// pr(counter(sieveBySegment(1n, 5044n, sieveEratosthenes(100)))); // wrong
// pr(counter(sieveBySegment(1n, 5044n, sieveEratosthenes(1000))));
// pr(counter(sieveBySegment(1n, 5044n, sieveEratosthenes(10000))));
/// pr(counter(sieveBySegment(1n, 5044n, sieveEratosthenes(100000))));

// pr(sqbi(9n), sqbi(8n), sqbi(BigInt(10 ** 18)));
