/**
 * 11.28 evening
 * https://codeforces.com/contest/1457/problem/B
 */

// Pretests passed https://codeforces.com/contest/1457/submission/99880120
const solve = (n, k, street) => {
    // let map = sortMapByKey(getRecord2(street));
    let map = getRecord2(street);
    // let maxFreq = map.values().next().value;
    // console.log(map, maxFreq);
    let res = Number.MAX_VALUE;
    for (const ke of map.keys()) {
        // let occ = map.get(ke);
        // if (occ != maxFreq) break;
        let cnt = 0;
        for (let i = 0; i < n;) {
            if (street[i] != ke) {
                cnt++;
                i += k;
            } else {
                i++;
            }
        }
        // console.log(cnt);
        res = Math.min(res, cnt);
    }
    console.log(res);
};

const getRecord2 = (arr) => {
    let map = new Map();
    for (const i of arr) {
        map.set(i, (map.get(i) + 1) || 1);
    }
    return map;
};

const sortMapByKey = (map) => {
    return new Map([...map].sort((a, b) => b[0] - a[0]));
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
            solve(input[2 * i - 1][0], input[2 * i - 1][1], input[2 * i]);
            t--;
            i++;
        }
    });
};

main()