let http = require('http');
let map = require('through2-map');


let server = http.createServer((request, response) => {
	if (request.method !== 'POST') return response;

	request.pipe(map((chunk) => {
		return chunk.toString().toUpperCase();
	})).pipe(response);

});

server.listen(process.argv[2]);

//TODO revenir sur le pipe, je ne comprends pas comment le serveur renvoit sa réponse