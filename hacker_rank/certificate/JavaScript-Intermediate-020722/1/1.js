/**
 * 02/07/22 morning
 * https://www.hackerrank.com/test/a4rbrfgp0f0/questions/cn4hsqdqm6t
 */

'use strict';

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


const pr = console.log;

// All available test cases passed
function ParkingLot(n) { // n: slots
    let a = Array(n).fill(-1), car = new Set();
    return { park, getSlots, remove }
    function park(carId) {
        let find = false;
        for (let i = 0; i < n; i++) {
            if (a[i] == -1) {
                a[i] = carId;
                find = true;
                break;
            }
        }
        pr("park", a)
        return find;
    }
    function getSlots() {
        let res = [];
        for (let i = 0; i < n; i++) {
            if (a[i] != -1) {
                res.push(a[i]);
            } else {
                res.push(null);
            }
        }
        pr("getSlots", a)
        return res;
    }
    function remove(carId) {
        let find = false;
        for (let i = 0; i < n; i++) {
            if (a[i] == carId) {
                a[i] = -1;
                find = true;
                break;
            }
        }
        pr("remove", a)
        return find;
    }
}


function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const numberOfSlots = parseInt(readLine().trim());
    const parkingLotObj = new ParkingLot(numberOfSlots);
    ws.write(`Parking Lot created with number of slots as ${numberOfSlots}\n`);

    let numberOfOperations = parseInt(readLine().trim());
    while (numberOfOperations-- > 0) {
        const inputs = readLine().trim().split(' ');
        const operation = inputs[0];
        const carId = inputs[1];

        switch (operation) {
            case 'Park':
                if (parkingLotObj.park(carId)) {
                    ws.write(`Parking Started: ${carId}\n`);
                } else {
                    ws.write(`Parking Full: ${carId}\n`);
                }
                break;
            case 'Remove':
                if (parkingLotObj.remove(carId)) {
                    ws.write(`Car id ${carId} removed from parking\n`);
                } else {
                    ws.write(`Car: ${carId} not found\n`);
                }
                break;
            case 'GetSlots':
                const status = parkingLotObj.getSlots();
                status.forEach((obj, i) => {
                    if (obj) {
                        ws.write(`Parked at slot ${i + 1}: ${obj}\n`);
                    } else {
                        ws.write(`Slot ${i + 1} is empty\n`);
                    }
                })
                break;
            default:
                break;
        }
    }
    ws.end();
}