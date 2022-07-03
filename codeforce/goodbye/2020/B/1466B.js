/**
 * 12.30 morning
 * https://codeforces.com/contest/1466/problem/B
 */

// wrong
const solve = (n, a) => {
    let res = [...a];
    let i = 0;
    while (i + 1 < n) {
        // console.log('i', i, a);
        let nextIdx = n - 1;
        if (a[i + 1] == a[i]) {
            res[i]++;
            for (let j = i + 1; j < n; j++) {
                if (a[j] != a[i]) {
                    nextIdx = j;
                    break;
                }
            }
            i = nextIdx - 1;
        }
        i++;
    }
    let res1 = [...new Set(res)].length;
    if (res[n - 1] == a[n - 1]) res[n - 1]++;
    let res2 = [...new Set(res)].length;
    console.log(res, Math.max(res1, res2));
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
            let data = input.slice(i, i + 2);
            solve(data[0][0], data[1]);
            i += 2;
        }
    });
};

main()
