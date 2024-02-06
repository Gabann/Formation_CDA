const {sequelize} = require("../config/dbConnection");
const bcrypt = require("bcrypt");
const jwt = require("jsonwebtoken");
const Student = require("../model/student")(sequelize);

getStudentById = async (req, res) => {
	try {
		let {id} = req.query;
		const student = await Student.findOne({id});

		if (!student) {
			return res
				.status(401)
				.json({message: "Student does not exist"});
		}

		// res.json(user);
		const token = jwt.sign({studentId: student.id}, "RANDOM_TOKEN_SECRET", {
			expiresIn: "1d",
		});
		res.status(200).json({token});
	} catch (error) {
		console.log(error);
		res.status(500).json({message: "Erreur getting student"});
	}
};

updateStudentById = async (req, res) => {
	try {
		let {id, key, value} = req.query;
		const user = await Student.findOne({id});

		if (!user) {
			return res
				.status(401)
				.json({message: "Student does not exist"});
		}


		await Student.update({[key]: value}, {
			where: {
				id: id
			}
		});
	} catch (error) {
		console.log(error);
		res.status(500).json({message: "Erreur updating student"});
	}
};

deleteStudentById = async (req, res) => {
	try {
		let {id} = req.query;
		const user = await Student.findOne({id});

		if (!user) {
			return res
				.status(401)
				.json({message: "Student does not exist"});
		}

		await Student.destroy({
			where: {
				id: id
			}
		});

	} catch (error) {
		console.log(error);
		res.status(500).json({message: "Erreur updating student"});
	}
};

module.exports = {getStudentById, updateStudentById, deleteStudentById};