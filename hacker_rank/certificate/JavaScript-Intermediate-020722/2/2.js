/**
 * 02/07/22 morning
 * https://www.hackerrank.com/test/a4rbrfgp0f0/questions/md29p0mjet
 * 
 * read: 
 * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Classes#sub_classing_with_extends
 */

'use strict';

const { timeStamp } = require('console');
const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding("ascii");
let inputString = "";
let currentLine = 0;

process.stdin.on("data", function (chunk) {
    inputString += chunk;
});
process.stdin.on("end", function () {
    inputString = inputString.split('\n');
    main();
});

function readLine() {
    return inputString[currentLine++];
}

// All available test cases passed
class Employee {
    constructor(title) {
        this.title = title;
    }
    setTitle(newTitle) {
       this.title = newTitle;
    }
    getTitle() {
        return this.title;
    }
}

class Engineer extends Employee {
    constructor(title, isManager) {
        super(title);
        this.isManager = isManager;
    }
    setIsManager(isManagerReset) {
       this.isManager = isManagerReset;
    }
    getIsManager() {
        return this.isManager;
    }
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    var inputs = readLine().split(' ');
    var engineerObject = new Engineer(inputs[0], inputs[1].toLowerCase() === 'true');

    ws.write(`Initial Employee Profile - Title is ${engineerObject.getTitle()}. ${engineerObject.getIsManager() ? 'Is' : 'Is not'} a Manager\n`)

    engineerObject.setTitle(readLine());
    engineerObject.setIsManager(readLine().toLowerCase() === 'true');

    ws.write(`Final Employee Profile - Title is ${engineerObject.getTitle()}. ${engineerObject.getIsManager() ? 'Is' : 'Is not'} a Manager\n`)

    ws.write(`Engineer.prototype has property setTitle: ${Engineer.prototype.hasOwnProperty('setTitle')}\n`);
    ws.write(`Engineer.prototype has property getTitle: ${Engineer.prototype.hasOwnProperty('getTitle')}\n`);
    ws.write(`Engineer.prototype has property setIsManager: ${Engineer.prototype.hasOwnProperty('setIsManager')}\n`);
    ws.write(`Engineer.prototype has property getIsManager: ${Engineer.prototype.hasOwnProperty('getIsManager')}\n`);
}