class Task {
	Title;
	description;
	isDone;


	constructor(title, description, isDone) {
		this.Title = title;
		this.description = description;
		this.isDone = isDone;
	}
}

module.exports = {Task};