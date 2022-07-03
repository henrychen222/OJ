const pr = console.log;

// 07/28/21 afternoon
// test for node.js vs Java
// TLE https://www.codechef.com/viewsolution/49219707
// https://www.codechef.com/viewsolution/49141137  Java 0.05sec
let left, right;
const solve = (a, b, c) => {
    left = 0;
    right = 0;
    parse(a);
    parse(b);
    parse(c);
    if (left >= 1 && right >= 1) {
        pr(1);
        return;
    }
    pr(0);
}

const parse = (x) => {
    if (x == 1) {
        left++;
    } else {
        right++;
    }
}

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
            solve(input[i][0], input[i][1], input[i][2]);
            i++;
        }
    });
};

main()