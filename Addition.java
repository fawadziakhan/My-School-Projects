//Name: Fawad Khan
//Class: CSET3600
//Instructor: Dr. Jared Oluoch
//Programming Assignment: Final Project
//Date: 12/01/2019
//This is the Addition class. It adds two integers together
package calculatorgui;

public class Addition {
   private int digit1;
    private int digit2;
    private int sum;
    //Constructors
    public Addition() {
    }
    public Addition(int digit1, int digit2){
	this.digit1 = digit1;
        this.digit2 = digit2;
    }
    //Class methods
    //Add the numbers together
    public void addNumbers(){
	sum = digit1 + digit2;
    }
    //Return the sum
    public int getSum(){
	return sum;
    } 
}
