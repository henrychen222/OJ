///////////////////////////////// pre-define ////////////////////////////////////////////////////////////////////////////////
const pr = console.log;
const mi = Math.min;
const mx = Math.max;
const abs = Math.abs;
const fl = Math.floor;
const ce = Math.ceil;
const sq = Math.sqrt;
const lge = Math.log;
const lg10 = Math.log10;
const gcd = (a, b) => b == 0 ? a : gcd(b, a % b);
const lcm = (a, b) => (a / gcd(a, b)) * b;
const amax = (a) => mx.apply(Math, a);
const amin = (a) => mi.apply(Math, a);
const sm = (a) => a.reduce(((x, y) => x + y), 0);
const aeq = (a, b) => JSON.stringify(a) == JSON.stringify(b);
const swap = (a, i, j) => [a[i], a[j]] = [a[j], a[i]];
const stin = (a) => a.sort((x, y) => x - y);
const stde = (a) => a.sort((x, y) => y - x);
const counter = (a_or_s) => { let map = new Map(); for (const i of a_or_s) map.set(i, map.get(i) + 1 || 1); return map; };
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// 05/09/21 evening
// Accepted --- 280ms https://codeforces.com/contest/1521/submission/115824397
// Accepted --- 264ms https://codeforces.com/contest/1521/submission/115824460
// Accepted ---- 265ms https://codeforces.com/contest/1521/submission/115824508
const solve = (a, b) => {
    if (b == 1) {
        return pr('NO');
    }
    pr('YES');
    pr(a, a * (2 * b - 1), 2 * a * b);
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
    });
    rl.on('close', () => {
        let t = input[0][0];
        let i = 1;
        while (t--) {
            solve(input[i][0], input[i][1]);
            i++;
        }
    });
};

main()