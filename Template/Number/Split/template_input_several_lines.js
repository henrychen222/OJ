// 10.17 morning
const solve = () => {
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
            let data = input.slice(i, i + 1);
            solve(data[0]);
            // console.log('Case #' + cnt + ': ' + solve(data[0])); for kickstart
            i++;
        }
    });
};

main()