// 11/24/20 morning
const solve = (n, arr) => {
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
        while (t > 0) {
            let data = input.slice(i, i + 2);
            solve(data[0][0], data[1]);  // n arr
            t--;
            i += 2;
        }
    });
};

main()