import React from "react";
import {CATEGORIES} from "./data/data";
import {FlatList, View} from "react-native";
import {CategoryButton} from "./CategoryButton.tsx";

const categories = CATEGORIES;

export const CategoryList: React.FC = () => {
	return (
		<View>
			<FlatList
				contentContainerStyle={{alignItems: 'center'}}
				data={categories}
				numColumns={2}
				renderItem={({item}) => (
					<CategoryButton category={item}/>
				)}
				keyExtractor={(item) => item.id}
			/>
		</View>
	);
}
