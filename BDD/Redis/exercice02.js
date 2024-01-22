const redis = require("redis");

const readline = require('node:readline');
const {stdin: input, stdout: output} = require('node:process');
const rl = readline.createInterface({input, output});

const host = "127.0.0.1";
const port = "6379";
const client = redis.createClient(port, host);
client.connect();

const {Product} = require("./Product");
const productListKey = "productList";

async function prompt(question) {
	return new Promise((resolve) => {
		rl.question(question + "\n", (answer) => {
			resolve(answer);
		});
	});
}

async function addProduct() {
	let productName = await prompt("Product name:");
	let productQuantity = await prompt("Product quantity:");
	let productPrice = await prompt("Product price:");

	let productToAdd = new Product(productName, productQuantity, productPrice);
	console.log(typeof productToAdd);

	await client.rPush(productListKey, JSON.stringify(productToAdd));
}

async function editProductByName() {
	let searchQuery = await prompt("New name:");
	let productList = await client.lRange(productListKey, 0, -1);

	let newProductName = await prompt("New name:");
	let newProductQuantity = await prompt("New quantity:");
	let newProductPrice = await prompt("New price:");
	let newProduct = new Product(newProductName, newProductQuantity, newProductPrice);


	for (let i = 0; i < productList.length; i++) {
		let item = JSON.parse(productList[i]);
		if (item.name === searchQuery) {
			console.log(i);
			await client.lSet(productListKey, i, JSON.stringify(newProduct));
		}
	}
}

async function displayProductList() {
	let productList = await client.lRange(productListKey, 0, -1);
	console.log(productList);
}

async function removeProductByName() {
	let productList = await client.lRange(productListKey, 0, -1);
	productList = productList.map(product => JSON.parse(product));

	let productNameToDelete = await prompt("Enter product name you'd like to remove");

	productList = productList.filter(product => product.name !== productNameToDelete);

	await client.del(productListKey);

	for (const product of productList) {
		await client.rPush(productListKey, JSON.stringify(product));
	}
}

async function removeAllProduct() {
	await client.del(productListKey);
}

async function displayMenu() {
	try {
		let option = await prompt(`Choisissez une option :
1. Add a product
2. Update a product
3. Display all products
4. Remove a product
5. Remove all products
-1. Quit`);

		if (option === '-1') {
			console.log("Quiting menu");
			rl.close();
			return;
		}

		switch (option) {
			case '1':
				await addProduct();
				break;
			case '2':
				await editProductByName();
				break;
			case '3':
				await displayProductList();
				break;
			case '4':
				await removeProductByName();
				break;
			case '5':
				await removeAllProduct();
				break;
			default:
				console.log('Invalid option. Please enter a number between 1 and 5');
		}

		displayMenu();

	} catch (error) {
		console.error(error);
	}
}

// client.on("connect", (err) => {
// 	console.mongodb.log(err);
// 	console.mongodb.log("connected");
// }).connect();

// (async () => {
// 	try {
// 		await client.set("key1", "value1");
// 		const value = await client.get("key1")
// 		console.mongodb.log(value);
// 	} catch (e) {
// 		console.mongodb.error(e);
// 	}
// })();

displayMenu();