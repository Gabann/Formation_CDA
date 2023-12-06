let http = require('http');
let url = process.argv[2];


http.get(url, (response) => {
	response.setEncoding("utf8");

	let dataString = "";

	response.on('data', (data) => {
		dataString += data;
	});

	response.on('end', () => {
		console.log(dataString.length);
		console.log(dataString);
	});
});