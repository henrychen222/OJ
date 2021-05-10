/**
 * 05/06/21 evening
 * https://www.hackerrank.com/challenges/compare-the-triplets/problem
 */

// Accepted --- https://www.hackerrank.com/challenges/compare-the-triplets/submissions/code/212134060
const compareTriplets = (a, b) => {
    // let Alice = Bob = 0; (not allowed)
    let Alice = 0;
    let Bob = 0;
    let n = a.length;
    for (let i = 0; i < n; i++) {
        if (a[i] > b[i]) {
            Alice++;
        } else if (a[i] < b[i]) {
            Bob++;
        }
    }
    return [Alice, Bob];
};

const pr = console.log;
const main = () => {
    let a = [5, 6, 7], b = [3, 6, 10];
    let a2 = [17, 28, 30], b2 = [99, 16, 8];
    pr(compareTriplets(a, b));
    pr(compareTriplets(a2, b2));
};

main()