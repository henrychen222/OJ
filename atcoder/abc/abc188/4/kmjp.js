// 1.17 evening

// WA  https://atcoder.jp/contests/abc188/submissions/19502151
// const solve = (N, C, arr) => {
//     // console.log(N, C, arr);
//     let m = new Map();
//     for (const e of arr) {
//         let a = e[0];
//         let b = e[1];
//         let c = e[2];
//         m.set(a - 1, (m.get(a - 1) || 0) + c);
//         m.set(b, (m.get(b) || 0) - c);
//     }
//     m = sortMapByKey(m);
//     // console.log(m);
//     let pre = cur = sum = 0;
//     for (const [k, v] of m) {
//         sum += (k - pre) * Math.min(cur, C);
//         pre = k;
//         cur += v;
//     }
//     console.log(sum);
// };

// const sortMapByKey = (map) => {
//     return new Map([...map].sort((a, b) => a[0] - b[0]));
// };


// WA https://atcoder.jp/contests/abc188/submissions/19502293
const bigIntMin = (...args) => args.reduce((m, e) => e < m ? e : m);
const solve = (N, C, arr) => {
    let m = new Map();
    for (const e of arr) {
        let a = e[0];
        let b = e[1];
        let c = e[2];
        m.set(a - 1n, (m.get(a - 1n) || 0n) + c);
        m.set(b, (m.get(b) || 0n) - c);
    }
    m = sortMapByKeyBigInt(m);
    let pre = cur = sum = 0n;
    for (const [k, v] of m) {
        sum += (k - pre) * bigIntMin(cur, C);
        pre = k;
        cur += v;
    }
    console.log(Number(sum));
};

const sortMapByKeyBigInt = (map) => {
    return new Map([...map].sort((a, b) => Number(a[0] - b[0])));
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
        solve(input[0][0], input[0][1], input.slice(1));
    });
};

main()