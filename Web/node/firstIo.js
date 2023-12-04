const fs = require('fs');

let str = fs.readFileSync(process.argv[2]).toString();
let array = str.split('\n');

console.log(array.length - 1);