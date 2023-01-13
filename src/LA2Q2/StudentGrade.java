package LA2Q2;

public class StudentGrade implements Comparable<StudentGrade>{
    //Declaring the private fields.
    private String firstName;
    private String lastName;
    private int grade;

    //Empty constructor
    StudentGrade(){}

    //Constructor with parameters
    StudentGrade(String firstName, String lastName, int grade){
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    //Getters and setters of each field
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    //This compareTo Function compares the students with respect to their grades
    @Override
    public int compareTo(StudentGrade o) {
        if (this.getGrade()<o.getGrade()){
            return -1;
        }if (this.getGrade()<o.getGrade()){
            return 1;
        }
        return 0;
    }


    @Override
    public String toString(){
        String string1= String.format("\n%8s %8s :     %d",firstName, lastName,grade);//Printing with having the correct format
        return string1;
    }



}
