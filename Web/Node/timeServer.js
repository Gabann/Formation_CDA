let net = require('net');
let currentDate = new Date();

let server = net.createServer((socket) => {
	let year = currentDate.getFullYear().toString().padStart(2, "0");
	let month = (currentDate.getMonth() + 1).toString().padStart(2, "0");
	let day = currentDate.getDate().toString().padStart(2, "0");
	let hour = currentDate.getHours().toString().padStart(2, "0");
	let minute = currentDate.getMinutes().toString().padStart(2, "0");

	let data = (`${year}-${month}-${day} ${hour}:${minute}\n`);

	socket.end(data);
});

server.listen(process.argv[2]);