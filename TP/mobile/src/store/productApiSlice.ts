import {createAsyncThunk, createSlice} from '@reduxjs/toolkit';
import {Product} from '@/src/classes/Product';
import AsyncStorage from '@react-native-async-storage/async-storage';
import axios from 'axios';

export interface apiSliceSate {
    productList: Product[];
}

const initialState: apiSliceSate = {
    productList: [],
};

const apiBaseUrl: string = 'http://10.0.2.2:3603/api/products/';

export const getAllProducts = createAsyncThunk(
    'product/getAllProducts',
    async () => {
        let storedProduct: string | null = await AsyncStorage.getItem('allProducts');

        if (storedProduct) {
            return JSON.parse(storedProduct);
        } else {
            await axios.get(apiBaseUrl + 'all')
                .then((response) => {
                    console.log(response.data);
                    AsyncStorage.setItem('allProducts', JSON.stringify(response.data));
                    return response.data;
                })
                .catch((error) => {
                    console.error(error);
                    throw error;
                });
        }
    },
);

const apiSlice = createSlice({
    name: 'apiSlice',
    initialState,
    reducers: {},
    extraReducers: (builder) => {
        builder.addCase(getAllProducts.pending, (state) => {
            state.productList = [];
        });
        builder.addCase(getAllProducts.rejected, (state, action) => {
            console.error('Failed to try to login: ', action.error);
            state.productList = [];
        });
        builder.addCase(getAllProducts.fulfilled, (state, action) => {
            state.productList = action.payload;
        });
    },
});

export default apiSlice.reducer;
