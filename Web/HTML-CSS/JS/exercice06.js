let age = prompt("Age");
let salaire = prompt("Salaire demandé");
let nbAnneesExeperiences = prompt("Nombre années experiences");

if (age < 30) {
	console.log("Trop jeune");
} else if (salaire > 40000) {
	console.log("Salaire demandé trop haut");
} else if (nbAnneesExeperiences < 5) {
	console.log("Pas assez d'experience");
} else {
	console.log("Vous correspondez au criteres")
}
