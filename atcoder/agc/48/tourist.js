/**
 * 07/03/22 morning
 */
const pr = console.log;

// Accepted --- https://atcoder.jp/contests/agc048/submissions/32968432
const solve = (s) => {
    let n = s.length;
    if (s > 'atcoder') return pr(0);
    if (s == 'a'.repeat(n)) return pr(-1);
    for (let i = 1; i < n; i++) {
        if (s[i] != 'a') {
            pr(i - (s[i] > 't' ? 1 : 0));
            break;
        }
    }
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
            let s = readLine();
            solve(s);
        }
    });
};

main()