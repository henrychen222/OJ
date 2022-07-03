/**
 * 10/18/20 morning
 * https://atcoder.jp/contests/agc048/tasks/agc048_a
 */

// WA
let permArr = [];
let usedChars = [];
const solve = (s) => {
    let ref = 'atcoder';  // should be small
    let refArr = ref.split("");
    let n = s.length;
    let sArr = s.split("");
    if (n >= 7) {
        let cnt = 0;
        for (let i = 0; i < 7; i++) {
            let sascii = sArr[i].charCodeAt();
            let refascii = refArr[i].charCodeAt();
            if (refascii > sascii) {
                let cntFirst = cnt;
                for (let j = n - 1; j >= 0; j--) {
                    if (i == j) continue;
                    if (sArr[j].charCodeAt() > refascii) {
                        swap(sArr, i, j);
                        cnt++;
                        return cnt;
                    }
                }
                if (cnt == cntFirst) { // cannot find a char make it SArr larger, look for equal char
                    let equalFromLastIdx = [];
                    for (let j = n - 1; j >= 0; j--) {
                        if (i == j) continue;
                        if (sArr[j].charCodeAt() == refascii) {
                            swap(sArr, i, j);
                            cnt++;
                            equalFromLastIdx.push(j);
                            break;
                        }
                    }
                    if (equalFromLastIdx.length == 0) return -1;  // no equal found
                }
            } else if (refascii < sascii) {
                return 0;
            } else {
                if (i == 6) return -1;
                continue;
            }
        }
        return cnt;
    } else {
        permArr = [];
        usedChars = [];
        let data = helper(sArr);
        let newSArr = data.map(x => x.join(""));
        // console.log(newSArr);
        newSArr = newSArr.concat(s);
        // console.log(newSArr);
        newSArr.sort((a, b) => a.localeCompare(b));
        if (newSArr[0] == s) return -1;
    }
};

const swap = (arr, i, j) => {
    [arr[i], arr[j]] = [arr[j], arr[i]];
};

const helper = (input) => {
    let ch;
    for (let i = 0; i < input.length; i++) {
        ch = input.splice(i, 1)[0];
        usedChars.push(ch);
        if (input.length == 0) {
            permArr.push(usedChars.slice());
        }
        helper(input);
        input.splice(i, 0, ch);
        usedChars.pop();
    }
    return permArr;
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
            console.log(solve(data[0]));
            t--;
            i++;
        }
    });
};

main()

// console.log(solve("ascoderu")) // 1
// console.log(solve("asbodertd")) // 2