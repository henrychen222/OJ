/**
 * 10.20 morning
 * https://codeforces.com/contest/1433/problem/B
 */

const solve = (shelf) => {
    let start = shelf.indexOf(1);
    let end = shelf.lastIndexOf(1);
    if (start == end) return 0;
    let cnt = 0;
    for (let i = start; i <= end; i++) {
        if (shelf[i] == 0) {
            cnt++;
        }
    }
    return cnt;
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
        let i = 2;
        while (t > 0) {
            let data = input.slice(i, i + 1);
            console.log(solve(data[0]));
            t--;
            i += 2;
        }
    });
};

main()

// console.log(solve(5, [1, 1, 0, 0, 1]));
// console.log(solve(6, [1, 0, 0, 0, 0, 1]));