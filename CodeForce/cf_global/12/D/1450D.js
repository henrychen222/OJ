/**
 * 12.6 morning
 * https://codeforces.com/contest/1450/problem/A
 */

// TLE
const solve = (k, arr) => {
    let n = arr.length;
    let res = '';
    for (let i = 1; i <= k; i++) {
        let p = getPermutation(i, arr, n);
        if (isHappy(p, p.length)) {
            res += '1';
        } else {
            res += '0';
        }
    }
    console.log(res);
};

const getPermutation = (k, arr, n) => {
    let res = [];
    for (let i = 0; i + k <= n; i++) {
        let tmp = arr.slice(i, i + k);
        res.push(Math.min.apply(Math, tmp));
    }
    return res;
};

const isHappy = (p, m) => {
    let mp = getRecord2(p);
    for (const num of p) {
        if (num > m || mp.get(num) > 1) return false;
    }
    return true;
};

const getRecord2 = (arr) => {
    let map = new Map();
    for (const i of arr) {
        map.set(i, (map.get(i) + 1) || 1);
    }
    return map;
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
            solve(input[2 * i - 1][0], input[2 * i]);
            i++;
        }
    });
};

main()