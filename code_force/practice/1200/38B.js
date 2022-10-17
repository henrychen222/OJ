/**
 * 07/03/22 night
 * https://codeforces.com/problemset/problem/38/B
 */

const pr = console.log;

const ord = (c) => c.charCodeAt();
const initialize2DArray = (n, m) => { let d = []; for (let i = 0; i < n; i++) { let t = Array(m).fill(0); d.push(t); } return d; };

/*
    1 1 1 1 1 1 1 1
    1 2 X 0 0 0 0 0
    1 X 0 2 0 0 0 0
    1 0 2 0 0 0 0 0
    1 0 0 0 0 0 0 0
    1 0 0 0 0 0 0 0
    1 0 0 0 0 0 0 0
    1 0 0 0 0 0 0 0
*/
// Accepted --- https://codeforces.com/problemset/submission/38/162716234
const solve = (x1, y1, x2, y2) => {
    // pr(x1, y1, x2, y2);
    let g = initialize2DArray(8, 8), res = 0, hitHook = 0;
    g[x1][y1] = 1;
    g[x2][y2] = 2;
    knightHit(g, x2, y2);
    rookHit(g, x1, y1);
    // pr(g);
    for (let i = 0; i < 8; i++) {
        for (let j = 0; j < 8; j++) {
            if (!g[i][j]) {
                for (let k = 0; k < 8; k++) { // 还要判断马不能吃车
                    let nx = i + dx[k], ny = j + dy[k];
                    if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8) continue;
                    if (nx == x1 && ny == y1) hitHook++;
                }
                res++;
            }
        }
    }
    pr(res - hitHook);
};

const rookHit = (g, x, y) => { // 车
    let n = g.length, m = g[0].length;
    for (let i = x; i < n; i++) g[i][y] = 1;
    for (let i = x; ~i; i--) g[i][y] = 1;
    for (let j = y; j < m; j++) g[x][j] = 1;
    for (let j = y; ~j; j--) g[x][j] = 1;
};

// similar problem: https://www.codechef.com/START44C/problems/KNIGHTATTACK
const dx = [-1, -1, 1, 1, -2, -2, 2, 2], dy = [-2, 2, -2, 2, -1, 1, -1, 1];
const knightHit = (g, x, y) => { // 马
    let n = g.length, m = g[0].length;
    for (let k = 0; k < 8; k++) {
        let nx = x + dx[k], ny = y + dy[k];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
        g[nx][ny] = 2;
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
        let s1 = readLine(), s2 = readLine();
        let x1 = ord(s1[0]) - 97, y1 = s1[1] - '0', x2 = ord(s2[0]) - 97, y2 = s2[1] - '0';
        y1--, y2--;
        solve(x1, y1, x2, y2);
    });
};

main()