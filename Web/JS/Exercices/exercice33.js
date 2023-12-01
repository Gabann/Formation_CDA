let timerMs;
let timerInterval;
let timerIntervalMs = 1000;

let hourInput = document.querySelector(".hour-input");
let minuteInput = document.querySelector(".minute-input");
let secondInput = document.querySelector(".second-input");
let msInput = document.querySelector(".millisecond-input");
let audio = new Audio('./ring.mp3');

document.querySelector("#start-timer-button").addEventListener("click", () => {
	let totalTimeMs = 0;
	totalTimeMs += Number(hourInput.value) * 3600000;
	totalTimeMs += Number(minuteInput.value) * 60000;
	totalTimeMs += Number(secondInput.value) * 1000;
	totalTimeMs += Number(msInput.value);

	launchTimer(totalTimeMs);
});

document.querySelector("#stop-timer-button").addEventListener("click", () => {
	stopTimer();
});

//Prevent the user from inputting non number and numbers too low or too high
const clamp = (num, min, max) => Math.min(Math.max(num, min), max);
document.querySelectorAll(".timer-input").forEach((input) => {
	input.addEventListener("input", (e) => {
		let nonDigitRegex = /[^0-9]/g;
		if (nonDigitRegex.test(e.target.value)) {
			e.target.value = e.target.value.replace(nonDigitRegex, '');
		}
		e.target.value = clamp(e.target.value, 0, 59);

	});
});

//Formats the time to hh:mm:ss:ms
function updateTimerDisplay(timeMs) {
	let timeSecond = timeMs / 1000;
	let returnString = "";

	let hours = String(Math.floor(timeSecond / 3600)).padStart(2, "0");
	let minutes = String(Math.floor(timeSecond % 3600 / 60)).padStart(2, "0");
	let seconds = String(Math.floor(timeSecond % 60)).padStart(2, "0");
	let milliseconds = String(Math.floor(timeSecond * 100 % 100)).padStart(2, "0");

	hourInput.value = hours;
	minuteInput.value = minutes;
	secondInput.value = seconds;
	msInput.value = milliseconds;
}

function setInputDisabledState(bool) {
	hourInput.disabled = bool;
	minuteInput.disabled = bool;
	secondInput.disabled = bool;
	msInput.disabled = bool;
}

function launchTimer(timeMs) {
	timerMs = timeMs;
	setInputDisabledState(true);

	if (timerInterval) {
		killInterval();
	}

	timerInterval = setInterval(() => {
		if (timerMs > 0) {
			timerMs -= timerIntervalMs;
			updateTimerDisplay(timerMs);
		} else {
			killInterval();
			console.log("timer ended");
			setInputDisabledState(false);
			audio.play();
		}
	}, timerIntervalMs);
}

function stopTimer() {
	setInputDisabledState(false);

	killInterval();
}

function killInterval() {
	clearInterval(timerInterval);
	timerInterval = null;
}


