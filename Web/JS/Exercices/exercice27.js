function addNameToList() {
	let nameInput = document.querySelector("#name-input");

	let name = formatName(nameInput.value);

	if (validateNameInput(name)) {
		let newNameLI = document.createElement("li");
		newNameLI.textContent = name;

		document.querySelector("#name-list").appendChild(newNameLI);

		nameInput.value = "";
	}
}

function formatName(str) {
	str = str.trim();
	return str.charAt(0).toUpperCase() + str.slice(1).toLowerCase();
}

//There should be no number in a name and should be at least 2 characters longs
function validateNameInput(str) {
	if (str.length < 2 || (/\d/.test(str))) return false;
	else return true;
}

document.querySelector("#list-add-button")?.addEventListener("click", function () {
	addNameToList();
});

document.querySelector("#name-input")?.addEventListener("keydown", function (event) {
	if (event.key === "Enter") {
		addNameToList();
	}
});