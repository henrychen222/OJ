// 1.2 night

// Accepted https://atcoder.jp/contests/abc187/submissions/19180297
const solve = (n, arr) => {
    let A = new Set();
    let B = new Set();
    for (const s of arr) {
        if (s[0] == '!') {
            A.add(s.slice(1));
        } else {
            B.add(s);
        }
    }
    for (const x of B) {
        if (A.has(x)) return console.log(x);
    }
    console.log('satisfiable');
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
        solve(Number(input[0]), input.slice(1));
    });
};

main()