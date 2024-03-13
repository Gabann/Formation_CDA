import React, {Component} from 'react';
import {Button, Modal, TextInput, View} from 'react-native';

type Props = {
	modalVisible: boolean;
	toggleModal: () => void;
	addItem: (text: string) => void;
};

type State = {
	newItemText: string,
};

export class MyModal extends Component<Props, State> {
	state = {
		newItemText: '',
	};

	handleTextChange = (text: string) => {
		this.setState({newItemText: text});
	};

	addItem() {
		return () => {
			if (this.state.newItemText) {
				this.props.addItem(this.state.newItemText);
				this.setState({newItemText: ''});
			}
		};
	}

	render() {
		const {modalVisible, toggleModal} = this.props;
		return (
			<Modal
				visible={modalVisible}
				onRequestClose={toggleModal}
			>
				<View>
					<TextInput
						value={this.state.newItemText}
						onChangeText={this.handleTextChange}
						placeholder={'Item to add'}
					/>
					<Button title="Ajouter" onPress={this.addItem()}/>
					<Button title="Annuler ajout" onPress={toggleModal}/>
				</View>
			</Modal>
		);
	}
}
