import {Product} from '@/src/classes/Product';
import {createSlice} from '@reduxjs/toolkit';
import {getAllProducts} from '@/src/store/productApiSlice';

export interface cartSliceState {
    productInCart: CartItem[];
}

export type CartItem = {
    product: Product;
    quantity: number;
};

const initialState: cartSliceState = {
    productInCart: [],
};

const cartSlice = createSlice({
    name: 'carsSlice',
    initialState,
    reducers: {},
    extraReducers: (builder) => {
        builder.addCase(getAllProducts.pending, (state) => {
            state.productInCart = [];
        });
        builder.addCase(getAllProducts.rejected, (state, action) => {
            console.error('Failed to get products: ', action.error);
            state.productInCart = [];
        });
        builder.addCase(getAllProducts.fulfilled, (state, action) => {
            state.productInCart = action.payload;
        });
    },
});

export default cartSlice.reducer;
