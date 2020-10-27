/**
 * 10.24 morning
 * https://codeforces.com/contest/1436/problem/A
 */

// TLE https://codeforces.com/contest/1436/submission/96575432
let permArr = [];
let usedChars = [];
const solve = (n, m, a) => {
    permArr = [];
    usedChars = [];
    let data = permute(a);
    // console.log(data);
    for (const d of data) {
        let res = check(n, m, d);
        if (res) {
            console.log('YES');
            return;
        }
    }
    console.log('NO');
    return;
};

const check = (n, m, a) => {
    let sum = 0;
    for (let i = 0; i < n; i++) {
        let inner = 0;
        for (let j = i; j < n; j++) {
            inner += a[j] / (j + 1);
        }
        sum += inner;
    }
    return sum == m ? true : false;
};

const permute = (input) => {
    let ch;
    for (let i = 0; i < input.length; i++) {
        ch = input.splice(i, 1)[0];
        usedChars.push(ch);
        if (input.length == 0) {
            permArr.push(usedChars.slice());
        }
        permute(input);
        input.splice(i, 0, ch);
        usedChars.pop();
    }
    return permArr;
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
            let data = input.slice(i, i + 2);
            let n = data[0][0];
            let m = data[0][1];
            let a = data[1]
            solve(n, m, a);
            t--;
            i += 2;
        }
    });
};

main()