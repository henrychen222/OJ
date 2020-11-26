// 11/24/20 morning
const solve = (num) => {
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(Number(line));
    });
    rl.on('close', () => {
        let t = Number(input[0]);
        let i = 1;
        while (t > 0) {
            let data = input[i];
            solve(data);
            t--;
            i++;
        }
    });
};

main()