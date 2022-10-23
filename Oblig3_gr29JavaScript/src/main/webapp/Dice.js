/**
 * 
 */
 
export class Dice{
	//By not including a constructor, JS will provide us with a standard constructor
	//Constructor (){}
	
	/**
	 * Will return the value of the dice after rolling it
	 */
	getValue(){
		return this.roll();
	}
	
	/**
	 * Will simulate a roll of a dice by using the Math.random() function
	 */
	roll(){
		return Math.floor(Math.random() *6)+1;;
	}
	
}