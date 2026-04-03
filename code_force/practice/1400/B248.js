/**
 * 01/12/23 night
 * https://codeforces.com/problemset/problem/248/B
 */
const pr = console.log;

const lcm = (a, b) => (a / gcd(a, b)) * b;
const gcd = (a, b) => b == 0 ? a : gcd(b, a % b);

const ll = BigInt;

// Accepted --- https://codeforces.com/problemset/submission/248/189063156
const solve = (n) => { // 找规律 6为周期
    if (n <= 6) {
        pr(make(n))
    } else {
        let d = Array(12), pos = (n % 6) + 6 - 1;
        for (let i = 1; i <= 11; i++) d[i - 1] = make(i);
        let s = d[pos], cnt = n / 6 >> 0;
        // pr("d", d, pos, s);
        cnt--;
        let idx = middleZeroEnd(s), l = s.slice(0, idx), r = s.slice(idx);
        let res = l + '0'.repeat(6 * cnt) + r;
        // pr(res, res.length, make(n), make(n).length, res == make(n));
        pr(res);
    }
};

const make = (n) => {
    let v = 1n, a = [2n, 3n, 5n, 7n];
    for (const x of a) v = lcm(v, x);
    let min = ll('1' + '0'.repeat(n - 1)), max = ll('9'.repeat(n)), start = min / v * v, end = max / v * v;
    if (v > end) return -1;
    return start.toString().length == n ? start.toString() : (start + v).toString();
};

const middleZeroEnd = (s) => {
    let i = 1;
    for (; i < s.length && s[i] == '0'; i++);
    return i;
};

const main = () => {
    const readLine = () => input[currentLine++];
    const ni = () => readLine() - '0';
    const nl = () => BigInt(readLine());
    const nas = () => readLine().split(" ");
    const nai = () => nas().map(Number);
    const nal = () => nas().map(BigInt);
    let input = '', currentLine = 0;
    process.stdin.on('data', (stdin) => input += stdin)
    process.stdin.on('end', () => {
        input = input.split('\n');
        solve(ni());
    });
};

main()