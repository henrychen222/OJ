const pr = console.log;

// 07/28/21 afternoon
// test for node.js vs Java
// TLE https://www.codechef.com/submit/CHFGCD
// https://www.codechef.com/viewsolution/49174810  Java 0.26sec
const solve = (x, y) => {
    if (gcd(x, y) > 1) return pr(0);
    if (x % 2 == 0) {
        if (y % 2 == 0) {
            pr(0);
        } else {
            pr(1);
        }
    } else {
        if (y % 2 == 0) {
            pr(1);
        } else {
            if ((gcd(x + 1, y) > 1) || (gcd(x, y + 1) > 1)) return pr(1);
            pr(2);
        }
    }
}

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