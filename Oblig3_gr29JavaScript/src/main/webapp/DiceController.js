/**
 * 
 */


import { Dice } from './Dice.js';
class DiceController {
	#rootElement
	constructor(rootElement) {
		this.#rootElement = rootElement;
		const dicebutton = rootElement.querySelector("*[data-dicebutton]");
		dicebutton.addEventListener("click", this.#rollDice.bind(this));
	}

	#rollDice() {
		const diceoutputElement = this.#rootElement.querySelector("*[data-diceoutput]");
		diceoutputElement.innerText = new Dice().getValue();
	};
}

function init() {
	const rootElement = document.getElementById('root');
	new DiceController(rootElement);
}

init();