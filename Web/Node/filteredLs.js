const fs = require("fs");

let directory = process.argv[2];
let filter = process.argv[3];

fs.readdir(directory, function (err, list) {
	if (err) {
		return console.log(err);
	}

	for (let file of list) {
		if (file.endsWith(`.${filter}`)) {
			console.log(file);
		}
	}
});