/**
 * 10.18 moring
 * https://codingcompetitions.withgoogle.com/kickstart/round/00000000001a0069/0000000000414bfb
 */

// WA
const solve = (s) => {
    let n = s.length;
    let cnt = 0;
    let set = new Set();
    for (let i = 0; i < n; i++) {
        if (s[i] != 'K' || ((i + 1 < n) && (s[i + 1] != 'I')) || ((i + 2 < n) && (s[i + 2] != 'C')) || ((i + 3 < n) && (s[i + 3] != 'K'))) continue;
        for (let j = i; j < n; j++) {
            // let len = j - i + 1;
            // if (len >= 5) {
                let sub = s.slice(i, j + 1);
                let len = sub.length;
                if (sub[len - 1] == 'T' && sub[len - 2] == 'R' && sub[len - 3] == 'A' && sub[len - 4] == 'T' && sub[len - 5] == 'S') {
                    // console.log(sub, sub.length, j - i + 1);
                    let idxRecord = '' + i + j;
                    set.add(idxRecord);
                }
            // } else { continue; }
        }
    }
    // console.log(set)
    return set.size;
};

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    let input = [];
    rl.on('line', (line) => {
        input.push(line);
    });
    rl.on('close', () => {
        let t = Number(input[0][0]);
        let i = 1;
        while (t > 0) {
            let data = input.slice(i, i + 1);
            console.log('Case #' + i + ': ' + solve(data[0]));
            t--;
            i++;
        }
    });
};

main()

console.log(solve('AKICKSTARTPROBLEMNAMEDKICKSTART'));
console.log(solve(''));
console.log(solve('K'));
console.log(solve('KI'));
console.log(solve('KIC'));
console.log(solve('KICK'));
console.log(solve('KICKKICKSTARTSTART'));