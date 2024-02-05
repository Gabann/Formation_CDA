const connection = require('../config/dbConnection');
const bcrypt = require("bcrypt");

class User {
	static getAllUsers(callback) {
		connection.query('SELECT * FROM user', callback);
	}

	static addUser(userData, callback) {
		connection.query('INSERT INTO user VALUES ?', userData, callback);
	}

	static updateUserById(userId, userData, callback) {
		connection.query('UPDATE user SET ? WHERE id= ?', [userData, userId], callback);
	}

	static deleteUserById(userId, callback) {
		connection.query('DELETE FROM user WHERE id= ?', userId, callback);
	}

	static signUp(userData) {
		userData = {username: 'user', password: 'password'};

		bcrypt.hash(userData.password, saltRounds, (err, hash) => {

			userData.password = hash;
			connection.query('INSERT INTO user (username, password) VALUES (?, ?)', [userData.username, hash], (err, result) => {
				if (err) throw err;
				res.send('Utilisateur ajouté avec succès');
			});
		});
	}
}

module.exports = User;