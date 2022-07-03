/**
 * 11.24 morning
 * https://codeforces.com/contest/1454/problem/B
 */

// Accepted --- https://codeforces.com/contest/1454/submission/99479968
const solve = (n, game) => {
    let map = getRecord2(game);
    let u = game.filter(x => map.get(x) == 1);
    let min = Math.min.apply(Math, u);
    for (let i = 0; i < n; i++) {
        if (game[i] == min && map.get(game[i]) == 1) {
            console.log(i + 1);
            return;
        }
    }
    console.log(-1);
};

const getRecord2 = (arr) => {
    let map = new Map();
    for (const i of arr) {
        map.set(i, (map.get(i) + 1) || 1);
    }
    return map;
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
            solve(data[0][0], data[1]);
            t--;
            i += 2;
        }
    });
};

main()