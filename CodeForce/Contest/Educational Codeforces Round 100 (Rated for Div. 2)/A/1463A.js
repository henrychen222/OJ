/**
 * 12.17 morning
 * https://codeforces.com/contest/1463/problem/A
 */

// WA
const solve1 = (arr) => {
    let n = arr.length;
    let sum = arr.reduce((a, b) => a + b);
    if ((sum - n >= 6) && (sum - n) % 6 == 0) return console.log('YES');
    console.log('NO');
};

// WA very close
const solve2 = (arr) => {
    let n = arr.length;
    let sum = arr.reduce((a, b) => a + b);
    let min = Math.min.apply(Math, arr);
    let round = Math.floor(sum / 7);
    // console.log(min, round, sum - n);
    if (min < round) {
        return console.log('NO');
    } else {
        if ((sum - n) != (round - 1) * (6 + n) + 6) {
            // console.log(sum - n, (round - 1) * (6 + n) + 6);
            return console.log('NO');
        }
    }
    console.log('YES');
};


// Accepted --- https://codeforces.com/contest/1463/submission/101584011 202ms
const solve = (arr) => {
    let n = arr.length;
    let sum = arr.reduce((a, b) => a + b);
    let min = Math.min.apply(Math, arr);
    let round = Math.floor(sum / (6 + n));
    if (min < round) {
        return console.log('NO');
    } else {
        if ((sum % (6 + n)) != 0) {
            return console.log('NO');
        }
    }
    console.log('YES');
};

// Accepted --- https://codeforces.com/contest/1463/submission/101583894 187ms
// reference: https://codeforces.com/contest/1463/submission/101517388
const solve_modify = (arr) => {
    let n = arr.length;
    let sum = arr.reduce((a, b) => a + b);
    let min = Math.min.apply(Math, arr);
    let round = Math.floor(sum / (6 + n));
    if (min < round) {
        return console.log('NO');
    } else {
        if ((sum % (6 + n)) == 0) {
            return console.log('YES');
        }
    }
    console.log('NO');
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