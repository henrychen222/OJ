/**
 * 05/06/21 evening
 * https://www.hackerrank.com/challenges/a-very-big-sum/problem
 */

// Accepted --- https://www.hackerrank.com/challenges/a-very-big-sum/submissions/code/212134486
const sm = (a) => a.reduce(((x, y) => x + y), 0);
const aVeryBigSum = (a) => sm(a);

const pr = console.log;
const main = () => {
    let ar = [1000000001, 1000000002, 1000000003, 1000000004, 1000000005];
    pr(aVeryBigSum(ar));
};

main()