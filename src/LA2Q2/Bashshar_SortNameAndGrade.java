package LA2Q2;

import java.util.Collections;
import java.util.Vector;

public class Bashshar_SortNameAndGrade {

    public static void main(String[] args) {
        MyHeader(2, 2);   //Calling the header
        //Having the strings be with the given information
        String[] fnArray = {"Hermione", "Ron", "Harry", "Luna", "Ginny", "Draco", "Dean", "Fred"};
        String[] lnArray = {"Granger", "Weasley", "Potter", "Lovegood", "Weasley", "Malfoy", "Thomas", "Weasley"};
        //Having the random values being generated
        Integer[] grd = {(int) (60 + Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 + Math.random() * 26), (int) (60 + Math.random() * 26)};


        //Creating a vector with reference variable sg
        Vector<StudentGrade> sg = new Vector<>();

        //Creating new objects of the StudentGrade class
        StudentGrade st0 = new StudentGrade(fnArray[0], lnArray[0], grd[0]);
        StudentGrade st1 = new StudentGrade(fnArray[1], lnArray[1], grd[1]);
        StudentGrade st2 = new StudentGrade(fnArray[2], lnArray[2], grd[2]);
        StudentGrade st3 = new StudentGrade(fnArray[3], lnArray[3], grd[3]);
        StudentGrade st4 = new StudentGrade(fnArray[4], lnArray[4], grd[4]);
        StudentGrade st5 = new StudentGrade(fnArray[5], lnArray[5], grd[5]);
        StudentGrade st6 = new StudentGrade(fnArray[6], lnArray[6], grd[6]);
        StudentGrade st7 = new StudentGrade(fnArray[7], lnArray[7], grd[7]);

        //Adding StudentGrade objects to the vector stack
        sg.add(st0);
        sg.add(st1);
        sg.add(st2);
        sg.add(st3);
        sg.add(st4);
        sg.add(st5);
        sg.add(st6);
        sg.add(st7);

        //Printing out the original, unsorted array.
        System.out.println("The Unsorted Array ................");
        printArray(sg);


        //Printing array that is sorted based on grades.
        Collections.sort(sg);  //Using the Collections' Sort method.
        System.out.println("\n\nSorted by Grades......................");
        printArray(sg);

        //Creating a new array which has the length of the first name array
        StudentGrade[] array1 = new StudentGrade[fnArray.length];
        sg.copyInto(array1);

        //Sorting the array using the insertion sort we made - this will print the array out by first names.
        sortArray(array1,1);
        System.out.println("\n\nSorted by First Names......................");
        printArray2(array1);


        //Sorting the array using the insertion sort we made - this will print the array out by last names.
        sortArray(array1,2);
        System.out.println("\n\nSorted by Last Names......................");
        printArray2(array1);




        System.out.println("\n");
        footer(2);
    }


    public static void sortArray(StudentGrade [] list, int key) {

        //The if statements select what you want the name's list to be sorted by, first names or last names.
        if (key == 1) { //first Name
            //this is the for loop that will repeat the nested loop  until the list is sorted
            int j = 0;
            for (int i = 1; i < (list.length); i++) {
                StudentGrade y = list[i];  //the current element that you need to put in the right place
                for (j = i - 1; j >= 0 && (list[j].getFirstName().compareTo(y.getFirstName()) < 0); j--){ //comparing the strings using the compareTo method
                    list[j + 1] = list[j]; //moving them accordingly
                }

                //placing the element in the correct place.
                list[j + 1] = y;
            }

        }

        //this is essentially the same code as the key ==1 but has get.firstName replaced with get.LastName
        if (key == 2) {
            //this is the for loop that will repeat the nested loop  until the list is sorted
            int j = 0;
            for (int i = 1; i < (list.length); i++) {
                StudentGrade y = list[i];  //the current element that you need to put in the right place
                for (j = i - 1; j >= 0 && (list[j].getLastName().compareTo(y.getLastName()) > 0); j--) {
                    list[j + 1] = list[j];
                }

                //placing the element in the correct place.
                list[j + 1] = y;
            }

        }
    }



    //This method prints out the Vector array (it uses the .get() method)
        public static void printArray (Vector < StudentGrade > list) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i).toString());
            }
        }

    //This method prints out the StudentGrade array (it uses the list[i] method)

    public static void printArray2 (StudentGrade[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i].toString());
        }
    }

    //the rest is my header and footer.
        public static void MyHeader ( int assignment_number, int q_number){
            System.out.println("______________________________________________________________________________________________________________________________________");
            System.out.println("Lab Assingment " + assignment_number + "Q" + q_number);
            System.out.println("Prepared By: Bashshar Atif");
            System.out.println("Student Number: 251219057");
            System.out.println("The goal of this assignment is to use Vector lists and tinker with them sorting!");
            System.out.println("______________________________________________________________________________________________________________________________________");
        }

        // Creating a footer method that taKes in the exercise number and prints out the relevant information to indicating the end of this exercise.
        public static void footer ( int exerciseNumber){
            System.out.println("_____________________________________________________________________");
            System.out.println("Completion of Assignment " + exerciseNumber + " is successful!");
            System.out.println("Signing off - Bashshar Atif.");
        }

    }



