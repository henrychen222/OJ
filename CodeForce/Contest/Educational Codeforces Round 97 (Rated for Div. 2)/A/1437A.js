/**
 * 10.27 morning
 * https://codeforces.com/contest/1437/problem/A
 */

// Accepted --- 77ms
// reference: Um_nik
const solve = (l, r) => {
    return 2 * l > r ? 'YES' : 'NO';
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
        let t = Number(input[0][0]);
        let i = 1;
        while (t > 0) {
            let data = input.slice(i, i + 1);
            console.log(solve(data[0][0], data[0][1]));
            t--;
            i++;
        }
    });
};

main()