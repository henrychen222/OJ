// 07/03/22 morning

const pr = console.log;

const counter = (a_or_s) => { let m = new Map(); for (const x of a_or_s) m.set(x, m.get(x) + 1 || 1); return m; };

// Accepted --- 3823ms
const solve = (n, k, a) => {
    let m = counter(a), u = [...new Set(a)].sort((x, y) => x - y), res = 0;
    for (let i = 1; i < u.length; i++) {
        if (u[i] - u[i - 1] <= k) {
            m.delete(u[i - 1]);
        }
    }
    for (const [, occ] of m) res += occ;
    pr(res);
};

const main = () => {
    const readLine = () => input[currentLine++];
    const ni = () => readLine() - '0';
    const nas = () => readLine().split(" ");
    const nai = () => nas().map(Number);
    const nall = () => nas().map(BigInt);
    let input = '', currentLine = 0;
    process.stdin.on('data', (stdin) => input += stdin)
    process.stdin.on('end', () => {
        input = input.split('\n');
        let [n, k] = nai(), a = nai();
        solve(n, k, a);
    });
};

main();