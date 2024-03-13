import React, {Component} from "react";
import {StyleSheet, Text, View} from "react-native";
import {CalculatorButton} from "./CalculatorButton.tsx";

type State = {
	result: number,
	displayNumber: number,
	mode: string
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
		result: 0,
		displayNumber: 0,
		mode: ''
	};

	calculate = async (): Promise<void> => {
		let result = this.state.result;

		switch (this.state.mode) {
			case calculatorMode.add:
				result += this.state.displayNumber;
				break;
			case calculatorMode.subtract:
				result -= this.state.displayNumber;
				break;
			case calculatorMode.divide:
				result /= this.state.displayNumber;
				break;
			case calculatorMode.multiply:
				result *= this.state.displayNumber;
				break;
			case calculatorMode.power:
				result = Math.pow(result, this.state.displayNumber);
				break;
			case calculatorMode.percent:
				result /= 100;
				break;
			default:
				result = this.state.displayNumber;
		}

		await this.setState({result: result});
	}

	addNumberToDisplay = (number: number): void => {
		this.setState({
			displayNumber: Number(String(this.state.displayNumber) + Number(String(number)))
		})
	}

	removeLastNumber = (): void => {
		this.setState({displayNumber: Number(String(this.state.displayNumber).slice(0, -1))});
	}

	setMode = (mode: string): void => {
		this.setState({
			mode,
			result: this.state.displayNumber,
			displayNumber: 0
		});
	};

	add = (): void => {
		this.setMode(calculatorMode.add);
	};

	subtract = (): void => {
		this.setMode(calculatorMode.subtract);
	};

	divide = (): void => {
		this.setMode(calculatorMode.divide);
	};

	multiply = (): void => {
		this.setMode(calculatorMode.multiply);
	};

	percent = (): void => {
		this.setMode(calculatorMode.percent);
		this.equal();
	};

	power = (): void => {
		this.setMode(calculatorMode.power);
	};

	equal = async (): Promise<void> => {
		await this.calculate();
		this.showResult();
	}

	reset = (): void => {
		this.setState({result: 0, displayNumber: 0, mode: ''});
	}

	showResult = (): void => {
		this.setState({displayNumber: this.state.result});
	}

	debug = (): void => {
		console.log(`result: ${this.state.result}`);
		console.log(`displayNumber: ${this.state.displayNumber}`);
		console.log(`mode: ${this.state.mode}`);
	}

	dot = (): void => {
		this.setState({displayNumber: Number(String(this.state.displayNumber) + '.')});
	}

	render() {

		return (
			<View style={styles.container}>
				<Text style={styles.title}>Calculator</Text>

				<View>
					<Text style={styles.result}>{this.state.displayNumber}</Text>
				</View>

				<View style={styles.buttons}>
					<View style={{flexDirection: 'row'}}>
						<CalculatorButton action={this.reset} text={"AC"} style={"Dark"}></CalculatorButton>
						<CalculatorButton action={this.power} text={"^"} style={"Dark"}></CalculatorButton>
						<CalculatorButton action={this.percent} text={"%"} style={"Dark"}></CalculatorButton>
						<CalculatorButton action={this.divide} text={"/"} style={"Dark"}></CalculatorButton>
					</View>

					<View style={{flexDirection: 'row'}}>
						<CalculatorButton action={() => this.addNumberToDisplay(7)} text={"7"} style={"Light"}></CalculatorButton>
						<CalculatorButton action={() => this.addNumberToDisplay(8)} text={"8"} style={"Light"}></CalculatorButton>
						<CalculatorButton action={() => this.addNumberToDisplay(9)} text={"9"} style={"Light"}></CalculatorButton>
						<CalculatorButton action={this.multiply} text={"*"} style={"Dark"}></CalculatorButton>
					</View>

					<View style={{flexDirection: 'row'}}>
						<CalculatorButton action={() => this.addNumberToDisplay(4)} text={"4"} style={"Light"}></CalculatorButton>
						<CalculatorButton action={() => this.addNumberToDisplay(5)} text={"5"} style={"Light"}></CalculatorButton>
						<CalculatorButton action={() => this.addNumberToDisplay(6)} text={"6"} style={"Light"}></CalculatorButton>
						<CalculatorButton action={this.subtract} text={"-"} style={"Dark"}></CalculatorButton>
					</View>

					<View style={{flexDirection: 'row'}}>
						<CalculatorButton action={() => this.addNumberToDisplay(1)} text={"1"} style={"Light"}></CalculatorButton>
						<CalculatorButton action={() => this.addNumberToDisplay(2)} text={"2"} style={"Light"}></CalculatorButton>
						<CalculatorButton action={() => this.addNumberToDisplay(3)} text={"3"} style={"Light"}></CalculatorButton>
						<CalculatorButton action={this.add} text={"+"} style={"Dark"}></CalculatorButton>
					</View>

					<View style={{flexDirection: 'row'}}>
						<CalculatorButton action={this.dot} text={"."} style={"Light"}></CalculatorButton>
						<CalculatorButton action={() => this.addNumberToDisplay(0)} text={"0"} style={"Light"}></CalculatorButton>
						<CalculatorButton action={this.removeLastNumber} text={"Del"} style={"Light"}></CalculatorButton>
						<CalculatorButton action={this.equal} text={"="} style={"Dark"}></CalculatorButton>
					</View>

					<View style={{flexDirection: 'row'}}>
						<CalculatorButton action={this.debug} text={"Debug"} style={"Light"}></CalculatorButton>
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
