const User = require('../model/user');
const bcrypt = require("bcrypt");
const connection = require("../config/dbConnection");
const saltRounds = 10;
const jwt = require('jsonwebtoken');

const generateToken = (userId) => {
	const payload = {
		userId: userId,
	};

	return jwt.sign(payload, 'RANDOM_TOKEN_SECRET', {expiresIn: "1d"});
};

const userController = {
	getAllUsers: (req, res) => {
		connection.query('SELECT * FROM user', (error, results) => {
			if (error) {
				console.error(error);
				res.status(500).send('Server error');
			} else {
				res.json(results);
			}
		});
	},

	signUpUser: (req, res) => {
		let userData = {username: req.query.username, password: req.query.password};

		bcrypt.hash(userData.password, saltRounds, (err, hash) => {

			userData.password = hash;
			connection.query('INSERT INTO user (username, password) VALUES (?, ?)', [userData.username, hash], (err, result) => {
				if (err) throw err;
				res.send('Utilisateur ajouté avec succès');
			});
		});
	},

	logUser: (req, res) => {
		let userData = {username: req.query.username, password: req.query.password};

		connection.query('SELECT * FROM user WHERE username = ?', [userData.username], (err, dbResult) => {
			if (err) throw err;

			bcrypt.compare(userData.password, dbResult[0].password, (err, hashResult) => {
				if (hashResult) {
					res.send(generateToken(dbResult.id));
				} else {
					res.send('Wrong username or password');
				}
			});
		});
	}
};

module.exports = userController;