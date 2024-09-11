import React, {useEffect} from 'react';
import {Button, View} from 'react-native';
import {ProductList} from '@/src/components/ProductList';
import {useAppDispatch, useAppSelector} from '@/src/store/hooks';
import {getAllProducts} from '@/src/store/productApiSlice';
import {RootState} from '../store/store';
import AsyncStorage from '@react-native-async-storage/async-storage';


export const ProductListView = () => {
    const dispatch = useAppDispatch();
    const productList = useAppSelector((state: RootState) => state.productApiSlice.productList);

    useEffect(() => {
        dispatch(getAllProducts()).catch(error => console.error('Failed to fetch product list: ', error));
    }, []);

    return (
        <View>
            <ProductList productList={productList}/>
            <Button title={'Delete cache'} onPress={() => {
                AsyncStorage.removeItem('allProducts');
            }}/>

        </View>
    );
};
