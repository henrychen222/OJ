const https = require('https');
const axios = require('axios');

// async function getCountryName(code) {
//     let res = {};
//     for (let i = 1; i <= 25; i++) {
//         https.get(`https://jsonmock.hackerrank.com/api/countries?page=${i}`, (resp) => {
//             let json = '';
//             resp.on('data', (chunk) => {
//                 json += chunk;
//             });
//             resp.on('end', () => {
//                 let data = JSON.parse(json);
//                 // console.log(data);
//                 res[data.alpha2Code] = data.name;
//                 // for (let i = 0; i < data.length; i++) {
//                 //     let country = data[i];
//                 //     console.log(country);
//                 // }
//             });
//         });
//     }
//     console.log(res);
// }

// work but return is a promise
async function getCountryName(code) {
    let res = [];
    for (let i = 1; i <= 25; i++) {
        const response = await axios.get(`https://jsonmock.hackerrank.com/api/countries?page=${i}`);
        const country = await response.data;
        // console.log(country);
        // console.log(country.data);
        for (const d of country.data) {
            // console.log(d.alpha2Code, d.name);
            if (d.alpha2Code == code) {
                console.log(d.alpha2Code, d.name);
                // return d.name;
            }
        }
    }
}

console.log(getCountryName('AF'));