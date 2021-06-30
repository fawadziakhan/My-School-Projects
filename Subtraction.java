/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorgui;

public class Subtraction {
    private int digit1;
    private int digit2;
    private int difference;
    //Constructors
    public Subtraction() {
    }
    public Subtraction(int digit1, int digit2){
	this.digit1 = digit1;
        this.digit2 = digit2;
    }
    //Class methods
    //Subtract the numbers
    public void subtractNumbers(){
	difference = digit1 - digit2;
    }
    //Return the difference
    public int getDifference(){
	return difference;
    }
}
