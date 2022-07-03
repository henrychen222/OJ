/**
 * 03/29/21 morning
 * https://codeforces.com/contest/1498/problem/A
 */


///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// Pretests passed
const solve = (n) => {
    while (1) {
        let s = n.toString();
        let sum = 0n;
        for (const c of s) sum += BigInt(c);
        let res = gcd(n, sum);
        if (res > 1) return pr(s);
        n++;
    }
};

const gcd = (a, b) => b == 0 ? a : gcd(b, a % b);

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(BigInt(line));
    });
    rl.on('close', () => {
        let t = input[0];
        let i = 1;
        while (t--) {
            solve(input[i]);
            i++;
        }
    });
};

main()