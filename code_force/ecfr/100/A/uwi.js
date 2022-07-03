// 12.17 noon
// Accepted --- https://codeforces.com/contest/1463/submission/101582552
const solve = (arr) => {
    let sum = arr.reduce((a, b) => a + b);
    if (sum % 9 != 0) {
        return console.log('NO');
    }
    let round = Math.floor(sum / 9);
    for (let i = 0; i < 3; i++) {
        if (arr[i] < round) {
            return console.log('NO');
        }
    }
    console.log('YES');
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
            solve(input[i]);
            i++;
        }
    });
};

main()