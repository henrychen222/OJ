/**
 * 10/13/22 night
 * https://codeforces.com/problemset/problem/230/B
 */

const pr = console.log;

/*
Accepted (10/14/22 night fix)
https://codeforces.com/problemset/submission/230/176236302

TLE:
https://codeforces.com/problemset/submission/230/176230925
https://codeforces.com/problemset/submission/230/176097670
*/
const solve = (n, a) => {
    let min = Math.min(...a), max = Math.max(...a), memo = new Set();
    for (const x of a) {
        if (isPerfectSqure(x)) {
            if (memo.has(x)) {
                pr("YES");
                continue;
            } else {
                if (isPrime(Math.sqrt(x))) {
                    pr("YES");
                    memo.add(x);
                    continue;
                }
            }
        }
        pr("NO");
    }
};

const isPerfectSqure = (n) => {
    let sq = Math.sqrt(n);
    return sq == parseInt(sq);
};

const millerRabin = (d, n) => {
    let a = 2 + parseInt(Math.random() % (n - 4));
    let x = Number(powmod(a, d, n));
    if (x == 1 || x == n - 1) return true;
    while (d != n - 1) {
        x = (x * x) % n;
        d *= 2;
        if (x == 1) return false;
        if (x == n - 1) return true;
    }
    return false;
};

const powmod = (a, b, mod) => {
    let r = 1;
    while (b > 0) {
        if (b % 2 == 1) r = r * a % mod;
        b >>= 1;
        a = a * a % mod;
    }
    return r;
};

const isPrime = (n, k = 4) => { // n < Number.MAX_SAFE_INTERGER
    if (n <= 1 || n == 4) return false;
    if (n <= 3) return true;
    let d = n - 1;
    while (d % 2 == 0) d = parseInt(d / 2);
    for (let i = 0; i < k; i++) {
        if (!millerRabin(d, n)) return false;
    }
    return true;
};

const main = () => {
    const readLine = () => input[currentLine++];
    const ni = () => readLine() - '0';
    const nas = () => readLine().split(" ");
    const nai = () => nas().map(Number);
    const nal = () => nas().map(BigInt);
    let input = '', currentLine = 0;
    process.stdin.on('data', (stdin) => input += stdin)
    process.stdin.on('end', () => {
        input = input.split('\n');
        let n = ni(), a = nai();
        solve(n, a);
    });
};

main()