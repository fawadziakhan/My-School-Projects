package gradingapplication;

import java.io.*;
import java.util.*;

public class GradingApplication {
    private Student[] cset4250Students;

    public static void main(String[] args) throws IOException {
        GradingApplication app = new GradingApplication();
        app.loadStudentRecord();

        // Display a list of enrolled students to the professor
        String studentReport = app.getStudentReport();
        System.out.println("These are the students who are enrolled in this class");
        System.out.println(studentReport); // Display the formatted output

        Scanner answer = new Scanner(System.in);
        System.out.println("Enter a selection");

        do {
            app.workLoop(answer);
        } while (true);
    }

    private void loadStudentRecord() {
        // Read students from file
        try (
                FileInputStream fin = new FileInputStream("studentGrades.dat");
                ObjectInputStream ois = new ObjectInputStream(fin);
        ) {
            cset4250Students = (Student[]) ois.readObject();
        } catch (Exception e) {
            // Show error and create default values
            System.out.println("Exception: " + e.getMessage());

            cset4250Students = getStudents();
        }
    }

    // Create an array of objects. These are the students in this class
    private Student[] getStudents() {
        Student[] cset4250Students = new Student[5];

        // Create an array of last names
        String[] lastNames = {"Khalid", "Malik", "Hamid", "Rahman", "Iqbal"};

        // Create an array of first names
        String[] firstNames = {"Ahmad", "Najeeb", "Adnan", "Nadir", "Khawer"};

        // Create an array of objects which contains the students enrolled in this class
        for (int i = 0; i < cset4250Students.length; i++) {
            String lname = lastNames[i];
            String fname = firstNames[i];

            cset4250Students[i] = new Student(fname, lname);
        }

        return cset4250Students;
    }

    // Creates a formatted report of the students in the class
    private String getStudentReport() {
        Formatter f = new Formatter();
        f.format("%15s %15s\n", "Last Name", "First Name");

        for (int i = 0; i < cset4250Students.length; i++) {
            Student s = cset4250Students[i];

            String lName = s.getLastName();
            String fName = s.getFirstName();

            f.format("%15s %15s\n", lName, fName);
        }

        return f.toString();
    }

    private void workLoop(Scanner answer) throws IOException {
        System.out.println("Enter h to enter a homework score: ");
        System.out.println("Enter t to enter a test: ");
        System.out.println("Enter H to delete a homework score: ");
        System.out.println("Enter T to delete a test: ");
        System.out.println("Enter w to save your entered information: ");
        System.out.println("Enter d to display result: ");
        System.out.println("To exit, enter x or anything other than the above choices");

        char c = answer.next().charAt(0);

        switch (c) {
            case 'h':
                inputHomework();
                break;

            case 't':
                inputTest();
                break;

            case 'H':
                deleteHomework();
                break;

            case 'T':
                deleteTest();
                break;

            case 'w':
                writeInformation();
                break;

            case 'd':
                displayResult();
                break;

            default:
                System.exit(0);
        }
    }

    // This method allows user to enter student's homework scores
    private void inputHomework() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter which homework assignment, 1 for homework1, 2 for 2 and 3 for 3: ");
        int num = readInt(input);

        System.out.println("Enter student's last name: ");
        String lname = input.next();

        System.out.println("Enter the homework score: ");
        int score = readInt(input);

        for (int i = 0; i < cset4250Students.length; i++) {
            Student s = cset4250Students[i];
            String temp = s.getLastName();

            if (temp.equals(lname)) {
                switch (num) {
                    case 1:
                        s.setHomework1(score);
                        break;

                    case 2:
                        s.setHomework2(score);
                        break;

                    case 3:
                        s.setHomework3(score);
                        break;
                }
            }
        }
    }

    // Reads an int from the Scanner, treats bad input as zero
    private int readInt(Scanner input) {
        try {
            return input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Using zero");

            return 0;
        }
    }

    // This method deletes a student's homework score by setting it's value to zero
    private void deleteHomework() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter which homework assignment, 1 for homework1, 2 for 2 and 3 for 3: ");
        int num = readInt(input);

        System.out.println("Enter student's last name: ");
        String lname = input.next();

        for (int i = 0; i < cset4250Students.length; i++) {
            Student s = cset4250Students[i];
            String temp = s.getLastName();

            if (temp.equals(lname)) {
                switch (num) {
                    case 1:
                        s.deleteHomework1();
                        break;

                    case 2:
                        s.deleteHomework2();
                        break;

                    case 3:
                        s.deleteHomework3();
                        break;
                }
            }
        }
    }

    // This method allows user to enter student's test scores
    private void inputTest() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter which test score, 1 for test1, 2 for test2: ");
        int num = readInt(input);

        System.out.println("Enter student's last name: ");
        String lname = input.next();

        System.out.println("Enter the test score: ");
        int score = readInt(input);

        for (int i = 0; i < cset4250Students.length; i++) {
            Student s = cset4250Students[i];
            String temp = s.getLastName();

            if (temp.equals(lname)) {
                switch (num) {
                    case 1:
                        s.setTest1(score);
                        break;

                    case 2:
                        s.setTest2(score);
                        break;
                }
            }
        }
    }

    // This method deletes a student's test score
    private void deleteTest() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter which test score, 1 for test1, 2 for test2: ");
        int num = readInt(input);

        System.out.println("Enter student's last name: ");
        String lname = input.next();

        for (int i = 0; i < cset4250Students.length; i++) {
            Student s = cset4250Students[i];
            String temp = s.getLastName();

            if (temp.equals(lname)) {
                switch (num) {
                    case 1:
                        s.deleteTest1();
                        break;

                    case 2:
                        s.deleteTest2();
                        break;
                }
            }
        }
    }

    // This method calculates the homework average score
    private void homeworkAverage() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter student's last name: ");
        String lname = input.next();

        for (int i = 0; i < cset4250Students.length; i++) {
            Student s = cset4250Students[i];
            String temp = s.getLastName();

            if (temp.equals(lname)) {
                float average = s.calcHomeworkAverage();

                System.out.println("This student's homework average is " + average);
            }
        }
    }

    // This method calculates the test average score
    private void testAverage() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter student's last name: ");
        String lname = input.next();

        for (int i = 0; i < cset4250Students.length; i++) {
            Student s = cset4250Students[i];
            String temp = s.getLastName();

            if (temp.equals(lname)) {
                float average = s.calcTestAverage();

                System.out.println("This student's test average is " + average);
            }
        }
    }

    // This method assigns a letter grade to either a homework average or a test average
    private char assignLetterGrade(float average) {
        char letterGrade = 'X'; // Variable initialized to some value just to avoid error message from compiler

        if (average >= 90)
            letterGrade = 'A';
        else if (average < 90 && average >= 80)
            letterGrade = 'B';
        else if (average < 80 && average >= 70)
            letterGrade = 'C';
        else if (average < 70 && average >= 60)
            letterGrade = 'D';
        else if (average < 60)
            letterGrade = 'F';
        else
            System.out.println("Invalid number");

        return letterGrade;
    }

    // This method will write all the information entered by user to file
    private void writeInformation() throws IOException {
        try (
                FileOutputStream fout = new FileOutputStream("studentGrades.dat");
                ObjectOutputStream oos = new ObjectOutputStream(fout);
        ) {
            oos.writeObject(cset4250Students);
        }
    }

    private void displayResult() {
        System.out.println("These are the students in this class and their scores");

        Formatter f = new Formatter();
        f.format("%15s %15s %15s %15s %15s %15s %15s %15s\n", "Last Name", "First Name", "Homework Average", "Homework Grade", "Test Average", "Test Grade", "Class Average", "Class Grade");

        for (int x = 0; x < cset4250Students.length; x++) {
            Student s = cset4250Students[x];
            String lname = s.getLastName();
            String fname = s.getFirstName();
            float hwAverage = s.calcHomeworkAverage();
            char hwGrade = assignLetterGrade(hwAverage);
            float tAverage = s.calcTestAverage();
            char tGrade = assignLetterGrade(tAverage);
            float cAverage = s.calcClassAverage();
            char cGrade = assignLetterGrade(cAverage);

            f.format("%15s %15s %15s %15s %15s %15s %15s %15s\n", lname, fname, hwAverage, hwGrade, tAverage, tGrade, cAverage, cGrade);
        }

        System.out.println(f);
    }
}
