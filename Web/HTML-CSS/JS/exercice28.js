class Person {
	constructor(firstName, lastName, birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}
}

let personArray = [];

function addPersonToTable() {
	let firstName = document.querySelector("#first-name-input").value;
	let lastName = document.querySelector("#last-name-input").value;
	let dob = document.querySelector("#dob-input").value;

	let person = new Person(firstName, lastName, dob);

	personArray.push(person);

	updateTable();
}

function updateTable() {
	let table = document.querySelector("table#person-table");

	let thead = table.querySelector("thead");
	let theadRow = thead.insertRow();

	personArray.forEach(person => {
		let row = table.insertRow();

		for (const [key, value] of Object.entries(person)) {
			var cell = row.insertCell();
			cell.textContent = value;
		}

		table.appendChild(row);
	});
}

document.querySelector("#list-add-button")?.addEventListener("click", function () {
	addPersonToTable();
});