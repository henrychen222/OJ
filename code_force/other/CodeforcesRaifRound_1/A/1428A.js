/**
 * 10.17 morning
 * https://codeforces.com/contest/1428/problem/A
 */

// Pretests passed
const solve = (data) => {
    let x1 = data[0][0];
    let y1 = data[0][1];
    let x2 = data[0][2];
    let y2 = data[0][3];
    if (y1 == y2) {
        if (x1 == x2) {
            return 0;
        } else {
            return Math.abs(x2 - x1);
        }
    } else {
        if (x1 == x2) {
            return Math.abs(y2 - y1);
        } else {
            let h = Math.abs(x2 - x1);
            let v = Math.abs(y2 - y1);
            return h + 2 + v;
        }
    }
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
            console.log(solve(data));
            t--;
            i++;
        }
    });

};

main()