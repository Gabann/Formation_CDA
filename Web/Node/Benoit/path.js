import path from "path";

let filename = 'rapport.txt';

//Utilisez la méthode path.join pour créer le chemin complet vers un fichier nommé "rapport.txt" dans un répertoire "documents" qui se trouve dans le répertoire utilisateur.
console.log('Join:', path.join('user', 'documents', filename));

//Utilisez la méthode path.resolve pour obtenir le chemin absolu du fichier "rapport.txt" créé précédemment.
let absolutePath = path.resolve('documents/' + filename);
console.log('Absolute Path:', absolutePath);

//Utilisez la méthode path.extname pour vérifier si le fichier a une extension ".txt".
console.log('Extension:', path.extname(absolutePath));

//Utilisez la méthode path.dirname pour obtenir le répertoire du fichier "rapport.txt".
console.log('Directory:', path.dirname(absolutePath));

//Utilisez la méthode path.basename pour extraire le nom du fichier (sans l'extension) à partir du chemin absolu.
console.log('Basename:', path.basename(filename, path.extname(absolutePath)));

//Utilisez la méthode path.parse pour obtenir un objet avec les détails du chemin du fichier "rapport.txt" (répertoire, base, nom, extension, etc.).
console.log('Parse:', path.parse(absolutePath));

//Utilisez la méthode path.normalize pour créer un chemin normalisé à partir de segments relatifs.
console.log('Normalize:', path.normalize(' C:/Code/Formation_CDA/Web/Node/Benoit/a/../documents//rapport.txt'));