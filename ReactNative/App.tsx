import React from 'react';
import {StyleSheet, View} from 'react-native';
import {List} from './src/component/Ex02/List.tsx';

export default function App(): React.JSX.Element {
	return (
		<View>

			<List/>
			{/*<Image*/}
			{/*	style={styles.image}*/}
			{/*	source={{uri: 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/30/React_Logo_SVG.svg/1200px-React_Logo_SVG.svg.png'}}*/}
			{/*/>*/}
			{/*<Text style={styles.text}>*/}
			{/*	Nom: Noceda*/}
			{/*</Text>*/}
			{/*<Text style={styles.text}>*/}
			{/*	Prenom: Luz*/}
			{/*</Text>*/}
			{/*<Text style={styles.text}>*/}
			{/*	Telephone: 06 06 06 06 06 06*/}
			{/*</Text>*/}
			{/*<Text style={styles.text}>*/}
			{/*	Adresse: Somewhere in the boiling isles*/}
			{/*</Text>*/}
		</View>
	);
}

const styles = StyleSheet.create({
	// container: {
	// 	flex: 1,
	// 	backgroundColor: '#ef72e8',
	// 	alignItems: 'center',
	// 	justifyContent: 'center',
	// },
	// image: {
	// 	width: 110,
	// 	height: 100,
	// },
	// text: {
	// 	fontSize: 25,
	// },
});
