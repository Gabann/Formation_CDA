const fs = require('fs');

module.exports = function filterFolder(folderPath, filterString, callback) {
	fs.readdir(folderPath, function (err, list) {
		if (err) {
			return callback(err);
		}

		let data = [];
		for (let file of list) {
			if (file.endsWith(`.${filterString}`)) {
				data.push(file);
			}
		}

		callback(err, data);
	});
};