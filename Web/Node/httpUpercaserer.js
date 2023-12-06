let http = require('http');
let map = require('through2-map');


let server = http.createServer((request, response) => {
	if (request.method !== 'POST') return response;

	request.pipe(map((chunk) => {
		return chunk.toString().toUpperCase();
	})).pipe(response);

});

server.listen(process.argv[2]);

//TODO come back to the pipe, i don't really get how the server return his response