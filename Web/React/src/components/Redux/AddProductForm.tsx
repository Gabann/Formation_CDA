import {useAppDispatch} from "./hooks.ts";
import {MouseEvent, useRef} from "react";
import {addProduct} from "./productSlice.ts";
// @ts-ignore
import {v4 as uuidv4} from "uuid";

export function AddProductForm() {
	const dispatch = useAppDispatch()
	const productNameRef = useRef<HTMLInputElement>(null);
	const productPriceRef = useRef<HTMLInputElement>(null);

	function addItem(event: MouseEvent<HTMLButtonElement>): void {
		event.preventDefault()
		console.log(`${productNameRef.current?.value} ${productPriceRef.current?.value}`)

		if (productPriceRef.current && productNameRef.current) {
			dispatch(addProduct({id: uuidv4(), name: productNameRef.current.value, price: parseInt(productPriceRef.current.value)}))
		}
	}

	return (
		<form>
			<label htmlFor="product-name">Product name</label>
			<input id='product-name' ref={productNameRef} type='text'/>

			<label htmlFor="product-price">Product price</label>
			<input id='product-price' ref={productPriceRef} type='number'/>

			<button onClick={addItem} type='submit'>Add item</button>
		</form>
	);
}