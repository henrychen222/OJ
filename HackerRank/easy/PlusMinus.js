/**
 * 05/06/21 evening
 * https://www.hackerrank.com/challenges/plus-minus/problem
 */

// Accepted --- https://www.hackerrank.com/challenges/plus-minus/submissions/code/212135658
const pr = console.log;
const plusMinus = (a) => {
    let neg = 0, pos = 0, zero = 0;
    let n = a.length;
    for (const e of a) {
        if (e < 0) {
            neg++;
        } else if (e > 0) {
            pos++;
        } else {
            zero++;
        }
    }
    pr((pos / n).toFixed(6));
    pr((neg / n).toFixed(6));
    pr((zero / n).toFixed(6));
};

const main = () => {
    let a = [-4, 3, -9, 0, 4, 1];
    plusMinus(a);
};

main()