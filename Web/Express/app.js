// var createError = require('http-errors');
// var express = require('express');
// var path = require('path');
// var cookieParser = require('cookie-parser');
// var logger = require('morgan');
//
// var indexRouter = require('./routes/index');
// var usersRouter = require('./routes/users');
//
// var app = express();
//
// // view engine setup
// app.set('views', path.join(__dirname, 'views'));
// app.set('view engine', 'jade');
//
// app.use(logger('dev'));
// app.use(express.json());
// app.use(express.urlencoded({ extended: false }));
// app.use(cookieParser());
// app.use(express.static(path.join(__dirname, 'public')));
//
// app.use('/', indexRouter);
// app.use('/users', usersRouter);
//
// // catch 404 and forward to error handler
// app.use(function(req, res, next) {
//   next(createError(404));
// });
//
// // error handler
// app.use(function(err, req, res, next) {
//   // set locals, only providing error in development
//   res.locals.message = err.message;
//   res.locals.error = req.app.get('env') === 'development' ? err : {};
//
//   // render the error page
//   res.status(err.status || 500);
//   res.render('error');
// });
//
// module.exports = app;

const express = require('express');
const router = require("./routes/router.js");
const path = require("path");
const connection = require("./dbConnection");
const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost:27017/Hopital');

const db = mongoose.connection;

db.on('error', console.error.bind(console, 'Erreur de connexion à MongoDB :'));
db.once('open', () => {
	console.log('Connecté à MongoDB');
}); // Ces lignes gèrent les événements liés à la connexion MongoDB. En cas d'erreur, un message est affiché dans la console. Si la connexion est établie avec succès, le message "Connecté à MongoDB" est affiché une fois.

const app = express();
const port = 3000;

app.set('view engine', 'pug');
app.set('views', path.join('./', 'views'));

app.use('/', router);

app.listen(port, () => {
	console.log(`server launched, listening on ${port}`);
});