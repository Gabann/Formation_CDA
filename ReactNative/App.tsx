import React from 'react';
import {View} from 'react-native';
import {Calculator} from "./src/component/Calculator/Calculator.tsx";

console.log("test")

export default function App(): React.JSX.Element {
	return (
		<View>
			<Calculator/>
			{/*<List/>*/}
			{/*<ContactList/>*/}
		</View>
	);
}

// const styles = StyleSheet.create({
// 	container: {
// 		flex: 1,
// 		backgroundColor: '#ef72e8',
// 		alignItems: 'center',
// 		justifyContent: 'center',
// 	},
// });
