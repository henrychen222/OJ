/**
 * 03/17/21 morning
 * https://codeforces.com/contest/1497/problem/C1
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// TLE
const solve = (n, k) => {
    let h = n >> 1;
    for (let x = 1; x <= h; x++) {
        for (let y = 1; x + y < n && y <= h; y++) {
            let z = n - x - y;
            let xy = lcm(x, y);
            let yz = lcm(y, z);
            let f = lcm(xy, yz);
            if (f <= h) return pr(`${x} ${y} ${z}`);
        }
    }
};

// TLE
// const solve = (n, k) => {
//     let h = n >> 1;
//     let memo = new Map();
//     for (let x = 1; x <= h; x++) {
//         for (let y = 1; x + y < n && y <= h; y++) {
//             let z = n - x - y;
//             let sxy = x + ' ' + y;
//             let xy;
//             if (memo.has(sxy)) {
//                 xy = memo.get(sxy)
//             } else {
//                 xy = lcm(x, y);
//                 memo.set(sxy, xy);
//             }
//             let syz = y + ' ' + z;
//             let yz;
//             if (memo.has(syz)) {
//                 yz = memo.get(syz)
//             } else {
//                 yz = lcm(y, z);
//                 memo.set(syz, yz);
//             }
//             let sf = xy + ' ' + yz;
//             let f;
//             if (memo.has(sf)) {
//                 f = memo.get(sf)
//             } else {
//                 f = lcm(xy, yz);
//                 memo.set(sf, f);
//             }
//             if (f <= h) return pr(`${x} ${y} ${z}`);
//         }
//     }
// };

const lcm = (a, b) => (a / gcd(a, b)) * b;
const gcd = (a, b) => b == 0 ? a : gcd(b, a % b);

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
