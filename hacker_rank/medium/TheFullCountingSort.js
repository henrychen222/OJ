/**
 * 02/08/22 evening
 * https://www.hackerrank.com/challenges/countingsort4/problem
 */

const pr = console.log;

// Accepted --- https://www.hackerrank.com/challenges/countingsort4/submissions/code/255540215
const countSort = (a) => {
    let n = a.length, res = '';
    let b = a.map(([x, c], i) => i + 1 <= n / 2 ? [x, '-'] : [x, c]);
    b.sort((x, y) => x[0] - y[0]);
    // pr(b);
    // pr(a);
    for (const e of b) res += e[1] + ' ';
    pr(res);
};

const main = () => {
    let a = [[0, 'a'], [1, 'b'], [0, 'c'], [1, 'd']];
    countSort(a);
};

main()