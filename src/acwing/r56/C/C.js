/**
 * 07/03/22 morning
 */

const pr = console.log;

const gcd = (a, b) => b == 0 ? a : gcd(b, a % b);

// Accepted --- https://www.acwing.com/problem/content/submission/code_detail/15138421/ 9982ms
const solve = (p, q, b) => {
    let g = gcd(p, q);
    p /= g;
    q /= g;
    pr(isFiniteDecimal(q, b) ? "YES" : "NO");
};

const isFiniteDecimal = (x, base) => { // 是否为有限小数
    while (1) {
        let g = gcd(x, base);
        if (g == 1) break;
        while (x % g == 0) x /= g;
    }
    return x == 1;
}

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
            let [p, q, b] = nai();
            solve(p, q, b);
        }
    });
};

main()