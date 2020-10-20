/**
 * 10.20 noon
 */

// https://codeforces.com/profile/A.Kaan42
// need to fix
const solve = (p) => {
    console.log(p);
    let n = p.length;
    let max = Math.max.apply(Math, p);
    // console.log(max)
    let res = -1;
    for (let i = 1; i <= n; i++) {
        if (p[i] == max && p[i] > p[i - 1]) {
            res = i;
            break;
        }
        if (p[i] == max && p[i] > p[i + 1]) {
            res = i;
            break;
        }
    }
    return res;
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
