import {Button, StyleSheet, Text, View} from 'react-native'
import React, {useState} from 'react'
import AsyncStorage from '@react-native-async-storage/async-storage'

export default function Async() {

	const [value, setValue] = useState("")

	async function addData() {
		try {
			await AsyncStorage.setItem('key', "toto")
		} catch (error) {
			console.log(error)
		}
	}

	async function getData() {
		try {
			const value = await AsyncStorage.getItem('key')
			if (value !== null) {
				setValue(value)
			}
		} catch (error) {
			console.log(error)
		}
	}

	async function removeData() {
		try {
			await AsyncStorage.removeItem('key')
			setValue('')
		} catch (error) {
			console.log(error)
		}
	}


	return (
		<View>
			<Text>Valeur stockée : {value}</Text>
			<Button title='Ajout' onPress={addData}/>
			<Button title='Recup' onPress={getData}/>
			<Button title='Delete' onPress={removeData}/>
		</View>
	)
}

const styles = StyleSheet.create({})
