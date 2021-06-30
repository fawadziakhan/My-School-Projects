/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorgui;

public class Multiplication {
    private int digit1;
    private int digit2;
    private int product;
    //Constructors
    public Multiplication() {
    }
    public Multiplication(int digit1, int digit2){
	this.digit1 = digit1;
        this.digit2 = digit2;
    }
    //Class methods
    //Multiply the two numbers together
    public void multiplyNumbers(){
	product = digit1 * digit2;
    }
    //Return the product obtained
    public int getProduct(){
	return product;
    }
}
