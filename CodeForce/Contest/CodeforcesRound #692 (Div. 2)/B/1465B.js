
/**
 * 12.20 morning
 * https://codeforces.com/contest/1465/problem/B
 */

// Pretests passed  TLE Test 11
const solve = (s) => {
    let num = BigInt(s);
    for (let i = num;;i++) {
        let element = [...new Set(i.toString().split(""))].filter(x => x != '0');
        if (ok(element, i)) {
            return console.log(i + '');
        }
    }
};

const ok = (element, num) => {
    for (const e of element) {
        let tmp = BigInt(e);
        if (num % tmp != 0n) {
            return false;
        }
    }
    return true;
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(line);
    });
    rl.on('close', () => {
        let t = Number(input[0]);
        let i = 1;
        while (t--) {
            solve(input[i]);
            i++;
        }
    });
};

main()