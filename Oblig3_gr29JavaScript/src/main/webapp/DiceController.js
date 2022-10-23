/**
 * 
 */


import { Dice } from './Dice.js';
class DiceController {
	//# -> the method or variable is private	
	#rootElement
	
	/**
	 * Constructor for creating a DiceController object. The constructor takes a "root" element, i.e. an accessible element
	 * from the html. When the object is created we also add an eventlistener to a button with the value [data-dicebutton].
	 */
	constructor(rootElement) {
		this.#rootElement = rootElement;
		
		
		//Adding event listener to the "[data-dicebutton]" button. Whenever the button is clicked the #rollDice method will be called
		const dicebutton = rootElement.querySelector("*[data-dicebutton]");
		dicebutton.addEventListener("click", this.#rollDice.bind(this));
	}
	
	/**
	 * This method selects the span with value of [data-diceoutput], and adds the result of rolling a dice to the inner html
	 */
	
	#rollDice() {
		const diceoutputElement = this.#rootElement.querySelector("*[data-diceoutput]");		
		//Probably bad practice to use new Dice.getValue() here
		//const dice = new Dice();
		//diceoutPutElement.innerText = dice.getValue(); is an alternative.
		diceoutputElement.innerText = new Dice().getValue();
	};
}
/**
 * Function to initialize the Dice Controller through a root element.
 * The method accesses the HTML element with id "root", and creates a new intstance of DiceCrontroller using said element.
 */
function init() {
	const rootElement = document.getElementById('root');
	new DiceController(rootElement);
}

/**
 * Runs the script -> same as addEventListener('DOMContentLoaded', init());
 */

init();