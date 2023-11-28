// Password must be at least 8 characters long, have one uppercase, one lowercase, one digit and one special character at least
function validatePasswordInput(str) {
	const regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
	return regex.test(str);
}

// Username should only contain letters and numbers and be at least 3 char long
function validateUsernameInput(str) {
	const regex = /^[a-zA-Z0-9]{3,}$/;
	return regex.test(str);
}

document.getElementById('login-form').addEventListener('submit', function (event) {
	event.preventDefault();

	let username = document.querySelector("input#username").value;
	let password = document.querySelector("input#password").value;

	if (validateUsernameInput(username) && validatePasswordInput(password)) {

		let user = {
			username: username,
			password: password
		};

		console.log(user);
	} else {
		console.log("invalid input");
	}
});

document.getElementById('login-form').addEventListener('input', function () {
	let username = document.querySelector("input#username").value;
	let password = document.querySelector("input#password").value;
	let submitButton = document.querySelector("#form-submit");

	if (!(validateUsernameInput(username) && validatePasswordInput(password))) {
		submitButton.disabled = true;
	} else {
		submitButton.disabled = false;
	}
});