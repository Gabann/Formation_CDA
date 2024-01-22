// let http = require('http');
//
// let urlArray = process.argv.slice(2);
// let results = [];
// let count = 0;
//
// function printResults() {
// 	for (const string of results) {
// 		console.mongodb.log(string);
// 	}
// }
//
// for (let i = 0; i < urlArray.length; i++) {
// 	let url = urlArray[i];
// 	http.get(url, (response) => {
// 		response.setEncoding("utf8");
//
// 		let dataString = "";
//
// 		response.on('data', (data) => {
// 			dataString += data;
// 		});
//
// 		response.on('end', () => {
// 			results[i] = dataString;
// 			count++;
//
// 			if (count === urlArray.length) {
// 				printResults();
// 			}
// 		});
// 	});
// }

//This code is more clean and understandable imo, promises catches error and we remove a weird check in the function
let http = require('http');

let urlArray = process.argv.slice(2);
let promises = [];

function httpGet(url) {
	return new Promise((resolve, reject) => {
		http.get(url, (response) => {
			response.setEncoding("utf8");

			let dataString = "";

			response.on('data', (data) => {
				dataString += data;
			});

			response.on('end', () => {
				resolve(dataString);
			});
		});
	});
}

for (let i = 0; i < urlArray.length; i++) {
	promises.push(httpGet(urlArray[i]));
}

Promise.all(promises)
	.then((results) => {
		for (const result of results) {
			console.log(result);
		}
	})
	.catch((error) => {
		console.error('Error:', error);
	});