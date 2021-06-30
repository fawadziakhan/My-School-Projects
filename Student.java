package gradingapplication;

public class Student implements java.io.Serializable {
    private String firstName;
    private String lastName;
    private int homework1;
    private int homework2;
    private int homework3;
    private int test1;
    private int test2;

    // Constructor
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters for student's name
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setHomework1(int homework1) {
        this.homework1 = homework1;
    }

    //Delete homework 1 score
    public void deleteHomework1() {
        this.homework1 = 0;
    }

    //Set homework2 score
    public void setHomework2(int homework2) {
        this.homework2 = homework2;
    }

    //Delete homework 2
    public void deleteHomework2() {
        this.homework2 = 0;
    }

    //Set homework3 score
    public void setHomework3(int homework3) {
        this.homework3 = homework3;
    }

    //Delete homework 3
    public void deleteHomework3() {
        this.homework3 = 0;
    }

    //Set test1 score
    public void setTest1(int test1) {
        this.test1 = test1;
    }

    //Delete test 1
    public void deleteTest1() {
        this.test1 = 0;
    }

    //Set test2 score
    public void setTest2(int test2) {
        this.test2 = test2;
    }

    //Delete test 2
    public void deleteTest2() {
        this.test2 = 0;
    }

    //Calculate and return the average homework score
    public float calcHomeworkAverage() {
        return (homework1 + homework2 + homework3) / 3.0f;
    }

    //Calculate and return the average test score
    public float calcTestAverage() {
        return (test1 + test2) / 2.0f;
    }

    //Calculate and return overall class average which is the average of both the homework and test average.
    public float calcClassAverage() {
        return (calcHomeworkAverage() + calcTestAverage()) / 2.0f;
    }
}
