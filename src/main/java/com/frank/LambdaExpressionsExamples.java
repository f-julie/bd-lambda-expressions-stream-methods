package com.frank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExpressionsExamples {

    static List<String> names     = new ArrayList<>();

    static List<Integer> numList  = new ArrayList<>();

    public static void main(String[] args) {
        /***************************************************************************************
         * Perform Initial/Setup processing for the application
         **************************************************************************************/
        setup();      // Perform start of main processing

        System.out.println("\n-------- Display elements in a List ---------");

        // List has its own version of the forEach() method - works just like the Stream forEach()
        // The List forEach() uses:
        //
        // 1. Iterators to traverse the List you may safely add or remove elements in the Lambda expression
        // without getting a ConcurrentModificationException
        //
        // 2. The order in which elements are processed is predictable - entry sequence
        //
        // 3. Slightly faster
        //
        // Using the Java for each:
        // for (String aName : names) {
        // System.out.println("Name: " + aName);
        // }

        // Using Lambda forEach() as a parameter
        System.out.println("\nUsing the List version of forEach to traverse the names: \n");
        names.forEach( (aName) -> {System.out.println("Name: " + aName);});  // List version of forEach()

        System.out.println("\nUsing the Stream interface forEach to traverse the names: \n");
        names.stream()forEach( (aName) -> {System.out.println("Name: " + aName);});  // Stream version of forEach()

        /***************************************************************************************
         * stream().map() Stream Interface function
         **************************************************************************************/
        System.out.println("\n-------- Showing first initials   ---------");

        List<String> firstInitials = names.stream().map((aName) -> {return (aName.substring(0,1));})
                .collect(Collectors.toList());

        firstInitials.forEach( (aName) -> {System.out.println("Name: " + aName);});

        /***************************************************************************************
         * stream().filter() Stream Interface function
         **************************************************************************************/
        System.out.println("\n-------- Removing Frank from List ---------");

        List<String> noFrank = names.stream().filter(aName -> {return (!aName.equals("Frank"));})
                                             .collect(Collectors.toList());

        noFrank.forEach( (aName) -> {System.out.println("Name: " + aName);});

        /***************************************************************************************
         * stream().filter() Stream Interface function
         **************************************************************************************/
        System.out.println("\n-------- Find values in ArrayList evenly divisble by 3 ---------");

        System.out.println("Values in numList ArrayList: ");
        numList.forEach( (aNum) -> {System.out.println("Value in List: " + aNum);});

        List<Integer> divBy3 = numList.stream().filter((aNum) -> {return (aNum % 3 == 0 ? true : false); }).collect(Collectors.toList());

        divBy3.forEach( (aNum) -> {System.out.println("\tnumber divisible by 3: " + aNum);});

        /***************************************************************************************
         * stream().reduce() Stream Interface function
         **************************************************************************************/
        System.out.println("\n-------- Using stream().reduce to sum an ArrayList   ---------");

        System.out.println("Values in numList ArrayList: ");
        numList.forEach( (aNum) -> {System.out.println("Value in List: " + aNum);});
        
        int listTotal = numList.stream().reduce(0, (sum, anElem) -> sum + anElem);
        System.out.println("Sum of elements in ArrayList is: " + listTotal);

        /***************************************************************************************
         * Arrays.reduce() Arrays method
         *
         * Since Stream interface methods may only be applied to Collections class objects (like ArrayList)
         *
         * Java created a set of equivalent methods for use with a simple array
         **************************************************************************************/
        System.out.println("\n-------- Using Arrays.reduce() to sum an array   ---------");

        int numArray[]  = {10, 20, 30,40};
        for(int i=0; i < numArray.length; i++) {
            System.out.println("Array elem " + i + ": " + numArray[i]);
        }

        // The Arrays class provided a stream().reduce() method for a simple array
        // .stream(array-name).method(parameters)
        int total = Arrays.stream(numArray).reduce(0, (sum, anElem) -> sum + anElem);
        System.out.println("Sum of elements in array is: " + total);

        takeDown();   // Perform end of main() processings
    } // End of main()

    public static void setup() {

        System.out.println("-".repeat(50) + "\nWelcome to Lambda Expressions Example\n" + "-".repeat(50));

        names.add("Frank");
        names.add("Kirk");
        names.add("Spock");
        names.add("Worf");
        names.add("Data");

        numList.add(100);
        numList.add(200);
        numList.add(300);
        numList.add(400);
        numList.add(500);
        numList.add(600);
    }

    public static void takeDown() {
        System.out.println("-".repeat(50) + "\nThanks for visiting Lambda Expressions Example\n" + "-".repeat(50));
    }

} // End if LambdaExpressionsExample class
