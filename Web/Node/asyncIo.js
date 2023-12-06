const fs = require('fs');

fs.readFile(process.argv[2], function (err, fileContents) {
	if (err) {
		return console.log(err);
	}

	let array = fileContents.toString().split('\n');
	console.log(array.length - 1);
});
