import {Product} from '@/src/classes/Product';
import React from 'react';
import {FlatList} from 'react-native';
import {ProductCard} from '@/src/components/ProductCard';

type Props = {
    productList: Product[]
}

export const ProductList: React.FC<Props> = ({productList}) => {
    return (
        <FlatList
            contentContainerStyle={{alignItems: 'center'}}
            data={productList}
            numColumns={3}
            renderItem={({item}) => (
                <ProductCard product={item}/>
            )}
            keyExtractor={(item: Product) => item.id.toString()}
        />
    );
};
