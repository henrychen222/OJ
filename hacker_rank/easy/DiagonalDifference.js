/**
 * 05/06/21 evening
 * https://www.hackerrank.com/challenges/diagonal-difference/problem
 */

// Accepted --- https://www.hackerrank.com/challenges/diagonal-difference/submissions/code/212135101
const abs = Math.abs;
const diagonalDifference = (a) => {
    let n = a.length;
    let m = a[0].length;
    let j;
    let sum2 = 0;
    for (let i = 0, j = m - 1; i < n; i++, j--) sum2 += a[i][j];
    let sum1 = 0;
    for (let i = 0, j = 0; i < n; i++, j++) sum1 += a[i][j];
    return abs(sum1 - sum2);
};

const pr = console.log;
const main = () => {
    let a = [[11, 2, 4], [4, 5, 6], [10, 8, -12]];
    pr(diagonalDifference(a));
};

main()