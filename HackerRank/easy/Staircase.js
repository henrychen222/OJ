/**
 * 05/06/21 evening
 * https://www.hackerrank.com/challenges/staircase/problem
 */

// Accepted --- https://www.hackerrank.com/challenges/staircase/submissions/code/212136238
const pr = console.log;
const staircase = (n) => {
    for (let i = 1; i <= n; i++) {
        let s = ' '.repeat(n - i) + '#'.repeat(i);
        pr(s);
    }
};

const main = () => {
    let n = 6;
    staircase(n);
};

main()