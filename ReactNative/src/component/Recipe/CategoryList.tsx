import {Component} from "react";
import {CATEGORIES} from "./data/data";
import {FlatList} from "react-native";
import {CategoryButton} from "./CategoryButton.tsx";
import {NavigationProp} from '@react-navigation/native';

const categories = CATEGORIES;


type Props = {
	navigation: NavigationProp<any, any>;
}

export class CategoryList extends Component<Props> {
	render() {
		return (
			<FlatList
				data={categories}
				numColumns={2}
				renderItem={({item}) => (
					<CategoryButton category={item} navigation={this.props.navigation}/>
				)}
				keyExtractor={(item) => item.id}
			/>
		);
	}
}
