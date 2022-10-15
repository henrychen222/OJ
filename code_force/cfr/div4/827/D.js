/**
 * 10/13/22 morning
 * https://codeforces.com/contest/1742/problem/D
 */

const pr = console.log;

const gcd = (a, b) => b == 0 ? a : gcd(b, a % b);

// Accepted
const solve = (n, a) => {
    let m = new Map(), res = -1;
    for (let i = 0; i < n; i++) {
        if (!m.has(a[i])) m.set(a[i], []);
        m.get(a[i]).push(i + 1);
    }
    for (const [x, ax] of m) {
        for (let y = 1; y <= 1000; y++) {
            if (m.has(y) && gcd(x, y) == 1) {
                let ay = m.get(y), i = ax[ax.length - 1], j = ay[ay.length - 1];
                // pr(x, ax, y, ay);
                res = Math.max(res, i + j);
            }
        }
    }
    pr(res);
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
        let t = ni();
        while (t--) {
            let n = ni(), a = nai();
            solve(n, a);
        }
    });
};

main()