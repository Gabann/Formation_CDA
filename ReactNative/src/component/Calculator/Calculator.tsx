import React, {Component} from "react";
import {StyleSheet, Text, View} from "react-native";
import {CalculatorButton} from "./CalculatorButton.tsx";

type State = {
	resultValue: number,
	displayValue: number,
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
		resultValue: 0,
		displayValue: 0,
		mode: '',
	};

	calculate = async (): Promise<void> => {
		let result = this.state.resultValue;

		switch (this.state.mode) {
			case calculatorMode.add:
				result += this.state.displayValue;
				break;
			case calculatorMode.subtract:
				result -= this.state.displayValue;
				break;
			case calculatorMode.divide:
				result /= this.state.displayValue;
				break;
			case calculatorMode.multiply:
				result *= this.state.displayValue;
				break;
			case calculatorMode.power:
				result = Math.pow(result, this.state.displayValue);
				break;
			case calculatorMode.percent:
				result /= 100;
				break;
			default:
				result = this.state.displayValue;
		}

		await this.setState({resultValue: result});
	}

	addNumberToDisplay = (number: number): void => {
		this.setState({
			displayValue: Number(String(this.state.displayValue) + Number(String(number)))
		})
	}

	removeLastNumber = (): void => {
		this.setState({displayValue: Number(String(this.state.displayValue).slice(0, -1))});
	}

	dot = (): void => {
		this.setState({displayValue: Number(String(this.state.displayValue) + '.')});
	}

	setMode = (mode: string): void => {
		this.setState({
			mode,
			resultValue: this.state.displayValue,
			displayValue: 0
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
		this.setState({resultValue: 0, displayValue: 0, mode: ''});
	}

	showResult = (): void => {
		this.setState({displayValue: this.state.resultValue});
	}

	debug = (): void => {
		console.log(`result: ${this.state.resultValue}`);
		console.log(`displayNumber: ${this.state.displayValue}`);
		console.log(`mode: ${this.state.mode}`);
	}

	render() {

		return (
			<View style={styles.container}>
				<Text style={styles.title}>Calculator</Text>

				<View>
					<Text style={styles.result}>{this.state.displayValue}</Text>
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
