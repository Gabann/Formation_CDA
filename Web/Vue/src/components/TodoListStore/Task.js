export class Task {
	title;
	description;
	isDone;
	isFavorite;


	constructor(title, description, isDone, favorite) {
		this.title = title;
		this.description = description;
		this.isDone = isDone;
		this.isFavorite = favorite;
	}
}