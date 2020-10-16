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
        data.push(line);
    });
    rl.on('close', () => {
        console.log(solve(input));
    });

};

main()
