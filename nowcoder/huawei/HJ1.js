/**
 * 8/11/20 afternoon
 * https://www.nowcoder.com/practice/8c949ea5f36f422594b306a2300315da?tpId=37&&tqId=21224&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 */

const solve = (s) => {
    let arr = s.split(" ");
    return arr[arr.length - 1].length;
}

const main = () => {
    var readline = require('readline');
    var rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout,
        terminal: false
    });

    rl.on('line', function (line) {
        console.log(solve(line));
    })
}

main()