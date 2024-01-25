const express = require("express");
const router = express.Router();
const path = require("path");
const fs = require("fs");

router.get('/welcome', (req, res) => {
	res.sendFile(path.resolve(path.join('./', 'public', 'index.html')));
});

router.get('/forbidden', (req, res) => {
	res.status(403).send('Access forbidden');
});

router.get('/info', (req, res) => {
	res.json({Nom: 'Edalyn Clawthorne', age: 50, Nickname: "The owl lady"});
});

router.get('', (req, res) => {
	res.redirect('/welcome');
});

router.get('/books', (req, res) => {
	res.json(require('../data/books.json'));
});

router.get('/search-book/book-id/:bookId', (req, res) => {
	let bookId = req.params.bookId;
	let bookList = require('../data/books.json');

	let books = bookList.filter((book) => {
		return book.id === parseInt(bookId);
	});

	if (books.length > 0) {
		res.json(books);
	} else {
		res.status(404).send(`Book with id ${bookId} does not exist`);
	}
});

router.get('/search-book/author/:authorName', (req, res) => {
	let authorName = req.params.authorName;

	let bookList = require('../data/books.json');

	let books = bookList.filter((book) => {
		return book.auteur === authorName;
	});

	if (books.length > 0) {
		res.json(books);
	} else {
		res.status(404).send(`Book with author ${authorName} does not exist`);
	}
});

router.get('/add-book', (req, res) => {
	let newBook = {
		"id": 5,
		"titre": "The book of bill",
		"auteur": "lex Hirsch"
	};

	let booksPath = path.resolve(path.join('./', 'data', 'books.json'));

	try {
		let bookList = JSON.parse(fs.readFileSync(booksPath, "utf-8"));
		bookList.push(newBook);
		fs.writeFileSync(booksPath, JSON.stringify(bookList), "utf-8");
	} catch (error) {
		console.error(error);
	}

	res.status(200).send("Book added successfully");
});

router.get('*', (req, res) => {
	res.status(404).send('Not found');
});

module.exports = router;