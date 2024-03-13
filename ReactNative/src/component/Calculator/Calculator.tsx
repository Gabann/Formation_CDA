import React, {Component} from "react";
import {StyleSheet, Text, View} from "react-native";
import {CalculatorButton} from "./CalculatorButton.tsx";

type State = {
	resultValue: number,
	expression: string[]
};

let calculatorMode = {
	add: '+',
	subtract: '-',
	divide: '/',
	multiply: '*',
	power: '^',
	percent: '%'
}

export class Calculator extends Component<{}, State> {
	state = {
		resultValue: 0,
		expression: []
	};
	
	addToExpression = (value: string): void => {
		this.setState({expression: [...this.state.expression, value]}, () => {
			this.showResult();
		});
	}
	reset = (): void => {
		this.setState({resultValue: 0, expression: []});
	}

	removeLastExpression = (): void => {
		this.setState({expression: this.state.expression.slice(0, -1)}, () => {
			this.showResult();
		});
	}

	showResult = (): void => {
		try {
			this.setState({resultValue: eval(this.state.expression.join(''))});
		} catch (error) {
			console.error(error);
		}
	}

	render() {

		return (
			<View style={styles.container}>
				<Text style={styles.title}>Calculator</Text>

				<View>
					<Text style={styles.result}>{this.state.expression}</Text>

					{this.state.expression.length > 0 ? (
						<Text style={styles.result}>={this.state.resultValue}</Text>
					) : (
						<Text style={styles.result}>0</Text>
					)}
				</View>

				<View style={styles.buttons}>
					<View style={{flexDirection: 'row'}}>
						<CalculatorButton action={this.reset} text={"AC"} style={"Dark"}></CalculatorButton>

						<CalculatorButton action={() => {
							this.addToExpression('**')
						}} text={"^"} style={"Dark"}></CalculatorButton>

						<CalculatorButton action={() => {
							this.addToExpression('/100')
						}} text={"%"} style={"Dark"}></CalculatorButton>

						<CalculatorButton action={() => {
							this.addToExpression('/')
						}} text={"/"} style={"Dark"}></CalculatorButton>
					</View>

					<View style={{flexDirection: 'row'}}>
						<CalculatorButton action={() => {
							this.addToExpression('7')
						}} text={"7"} style={"Dark"}></CalculatorButton>

						<CalculatorButton action={() => {
							this.addToExpression('8')
						}} text={"8"} style={"Dark"}></CalculatorButton>

						<CalculatorButton action={() => {
							this.addToExpression('9')
						}} text={"9"} style={"Dark"}></CalculatorButton>

						<CalculatorButton action={() => {
							this.addToExpression('*')
						}} text={"*"} style={"Dark"}></CalculatorButton>
					</View>

					<View style={{flexDirection: 'row'}}>
						<CalculatorButton action={() => {
							this.addToExpression('4')
						}} text={"4"} style={"Dark"}></CalculatorButton>

						<CalculatorButton action={() => {
							this.addToExpression('5')
						}} text={"5"} style={"Dark"}></CalculatorButton>

						<CalculatorButton action={() => {
							this.addToExpression('6')
						}} text={"6"} style={"Dark"}></CalculatorButton>

						<CalculatorButton action={() => {
							this.addToExpression('-')
						}} text={"-"} style={"Dark"}></CalculatorButton>
					</View>

					<View style={{flexDirection: 'row'}}>
						<CalculatorButton action={() => {
							this.addToExpression('1')
						}} text={"1"} style={"Dark"}></CalculatorButton>

						<CalculatorButton action={() => {
							this.addToExpression('2')
						}} text={"2"} style={"Dark"}></CalculatorButton>

						<CalculatorButton action={() => {
							this.addToExpression('3')
						}} text={"3"} style={"Dark"}></CalculatorButton>

						<CalculatorButton action={() => {
							this.addToExpression('+')
						}} text={"+"} style={"Dark"}></CalculatorButton>
					</View>

					<View style={{flexDirection: 'row'}}>
						<CalculatorButton action={() => {
							this.addToExpression('.')
						}} text={"."} style={"Dark"}></CalculatorButton>

						<CalculatorButton action={() => {
							this.addToExpression('0')
						}} text={"0"} style={"Dark"}></CalculatorButton>


						<CalculatorButton action={this.removeLastExpression} text={"Del"} style={"Light"}></CalculatorButton>
						<CalculatorButton action={this.showResult} text={"="} style={"Dark"}></CalculatorButton>
					</View>
				</View>
			</View>
		)
	}
}

const styles = StyleSheet.create({
	container: {
		backgroundColor: '#212121',
		padding: 10,
		height: '100%',
		justifyContent: 'space-between',
	},
	title: {
		textAlign: 'center',
		fontSize: 50,
		color: 'white',
	},
	result: {
		textAlign: 'right',
		fontSize: 50,
		color: 'white',
	},
	buttons: {}
});
