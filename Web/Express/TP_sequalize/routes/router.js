const express = require("express");
const router = express.Router();
const jwt = require('jsonwebtoken');
const userController = require("../controller/userController");
const studentController = require("../controller/studentController");

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

router.get('/getAllUsers', userController.getAllUsers);

router.post('/addUser', userController.createUser);

router.post('/log', userController.logUser);

router.get('/getStudentById', studentController.getStudentById);

router.post('/setStudentById', isAuthenticated, studentController.updateStudentById);

router.post('/deleteStudentById', studentController.deleteStudentById);


module.exports = router;