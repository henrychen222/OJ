/**
 * 10.15 evening
 * https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ffc7/00000000001d3f56
 */

// Accepted
const solve = (N, K, P, A) => {
    let prefixes = [];
    for (const row of A) {
        let pr = [0];
        for (const x of row) {
            pr.push(pr[pr.length - 1] + x);
        }
        prefixes.push(pr);
    }
    // console.log(prefixes);
    let memo = {};
    const dfs = (i, take) => {
        if (take == 0 || i == N) return 0;
        if (memo.hasOwnProperty(`[${i}, ${take}]`)) {
            // console.log(memo);
            // console.log(memo[`[${i}, ${take}]`]);
            return memo[`[${i}, ${take}]`];
        }
        let res = 0;
        for (let choice = 0; choice < K + 1; choice++) {
            let take2 = take - choice;
            if (take2 < 0) break;
            cand = dfs(i + 1, take2) + prefixes[i][choice];
            if (cand > res) {
                res = cand;
            }
        }
        memo[`[${i}, ${take}]`] = res;
        return res;
    };
    return dfs(0, P);
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
        let cnt = 1;
        let i = 1;
        while (t > 0) {
            let N = input[i][0];
            let K = input[i][1];
            let P = input[i][2];
            let A = input.slice(i + 1, i + 1 + N);
            // console.log(N, K, P, A);
            console.log('Case #' + cnt + ': ' + solve(N, K, P, A));
            t--;
            cnt++;
            i += (N + 1);
        }
    });
};

main()
