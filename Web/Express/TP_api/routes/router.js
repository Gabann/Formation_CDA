const express = require("express");
const router = express.Router();
const jwt = require('jsonwebtoken');
const userController = require("../controller/userController");


function isAuthenticated(req, res, next) {
	try {
		const token = req.headers.authorization.split(" ")[1];
		const decodedToken = jwt.verify(token, "RANDOM_TOKEN_SECRET");
		const userId = decodedToken.userId;

		return next();
	} catch (error) {
		res.send("Please log in");
	}
}

router.get('/signup', userController.signUpUser);

router.get('/login', userController.logUser);

router.get('/profile', isAuthenticated, (req, res) => {
	res.send('Accessed protected route');
});

module.exports = router;