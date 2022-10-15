/**
 * 10/13/22 morning
 * https://codeforces.com/contest/1742/problem/C
 */

const pr = console.log;

const R = "R".repeat(8), B = "B".repeat(8);

// WA --- https://codeforces.com/contest/1742/submission/176003062
// Accepted --- https://codeforces.com/contest/1742/submission/176052340
const solve = (g) => {
    let n = g.length, m = g[0].length, res = '';
    // pr(g, n, m)
    let rows = [], cols = [];
    for (let i = 0; i < n; i++) {
        let row = '';
        for (let j = 0; j < m; j++) {
            row += g[i][j];
        }
        rows.push(row);
    }
    // pr('rows', rows);
    for (let row of rows) {
        if (row = R) res = 'R';
        // if (row == R) return pr('R');
        // if (row == B) return pr('B');
    }
    for (let i = 0; i < n; i++) {
        let col = '';
        for (let j = 0; j < m; j++) {
            col += g[j][i];
        }
        cols.push(col);
    }
    // pr('cols', cols);
    for (let col of cols) {
        if (col == B) res = 'B';
        // if (col == R) return pr('R');
        // if (col == B) return pr('B');
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
        input = input.split('\r\n');
        // pr("input", input)
        let t = ni();
        while (t--) {
            readLine();
            let g = [];
            for (let i = 0; i < 8; i++) {
                let row = readLine();
                g.push(row);
            }
            solve(g);
        }
    });
};

main()