/**
 * 10.20 morning
 * https://codeforces.com/contest/1433/problem/B
 */

// thinking too complicated, related to max value
const solve = (p) => {
    console.log(p);
    let n = p.length;
    for (let i = 0; i < n; i++) {
        if (i == 0 && p[i] < p[i + 1]) continue;
        if (i == n - 1 && p[i] < p[i - 1]) continue;
        let tmp = [];
        if (p[i] <= p[i - 1]) {
            if (p[i] <= p[i + 1]) {
                continue;
            } else {
                tmp = eat([...p], i, i + 1);
                if (tmp.length == 1) return i;
                solve(tmp);
            }
        } else {
            tmp = eat([...p], i, i - 1);
            console.log(tmp);
            if (tmp.length == 1) return i;
            solve(tmp);
            break;
        }
    }
    return -1;
};

const eat = (arr, idx, eatIdx) => {
    let res = [];
    let n = arr.length;
    for (let i = 0; i < n; i++) {
        if (i == eatIdx) {
            continue;
        } else if (i == idx) {
            res.push(arr[i] + 1);
        } else {
            res.push(arr[i]);
        }
    }
    return res;
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
        let i = 2;
        while (t > 0) {
            let data = input.slice(i, i + 1);
            console.log(solve(data[0]));
            t--;
            i += 2;
        }
    });
};

main()

// console.log(solve([5, 3, 4, 4, 5]))
// console.log(solve([1, 1, 1]));
// console.log(solve([4, 4, 3, 4, 4]));
// console.log(solve([5, 5, 4, 3, 2]));
// console.log(solve([1, 1, 2]));
// console.log(solve([5, 4, 3, 5, 5]));
