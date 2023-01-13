package LA2Q1;


import java.util.*;

public class BashsharSortingMethods<T> {
    public static void main(String[] args) {
        MyHeader(2,1); //Calling the header!
        int sz= 100;   //This is the size variable, you can change the sizes of the list through this!
        Integer[] list = new Integer[sz]; //creating a new Integer list, of size.
        Integer[] backUpList = new Integer[sz];  //creating a back-up list so that we can reset the list after it has been sorted by a certain method.


        //populate the lists with random values between 13 and 93.
        for (int i = 0; i<sz; i++){
           list[i]  = getRandomIntInclusive(13,93);  //I made a function to calculate random integers - thought it would make the code neater.
        }

        System.arraycopy(list,0,backUpList,0,sz); //To copy to the second list.

        List<Integer> list1 = Arrays.asList(list); //This line of code converts the list to a ArrayList

        System.out.println(String.format("Testing execution time of different sorting methods for sorting %d random numbers:",sz)); //making sure that it displays the right list size with String.format.
        //System.out.println("The unsorted list: " + list1.toString()); //This will print the ArrayList using .toString.


        //Collections' Sort
        long beginTime = System.nanoTime();
        Collections.sort(list1);  //Sort the list using the collections' sort method!
        double  endTime = (System.nanoTime()-beginTime)/1e+6; //nanoseconds to milliseconds
        System.out.println(String.format("Collections' Sorting Time %.2f milliseconds.", endTime)); //Printing out the time it takes using the correct conversion
        //System.out.println("The sorted list using Collections' sort method: " + list1.toString());
        System.arraycopy(backUpList,0,list,0,sz); //To reset the list



        //Selection Sort
        //System.out.println("\nThe unsorted list: " + printList(list));
        endTime = selectionSort(list)/1e+6; //nanoseconds to milliseconds
        System.out.println(String.format("My Selection-Sort Time: %.2f milliseconds.", endTime));//Printing out the time it takes with the correct conversion
        //System.out.println("The sorted list: " + printList(list));
        System.arraycopy(backUpList,0,list,0,sz); //To reset the list.


        //Bubble Sort
        //System.out.println("\nThe unsorted list: " + printList(list));
        endTime = bubbleSort(list)/1e+6; //nanoseconds to milliseconds
        System.out.println(String.format("My Bubble-Sort Time: %.2f milliseconds.", endTime)); //Printing out the time it takes with the correct conversion
        //System.out.println("The sorted list: " + printList(list));
        System.arraycopy(backUpList,0,list,0,sz); //To reset the list.

        //Insertion Sort
        //System.out.println("\nThe unsorted list: " + printList(list));
        endTime = insertionSort(list)/1e+6; //nanoseconds to milliseconds
        System.out.println(String.format("My Insertion-Sort Time: %.2f milliseconds.", endTime)); //Printing out the time it takes with the correct conversion
        //System.out.println("The sorted list: " + printList(list));
        System.arraycopy(backUpList,0,list,0,sz); //To reset the list.


        //Merge Sort
        //System.out.println("\nThe unsorted list: " + printList(list));
        endTime = mergeSort(list)/1e+6; //nanoseconds to milliseconds
        System.out.println(String.format("My Merge-Sort Time: %.2f milliseconds.", endTime));//Printing out the time it takes with the correct conversion
        //System.out.println("The sorted list: " + printList(list));
        System.arraycopy(backUpList,0,list,0,sz); //To reset the list.


        //Quick Sort
        //System.out.println("\nThe unsorted list: " + printList(list));
        endTime = quickSort(list,0,sz-1)/1e+6; //nanoseconds to milliseconds
        System.out.println(String.format("My Quick-Sort Time: %.2f milliseconds.", endTime));//Printing out the time it takes with the correct conversion
        //System.out.println("The sorted list: " + printList(list));
        System.arraycopy(backUpList,0,list,0,sz); //To reset the list.


        //Bucket Sort
        //System.out.println("\nThe unsorted list: " + printList(list));
        endTime = bucketSort(list,0,sz-1,2)/1e+6; //nanoseconds to milliseconds
        System.out.println(String.format("My Bucket-Sort Time: %.2f milliseconds.", endTime));//Printing out the time it takes with the correct conversion
        //System.out.println("The sorted list: " + printList(list));
        System.arraycopy(backUpList,0,list,0,sz); //To reset the list.


        //Calling the footer
        footer(2);
    }



    //Bucket Sort
    public static long bucketSort(Integer[] list, int first, int last, int maxDigits) {  //takes in the first index and the last index followed by the maxiumum digit (tens, hundreths, etc) found in you list.
        long beginTime = System.nanoTime();                       //Noting the time at the beginning
        Vector<Integer>[] bucket = new Vector[10];                //creating 10 buckets using Vector with the assumption they are positive!
        //create each bucket
        for (int i = 0; i < 10; i++) {    //instantiate each bucket
            bucket[i] = new Vector<>();
        }
        for (int i = 0; i < maxDigits; i++) {
            //clear the Vector buckets.
            for (int j = 0; j < 10; j++) {
                bucket[j].removeAllElements();
            }
            //Placing list[index] at the end of bucket[digit]
            for (int index = first; index <= last; index++) {
                Integer digit = findDigit(list[index], i);
                bucket[digit].add(list[index]);
            }
            //Placing all the buckets back into the array
            int index = 0;
            for (int m = 0; m < 10; m++) {
                for (int n = 0; n < bucket[m].size(); n++) {
                    list[index++] = bucket[m].get(n);
                }
            }

        }
        return System.nanoTime() - beginTime;  //return the amount of time it takes.
    }

    //The following method extracts the ith digit from a decimal number
    public static Integer findDigit(int number, int i) {
        int target = 0;
        for (int k = 0; k <= i; k++) {
            target = number % 10;
            number = number / 10;
        }
        return target;
    }



    //[a, 1, 2, 4, b]
    //Quick Sort
    public static <T extends Comparable<? super T>> long quickSort(T[] list, int a, int b){
        long beginTime = System.nanoTime();
        if (a >= b){  return System.nanoTime()-beginTime;} //this means that the list is already sorted.

        int left = a;
        int right = b-1;  //otherwise it will be index out of bounds!
        T pivot = list[b]; //setting the pivot!
        T temp;   //This will store the temporary list item.
        while (left <= right){  //overarching while loop
            // scan until value equal or larger than the stated pivot
            while((left <= right)&&(list[left].compareTo(pivot))<0){
                left ++; //scan until reaching a value smaller than the pivot
            }
            while((left <=right) && (list[right].compareTo(pivot)>0)){
                right--;
            }
            if(left <= right){
                //if the item on the left is less than the item on the right, then sqap them and shrink the range.
                temp = list[left];
                list[left] = list[right];
                list[right] = temp;

                //reducing the range - otherwise it will be take a very long time.
                left++;
                right--;
            }
        }
        //put pivot into it's final place (currently marked by left index)
        temp = list[left]; //we use temp so that we don't lose any information in the list, this is repeated throughout.
        list[left] = list[b];
        list[b] = temp;

        //Make recursive calls to "divide and conquer" the sorting.
        quickSort(list,a,left-1);
        quickSort(list,left+1,b);

        return System.nanoTime()-beginTime;  //return the amount of time it takes.
    }

    public static <T extends Comparable <? super T>>long selectionSort(T[] list){
        long beginTime = System.nanoTime();

        for(int i = 0; i< list.length-1; i++){ //outer loop that will run length - 1 times
            int min = i;
            for(int j = i+1; j< list.length;j++ ){
                if (list[j].compareTo(list[min])<0){ //if the current index is lower than the min
                    min = j;
                }

            }

            //Swapping
            T temp = list[min];
            list[min] = list[i];
            list[i]= temp;
        }

        return System.nanoTime()-beginTime;  //return the amount of time it takes.
    }


    public static < T extends Comparable <? super T >> long bubbleSort(T[] list){
        long beginTime = System.nanoTime(); //Getting the beginning time

        for (int i = 0; i< list.length-1; i++){  //the outer loop, the last number will be automatically in the correct place

            for(int j =0; j<list.length-i-1;j++){  //The -i exists because every number before that index will be sorted

                if(list[j].compareTo(list[j+1])>0){

                    //swapping
                    T temp = list[j];   //storing the values so nothing is missing in the list
                    list[j] = list[j+1];
                    list[j+1] = temp;

                    //Bubble O(n) > O(n^2) <
                    //Merge sort nLog(n) <<<


                }

            }
        }



        return System.nanoTime()-beginTime;  //return the amount of time it takes.
    }

    public static < T extends Comparable <? super T >> long insertionSort(T[] list){
        long beginTime = System.nanoTime(); //noting the beginning time

        //this is the for loop that will repeat the nested loop  until the list is sorted
        for(int i =1; i<list.length; i++){
            T current = list[i];  //the current element that you need to put in the right place
            int j = i-1;
            while(j >=0 &&((current.compareTo(list[j]))<0)){ //we are using j to track the sorted part
                list[j+1] = list[j];                         //pushing each array forward.
                j--;
            }

            //placing the element in the correct place.
            list[j+1] = current;
        }

        return System.nanoTime()-beginTime;  //return the amount of time it takes.
    }

    public static <T extends Comparable<? super T>> long mergeSort(T[] list){

        long beginTime = System.nanoTime();
        int n= list.length;
        if(n<2){                                              //Queue is sorted if it is less than 2
            return System.nanoTime()-beginTime;
        }

        int mid = n/2; //getting the middle value



        //splitting arrays
        T[] S1 = Arrays.copyOfRange(list, 0, mid);
        T[] S2 = Arrays.copyOfRange(list,mid,n);

        //recursion!
        mergeSort(S1);//sorting the first half
        mergeSort(S2);//sorting the second half

        int i = 0, j=0;
        while(i+j < list.length){
            if (j== S2.length || (i < S1.length && S1[i].compareTo(S2[j])<0)){
                list[i+j]= S1[i++];     //copy elements from s1 and increment i to move on to the next element
            }else{
                list[i+j]= S2[j++];//copy elements from s2 and increment j to move on to the next element
            }
        }

        return System.nanoTime()-beginTime;  //return the amount of time it takes.
    }






    //Thsi method creates a list with the array format, it returns the elements (they are generic)
    public static <T extends Comparable <? super T>> String printList(T[] list) {
        {
            String returnString = null;
            for (int i = 0; i < list.length; i++) {
                if (i == 0) {
                    returnString = "[";
                }
                returnString += list[i];
                if (i == list.length - 1) {
                    returnString += "] ";
                } else {
                    returnString += ", ";
                }
            }
            return returnString;
        }
    }

    public static int getRandomIntInclusive(int min, int max) {
        return (int)(Math.random() * (max-min+1)); // The maximum is inclusive and the minimum is inclusive since we have the range stated as max-min+1 -
    }


    public static void MyHeader(int assignment_number, int q_number) {
        System.out.println("______________________________________________________________________________________________________________________________________");
        System.out.println("Lab Assingment " + assignment_number + "Q" + q_number);
        System.out.println("Prepared By: Bashshar Atif");
        System.out.println("Student Number: 251219057");
        System.out.println("The goal of this assignment is to use numerous types of self-implemented sorting algorithms and then see the differences in time they each take.");
        System.out.println("______________________________________________________________________________________________________________________________________");
    }

    // Creating a footer method that taKes in the exercise number and prints out the relevant information to indicating the end of this exercise.
    public static void footer(int exerciseNumber) {
        System.out.println("_____________________________________________________________________");
        System.out.println("Completion of Assignment " + exerciseNumber + " is successful!");
        System.out.println("Signing off - Bashshar Atif.");
    }

}
