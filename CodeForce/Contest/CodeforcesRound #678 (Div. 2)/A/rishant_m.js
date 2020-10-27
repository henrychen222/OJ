/**
 * 10.27 afternoon
 */


// Accepted --- 78ms https://codeforces.com/contest/1436/submission/96943579
const solve1 = (n, m, a) => {
    // console.log(n, m, a)
    let sum = 0;
    for (let i = 0; i < n; i++) {
        for (const item of a) {
            sum += item;
        }
        // console.log(sum, m);
        return sum == m ? 'YES' : 'NO';
    }
};

// Accepted --- 78ms https://codeforces.com/contest/1436/submission/96943579
const solve = (n, m, a) => {
    let sum = 0;
    for (const item of a) {
        sum += item;
    }
    return sum == m ? 'YES' : 'NO';
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
        let i = 1;
        while (t > 0) {
            let data = input.slice(i, i + 2);
            let n = data[0][0];
            let m = data[0][1];
            let a = data[1]
            console.log(solve(n, m, a));
            t--;
            i += 2;
        }
    });
};

main()