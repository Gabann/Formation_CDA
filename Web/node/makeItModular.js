const myModule = require('./mymodule');

let directory = process.argv[2];
let filter = process.argv[3];

myModule.filterFolder();
