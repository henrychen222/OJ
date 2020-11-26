/**
 * 11.21 morning
 * https://atcoder.jp/contests/arc108/tasks/arc108_b
 */

// Accepted --- https://atcoder.jp/contests/arc108/submissions/18275361 100ms
const solve = (n, s) => {
    let stack = [];
    for (const c of s) {
        if (stack.length != 0) {
            let l = stack[stack.length - 1];
            let sl = stack[stack.length - 2];
            if (c == 'x') {
                if (sl == 'f' && l == 'o') {
                    stack.pop();
                    stack.pop();
                } else {
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        } else {
            stack.push(c);
        }
    }
    // let res = stack.join("");
    // console.log(res);
    console.log(stack.length);
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
        solve(Number(input[0]), input[1]);
    });
};

main()