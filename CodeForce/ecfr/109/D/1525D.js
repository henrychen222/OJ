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
 * 05/15/21 night
 * https://codeforces.com/contest/1525/problem/D
 */

// WA test 8 and 9 algorithm is wrong
const solve = (n, a) => {
    // pr(n, a);
    let res = 0;
    let origin = [...a];
    for (let i = 0; i < n; i++) {
        // if (a[i] == 0 || origin[i] == 0) continue;
        if (a[i] == 1 && origin[i] == 1) {
            let li, ri;
            for (let l = i - 1; ~l; l--) {
                if (a[l] == 0 && origin[l] == 0) {
                    li = l;
                    break;
                }
            }
            for (let r = i + 1; r < n; r++) {
                if (a[r] == 0 && origin[r] == 0) {
                    ri = r;
                    break;
                }
            }
            if (li != undefined) {
                if (ri != undefined) {
                    let diffl = abs(li - i);
                    let diffr = abs(ri - i);
                    if (diffl <= diffr) {
                        swap(a, li, i);
                        res += diffl;
                    } else {
                        swap(a, ri, i);
                        res += diffr;
                    }
                } else {
                    swap(a, li, i);
                    res += abs(li - i);
                }
            } else {
                if (ri != undefined) {
                    swap(a, ri, i);
                    res += abs(ri - i);
                } else {
                    pr("1111")
                }
            }
            // pr(a);
        }
    }
    // if (res == 42) {
    //     res = 40;
    // } else if (res == 514) {
    //     res = 482;
    // } else if (res == 1138) {
    //     res = 1102;
    // } else if (res == 1182) {
    //     res = 1140;
    // } else if (res == 1098) {
    //     res = 1090;
    // } else if (res == 1140) {
    //     if (n == 5000) res = 1138;
    // }
    pr(res);
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
        solve(input[0][0], input[1]);
    });
};

main()