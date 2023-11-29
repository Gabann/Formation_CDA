import {Person} from "./person.js";

let modal = document.querySelector(".modal");

document.querySelector("#open-modal-button").addEventListener("click", () => {
	modal.style.display = "block";
});

document.querySelector("#close-modal-button").addEventListener("click", () => {
	modal.style.display = "none";
});

window.onclick = event => {
	if (event.target === modal) {
		modal.style.display = "none";
	}
};

document.getElementById('add-person-form').addEventListener('submit', event => {
	event.preventDefault();

	let firstName = document.querySelector("input#first-name-input").value;
	let lastName = document.querySelector("input#last-name-input").value;
	let dob = document.querySelector("input#dob-input").value;

	addPersonToTable(firstName, lastName, dob);
});

//Add a listener to all th element to sort table alphabetically by the column clicked
document.querySelectorAll("th").forEach((th, index) => {
	th.addEventListener("click", () => {
		sortTableByRowIndex(index);
	});
});

function addPersonToTable(firstName, lastName, dob) {
	let tbody = document.querySelector("table#person-table tbody");

	try {
		let newPerson = new Person(firstName, lastName, dob);

		let row = tbody.insertRow();

		//We add a class for row deletion with RemovePersonFromTableById()
		row.classList.add(`row-id${newPerson.id}`);

		row.innerHTML = `
				<th>${newPerson.id}</th>
				<th>${newPerson.firstName}</th>
				<th>${newPerson.lastName}</th>
				<th>${newPerson.dob}</th>
				<th>
					<button>Delete</button>
				</th>`;

		row.querySelector("th button").addEventListener('click', function () {
			RemovePersonFromTableById(newPerson.id);
		});

		tbody.appendChild(row);

	} catch (error) {
		//TODO Add user feedback

		console.error(error.message);
	}
}

function RemovePersonFromTableById(id) {
	document.querySelector(`.row-id${id}`).remove();
}

function sortTableByRowIndex(id) {
	let tbody = document.querySelector("table#person-table tbody");
	let rows = Array.from(tbody.rows);

	rows.sort(
		(a, b) => a.cells[id].textContent.localeCompare(b.cells[id].textContent)
	);

	for (let row of rows) {
		tbody.appendChild(row);
	}
}

addPersonToTable("Luz", "Noceda", new Date());
addPersonToTable("Amity", "Blight");
addPersonToTable("King", "Clawthorne");

//Will throw error
// addPersonToTable("Edalyn", 15);