const {sequelize} = require("../config/dbConnection");
const bcrypt = require("bcrypt");
const jwt = require("jsonwebtoken");
const User = require("../model/user")(sequelize);

getAllUsers = async (req, res) => {
	try {
		const users = await User.findAll();
		res.json(users);
	} catch (error) {
		console.log(error);
		res.status(500).json({message: "Erreur getting all users"});
	}
};

createUser = async (req, res) => {
	try {
		let {username, password, role} = req.query;

		let hashedPassword = await bcrypt.hash(password, 10);

		console.log(username, hashedPassword, role);

		const newUser = await User.create({username, password: hashedPassword, role});
		res.status(201).json(newUser);
	} catch (error) {
		console.error(error);
		res.status(500).json({message: "Error creating user"});
	}
};

logUser = async (req, res) => {
	try {
		const {username, password} = req.query;
		const user = await User.findOne({username});
		if (!user) {
			return res
				.status(401)
				.json({message: "Utilisateur ou mot de passe incorrect"});
		}

		const isValid = await bcrypt.compare(password, user.password);

		if (!isValid) {
			return res
				.status(401)
				.json({message: "Utilisateur ou mot de passe incorrect"});
		}

		const token = jwt.sign({userId: user.id}, "RANDOM_TOKEN_SECRET", {
			expiresIn: "1d",
		});
		res.status(200).json({token});
	} catch (error) {
		res.status(500).json({error: error.message});
	}
};

module.exports = {getAllUsers, createUser, logUser};