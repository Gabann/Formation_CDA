import React from 'react';
import {Pressable, StyleSheet, Text, View} from 'react-native';
import {useDispatch, useSelector} from 'react-redux';
import {removeIds} from './store/data';

export default function MyId() {

	const myId = useSelector((state) => state.data.ids);
	const dispatch = useDispatch();

	return (
		<View>
			<Text>MyId</Text>
			{myId.map((ids, i) => <Pressable key={i} onPress={() => dispatch(removeIds({id: ids}))}><Text
				style={styles.text}>{ids}</Text></Pressable>)}
		</View>
	);
}

const styles = StyleSheet.create({
	text: {
		fontSize: 32
	}
});
