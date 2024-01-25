import fs from "fs";

try {
	await fs.promises.mkdir('nouveau_repertoire');
} catch (error) {
	console.error(error);
}

fs.writeFileSync('nouveau_fichier.txt', 'Hello world');

// fs.readFile('nouveau_fichier.txt', 'utf8', (err, data) => {
// 	if (err) throw err;
// 	console.log(data);
// });
console.log(fs.readFileSync('nouveau_fichier.txt', "utf-8"));


fs.readdir('./', "utf-8", (err, data) => {
	if (err) throw err;

	console.log(data);
});
// console.log(fs.readdirSync('./', "utf-8"));

// fs.unlink('nouveau_fichier.txt', err => {
// 	if (err) throw err;
// });
fs.unlinkSync('nouveau_fichier.txt');

// fs.rmdir('nouveau_repertoire', (err) => {
// 	if (err) throw err;
// });
fs.rmdirSync('nouveau_repertoire');