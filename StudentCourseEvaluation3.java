/*
 * This program asks the student to enter the classes that he/she has already 
   
   completed. The program then tells the student whether there are any classes 

   left to take. If student has completed all the classes required for his/her

   major, then the program prints a congratulatory message. The program accomplishes

   this task by using various methods, arrays and loops.
 */
package studentcourseevaluation3;
import java.util.Scanner;
import java.util.Arrays;

public class StudentCourseEvaluation3 {
    //This is the main method. This is where all the appropriate methods that do the work get invoked.
    public static void main(String[] args) {
        //CSET classes which are required
        String[][] requiredCSETClasses = {
            {"CSET1100", "4"},
            {"CSET1200", "3"},
            {"CSET3150", "4"},
            {"CSET3600", "3"},
            {"CSET2230", "4"},
            {"CSET3300", "4"},
            {"CSET4250", "3"},
            {"CSET4350", "3"},
            {"CSET2200", "4"},
            {"CSET4750", "4"}};
        
        //EET classes which are required
        String[][] requiredEETClasses = {
            {"EET2420", "1"},
            {"EET2210", "4"},
            {"EET2410", "4"},
            {"EET3350", "4"}};
        
        //ENGT classes which are required
        String[][] requiredENGTClasses = {
            {"ENGT3050", "4"},
            {"ENGT2000", "1"},
            {"ENGT3010", "4"},
            {"ENGT4050", "3"}};
        
        //Math and Physics classes which are required
        String[][] requiredMathPhysicsClasses = {
            {"MATH2450", "4"},
            {"MATH2460", "4"},
            {"MATH2890", "3"},
            {"PHYS2020", "4"},
            {"PHYS2010", "4"}};
        
        //Professional Development Electives
        String[][] professionalDevElec = {
            {"BUAD2040", "3"},
            {"BUAD2050", "3"},
            {"BUAD2080", "3"},
            {"BUAD3010", "3"},
            {"BUAD3020", "3"},
            {"BUAD3030", "3"},
            {"BUAD3040", "3"},
            {"BUAD3470", "3"},
            {"BLAW3570", "3"},
            {"FINA3060", "3"}};
                
        //CSET classes which student has taken
        String studentCSETClasses[] = new String[11];
        //EET classes which student has taken
        String studentEETClasses[] = new String[5];
        //ENGT classes which student has already taken
        String studentENGTClasses[] = new String[5];
        //Math and Physics classes which student has already taken
        String studentMathPhysicsClasses[] = new String[6];
        //Professional development classes which student has already taken
        String studentProfessionalDev[] = new String[2];
        //CSET classes which student still needs to take
        String missingCSETClasses[] = new String[11];
        //EET classes which student still needs to take
        String missingEETClasses[] = new String[5];
        //ENGT classes which student still needs to take
        String missingENGTClasses[] = new String[5];
        //Math and Physics classes which student still needs to take
        String missingMathPhysics[] = new String[6];
        
        //CSET credit hours
        int creditHoursCSET;
        //EET credit hours
        int creditHoursEET;
        //ENGT credit hours
        int creditHoursENGT;
        //Math and Physics credit hours
        int creditMathPhysics;
        //Professional development credit hours
        int creditProDev;
        //Credit hours already earned by student
        int totalCreditHoursTaken;
        //Total number of credit hours needed
        final int CREDIT_HOURS_NEEDED = 80;
        //Credit hours remaining
        int creditHoursRemaining;
        
        //Get student's CSET classes
        getStudentClasses(studentCSETClasses, "CSET");
        
        //Get student's EET classes
        getStudentClasses(studentEETClasses, "EET");
        
        //Get student's ENGT classes
        getStudentClasses(studentENGTClasses, "ENGT");
        
        //Get student's math and physics classes
        getStudentClasses(studentMathPhysicsClasses, "Math & Physics");
        
        //Checks electives
        getHumanitiesElectives();
        getMultiElectives();
        getMultiUSElectives();
        getNaturalScience();
        getSocialScienceElectives();
        
        //Check student's CSET classes
        creditHoursCSET = compareStudentClasses(requiredCSETClasses, studentCSETClasses, missingCSETClasses);
        
        //Check student's EET classes
        creditHoursEET = compareStudentClasses(requiredEETClasses, studentEETClasses, missingEETClasses);
        
        //Check student's ENGT classes
        creditHoursENGT = compareStudentClasses(requiredENGTClasses, studentENGTClasses, missingENGTClasses);
        
        //Check student's Math and Physics classes
        creditMathPhysics = compareStudentClasses(requiredMathPhysicsClasses, studentMathPhysicsClasses, missingMathPhysics);
        
        totalCreditHoursTaken = creditHoursCSET + creditHoursEET + creditHoursENGT + creditMathPhysics;
        creditHoursRemaining = CREDIT_HOURS_NEEDED - totalCreditHoursTaken;
        if (totalCreditHoursTaken < CREDIT_HOURS_NEEDED) {
            System.out.println("You need " + creditHoursRemaining + " credit hours");
            System.out.println("You need the following classes");
            displayResult(missingCSETClasses);
            displayResult(missingEETClasses);
            displayResult(missingENGTClasses);
            displayResult(missingMathPhysics);
        }
        else
            System.out.println("You have completed all required classes");
}
    
    /*This method allows the student to enter his/her classes. This method will be
     
      called repeatedly with a different array each time.
    */
    public static void getStudentClasses(String studentClasses[], String name) {
        Scanner input = new Scanner(System.in);
        String courseName = "y";
        
        int a = 0;
        System.out.println("Enter your " + name + " classes. Enter n when done: ");
        //Keep prompting student to enter classes taken. Loop exits when student enters n
        while (!"n".equals(courseName)){
            courseName = input.next();
            studentClasses[a] = courseName;
            a++;
        }
      
        
    }
    
  
    /*This method compares the classes completed by student, with the classes which are required
    
      in the student's degree program. This method will be called repeatedly with different 
    
      arrays
    */
    public static int compareStudentClasses(String requiredClasses[][], String studentClasses[], String missingClasses[]) {
        int creditHours = 0;
        //Loop to compare classes required array with array containing classes already taken by student
        for(int i = 0, j = 1; i < requiredClasses.length; i++){
            String className = requiredClasses[i][0];
            String hours = requiredClasses[i][j];
            int courseHours = Integer.parseInt(hours);
            /*If class is in student's array, student's credit hours are
              incremented. Else, classes that are missing get stored in a 
              different array called missingClasses
            */
            if (Arrays.asList(studentClasses).contains(className))
                creditHours += courseHours;
            else
                missingClasses[i] = className;
        }
        
        return creditHours;
    }
    
    /*This method outputs only those classes which the student has 
    
      taken yet.
    */
    public static void displayResult(String missingClasses[]) {
        for (String name: missingClasses){
            if (name != null)
                System.out.println(name);
        }   
     
        
    } 

    private static void getHumanitiesElectives() {
        Scanner input = new Scanner(System.in);
        System.out.println("How many humnaities courses have you taken? (0,1, or 2)");
        int courses = input.nextInt();
        changeHumanities(courses);
    }
   
    private static void getMultiElectives() {
        Scanner input = new Scanner(System.in);
        System.out.println("How many multicultural non-western courses? (0 or 1) ");
        int courses = input.nextInt();
        changeMulti(courses);
    }
    private static void getMultiUSElectives() {
        Scanner input = new Scanner(System.in);
        System.out.println("How many multicultural US courses have you taken? (0 or 1)");
        int courses = input.nextInt();
        changeMultiUS(courses);
    }
     private static void getNaturalScience() {
        Scanner input = new Scanner(System.in);
        System.out.println("How many humnaities courses have you taken? (0,1, or 2) ");
        int courses = input.nextInt();
        changeNaturalScience(courses);
    }
    private static void getSocialScienceElectives() {
        Scanner input = new Scanner(System.in);
        System.out.println("How many Social Science courses have you taken? (0 or 1)");
        int courses = input.nextInt();
        changeSocialScience(courses);
    }
    
    public static void changeHumanities(int courses){
        int credits = 6 - (courses * 3);
        System.out.println("You have " + credits + " Humanities credits remaining.");
    }
    public static void changeMultiUS(int courses){
        int credits = 3 - (courses * 3);
        System.out.println("You have " + credits + " Multicultural US credits remaining.");
    }
    public static void changeMulti(int courses){
        int credits = 3 - (courses * 3);
        System.out.println("You have " + credits + " Multicultural Non-Western credits remaining.");
    }
    public static void changeSocialScience(int courses){
        int credits = 3 - (courses * 3);
        System.out.println("You have " + credits + " Social Science credits remaining.");
    }
    public static void changeNaturalScience(int courses){
        int credits = 4 - (courses * 2);
        System.out.println("You have " + credits + " Natural Science credits remaining.");
    }
}
