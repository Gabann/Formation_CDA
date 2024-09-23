import React, {useEffect} from 'react';
import {View} from 'react-native';
import {ProductList} from '@/src/components/ProductList';
import {useAppDispatch, useAppSelector} from '@/src/store/hooks';
import {getAllProducts} from '@/src/store/productApiSlice';
import {RootState} from '../store/store';


export const ProductListView = () => {
    const dispatch = useAppDispatch();
    const productList = useAppSelector((state: RootState) => state.productApiSlice.productList);

    useEffect(() => {
        dispatch(getAllProducts()).catch(error => console.error('Failed to fetch product list: ', error));
    }, []);

    useEffect(() => {
        dispatch(getAllProducts());
    }, [dispatch]);
    
    return (
        <View>
            <ProductList productList={productList}/>
        </View>
    );
};
