const fs = require('fs');

function filterFolder(folderPath, filterString, callback) {
	fs.readdir(folderPath, callback);
}