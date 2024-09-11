import {Image, Text, View} from 'react-native';
import {Product} from '@/src/classes/Product';

type Props = {
    product: Product
}

export const ProductCard: React.FC<Props> = ({product}) => {


    return (
        <View>
            <Image
                source={{uri: product.imageUrl}}
                style={{width: 100, height: 100}}
            />
            <Text>Id: {product.id}</Text>
            <Text>Name: {product.name}</Text>
            <Text>Description: {product.description}</Text>
            <Text>Price: {product.price}€</Text>
            <Text>Category: {product.category}</Text>
        </View>
    );
};
