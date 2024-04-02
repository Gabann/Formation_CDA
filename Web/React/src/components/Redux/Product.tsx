import {editProduct, IProduct, removeProduct} from "./productSlice.ts";
import {useAppDispatch} from "./hooks.ts";
import {MouseEvent, useRef, useState} from "react";
// @ts-ignore
import {v4 as uuidv4} from "uuid";

export function Product(props: Readonly<IProduct>) {
	const dispatch = useAppDispatch()

	function removeItem(event: MouseEvent<HTMLButtonElement>) {
		event.preventDefault()

		console.log(props.id)

		dispatch(removeProduct(props.id))
	}

	const [isEditMode, setIsEditMode] = useState<boolean>(false);
	const editedProductNameRef = useRef<HTMLInputElement>(null);
	const editedProductPriceRef = useRef<HTMLInputElement>(null);

	function toggleEditMode(): void {
		setIsEditMode(!isEditMode)
	}

	function confirmEditProduct(): void {
		if (editedProductNameRef.current?.value && editedProductPriceRef.current?.value) {
			const newProduct: IProduct = {
				id: props.id,
				name: editedProductNameRef.current?.value,
				price: parseInt(editedProductPriceRef.current.value)
			}
			dispatch(editProduct(newProduct));

			toggleEditMode()
		}
	}

	return (
		<tr>
			<td>
				{isEditMode ?
					<input ref={editedProductNameRef} defaultValue={props.name}/>
					:
					props.name
				}</td>
			<td>
				{isEditMode ?
					<input ref={editedProductPriceRef} defaultValue={props.price}/>
					:
					props.price
				}
			</td>
			<td>
				{isEditMode ?
					<>
						<button onClick={confirmEditProduct} className='btn btn-success'>Confirm</button>
						<button onClick={toggleEditMode} className='btn btn-warning'>Cancel</button>
					</>
					:
					<button onClick={toggleEditMode} className='btn btn-info'> Edit</button>
				}
			</td>
			<td>
				<button className='btn btn-danger' onClick={removeItem}>Delete</button>
			</td>
		</tr>
	);
}
