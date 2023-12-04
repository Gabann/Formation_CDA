function sum(args) {
	let total = 0;
	for (let i = 2; i < args.length; i++) {
		total += Number(args[i]);
	}

	console.log(total);
}

sum(process.argv);