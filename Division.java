/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorgui;

public class Division {
    private int digit1;
    private int digit2;
    private int quotient;
    //Constructors
    public Division() {
    }
    public Division(int digit1, int digit2){
	this.digit1 = digit1;
        this.digit2 = digit2;
    }
    //Class methods
    //Divide the two numbers
    public void divideNumbers(){
	quotient = digit1/digit2;
    }
    //Return the quotient
    public int getQuotient(){
	return quotient;
    }
}
