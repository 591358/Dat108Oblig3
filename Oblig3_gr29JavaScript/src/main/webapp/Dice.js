/**
 * 
 */
 
export class Dice{
	constructor(value){
		this.value=value
	}
	getValue(){
		return this.roll();
	}
	roll(){
		return Math.floor(Math.random() *6)+1;;
	}
	
}