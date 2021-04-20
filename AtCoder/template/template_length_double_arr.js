///////////////////////////////// pre-define /////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////
const pr = console.log;
const err = console.error;
// ****************************** Math *******************************************
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
const gcd = (a, b) => b == 0 ? a : gcd(b, a % b);
const lcm = (a, b) => (a / gcd(a, b)) * b;
const powmod = (a, b, mod) => {
    let r = 1n;
    while (b > 0n) {
        if (b % 2n == 1) r = r * a % mod;
        b >>= 1n;
        a = a * a % mod;
    }
    return r; // return BigInt
};
const combination = (m, n) => {
    return factorial(m, n) / factorial(n, n); // return BigInt
};
const factorial = (m, n) => {
    let num = 1n;
    let cnt = 0;
    for (let i = BigInt(m); i > 0; i--) {
        if (cnt == n) break;
        num *= i;
        cnt++;
    }
    return num;
};
const bitCount = (n) => {
    n = n - ((n >> 1) & 0x55555555);
    n = (n & 0x33333333) + ((n >> 2) & 0x33333333);
    return ((n + (n >> 4) & 0xF0F0F0F) * 0x1010101) >> 24;
};
// ****************************** Array / String *******************************************
const amax = (a) => mx.apply(Math, a);
const amin = (a) => mi.apply(Math, a);
const sum = (a) => a.reduce(((x, y) => x + y), 0);
const arrayEqual = (a, b) => JSON.stringify(a) == JSON.stringify(b);
const swap = (a, i, j) => [a[i], a[j]] = [a[j], a[i]];
const sortPart = (a, k) => { // sort only first kth elements
    let l = a.slice(0, k);
    l.sort((x, y) => x - y);
    let r = a.slice(k);
    return l.concat(r);
};
const counter = (a_or_s) => {
    let map = new Map();
    for (const i of a_or_s) map.set(i, map.get(i) + 1 || 1);
    return map;
};
const isPalindrome = (s) => {
    let n = s.length;
    let i = 0;
    let j = n - 1;
    while (i < j) {
        if (s[i++] != s[j--]) return false;
    }
    return true;
};
///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////

const solve = (n, da) => {
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
        // input.push(line.split(" ").map(x => BigInt(x)));
    });
    rl.on('close', () => {
        solve(input[0][0], input.slice(1));
    });
};

main()