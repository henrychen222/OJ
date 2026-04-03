/**
 * 8/11/20 afternoon
 * https://www.nowcoder.com/practice/a35ce98431874e3a820dbe4b2d0508b1?tpId=37&&tqId=21225&rp=1&ru=/ta/huawei&qru=/ta/huawei/question-ranking
 */

const solve = (data) => {
    let s = data[0];
    let target = data[1];
    let cnt = 0;
    for (const c of s) {
        if (c.toLowerCase() == target) cnt++;
    }
    return cnt;
}

const main = () => {
    const readline = require('readline');
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    let data = [];
    rl.on('line', (line) => {
        data.push(line);
    });

    rl.on('close', () => {
        console.log(solve(data));
    });
}

// main()

const test = () => {
    let debug1 = ['ABCaD', 'a'];
    console.log(solve(debug1)); // 2
}

test();


