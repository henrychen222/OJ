/**
 * 2.25 morning
 * https://www.codechef.com/LTC22021/problems/LTC05
 */

///////////////////////////////// pre-define /////////////////////////////////////
const pr = console.log;
///////////////////////////////////////////////////////////////////////////////////

// Accepted --- 0.13sec
const solve = (s1, s2, s3) => {
    let a1 = s1.split("");
    let a2 = s2.split("");
    let a3 = s3.split("");
    if (ok(a1, a2) && ok(a1, a3)) return pr('Possible');
    pr('Not Possible');
};

const ok = (a1, a2) => {
    a1.sort((a, b) => a.localeCompare(b));
    a2.sort((a, b) => a.localeCompare(b));
    return JSON.stringify(a1) == JSON.stringify(a2);
}

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(line.split(" "));
    });
    rl.on('close', () => {
        let t = Number(input[0][0]);
        let i = 1;
        while (t--) {
            solve(input[i][0], input[i][1], input[i][2]);
            i++;
        }
    });
};

main()