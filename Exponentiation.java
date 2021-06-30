/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorgui;

public class Exponentiation {
    private int digit1;
    private int digit2;
    private double exponential;
    //Constructors
    public Exponentiation() {
    }
    public Exponentiation(int digit1, int digit2){
	this.digit1 = digit1;
        this.digit2 = digit2;
    }
    //Class methods
    //Use the math library's pow method to raise number to required power
    public void raisePower(){
	exponential = Math.pow(digit1,digit2);
    }
    //Return the result or exponential
    public double getExponential(){
	return exponential;
    }
}

