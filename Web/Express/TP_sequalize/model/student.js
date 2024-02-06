const {DataTypes} = require("sequelize");

module.exports = (sequelize) => {
	return sequelize.define("Student", {
		id: {
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true,
		},
		firstName: {
			type: DataTypes.STRING,
			allowNull: false,
		},
		lastName: {
			type: DataTypes.STRING,
			allowNull: false,
		}
	});
};
