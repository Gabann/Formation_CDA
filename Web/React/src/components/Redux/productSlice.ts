import {createSlice, PayloadAction} from '@reduxjs/toolkit';
// @ts-ignore
import {v4 as uuidv4} from "uuid";


export interface IProduct {
	id: number,
	name: string,
	price: number
}

const initialState: IProduct[] = [
	{id: uuidv4(), name: "Test", price: 10},
	{id: uuidv4(), name: "Test 2", price: 20},
];

const productSlice = createSlice({
	name: 'product',
	initialState,
	reducers: {
		addProduct(state, action: PayloadAction<IProduct>) {
			state.push({
				id: uuidv4(),
				name: action.payload.name,
				price: action.payload.price
			})
		},
		removeProduct(state, action: PayloadAction<number>) {
			return state.filter(product => product.id !== action.payload);
		},
		editProduct(state, action: PayloadAction<IProduct>) {
			return state.map(product => product.id === action.payload.id ? action.payload : product);
		},
	},
});

export const {addProduct, removeProduct, editProduct} = productSlice.actions;
export default productSlice.reducer;