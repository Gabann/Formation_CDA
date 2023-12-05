const filterFunction = require('./mymodule');

let directory = process.argv[2];
let filter = process.argv[3];

filterFunction(directory, filter, (err, list) => {
	if (err) {
		console.log(err);
	} else {
		for (let i = 0; i < list.length; i++) {
			console.log(list[i]);
		}
	}

});

