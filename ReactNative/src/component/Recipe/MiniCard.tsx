import React from 'react';
import {Dimensions, StyleSheet, Text, View} from "react-native";
import {GlobalStyles, mainColor} from "./globalStyles.ts";

type Props = {
	text: string;
}

export const MiniCard: React.FC<Props> = ({text}) => {
	return (
		<View style={[styles.view, GlobalStyles.centeredView]}>
			<Text style={styles.Text}>{text}</Text>
		</View>
	);
}

const styles = StyleSheet.create({
	view: {
		backgroundColor: mainColor,
		margin: 3,
		padding: 2,
		borderRadius: 8,
		width: Dimensions.get('window').width * 0.8,
	},
	Text: {
		color: 'black',
		fontSize: 15,
	}
});
