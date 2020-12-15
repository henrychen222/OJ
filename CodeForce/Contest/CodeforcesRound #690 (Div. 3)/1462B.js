/**
 * 12.15 morning
 * https://codeforces.com/contest/1462/problem/B
 */

// Accepted
const solve = (n, s) => {
    if (s.indexOf('2020') == 0 || s.lastIndexOf('2020') == n - 4) {
        console.log("YES");
        return;
    } else if (s.indexOf('2') == 0 && s.lastIndexOf('020') == n - 3) {
        console.log("YES");
        return;
    } else if (s.indexOf('20') == 0 && s.lastIndexOf('20') == n - 2) {
        console.log("YES");
        return;
    } else if (s.indexOf('202') == 0 && s.lastIndexOf('0') == n - 1) {
        console.log("YES");
        return;
    }
    console.log("NO");
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
        while (t > 0) {
            let data = input.slice(i, i + 2);
            solve(Number(data[0]), data[1]);
            t--;
            i += 2;
        }
    });
};

main()