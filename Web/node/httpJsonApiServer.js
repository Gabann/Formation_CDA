const http = require('http');
const url = require("url");

let server = http.createServer((request, response) => {
	if (request.method !== 'GET') return response;

	let parsedUrl = new URL(request.url, `http://${request.headers.host}`);
	let date = new Date((parsedUrl.searchParams.get('iso')));
	let path = parsedUrl.pathname;

	let jsonResponse;

	if (path === '/api/unixtime') {
		jsonResponse = {
			"unixtime": date.getTime()
		};
	} else if (path === '/api/parsetime') {
		jsonResponse = {
			"hour": date.getHours(),
			"minute": date.getMinutes(),
			"second": date.getSeconds()
		};
	}


	if (jsonResponse) {
		response.writeHead(200, {'Content-Type': 'application/json'});
		response.end(JSON.stringify(jsonResponse));
	} else {
		res.writeHead(404);
		res.end();
	}
});

server.listen(process.argv[2]);