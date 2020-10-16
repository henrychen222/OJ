/**
 * 10.16 afternoon
 * https://codeforces.com/problemset/problem/2/A
 */

// Accepted 
// 186ms https://codeforces.com/problemset/submission/2/95694379
// 184ms https://codeforces.com/problemset/submission/2/95694221
const solve = (t, players) => {
    let map = new Map();
    for (let i = 0; i < t; i++) {
        let p = players[i];
        if (map.has(p[0])) {
            map.set(p[0], p[1] + map.get(p[0]));
        } else {
            map.set(p[0], p[1]);
        }
    }
    // console.log(map);
    let sMap = sortMap(map, players);
    // console.log(sMap);
    return sMap.keys().next().value;
};

const sortMap = (map, players) => { // sort map based on value, if value same, sort based on index who scored at least m points first
    return new Map([...map].sort((a, b) => {
        if (a[1] == b[1]) {
            let score = a[1];
            let aIdx;
            let bIdx;
            let aSum = 0;
            let bSum = 0;
            for (let i = 0; i < players.length; i++) {
                let p = players[i];
                if (i == players.length - 1) aIdx = i;
                if (aSum >= score) {
                    aIdx = i - 1;
                    break;
                }
                if (p[0] == a[0]) {
                    aSum += p[1];
                }
            }
            for (let i = 0; i < players.length; i++) {
                let p = players[i];
                if (i == players.length - 1) bIdx = i;
                if (bSum >= score) {
                    bIdx = i - 1;
                    break;
                }
                if (p[0] == b[0]) {
                    bSum += p[1];
                }
            }
            // console.log(a[0], aIdx, b[0], bIdx);
            return aIdx - bIdx;
        }
        return b[1] - a[1];
    }));
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout,
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(line.split(" "));
    });

    rl.on('close', () => {
        let t = Number(input[0][0]);
        let players = input.slice(1).map(x => [x[0], Number(x[1])]);
        console.log(solve(t, players));
    });

};

main()
