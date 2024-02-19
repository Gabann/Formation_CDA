const express = require('express');
const router = require("./routes/router.js");
const app = express();
const port = 3001;

app.use('/', router);

app.listen(port, () => {
	console.log(`server launched, listening on ${port}`);
});