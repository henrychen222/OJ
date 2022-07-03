/**
 * 10.15 night
 * https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ffc7/00000000001d3f56
 */

// need to fix
const solve = (n, k, p, a) => {
    let dp = initialize2DArrayNew(51, 1501);
    for (let i = 0; i < n; i++) {
        for (let j = 0, s = 0; j < k; ++j) {
            s += a[i][j];
            for (let l = 0; l + j + 1 <= p; l++) {
                dp[i + 1][l + j + 1] = Math.max(dp[i][l] + s, dp[i + 1][l + j + 1]);
            }
        }
    }
    // console.log(dp);
    return dp[n][p];
};

const initialize2DArrayNew = (m, n) => {
    let data = [];
    for (let i = 0; i < m; i++) {
        let tmp = new Array(n).fill(0);
        data.push(tmp);
    }
    return data;
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
            console.log('Case #' + cnt + ': ' + solve(N, K, P, A));
            t--;
            cnt++;
            i += (N + 1);
        }
    });
};

main()
