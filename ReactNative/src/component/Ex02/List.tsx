import {Button, FlatList, Text, View} from 'react-native';
import React, {Component} from 'react';
import {MyModal} from './MyModal.tsx';

type State = {
	list: { text: string, id: number }[],
	modalVisible: boolean
};

export class List extends Component<{}, State> {
	state = {
		list: [
			{text: '1', id: 1},
			{text: '2', id: 2},
			{text: '3', id: 3},
		],
		modalVisible: false,
	};

	toggleModal = () => {
		this.setState(prevState => ({modalVisible: !prevState.modalVisible}));
	};

	addItem = (itemName: string) => {
		const newItem = {text: itemName, id: this.state.list.length + 1};
		this.setState({
			list: [...this.state.list, newItem],
		});
		this.toggleModal();

	};

	render() {
		return (
			<>
				<Text>Liste de courses</Text>

				<FlatList
					data={this.state.list}
					renderItem={({item}) => <Text>{item.text}</Text>}
					keyExtractor={(item) => item.id.toString()}
				/>

				<View>
					<Button title="Ajouter" onPress={this.toggleModal}/>
				</View>

				<MyModal
					modalVisible={this.state.modalVisible}
					toggleModal={this.toggleModal}
					addItem={this.addItem}
				/>
			</>
		);
	}
}
