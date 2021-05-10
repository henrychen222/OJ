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
/**
 * 05/07/21 morning
 * https://codeforces.com/problemset/problem/1521/A
 */
// WA
const MAX = BigInt(10 ** 18);
const solve = (a, b) => {
    let p = a * b;
    // pr(a,b,p);
    // if (a == 1) {
    //     if (b == 1) {
    //         pr('YES');
    //         pr(2, 4, 6);
    //         return;
    //     } else if (b == 2) {
    //         pr('YES');
    //         pr(1, 3, 4);
    //         return;
    //     }
    // }
    for (let z = p, rz = 1; z <= MAX; z *= p, rz++) {
        if (rz > 1 && z == p) break;
        // pr(z);
        for (let x = a, rx = 1; x < z; x *= a, rx++) {
            if (rx > 1 && x == a) break;
            let y = z - x;
            // pr(x, y);
            if (x % b != 0) {
                if (y % a == 0 && y % b != 0 && (y != x && x != z && y != z)) {
                    pr('YES');
                    pr(x.toString(), y.toString(), z.toString());
                    return;
                }
            }
        }
    }
    pr('NO');
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(line.split(" ").map(x => BigInt(x)));
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


// pr(60 / (5 * 3));
// pr(208 / (13 * 2));
// pr(154 / (7 * 11));

// pr(50 / 5, 10 / 5, 60 / 5);
// pr(169 / 13, 39 / 13, 208 / 13);
// pr(154 / 7, 28 / 7, 182 / 7);